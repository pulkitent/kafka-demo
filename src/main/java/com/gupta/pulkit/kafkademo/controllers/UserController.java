package com.gupta.pulkit.kafkademo.controllers;

import com.gupta.pulkit.kafkademo.models.User;
import com.gupta.pulkit.kafkademo.service.KafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    private final KafkaProducer kafkaProducer;

    @Autowired
    UserController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping
    public void sendUserDetailsToKafkaUserTopic(@RequestBody() User user) {
        LOGGER.info("User details received " + user);
        kafkaProducer.produceUserDetails(user);
    }
}