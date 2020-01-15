package com.gupta.pulkit.kafkademo.service;

import com.gupta.pulkit.kafkademo.models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);
    private static final String TOPIC = "users";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void produceUserDetails(User user) {
        LOGGER.info("Producing user details -> " + user);
        String userString = user.toString();
        kafkaTemplate.send(TOPIC, userString);
    }
}