package ru.netology.rest;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


class PostmanEchoTest {
    @Test
    void shouldReturnDemoAccounts() {
        given()
                .baseUri("https://postman-echo.com")
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "  \"name\": \"Ivan\",\n" +
                        "  \"age\": 21\n" +
                        "}")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("data.name", equalTo("Ivan"))
                .body("data.age", equalTo(21));
    }
}
