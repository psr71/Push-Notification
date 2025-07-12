package com.fireBase.pushNotification.fireConfig;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Logger;

@Service

public class FCMInitializer {
    @Value("${app.firebase-configuration-file}")
    private String firebaseConfigPath;

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(FCMInitializer.class);


    @PostConstruct
    public void init() throws IOException {
        try (InputStream serviceAccount = new ClassPathResource(firebaseConfigPath).getInputStream()) {
            FirebaseOptions fire = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();

            if (FirebaseApp.getApps().isEmpty()) {
                FirebaseApp.initializeApp(fire);
                log.info("Firebase application has been initialized");
            }
        } catch (IOException e) {
            log.error("Failed to initialize Firebase: {}", e.getMessage(), e);
        }
    }
}
