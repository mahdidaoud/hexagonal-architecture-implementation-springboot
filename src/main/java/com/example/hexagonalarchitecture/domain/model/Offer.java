package com.example.hexagonalarchitecture.domain.model;

public class Offer {

    Long id;
    Long discount;
    long actualPrice;
    long originalPrice;

    public void setId(Long id) {
        this.id = id;
    }
    public Offer(Long id, Long discount, long actualPrice, long originalPrice) {
        this.id = id;
        this.discount = discount;
        this.actualPrice = actualPrice;
        this.originalPrice = originalPrice;
    }
    public void setDiscount(Long discount) {
        this.discount = discount;
    }
    public void setActualPrice(long actualPrice) {
        this.actualPrice = actualPrice;
    }
    public void setOriginalPrice(long originalPrice) {
        this.originalPrice = originalPrice;
    }
    public Long getId() {
        return id;
    }
    public Long getDiscount() {
        return discount;
    }
    public long getActualPrice() {
        return actualPrice;
    }
    public long getOriginalPrice() {
        return originalPrice;
    }
    
}
