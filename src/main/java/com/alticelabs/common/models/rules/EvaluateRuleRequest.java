package com.alticelabs.common.models.rules;

import com.alticelabs.exagon_communication_lib.models.Payload;

public class EvaluateRuleRequest extends Payload {

    private final int ruleID;

    public EvaluateRuleRequest(int ruleID) {
        this.ruleID = ruleID;
    }

    public int getRuleID() {
        return ruleID;
    }

}