package com.github.josephnun3z.pricesservice;

import com.github.josephnun3z.pricesservice.boundary.FinalPriceDto;

import java.util.function.Consumer;

public record FinalPriceTestExpectation(
    Integer testCaseNumber,
    FinalPriceDto expectedPrice,
    Long productId,
    Integer brandId,
    String startDate,
    int expectedHttpCode
) {

    public static Builder aTestExpectation() {
        return new Builder();
    }

    public static final class Builder {
        public Integer testCaseNumber;
        public FinalPriceDto expectedPrice;
        public Long productId;
        public Integer brandId;
        public String startDate;
        public int expectedHttpCode;

        public Builder with(Consumer<Builder> builderConsumer) {
            builderConsumer.accept(this);
            return this;
        }

        public FinalPriceTestExpectation createExpectation() {
            return new FinalPriceTestExpectation(
                testCaseNumber,
                expectedPrice,
                productId,
                brandId,
                startDate,
                expectedHttpCode
            );
        }
    }
}
