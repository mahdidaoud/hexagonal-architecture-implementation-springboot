package com.example.hexagonalarchitecture.application.csvfileadapter;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.example.hexagonalarchitecture.application.OfferDto;
import com.example.hexagonalarchitecture.application.OfferMapperDtoModel;
import com.example.hexagonalarchitecture.domain.model.Offer;
import com.example.hexagonalarchitecture.domain.port.api.OfferServicePort;

@Configuration
public class FileAdapter {

    @Autowired
    OfferServicePort offerserviceport;

    @Bean
    public void getOffers() {

        String csvFilePath = "/home/mahdi/Desktop/Test/hexagonal-architecture-implementation-springboot/offers.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath)))  {
            String line;
            boolean headerSkipped = true;

            while ((line = br.readLine()) != null) {
                if (!headerSkipped) {
                    headerSkipped = true;
                    continue; 
                }

                String[] columns = line.split(",");
                if (columns.length >= 2) {
                    String discountString = columns[0].trim();
                    String originalPriceString = columns[1].trim();

                    OfferDto offerdto = new OfferDto(Long.parseLong(discountString),
                            Long.parseLong(originalPriceString));
                    Offer offer = OfferMapperDtoModel.INSTANCE.offerDtoToOfferModel(offerdto);
                    offerserviceport.createOffer(offer);

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
 