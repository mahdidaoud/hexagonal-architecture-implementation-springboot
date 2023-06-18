package com.example.hexagonalarchitecture.infrastructure.kafkaconsumeradapter;

import java.nio.charset.StandardCharsets;

import org.apache.kafka.common.serialization.Serializer;

import com.example.hexagonalarchitecture.domain.model.Offer;

public class OfferSerializer implements Serializer<Offer> {
    @Override
    public byte[] serialize(String topic, Offer data) {
        String jsonString = data.toString();
        return jsonString.getBytes(StandardCharsets.UTF_8);
    }
}
