package com.example.hexagonalarchitecture.infrastructure.h2dbadapter;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hexagonalarchitecture.infrastructure.h2dbadapter.entities.Offerentity;

public interface OfferRespositoryH2 extends JpaRepository<Offerentity, Long> {

}
