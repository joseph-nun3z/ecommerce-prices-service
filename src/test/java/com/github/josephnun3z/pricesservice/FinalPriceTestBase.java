package com.github.josephnun3z.pricesservice;

import com.github.josephnun3z.pricesservice.boundary.FinalPriceDto;
import org.springframework.http.HttpStatus;

import static com.github.josephnun3z.pricesservice.testsupport.RestAssuredConfig.restAssuredConfig;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class FinalPriceTestBase {

    protected final void assertExpectation(FinalPriceTestExpectation expectation) {
        var result = given()
            .config(restAssuredConfig())
            .contentType(JSON)
            .queryParam("startDate", expectation.startDate())
            .queryParam("productId", expectation.productId())
            .queryParam("brandId", expectation.brandId())
            .when().get(UriFixtures.URI_RECOMMENDED_PRICE)
            .then().statusCode(expectation.expectedHttpCode())
            .extract();

        if (HttpStatus.OK.value() == expectation.expectedHttpCode()) {
            assertThat(result.as(FinalPriceDto.class), is(expectation.expectedPrice()));
        }
    }
}
