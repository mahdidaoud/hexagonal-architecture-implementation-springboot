package com.example.hexagonalarchitecture.domain.port.api;

import com.example.hexagonalarchitecture.domain.model.Offer;

public interface OfferServicePort {

    public Offer createOffer(Offer offer);

    public Offer getOfferById(Long id);
    
}
