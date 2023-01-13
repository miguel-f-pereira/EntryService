package com.alticelabs.common.models.rules.rest;


public class RestEvaluateRuleResponse {

    private final boolean response;

    private long timeSpentInMs;

    public RestEvaluateRuleResponse(boolean response) {
        this.response = response;
    }

    public boolean getResponse() {
        return response;
    }

    public long getTimeSpentInMs() {
        return timeSpentInMs;
    }

    public void setTimeSpentInMs(long timeSpentInMs) {
        this.timeSpentInMs = timeSpentInMs;
    }

}
