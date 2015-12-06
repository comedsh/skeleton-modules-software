package com.fenghua.auto.sku.domain;

import com.fenghua.auto.backend.domain.DomainObject;

public class SkuStock implements DomainObject{
    private Long id;

    private Integer stockCount;

    private Integer stockAvailability;

    private Long repertoryId;

    private Long skuId;
    
    private Long saledCount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getStockCount() {
        return stockCount;
    }

    public void setStockCount(Integer stockCount) {
        this.stockCount = stockCount;
    }

    public Integer getStockAvailability() {
        return stockAvailability;
    }

    public void setStockAvailability(Integer stockAvailability) {
        this.stockAvailability = stockAvailability;
    }

    public Long getRepertoryId() {
        return repertoryId;
    }

    public void setRepertoryId(Long repertoryId) {
        this.repertoryId = repertoryId;
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

	public Long getSaledCount() {
		return saledCount;
	}

	public void setSaledCount(Long saledCount) {
		this.saledCount = saledCount;
	}
    
    
}