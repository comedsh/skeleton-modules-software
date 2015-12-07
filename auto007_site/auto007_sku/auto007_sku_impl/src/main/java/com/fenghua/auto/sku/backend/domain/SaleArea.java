package com.fenghua.auto.sku.backend.domain;

import com.fenghua.auto.backend.domain.DomainObject;

public class SaleArea implements DomainObject {
	private static final long serialVersionUID = 1L;
    private Long id;

    private Long saleId;

    private Integer type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSaleId() {
        return saleId;
    }

    public void setSaleId(Long saleId) {
        this.saleId = saleId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}