package com.github.josephnun3z.pricesservice.control;

import com.github.josephnun3z.pricesservice.boundary.CreatePriceDto;
import com.github.josephnun3z.pricesservice.boundary.FinalPriceDto;
import com.github.josephnun3z.pricesservice.entity.Price;
import com.github.josephnun3z.pricesservice.repository.PriceRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FinalPriceService {

    private final PriceRepository priceRepository;
    private final PriceMapper priceMapper;

    public FinalPriceService(PriceRepository priceRepository, PriceMapper priceMapper) {
        this.priceRepository = priceRepository;
        this.priceMapper = priceMapper;
    }

    public Mono<FinalPriceDto> findFinalPriceFor(LocalDateTime dateTime, Long productId, Integer brandId) {
        return priceRepository.findTopByDateTimeProductAndBrand(dateTime, productId, brandId)
            .map(priceMapper::finalPriceFrom);
    }

    public Mono<Void> save(List<CreatePriceDto> request) {
        List<Mono<Price>> saveOperations = request.stream()
            .map(newPrice -> {
                Price price = priceMapper.priceFrom(newPrice);
                return priceRepository.save(price);
            }).collect(Collectors.toList());

        return Flux.merge(saveOperations).then();
    }
}
