package com.fago.testcontainers;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
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

//    @Autowired
//    Flyway flyway;
//
//    @BeforeEach
//    void cleanDatabase(){
//        flyway.clean();
//        flyway.migrate();
//    }
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
