package com.github.josephnun3z.pricesservice;

import com.github.josephnun3z.pricesservice.boundary.FinalPriceDto;

import java.util.function.Consumer;

public class FinalPriceDtoBuilder {

    public Long productId;
    public Integer brandId;
    public Integer priceListId;
    public Double finalPrice;
    public String currency;

    public static FinalPriceDtoBuilder builder() {
        return new FinalPriceDtoBuilder();
    }

    public FinalPriceDtoBuilder with(Consumer<FinalPriceDtoBuilder> builderConsumer) {
        builderConsumer.accept(this);
        return this;
    }

    public FinalPriceDto build() {
        return new FinalPriceDto(
            productId,
            brandId,
            priceListId,
            finalPrice,
            currency
        );
    }
}
