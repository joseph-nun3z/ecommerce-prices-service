package com.github.josephnun3z.pricesservice.boundary;

import com.github.josephnun3z.pricesservice.UriFixtures;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static com.github.josephnun3z.pricesservice.testsupport.RestAssuredConfig.restAssuredConfig;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FinalPriceBadRequestTest {

    @LocalServerPort
    private int port;

    @Test
    void givenInvalidFieldsExpectBadRequest() {
        RestAssured.port = port;

        given()
            .config(restAssuredConfig())
            .contentType(JSON)
            .queryParam("startDate", "invalid-date") // Invalid date format
            .queryParam("productId", -1) // Invalid product ID
            .queryParam("brandId", -1) // Invalid brand ID
            .when().get(UriFixtures.URI_RECOMMENDED_PRICE)
            .then()
            .statusCode(400);
    }
}
