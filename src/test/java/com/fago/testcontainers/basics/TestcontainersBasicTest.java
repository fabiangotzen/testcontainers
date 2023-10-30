package com.fago.testcontainers.basics;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.OracleContainer;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;
@Testcontainers
public class TestcontainersBasicTest {

    @Container
    private final PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer<>(DockerImageName.parse("postgres:12"))
            .withDatabaseName("testcontainers")
            .withPassword("testcontainers")
            .withPassword("testcontainers");


    @Container
    private final OracleContainer oracleContainer = new OracleContainer(DockerImageName.parse("gvenzl/oracle-xe"))
            .withDatabaseName("testcontainers")
            .withPassword("testcontainers")
            .withPassword("testcontainers");

    @Test
    public void testSetup() {
        String jdbcUrl = this.postgreSQLContainer.getJdbcUrl();
        Assertions.assertThat(jdbcUrl).isNotNull();
    }
}
