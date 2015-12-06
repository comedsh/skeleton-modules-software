package com.fenghua.auto.sku.domain;

import com.fenghua.auto.backend.domain.DomainObject;

public class SkuImageHtml  implements DomainObject{
    private Long id;

    private Long skuId;

    private String contentsHtml;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public String getContentsHtml() {
        return contentsHtml;
    }

    public void setContentsHtml(String contentsHtml) {
        this.contentsHtml = contentsHtml == null ? null : contentsHtml.trim();
    }
}