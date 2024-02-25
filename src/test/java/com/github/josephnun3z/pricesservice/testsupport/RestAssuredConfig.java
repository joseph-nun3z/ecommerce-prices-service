package com.github.josephnun3z.pricesservice.testsupport;

import io.restassured.config.ObjectMapperConfig;
import io.restassured.mapper.ObjectMapperType;

import java.util.concurrent.atomic.AtomicReference;

import static java.util.Objects.isNull;

public final class RestAssuredConfig {

    private static final AtomicReference<io.restassured.config.RestAssuredConfig> REST_ASSURED_CONFIG_REF = new AtomicReference<>();

    private RestAssuredConfig() { }

    public static io.restassured.config.RestAssuredConfig restAssuredConfig() {
        var restAssuredConfig = REST_ASSURED_CONFIG_REF.get();
        return isNull(restAssuredConfig) ? newRestAssuredConfig() : restAssuredConfig;
    }

    private static synchronized io.restassured.config.RestAssuredConfig newRestAssuredConfig() {
        if (isNull(REST_ASSURED_CONFIG_REF.get())) {
            REST_ASSURED_CONFIG_REF.set(
                    io.restassured.config.RestAssuredConfig
                            .config()
                            .objectMapperConfig(new ObjectMapperConfig(ObjectMapperType.JSONB))
            );
        }
        return REST_ASSURED_CONFIG_REF.get();
    }
}
