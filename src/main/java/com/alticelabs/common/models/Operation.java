package com.alticelabs.common.models;

public class Operation {

    private String id;

    private String operation;

    public Operation() {
    }

    public Operation(String id, String operation) {
        this.id = id;
        this.operation = operation;
    }

    public String getId() {
        return id;
    }

    public String getOperation() {
        return operation;
    }

}
