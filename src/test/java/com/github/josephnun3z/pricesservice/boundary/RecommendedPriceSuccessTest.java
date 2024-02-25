package com.github.josephnun3z.pricesservice.boundary;


import com.github.josephnun3z.pricesservice.CorrectPriceRecommendationTestExpectation;
import com.github.josephnun3z.pricesservice.RecommendedPriceTestBase;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.util.stream.Stream;

import static com.github.josephnun3z.pricesservice.CorrectPriceRecommendationTestExpectation.aTestExpectation;
import static com.github.josephnun3z.pricesservice.RecommendedPriceTestCases.SUCCESS_TEST_CASES;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RecommendedPriceSuccessTest extends RecommendedPriceTestBase {

    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() {
        RestAssured.port = port;
    }

    @ParameterizedTest(name = "{index} {1}")
    @MethodSource("testExpectations")
    void givenAPriceRequestExpectCorrectPriceRecommendations(CorrectPriceRecommendationTestExpectation expectation, String description) {
        assertExpectation(expectation);
    }

    private static Stream<Arguments> testExpectations() {
        return Stream.of(
            Arguments.of(
                aTestExpectation().with($ -> {
                    $.testCaseNumber = 1;
                    $.recommendedPrice = SUCCESS_TEST_CASES.get(1);
                    $.brandId = 1;
                    $.productId = 35455L;
                    $.startDate = "2020-06-14T10:00:00";
                }).createExpectation(),
                "Test 1: petición a las 10:00 del día 14 del producto 35455 para la brand 1 (ZARA)"
            ),
            Arguments.of(
                aTestExpectation().with($ -> {
                    $.testCaseNumber = 2;
                    $.recommendedPrice = SUCCESS_TEST_CASES.get(2);
                    $.brandId = 1;
                    $.productId = 35455L;
                    $.startDate = "2020-06-14T16:00:00";
                }).createExpectation(),
                "Test 2: petición a las 16:00 del día 14 del producto 35455 para la brand 1 (ZARA)"
            ),
            Arguments.of(
                aTestExpectation().with($ -> {
                    $.testCaseNumber = 3;
                    $.recommendedPrice = SUCCESS_TEST_CASES.get(3);
                    $.brandId = 1;
                    $.productId = 35455L;
                    $.startDate = "2020-06-14T21:00:00";
                }).createExpectation(),
                "Test 3: petición a las 21:00 del día 14 del producto 35455 para la brand 1 (ZARA)"
            ),
            Arguments.of(
                aTestExpectation().with($ -> {
                    $.testCaseNumber = 4;
                    $.recommendedPrice = SUCCESS_TEST_CASES.get(4);
                    $.brandId = 1;
                    $.productId = 35455L;
                    $.startDate = "2020-06-15T10:00:00";
                }).createExpectation(),
                "Test 4: petición a las 10:00 del día 15 del producto 35455 para la brand 1 (ZARA)"
            ),
            Arguments.of(
                aTestExpectation().with($ -> {
                    $.testCaseNumber = 5;
                    $.recommendedPrice = SUCCESS_TEST_CASES.get(5);
                    $.brandId = 1;
                    $.productId = 35455L;
                    $.startDate = "2020-06-16T21:00:00";
                }).createExpectation(),
                "Test 5: petición a las 21:00 del día 16 del producto 35455 para la brand 1 (ZARA)"
            )
        );
    }
}
