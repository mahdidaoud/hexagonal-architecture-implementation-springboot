package com.example.hexagonalarchitecture.application;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.hexagonalarchitecture.domain.model.Offer;

@Mapper(componentModel = "spring")
public interface OfferMapperDtoModel {

    OfferMapperDtoModel INSTANCE = Mappers.getMapper(OfferMapperDtoModel.class);

    OfferDto offerModelToOfferDto(Offer offer);

    Offer offerDtoToOfferModel(OfferDto offerdto);


}