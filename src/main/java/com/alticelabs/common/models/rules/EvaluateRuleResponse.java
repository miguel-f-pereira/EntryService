package com.alticelabs.common.models.rules;

import com.alticelabs.exagon_communication_lib.models.Payload;

public class EvaluateRuleResponse extends Payload {

    private boolean ruleApproved;

    public EvaluateRuleResponse() {
    }

    public EvaluateRuleResponse(boolean ruleApproved) {
        this.ruleApproved = ruleApproved;
    }

    public boolean isRuleApproved() {
        return ruleApproved;
    }

    public void setRuleApproved(boolean ruleApproved) {
        this.ruleApproved = ruleApproved;
    }

}