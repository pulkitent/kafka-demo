package com.gupta.pulkit.kafkademo.service;

import com.gupta.pulkit.kafkademo.models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);

    @KafkaListener(topics = "users", groupId = "group_id")
    public void consumeUserDetails(String user) {
        LOGGER.info("Consumed user details -> " + user);
    }
}