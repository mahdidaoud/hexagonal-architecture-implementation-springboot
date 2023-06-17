package com.example.hexagonalarchitecture.infrastructure.h2dbadapter;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.hexagonalarchitecture.domain.model.Offer;
import com.example.hexagonalarchitecture.infrastructure.h2dbadapter.entities.Offerentity;

@Mapper(componentModel = "spring")
public interface OfferMapperEntityModel {

    OfferMapperEntityModel INSTANCE = Mappers.getMapper(OfferMapperEntityModel.class);

    Offerentity offerModelToOfferEntity(Offer offer);

    Offer offerEntityToOfferModel(Offerentity offerentity);


}