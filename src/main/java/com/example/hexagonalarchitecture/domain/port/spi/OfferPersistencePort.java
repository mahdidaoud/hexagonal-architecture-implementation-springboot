package com.example.hexagonalarchitecture.domain.port.spi;

import com.example.hexagonalarchitecture.domain.model.Offer;

public interface OfferPersistencePort {

    public Offer createOffer(Offer offer);

    public Offer getOfferById(Long id);
    
}
