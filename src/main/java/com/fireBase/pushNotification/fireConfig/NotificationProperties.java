package com.fireBase.pushNotification.fireConfig;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Setter
@Getter
@Component
@ConfigurationProperties(prefix = "app.notifications")
public class NotificationProperties {

    private Map<String, String> defaults;

}
