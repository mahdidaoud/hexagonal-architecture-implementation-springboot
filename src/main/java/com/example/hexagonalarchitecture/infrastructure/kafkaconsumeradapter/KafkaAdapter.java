package com.example.hexagonalarchitecture.infrastructure.kafkaconsumeradapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.hexagonalarchitecture.domain.model.Offer;
import com.example.hexagonalarchitecture.domain.port.spi.OfferPersistencePort;

@Service("impl2")
public class KafkaAdapter implements OfferPersistencePort {

  @Autowired
  KafkaTemplate<String, Offer> kafkaTemplate;

  private static final String topic = "Topic";

  @Override
  public Offer createOffer(Offer offer) {
    kafkaTemplate.send(topic, offer);
    return offer;
  }

  @Override
  public Offer getOfferById(Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getOfferById'");
  }

}
