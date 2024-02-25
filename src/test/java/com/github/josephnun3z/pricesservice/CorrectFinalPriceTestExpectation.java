package com.github.josephnun3z.pricesservice;

import com.github.josephnun3z.pricesservice.boundary.FinalPriceDto;

import java.util.function.Consumer;

public record CorrectFinalPriceTestExpectation(
    Integer testCaseNumber,
    FinalPriceDto expectedPrice,
    Long productId,
    Integer brandId,
    String startDate
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

        public Builder with(Consumer<Builder> builderConsumer) {
            builderConsumer.accept(this);
            return this;
        }

        public CorrectFinalPriceTestExpectation createExpectation() {
            return new CorrectFinalPriceTestExpectation(
                testCaseNumber,
                expectedPrice,
                productId,
                brandId,
                startDate
            );
        }
    }
}
