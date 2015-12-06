package com.fenghua.auto.finance.domain;

import com.fenghua.auto.backend.domain.DomainObject;
import java.math.BigDecimal;
import java.util.Date;

public class BillOrder implements DomainObject {
	private static final long serialVersionUID = 1L;
    private Long id;

    private String billNo;

    private Long buyerId;

    private Long sellerId;

    private Date startDate;

    private Date endDate;

    private BigDecimal inAmount;

    private BigDecimal outAmount;

    private BigDecimal billAmount;

    private Integer status;

    private Integer inQty;

    private Integer outQty;

    private Long sumOperatorId;

    private Date sumTime;

    private Long reviewId;

    private Date reviewTime;

    private String reviewNote;

    private Long payerId;

    private Date payedTime;

    private String payedNote;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo == null ? null : billNo.trim();
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public BigDecimal getInAmount() {
        return inAmount;
    }

    public void setInAmount(BigDecimal inAmount) {
        this.inAmount = inAmount;
    }

    public BigDecimal getOutAmount() {
        return outAmount;
    }

    public void setOutAmount(BigDecimal outAmount) {
        this.outAmount = outAmount;
    }

    public BigDecimal getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(BigDecimal billAmount) {
        this.billAmount = billAmount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getInQty() {
        return inQty;
    }

    public void setInQty(Integer inQty) {
        this.inQty = inQty;
    }

    public Integer getOutQty() {
        return outQty;
    }

    public void setOutQty(Integer outQty) {
        this.outQty = outQty;
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

    public Long getReviewId() {
        return reviewId;
    }

    public void setReviewId(Long reviewId) {
        this.reviewId = reviewId;
    }

    public Date getReviewTime() {
        return reviewTime;
    }

    public void setReviewTime(Date reviewTime) {
        this.reviewTime = reviewTime;
    }

    public String getReviewNote() {
        return reviewNote;
    }

    public void setReviewNote(String reviewNote) {
        this.reviewNote = reviewNote == null ? null : reviewNote.trim();
    }

    public Long getPayerId() {
        return payerId;
    }

    public void setPayerId(Long payerId) {
        this.payerId = payerId;
    }

    public Date getPayedTime() {
        return payedTime;
    }

    public void setPayedTime(Date payedTime) {
        this.payedTime = payedTime;
    }

    public String getPayedNote() {
        return payedNote;
    }

    public void setPayedNote(String payedNote) {
        this.payedNote = payedNote == null ? null : payedNote.trim();
    }
}