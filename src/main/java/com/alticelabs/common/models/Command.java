package com.alticelabs.common.models;

import com.alticelabs.exagon_communication_lib.models.Payload;

public class Command extends Payload {

    private String id;

    public Command() {
    }

    public Command(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
