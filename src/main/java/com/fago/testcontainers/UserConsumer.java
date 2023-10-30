package com.fago.testcontainers;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@KafkaListener(id = "myId", topics = "userTopic")
@Component
public class UserConsumer {
    private final UserService userService;

    public UserConsumer(UserService userService) {
        this.userService = userService;
    }

    @KafkaHandler
    public void consume(UserDto userDto) {
        userService.save(userDto);
    }

    @Bean
    public NewTopic topic() {
        return new NewTopic("userTopic", 1, (short) 1);
    }
}
