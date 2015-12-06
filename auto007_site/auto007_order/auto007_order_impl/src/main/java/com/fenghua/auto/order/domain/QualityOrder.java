package com.fenghua.auto.order.domain;

import com.fenghua.auto.backend.domain.DomainObject;
import java.util.Date;

public class QualityOrder implements DomainObject {
	private static final long serialVersionUID = 1L;
    private Long id;

    private String qualityNo;

    private Long buyerId;

    private Long sellerId;

    private Long orderId;

    private String orderNo;

    private String processDesc;

    private Long auditorId;

    private Date auditTime;

    private Long processorId;

    private Date processTime;

    private Long applicantId;

    private Long applyTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQualityNo() {
        return qualityNo;
    }

    public void setQualityNo(String qualityNo) {
        this.qualityNo = qualityNo == null ? null : qualityNo.trim();
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

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public String getProcessDesc() {
        return processDesc;
    }

    public void setProcessDesc(String processDesc) {
        this.processDesc = processDesc == null ? null : processDesc.trim();
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

    public Long getProcessorId() {
        return processorId;
    }

    public void setProcessorId(Long processorId) {
        this.processorId = processorId;
    }

    public Date getProcessTime() {
        return processTime;
    }

    public void setProcessTime(Date processTime) {
        this.processTime = processTime;
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
}