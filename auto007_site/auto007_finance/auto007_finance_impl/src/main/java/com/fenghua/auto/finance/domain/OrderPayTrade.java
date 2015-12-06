package com.fenghua.auto.finance.domain;

import com.fenghua.auto.backend.domain.DomainObject;
import java.util.Date;

public class OrderPayTrade implements DomainObject {
	private static final long serialVersionUID = 1L;
    private Long id;

    private Long orderPaymentId;

    private String orderPaymentSubNo;

    private Integer payMethod;

    private Integer payStatus;

    private String tradeNo;

    private Date submitTime;

    private Date payTime;

    private Date cancelTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderPaymentId() {
        return orderPaymentId;
    }

    public void setOrderPaymentId(Long orderPaymentId) {
        this.orderPaymentId = orderPaymentId;
    }

    public String getOrderPaymentSubNo() {
        return orderPaymentSubNo;
    }

    public void setOrderPaymentSubNo(String orderPaymentSubNo) {
        this.orderPaymentSubNo = orderPaymentSubNo == null ? null : orderPaymentSubNo.trim();
    }

    public Integer getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(Integer payMethod) {
        this.payMethod = payMethod;
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo == null ? null : tradeNo.trim();
    }

    public Date getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Date getCancelTime() {
        return cancelTime;
    }

    public void setCancelTime(Date cancelTime) {
        this.cancelTime = cancelTime;
    }
}