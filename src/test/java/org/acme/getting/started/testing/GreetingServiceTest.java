package org.acme.getting.started.testing;

import jakarta.inject.Inject;

import io.qameta.allure.Allure;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class GreetingServiceTest {

    @Inject
    GreetingService service;

    @Test
    public void testGreetingService() {
        Allure.step("check greeting service", () -> {
            Assertions.assertEquals("hello Quarkus", service.greeting("Quarkus"));
        });
    }
}
