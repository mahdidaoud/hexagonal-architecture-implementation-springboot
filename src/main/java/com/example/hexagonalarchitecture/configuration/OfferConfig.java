package com.example.hexagonalarchitecture.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.hexagonalarchitecture.domain.port.api.OfferServicePort;
import com.example.hexagonalarchitecture.domain.port.spi.OfferPersistencePort;
import com.example.hexagonalarchitecture.domain.service.OfferServiceImpl;
import com.example.hexagonalarchitecture.infrastructure.h2dbadapter.H2DBAdapter;

@Configuration
public class OfferConfig {

    @Bean
    public OfferPersistencePort offerPersistence() {
        return new H2DBAdapter();
    }

    @Bean
    public OfferServicePort offerService() {
        return new OfferServiceImpl(offerPersistence());
    }


}
