package com.github.josephnun3z.pricesservice.boundary;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class FinalPriceRequestDto {

    @NotNull(message = "startDate is required")
    private String startDate;

    @NotNull(message = "productId is required")
    @Min(value = 1, message = "productId must be positive")
    private Long productId;

    @NotNull(message = "brandId is required")
    @Min(value = 1, message = "brandId must be positive")
    private Integer brandId;

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }
}
