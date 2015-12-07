package com.fenghua.auto.sku.backend.domain;

import com.fenghua.auto.backend.domain.DomainObject;

public class SkuCatalogAttrValue implements DomainObject {
	private static final long serialVersionUID = 1L;
    private Long id;

    private Long catalogAttrId;

    private String sttrValue;

    private Long skuId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCatalogAttrId() {
        return catalogAttrId;
    }

    public void setCatalogAttrId(Long catalogAttrId) {
        this.catalogAttrId = catalogAttrId;
    }

    public String getSttrValue() {
        return sttrValue;
    }

    public void setSttrValue(String sttrValue) {
        this.sttrValue = sttrValue == null ? null : sttrValue.trim();
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }
}