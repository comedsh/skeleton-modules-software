package com.fenghua.auto.finance.domain;

import com.fenghua.auto.backend.domain.DomainObject;
import java.math.BigDecimal;
import java.util.Date;

public class TransactionFlow implements DomainObject {
	private static final long serialVersionUID = 1L;
    private Long id;

    private Integer tranType;

    private Long bizOrderId;

    private Long masterOrderId;

    private String masterOrderNo;

    private Long orderId;

    private String orderNo;

    private Long buyerId;

    private Long sellerId;

    private Integer tranMethod;

    private String tradeNo;

    private BigDecimal tranAmount;

    private Integer status;

    private Long operatorId;

    private Date tranTime;

    private Long billId;

    private Long sumOperatorId;

    private Date sumTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTranType() {
        return tranType;
    }

    public void setTranType(Integer tranType) {
        this.tranType = tranType;
    }

    public Long getBizOrderId() {
        return bizOrderId;
    }

    public void setBizOrderId(Long bizOrderId) {
        this.bizOrderId = bizOrderId;
    }

    public Long getMasterOrderId() {
        return masterOrderId;
    }

    public void setMasterOrderId(Long masterOrderId) {
        this.masterOrderId = masterOrderId;
    }

    public String getMasterOrderNo() {
        return masterOrderNo;
    }

    public void setMasterOrderNo(String masterOrderNo) {
        this.masterOrderNo = masterOrderNo == null ? null : masterOrderNo.trim();
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public Integer getTranMethod() {
        return tranMethod;
    }

    public void setTranMethod(Integer tranMethod) {
        this.tranMethod = tranMethod;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo == null ? null : tradeNo.trim();
    }

    public BigDecimal getTranAmount() {
        return tranAmount;
    }

    public void setTranAmount(BigDecimal tranAmount) {
        this.tranAmount = tranAmount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }

    public Date getTranTime() {
        return tranTime;
    }

    public void setTranTime(Date tranTime) {
        this.tranTime = tranTime;
    }

    public Long getBillId() {
        return billId;
    }

    public void setBillId(Long billId) {
        this.billId = billId;
    }

    public Long getSumOperatorId() {
        return sumOperatorId;
    }

    public void setSumOperatorId(Long sumOperatorId) {
        this.sumOperatorId = sumOperatorId;
    }

    public Date getSumTime() {
        return sumTime;
    }

    public void setSumTime(Date sumTime) {
        this.sumTime = sumTime;
    }
}