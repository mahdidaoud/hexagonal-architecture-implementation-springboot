package com.example.hexagonalarchitecture.domain.service;

import com.example.hexagonalarchitecture.domain.model.Offer;
import com.example.hexagonalarchitecture.domain.port.api.OfferServicePort;
import com.example.hexagonalarchitecture.domain.port.spi.OfferPersistencePort;

public class OfferServiceImpl implements OfferServicePort {

    OfferPersistencePort offerpersistenceport ;

    public OfferServiceImpl(OfferPersistencePort offerPersistencePort) {
        this.offerpersistenceport = offerPersistencePort;
    }


    public Offer calculateActualPrice(Offer offer){
        offer.setActualPrice(offer.getOriginalPrice()-((offer.getDiscount()*offer.getOriginalPrice())/100) ); 
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
