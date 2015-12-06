package com.fenghua.auto.order.domain;

import com.fenghua.auto.backend.domain.DomainObject;
import java.math.BigDecimal;
import java.util.Date;

public class ShoppingCart implements DomainObject {
	private static final long serialVersionUID = 1L;
    private Long id;

    private Long buyerId;

    private Long skuId;

    private BigDecimal originalPrice;

    private BigDecimal salePrice;

    private BigDecimal currentPrice;

    private String discountStrategyDesc;

    private Integer qty;

    private Date lastPriceTime;

    private Date addTime;

    private Long sellerId;

    public void addQty(int qty) {
    	if(this.qty == null) {
    		this.qty = qty;
    	}
    	this.qty += qty;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public BigDecimal getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(BigDecimal originalPrice) {
        this.originalPrice = originalPrice;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public BigDecimal getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(BigDecimal currentPrice) {
        this.currentPrice = currentPrice;
    }

    public String getDiscountStrategyDesc() {
        return discountStrategyDesc;
    }

    public void setDiscountStrategyDesc(String discountStrategyDesc) {
        this.discountStrategyDesc = discountStrategyDesc == null ? null : discountStrategyDesc.trim();
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Date getLastPriceTime() {
        return lastPriceTime;
    }

    public void setLastPriceTime(Date lastPriceTime) {
        this.lastPriceTime = lastPriceTime;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }
}