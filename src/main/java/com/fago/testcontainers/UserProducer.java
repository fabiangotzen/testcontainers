package com.fago.testcontainers;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserProducer {

    private final KafkaTemplate<String, UserDto> kafkaTemplate;

    public UserProducer(KafkaTemplate<String, UserDto> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(UserDto userDto) {
        kafkaTemplate.send("userTopic", userDto);
    }
}
