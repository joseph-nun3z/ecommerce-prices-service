package com.github.josephnun3z.pricesservice.repository;

import com.github.josephnun3z.pricesservice.entity.Price;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Repository
public interface PriceRepository extends ReactiveCrudRepository<Price, Long> {

    @Query(
        """
            SELECT * FROM price p
            WHERE :dateTime BETWEEN p.start_date AND p.end_date
            AND p.product_id = :productId
            AND p.brand_id = :brandId
            ORDER BY p.priority DESC
            LIMIT 1
            """
    )
    Mono<Price> findTopByDateTimeProductAndBrand(LocalDateTime dateTime, Long productId, Integer brandId);

}
