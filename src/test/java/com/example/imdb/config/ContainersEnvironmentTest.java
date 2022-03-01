package com.example.imdb.config;

import com.example.imdb.containers.PostgresTestContainer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;


@Testcontainers
public class ContainersEnvironmentTest {

    // will be shared between test methods
//    @Container
//    private static final MySQLContainer MY_SQL_CONTAINER = new MySQLContainer();

    // will be started before and stopped after each test method
    @Container
    private PostgreSQLContainer postgresqlContainer = new PostgresTestContainer()
            .withDatabaseName("lunatech_imdb")
            .withUsername("postgres")
            .withPassword("postgres");

    @Test
    void test() {
        Assertions.assertTrue(postgresqlContainer.isRunning());
    }

//    @Container
//    public static PostgreSQLContainer postgreSQLContainer = PostgresTestContainer.getInstance();
}
