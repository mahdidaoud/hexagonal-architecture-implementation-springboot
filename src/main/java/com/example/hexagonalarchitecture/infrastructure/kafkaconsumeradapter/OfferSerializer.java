package com.example.hexagonalarchitecture.infrastructure.kafkaconsumeradapter;

import java.nio.charset.StandardCharsets;

import org.apache.kafka.common.serialization.Serializer;

import com.example.hexagonalarchitecture.domain.model.Offer;

public class OfferSerializer implements Serializer<Offer> {
    @Override
    public byte[] serialize(String topic, Offer data) {
        // Convert the Offer object to a string representation
        String jsonString = data.toString();

        // Convert the string to bytes using an appropriate encoding
        return jsonString.getBytes(StandardCharsets.UTF_8);
    }
}
