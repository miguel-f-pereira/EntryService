package com.alticelabs.common.models.rules.rest;

public class RestEvaluateRuleRequest {

    private int ruleID;

    public RestEvaluateRuleRequest() {
    }

    public RestEvaluateRuleRequest(int ruleID) {
        this.ruleID = ruleID;
    }

    public int getRuleID() {
        return ruleID;
    }

    public void setRuleID(int ruleID) {
        this.ruleID = ruleID;
    }

}