package com.fenghua.auto.sku.backend.domain;

import com.fenghua.auto.backend.domain.DomainObject;

public class SkuStatistic implements DomainObject {
	private static final long serialVersionUID = 1L;
    private Long id;

    private Long saleCount;

    private Long buyerCount;

    private String highPraise;

    private Long commentCount;

    private Long highCommentCount;

    private Long skuId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSaleCount() {
        return saleCount;
    }

    public void setSaleCount(Long saleCount) {
        this.saleCount = saleCount;
    }

    public Long getBuyerCount() {
        return buyerCount;
    }

    public void setBuyerCount(Long buyerCount) {
        this.buyerCount = buyerCount;
    }

    public String getHighPraise() {
        return highPraise;
    }

    public void setHighPraise(String highPraise) {
        this.highPraise = highPraise == null ? null : highPraise.trim();
    }

    public Long getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Long commentCount) {
        this.commentCount = commentCount;
    }

    public Long getHighCommentCount() {
        return highCommentCount;
    }

    public void setHighCommentCount(Long highCommentCount) {
        this.highCommentCount = highCommentCount;
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }
}