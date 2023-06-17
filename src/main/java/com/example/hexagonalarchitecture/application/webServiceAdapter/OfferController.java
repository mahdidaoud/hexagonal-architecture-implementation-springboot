package com.example.hexagonalarchitecture.application.webServiceAdapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.hexagonalarchitecture.domain.model.Offer;
import com.example.hexagonalarchitecture.domain.port.api.OfferServicePort;

@RestController
public class OfferController {

    @Autowired
    OfferServicePort offerserviceport;

    @PostMapping("/")
    public OfferDto createOffer(@RequestBody OfferDto offerdto){
        Offer offer = OfferMapperDtoModel.INSTANCE.offerDtoToOfferModel(offerdto);
        return OfferMapperDtoModel.INSTANCE.offerModelToOfferDto(offerserviceport.createOffer(offer)); 
    }
    
    @GetMapping("/{id}")
    public OfferDto getOffer(@PathVariable(value = "id") Long id){
        return OfferMapperDtoModel.INSTANCE.offerModelToOfferDto(offerserviceport.getOfferById(id)); 

    }
}
