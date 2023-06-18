package com.example.hexagonalarchitecture.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.example.hexagonalarchitecture.domain.model.Offer;
import com.example.hexagonalarchitecture.domain.port.api.OfferServicePort;
import com.example.hexagonalarchitecture.domain.port.spi.OfferPersistencePort;

@Component
public class OfferServiceImpl implements OfferServicePort {

    @Autowired
    @Qualifier("impl2")
    OfferPersistencePort offerpersistenceport;

    public Offer calculateActualPrice(Offer offer) {
        offer.setActualPrice(offer.getOriginalPrice() - ((offer.getDiscount() * offer.getOriginalPrice()) / 100));
        return offer;
    }

    @Override
    public Offer createOffer(Offer offer) {
        return offerpersistenceport.createOffer(calculateActualPrice(offer));
    }

    @Override
    public Offer getOfferById(Long id) {
        return offerpersistenceport.getOfferById(id);
    }

}
