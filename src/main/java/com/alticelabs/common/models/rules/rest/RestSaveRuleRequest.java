package com.alticelabs.common.models.rules.rest;

public class RestSaveRuleRequest {

    private int ruleID;

    private String rule;

    public RestSaveRuleRequest() {
    }

    public RestSaveRuleRequest(int ruleID, String rule) {
        this.ruleID = ruleID;
        this.rule = rule;
    }

    public int getRuleID() {
        return ruleID;
    }

    public void setRuleID(int ruleID) {
        this.ruleID = ruleID;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }
}