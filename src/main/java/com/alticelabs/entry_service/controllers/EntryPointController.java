package com.alticelabs.entry_service.controllers;

import com.alticelabs.common.models.rules.rest.RestSaveRuleRequest;
import com.alticelabs.common.models.rules.rest.RestSaveRuleResponse;
import com.alticelabs.entry_service.services.EntryPointService;
import com.alticelabs.common.models.rules.rest.RestEvaluateRuleRequest;
import com.alticelabs.common.models.rules.rest.RestEvaluateRuleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/entryPoint")
public class EntryPointController {

    @Autowired
    private EntryPointService service;

    @PostMapping("/postEvaluateRuleRequest")
    @ResponseBody
    public RestEvaluateRuleResponse postRequest(@RequestBody RestEvaluateRuleRequest restEvaluateRuleRequest) {
        service.sendEvaluateRuleRequest(restEvaluateRuleRequest);

        System.out.println("[EntryPoint] Sending events");
        long timer = System.currentTimeMillis();

        RestEvaluateRuleResponse restEvaluateRuleResponse = service.getEvaluateRuleResponse();
        long responseTime = System.currentTimeMillis() - timer;
        restEvaluateRuleResponse.setTimeSpentInMs(responseTime);
        System.out.println("[EntryPoint] Received response in " + responseTime + "ms");

        return restEvaluateRuleResponse;
    }

    @PostMapping("/postSaveRuleRequest")
    @ResponseBody
    public RestSaveRuleResponse postRule(@RequestBody RestSaveRuleRequest restSaveRuleRequest) {
        service.sendSaveRuleRequest(restSaveRuleRequest);

        System.out.println("[EntryPoint] Sending events");
        long timer = System.currentTimeMillis();

        RestSaveRuleResponse restSaveRuleResponse = service.getSaveRuleResponse();
        long responseTime = System.currentTimeMillis() - timer;
        restSaveRuleResponse.setTimeSpentInMs(responseTime);
        System.out.println("[EntryPoint] Received response in " + responseTime + "ms");

        return restSaveRuleResponse;
    }

}