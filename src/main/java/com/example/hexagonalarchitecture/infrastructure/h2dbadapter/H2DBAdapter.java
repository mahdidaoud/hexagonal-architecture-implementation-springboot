package com.example.hexagonalarchitecture.infrastructure.h2dbadapter;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.hexagonalarchitecture.domain.model.Offer;
import com.example.hexagonalarchitecture.domain.port.spi.OfferPersistencePort;
import com.example.hexagonalarchitecture.infrastructure.h2dbadapter.entities.Offerentity;

public class H2DBAdapter implements OfferPersistencePort {

    @Autowired
    OfferRespositoryH2 offerrepo;
    @Override
    public Offer createOffer(Offer offer) {
        Offerentity offerentity = OfferMapperEntityModel.INSTANCE.offerModelToOfferEntity(offer);
        return OfferMapperEntityModel.INSTANCE.offerEntityToOfferModel(offerrepo.save(offerentity));
    }

    @Override
    public Offer getOfferById(Long id) {

        return OfferMapperEntityModel.INSTANCE.offerEntityToOfferModel(offerrepo.getReferenceById(id));
    }
    
    
}
