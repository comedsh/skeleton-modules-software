package com.fenghua.auto.sku.backend.domain;

import com.fenghua.auto.backend.domain.DomainObject;

public class CatalogSku implements DomainObject {
	private static final long serialVersionUID = 1L;
    private Long catalogId;

    private Long skuId;

    public Long getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(Long catalogId) {
        this.catalogId = catalogId;
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }
}