package com.fago.testcontainers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.jupiter.api.Assertions;
import java.util.UUID;

import static java.time.Duration.ofSeconds;
import static org.testcontainers.shaded.org.awaitility.Awaitility.await;

@IntegrationTest(properties = {""})
public class UserConsumerIntegrationTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserProducer userProducer;

    @Test
    void testConsumeUserMessage() {
        //arrange
        var id = UUID.randomUUID();
        var userDto = new UserDto(id, "John", "52");

        // act
        userProducer.send(userDto);

        //assert
        await().pollDelay(ofSeconds(3)).until(() -> userRepository.findById(id).isPresent());
        User user = userRepository.findById(id).orElseThrow();
        Assertions.assertNotNull(user);
    }
}
