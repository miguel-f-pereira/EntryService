package com.alticelabs.common.models;

import com.alticelabs.exagon_communication_lib.models.Payload;

public class Notification2 extends Payload {

    private final int value2;

    public Notification2(int value2) {
        this.value2 = value2;
    }

    public int getValue2() {
        return value2;
    }

}
