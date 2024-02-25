package com.github.josephnun3z.pricesservice.boundary;


import com.github.josephnun3z.pricesservice.CorrectPriceRecommendationTestExpectation;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

@SpringBootTest
class PricesResourceTest {

    @ParameterizedTest(name = "{index}, {1}")
    @MethodSource("testExpectations")
    void givenAPriceRequestExpectCorrectPriceRecommendations(CorrectPriceRecommendationTestExpectation expectation) {

    }

    private void assertExpectation(CorrectPriceRecommendationTestExpectation expectation) {
    }

    private static Stream<Arguments> testExpectations() {
        return Stream.of(

        );
    }

}