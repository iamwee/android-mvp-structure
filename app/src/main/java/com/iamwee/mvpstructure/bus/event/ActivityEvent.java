package com.iamwee.mvpstructure.bus.event;


public class ActivityEvent {

    private int status;

    public ActivityEvent(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
