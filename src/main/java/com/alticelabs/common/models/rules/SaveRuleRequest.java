package com.alticelabs.common.models.rules;

import com.alticelabs.exagon_communication_lib.models.Payload;

public class SaveRuleRequest extends Payload {

    private int ruleID;

    private String rule;

    public SaveRuleRequest() {}

    public SaveRuleRequest(int ruleID, String rule) {
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
