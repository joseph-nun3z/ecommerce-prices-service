package com.github.josephnun3z.pricesservice.control;

import com.github.josephnun3z.pricesservice.boundary.FinalPriceDto;
import com.github.josephnun3z.pricesservice.entity.Price;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static com.github.josephnun3z.pricesservice.ancillary.constants.PropertyName.PROP_FINAL_PRICE;
import static com.github.josephnun3z.pricesservice.ancillary.constants.PropertyName.PROP_PRICE;

@Mapper(componentModel = "spring")
public interface PriceMapper {

    @Mapping(target = PROP_FINAL_PRICE, source = PROP_PRICE)
    FinalPriceDto finalPriceFrom(Price source);

}
