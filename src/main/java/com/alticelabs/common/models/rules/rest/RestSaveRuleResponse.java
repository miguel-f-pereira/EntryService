package com.alticelabs.common.models.rules.rest;

public class RestSaveRuleResponse {

    private final String response;

    private long timeSpentInMs;

    public RestSaveRuleResponse(String response) {
        this.response = response;
    }

    public String getResponse() {
        return response;
    }

    public long getTimeSpentInMs() {
        return timeSpentInMs;
    }

    public void setTimeSpentInMs(long timeSpentInMs) {
        this.timeSpentInMs = timeSpentInMs;
    }

}
