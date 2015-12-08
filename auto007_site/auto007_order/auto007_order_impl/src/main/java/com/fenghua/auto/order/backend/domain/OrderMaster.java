package com.fenghua.auto.order.backend.domain;

import java.math.BigDecimal;
import java.util.Date;

import com.fenghua.auto.backend.domain.DomainObject;
/**
 * 订单主单（付款前采购的全部商品，付款后将会拆分）
 *
 */
public class OrderMaster implements DomainObject {
	private static final long serialVersionUID = 1L;
    private Long id;
    /**
     * 主订单编号
     */
    private String masterOrderNo;
    /**
     * 主订单状态
     */
    private Integer status;
    /**
     * 买家id
     */
    private Long buyerId;
    /**
     * 卖家id
     */
    private Long sellerId;
    /**
     * 总金额
     */
    private BigDecimal totalAmount;
    /**
     * 折扣
     */
    private BigDecimal discountAmount;
    /**
     * 物流费
     */
    private BigDecimal transportAmount;
    /**
     * 需要支付金额
     */
    private BigDecimal needPayAmount;
    /**
     * 已付金额
     */
    private BigDecimal payedAmount;
    /**
     * 结算方式
     */
    private Long paymentType;
    /**
     * 付款方式：线下支付，微信支付，支付宝支付
     */
    private Integer payMethod;
    /**
     * 付款状态
     */
    private Integer payStatus;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 付款时间
     */
    private Date payTime;
    /**
     * 城市id
     */
    private Long cityId;
    /**
     * 数据来源
     */
    private Integer comeFrom;
    /**
     * 订单数量
     */
    private Integer orderQty;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMasterOrderNo() {
        return masterOrderNo;
    }

    public void setMasterOrderNo(String masterOrderNo) {
        this.masterOrderNo = masterOrderNo == null ? null : masterOrderNo.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }

    public BigDecimal getTransportAmount() {
        return transportAmount;
    }

    public void setTransportAmount(BigDecimal transportAmount) {
        this.transportAmount = transportAmount;
    }

    public BigDecimal getNeedPayAmount() {
        return needPayAmount;
    }

    public void setNeedPayAmount(BigDecimal needPayAmount) {
        this.needPayAmount = needPayAmount;
    }

    public BigDecimal getPayedAmount() {
        return payedAmount;
    }

    public void setPayedAmount(BigDecimal payedAmount) {
        this.payedAmount = payedAmount;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public Integer getComeFrom() {
        return comeFrom;
    }

    public void setComeFrom(Integer comeFrom) {
        this.comeFrom = comeFrom;
    }

    public Integer getOrderQty() {
        return orderQty;
    }

    public void setOrderQty(Integer orderQty) {
        this.orderQty = orderQty;
    }

	public Long getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(Long paymentType) {
		this.paymentType = paymentType;
	}
}