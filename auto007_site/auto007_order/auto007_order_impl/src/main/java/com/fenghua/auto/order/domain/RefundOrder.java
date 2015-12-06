package com.fenghua.auto.order.domain;

import com.fenghua.auto.backend.domain.DomainObject;
import java.math.BigDecimal;
import java.util.Date;

public class RefundOrder implements DomainObject {
	private static final long serialVersionUID = 1L;
    private Long id;

    private String refundNo;

    private Long buyerId;

    private Long sellerId;

    private Long orderId;

    private Long warehouseId;

    private Integer type;

    private String reasonCodes;

    private String reasonDesc;

    private Integer status;

    private BigDecimal orderAmount;

    private BigDecimal deductAmount;

    private BigDecimal freightAmount;

    private BigDecimal refundAmount;

    private BigDecimal actRefundMount;

    private Integer refundStatus;

    private String reReceivePerson;

    private String reReceivePhone;

    private String reReceiveAddress;

    private String auditContent;

    private Long auditorId;

    private Date auditTime;

    private Long applicantId;

    private Long applyTime;

    private Integer refundMethod;

    private Integer payMethod;

    private Integer accountType;

    private Integer accountName;

    private String bankCode;

    private Integer accountNo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRefundNo() {
        return refundNo;
    }

    public void setRefundNo(String refundNo) {
        this.refundNo = refundNo == null ? null : refundNo.trim();
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

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getReasonCodes() {
        return reasonCodes;
    }

    public void setReasonCodes(String reasonCodes) {
        this.reasonCodes = reasonCodes == null ? null : reasonCodes.trim();
    }

    public String getReasonDesc() {
        return reasonDesc;
    }

    public void setReasonDesc(String reasonDesc) {
        this.reasonDesc = reasonDesc == null ? null : reasonDesc.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    public BigDecimal getDeductAmount() {
        return deductAmount;
    }

    public void setDeductAmount(BigDecimal deductAmount) {
        this.deductAmount = deductAmount;
    }

    public BigDecimal getFreightAmount() {
        return freightAmount;
    }

    public void setFreightAmount(BigDecimal freightAmount) {
        this.freightAmount = freightAmount;
    }

    public BigDecimal getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(BigDecimal refundAmount) {
        this.refundAmount = refundAmount;
    }

    public BigDecimal getActRefundMount() {
        return actRefundMount;
    }

    public void setActRefundMount(BigDecimal actRefundMount) {
        this.actRefundMount = actRefundMount;
    }

    public Integer getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(Integer refundStatus) {
        this.refundStatus = refundStatus;
    }

    public String getReReceivePerson() {
        return reReceivePerson;
    }

    public void setReReceivePerson(String reReceivePerson) {
        this.reReceivePerson = reReceivePerson == null ? null : reReceivePerson.trim();
    }

    public String getReReceivePhone() {
        return reReceivePhone;
    }

    public void setReReceivePhone(String reReceivePhone) {
        this.reReceivePhone = reReceivePhone == null ? null : reReceivePhone.trim();
    }

    public String getReReceiveAddress() {
        return reReceiveAddress;
    }

    public void setReReceiveAddress(String reReceiveAddress) {
        this.reReceiveAddress = reReceiveAddress == null ? null : reReceiveAddress.trim();
    }

    public String getAuditContent() {
        return auditContent;
    }

    public void setAuditContent(String auditContent) {
        this.auditContent = auditContent == null ? null : auditContent.trim();
    }

    public Long getAuditorId() {
        return auditorId;
    }

    public void setAuditorId(Long auditorId) {
        this.auditorId = auditorId;
    }

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    public Long getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(Long applicantId) {
        this.applicantId = applicantId;
    }

    public Long getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Long applyTime) {
        this.applyTime = applyTime;
    }

    public Integer getRefundMethod() {
        return refundMethod;
    }

    public void setRefundMethod(Integer refundMethod) {
        this.refundMethod = refundMethod;
    }

    public Integer getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(Integer payMethod) {
        this.payMethod = payMethod;
    }

    public Integer getAccountType() {
        return accountType;
    }

    public void setAccountType(Integer accountType) {
        this.accountType = accountType;
    }

    public Integer getAccountName() {
        return accountName;
    }

    public void setAccountName(Integer accountName) {
        this.accountName = accountName;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode == null ? null : bankCode.trim();
    }

    public Integer getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(Integer accountNo) {
        this.accountNo = accountNo;
    }
}