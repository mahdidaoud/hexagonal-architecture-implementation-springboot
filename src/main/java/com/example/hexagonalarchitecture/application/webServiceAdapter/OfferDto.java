package com.example.hexagonalarchitecture.application.webServiceAdapter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OfferDto {

    Long discount;
    long originalPrice;
}
