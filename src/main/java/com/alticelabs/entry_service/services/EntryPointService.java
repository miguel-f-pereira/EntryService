package com.alticelabs.entry_service.services;

import com.alticelabs.common.models.rules.*;
import com.alticelabs.common.models.rules.rest.RestEvaluateRuleRequest;
import com.alticelabs.common.models.rules.rest.RestEvaluateRuleResponse;
import com.alticelabs.common.models.rules.rest.RestSaveRuleRequest;
import com.alticelabs.common.models.rules.rest.RestSaveRuleResponse;
import com.alticelabs.entry_service.configurations.EventRepository;
import com.alticelabs.entry_service.configurations.TOPICS;
import com.alticelabs.exagon_communication_lib.consumer.IConsumer;
import com.alticelabs.exagon_communication_lib.models.Event;
import com.alticelabs.exagon_communication_lib.producer.IProducer;
import com.alticelabs.exagon_communication_lib.to_be_moved.modules.kafka.KafkaConsumerImpl;
import com.alticelabs.exagon_communication_lib.to_be_moved.modules.kafka.KafkaProducerImpl;
import org.springframework.stereotype.Component;

@Component
public class EntryPointService {

    private final IConsumer consumer;

    private final IProducer producer;

    private final EventRepository repository;

    public EntryPointService(EventRepository repository) {
        this.consumer = new KafkaConsumerImpl();
        this.producer = new KafkaProducerImpl();
        this.repository = repository;

        consumer.subscribeEvent(TOPICS.EVALUATE_RULE_RESPONSES, EvaluateRuleResponse.class);
        consumer.subscribeEvent(TOPICS.SAVE_RULE_RESPONSE, SaveRuleResponse.class);
        consumer.start();
    }

    public void sendEvaluateRuleRequest(RestEvaluateRuleRequest restEvaluateRuleRequest) {
        EvaluateRuleRequest evaluateRuleRequest = new EvaluateRuleRequest(restEvaluateRuleRequest.getRuleID());
        Event evaluateRuleRequestEvent = new Event("1", TOPICS.EVALUATE_RULE_REQUESTS, evaluateRuleRequest);
        producer.produce(evaluateRuleRequestEvent);
    }

    public RestEvaluateRuleResponse getEvaluateRuleResponse() {
        Event responseEvent;

        while ((responseEvent = consumer.getNext()) == null) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        EvaluateRuleResponse evaluateRuleResponse = (EvaluateRuleResponse) responseEvent.getPayload();
        RestEvaluateRuleResponse restEvaluateRuleResponse = new RestEvaluateRuleResponse(evaluateRuleResponse.isRuleApproved());

        return restEvaluateRuleResponse;
    }

    public void sendSaveRuleRequest(RestSaveRuleRequest restSaveRuleRequest) {
        SaveRuleRequest saveRuleRequest = new SaveRuleRequest(restSaveRuleRequest.getRuleID(), restSaveRuleRequest.getRule());
        Event saveRuleRequestEvent = new Event("1", TOPICS.SAVE_RULE_REQUEST, saveRuleRequest);
        producer.produce(saveRuleRequestEvent);
    }

    public RestSaveRuleResponse getSaveRuleResponse() {
        Event responseEvent;

        while ((responseEvent = consumer.getNext()) == null) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        SaveRuleResponse saveRuleResponse = (SaveRuleResponse) responseEvent.getPayload();
        RestSaveRuleResponse restSaveRuleResponse = new RestSaveRuleResponse(saveRuleResponse.getResponse());

        return restSaveRuleResponse;
    }

}