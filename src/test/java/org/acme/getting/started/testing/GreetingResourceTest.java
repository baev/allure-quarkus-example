package org.acme.getting.started.testing;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import java.util.UUID;

import io.qameta.allure.Allure;
import io.qameta.allure.restassured.AllureRestAssured;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class GreetingResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
                .filter(new AllureRestAssured())
                .when().get("/hello")
                .then()
                .statusCode(200)
                .body(is("hello"));
    }

    @Test
    public void testGreetingEndpoint() {
        String uuid = UUID.randomUUID().toString();
        given()
                .filter(new AllureRestAssured())
                .pathParam("name", uuid)
                .when().get("/hello/greeting/{name}")
                .then()
                .statusCode(200)
                .body(is("hello " + uuid));
    }

    @Test
    void allureStepApiTest() {
        Allure.step("hi from Allure");
        Allure.attachment("Attachment", "Content");
    }
}
