package com.alticelabs.common.models.rules;

import com.alticelabs.exagon_communication_lib.models.Payload;

public class SaveRuleResponse extends Payload {

    private String response;

    public SaveRuleResponse() {}

    public SaveRuleResponse(String response) {
        this.response = response;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
