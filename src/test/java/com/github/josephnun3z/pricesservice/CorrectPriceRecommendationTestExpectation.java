package com.github.josephnun3z.pricesservice;

import com.github.josephnun3z.pricesservice.boundary.RecommendedPriceDto;

import java.util.function.Consumer;

public record CorrectPriceRecommendationTestExpectation(
    Integer testCaseNumber,
    RecommendedPriceDto expectedPrice,
    Long productId,
    Integer brandId,
    String startDate
) {

    public static Builder aTestExpectation() {
        return new Builder();
    }

    public static final class Builder {
        public Integer testCaseNumber;
        public RecommendedPriceDto recommendedPrice;
        public Long productId;
        public Integer brandId;
        public String startDate;

        public Builder with(Consumer<Builder> builderConsumer) {
            builderConsumer.accept(this);
            return this;
        }

        public CorrectPriceRecommendationTestExpectation createExpectation() {
            return new CorrectPriceRecommendationTestExpectation(
                testCaseNumber,
                recommendedPrice,
                productId,
                brandId,
                startDate
            );
        }
    }
}
