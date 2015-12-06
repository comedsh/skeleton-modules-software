package com.fenghua.auto.order.domain;

import com.fenghua.auto.backend.domain.DomainObject;
import java.util.Date;

public class OrderTransportDetail implements DomainObject {
	private static final long serialVersionUID = 1L;
    private Long id;

    private Long transportId;

    private Long orderItemId;

    private Long skuId;

    private String skuCode;

    private String skuName;

    private Integer qty;

    private Long entryId;

    private Date entryTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTransportId() {
        return transportId;
    }

    public void setTransportId(Long transportId) {
        this.transportId = transportId;
    }

    public Long getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Long orderItemId) {
        this.orderItemId = orderItemId;
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode == null ? null : skuCode.trim();
    }

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName == null ? null : skuName.trim();
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Long getEntryId() {
        return entryId;
    }

    public void setEntryId(Long entryId) {
        this.entryId = entryId;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }
}