package com.fireBase.pushNotification.fireConfig;

import lombok.Getter;

@Getter
public enum NotificationParameter {

        SOUND("default"),
        COLOR("#FFFF00");

        private final String value;

        NotificationParameter(String value) {
            this.value = value;
        }

}
