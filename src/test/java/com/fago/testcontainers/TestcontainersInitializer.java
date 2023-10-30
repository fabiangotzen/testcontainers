package com.fago.testcontainers;

import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.testcontainers.utility.DockerImageName;
import org.testcontainers.containers.KafkaContainer;
import org.testcontainers.containers.PostgreSQLContainer;

class TestcontainersInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    static final KafkaContainer KAFKA_CONTAINER;
    static final PostgreSQLContainer POSTGRES_CONTAINER;

    static {
        KAFKA_CONTAINER = new KafkaContainer(DockerImageName.parse("confluentinc/cp-kafka:6.2.1"));
        POSTGRES_CONTAINER = new PostgreSQLContainer(DockerImageName.parse("postgres:12"));
    }

    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
        // testcontainers deepstart method
        KAFKA_CONTAINER.start();
        POSTGRES_CONTAINER.start();

        TestPropertyValues.of(
                "spring.kafka.bootstrap-servers=" + KAFKA_CONTAINER.getBootstrapServers(),
                "spring.datasource.url=" + POSTGRES_CONTAINER.getJdbcUrl(),
                "spring.datasource.username=" + POSTGRES_CONTAINER.getUsername(),
                "spring.datasource.password=" + POSTGRES_CONTAINER.getPassword()
        ).applyTo(configurableApplicationContext.getEnvironment());
    }
}
