package com.github.josephnun3z.pricesservice.boundary;

import com.github.josephnun3z.pricesservice.FinalPriceTestBase;
import com.github.josephnun3z.pricesservice.FinalPriceTestExpectation;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.stream.Stream;

import static com.github.josephnun3z.pricesservice.FinalPriceTestExpectation.aTestExpectation;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class FinalPriceNotFoundTest extends FinalPriceTestBase {

    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() {
        RestAssured.port = port;
    }

    @ParameterizedTest(name = "{index} {1}")
    @MethodSource("notFoundExpectations")
    void givenAFinalPriceRequestExpect404(FinalPriceTestExpectation expectation, String ignoredDescription) {
        assertExpectation(expectation);
    }

    private static Stream<Arguments> notFoundExpectations() {
        return Stream.of(
            Arguments.of(
                aTestExpectation().with($ -> {
                    $.brandId = 99; // Assuming brandId '99' does not exist
                    $.productId = 35455L;
                    $.startDate = "2020-06-14T10:00:00";
                    $.expectedHttpCode = HttpStatus.NOT_FOUND.value();
                }).createExpectation(),
                "Test 1: Request with non-existent brandId"
            ),
            Arguments.of(
                aTestExpectation().with($ -> {
                    $.brandId = 1;
                    $.productId = 99999L; // Assuming productId '99999' does not exist
                    $.startDate = "2020-06-14T10:00:00";
                    $.expectedHttpCode = HttpStatus.NOT_FOUND.value();
                }).createExpectation(),
                "Test 2: Request with non-existent productId"
            ),
            Arguments.of(
                aTestExpectation().with($ -> {
                    $.brandId = 1;
                    $.productId = 35455L;
                    $.startDate = "2021-01-01T00:00:00"; // Assuming no prices for this future date
                    $.expectedHttpCode = HttpStatus.NOT_FOUND.value();
                }).createExpectation(),
                "Test 3: Request with date outside any price range"
            )
        );
    }

}

