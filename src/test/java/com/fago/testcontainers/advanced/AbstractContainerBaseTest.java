package com.fago.testcontainers.advanced;

import org.testcontainers.containers.PostgreSQLContainer;

public class AbstractContainerBaseTest {

    static final PostgreSQLContainer<?> POSTGRE_SQL_CONTAINER;

    static {
        POSTGRE_SQL_CONTAINER = new PostgreSQLContainer<>("postgres:12")
                .withDatabaseName("testcontainers")
                .withUsername("testcontainers")
                .withPassword("testcontainers");
        POSTGRE_SQL_CONTAINER.start();
    }
}
