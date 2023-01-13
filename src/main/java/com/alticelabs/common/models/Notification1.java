package com.alticelabs.common.models;

import com.alticelabs.exagon_communication_lib.models.Payload;

public class Notification1 extends Payload {

    private final int value1;

    public Notification1(int value1) {
        this.value1 = value1;
    }

    public int getValue1() {
        return value1;
    }

}
