package com.fago.testcontainers.advanced;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.OracleContainer;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

@Testcontainers
public class TestcontainersAdvancedTest extends AbstractContainerBaseTest{

    @Test
    public void testSetup() {
        String jdbcUrl = POSTGRE_SQL_CONTAINER.getJdbcUrl();
        Assertions.assertThat(jdbcUrl).isNotNull();
    }
}
