package com.fireBase.pushNotification.model;

import lombok.Data;

@Data
public class PushNotificationResponse {
    private int status;
    private String message;

    public PushNotificationResponse() {
    }

    public PushNotificationResponse(int value, String s) {
    }
}
