package com.example.hexagonalarchitecture.application.csvfileadapter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.hexagonalarchitecture.application.OfferDto;
import com.example.hexagonalarchitecture.application.OfferMapperDtoModel;
import com.example.hexagonalarchitecture.domain.model.Offer;
import com.example.hexagonalarchitecture.domain.port.api.OfferServicePort;

@Configuration
public class FileAdapter {

    @Autowired
    OfferServicePort offerserviceport;

    @Value("${csvFilePath}")
    private String csvFilePath;

    @Bean
    public void getOffers() {

        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
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
