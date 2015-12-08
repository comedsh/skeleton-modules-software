/**
 * 
 */
package com.fenghua.auto.order.intf.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * @author zhiyuan.wang@auto007.com
 *
 */
public class OrderMasterDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
    private String masterOrderNo;
    private Integer status;
    private Long buyerId;
    private Long sellerId;
    private BigDecimal totalAmount;
    private BigDecimal discountAmount;
    private BigDecimal transportAmount;
    private BigDecimal needPayAmount;
    private BigDecimal payedAmount;
    private Long paymentType;
    private Integer payMethod;
    private Integer payStatus;
    private Date createTime;
    private Date payTime;
    private Long cityId;
    private Integer comeFrom;
    private Integer orderQty;
    
	/**
	 * 主订单ID
	 * @return
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 主订单ID
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 主订单号
	 * @return
	 */
	public String getMasterOrderNo() {
		return masterOrderNo;
	}
	/**
	 * 主订单号
	 * @param masterOrderNo
	 */
	public void setMasterOrderNo(String masterOrderNo) {
		this.masterOrderNo = masterOrderNo;
	}
	/**
     * 主订单状态
     */
	public Integer getStatus() {
		return status;
	}
	/**
     * 主订单状态
     */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
     * 买家id，对应User表
     */
	public Long getBuyerId() {
		return buyerId;
	}
	/**
     * 买家id，对应User表
     */
	public void setBuyerId(Long buyerId) {
		this.buyerId = buyerId;
	}
	/**
     * 卖家id对应Seller表
     */
	public Long getSellerId() {
		return sellerId;
	}
	/**
     * 卖家id对应Seller表
     */
	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}
	/**
     * 总金额
     */
	public BigDecimal getTotalAmount() {
		return totalAmount;
	}
	/**
     * 总金额
     */
	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}
	/**
     * 折扣
     */
	public BigDecimal getDiscountAmount() {
		return discountAmount;
	}
	/**
     * 折扣
     */
	public void setDiscountAmount(BigDecimal discountAmount) {
		this.discountAmount = discountAmount;
	}
	/**
     * 物流费
     */
	public BigDecimal getTransportAmount() {
		return transportAmount;
	}
	/**
     * 物流费
     */
	public void setTransportAmount(BigDecimal transportAmount) {
		this.transportAmount = transportAmount;
	}
	/**
     * 需要支付金额
     */
	public BigDecimal getNeedPayAmount() {
		return needPayAmount;
	}
	/**
     * 需要支付金额
     */
	public void setNeedPayAmount(BigDecimal needPayAmount) {
		this.needPayAmount = needPayAmount;
	}
	/**
     * 已付金额
     */
	public BigDecimal getPayedAmount() {
		return payedAmount;
	}
	/**
     * 已付金额
     */
	public void setPayedAmount(BigDecimal payedAmount) {
		this.payedAmount = payedAmount;
	}
	/**
     * 结算方式，对应 OrderConstants.PaymentType
     */
	public Long getPaymentType() {
		return paymentType;
	}
	/**
     * 结算方式，对应 OrderConstants.PaymentType
     */
	public void setPaymentType(Long paymentType) {
		this.paymentType = paymentType;
	}
	/**
     * 付款方式：线下支付，微信支付，支付宝支付
     * 对应OrderConstants.PaymentMethod
     */
	public Integer getPayMethod() {
		return payMethod;
	}
	/**
     * 付款方式：线下支付，微信支付，支付宝支付
     * 对应OrderConstants.PaymentMethod
     */
	public void setPayMethod(Integer payMethod) {
		this.payMethod = payMethod;
	}
	/**
     * 付款状态
     * 对应OrderConstants.PaymentStatus
     */
	public Integer getPayStatus() {
		return payStatus;
	}
	/**
     * 付款状态
     * 对应OrderConstants.PaymentStatus
     */
	public void setPayStatus(Integer payStatus) {
		this.payStatus = payStatus;
	}
	/**
     * 创建时间
     */
	public Date getCreateTime() {
		return createTime;
	}
	/**
     * 创建时间
     */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
     * 付款时间
     */
	public Date getPayTime() {
		return payTime;
	}
	/**
     * 付款时间
     */
	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}
	/**
     * 城市id
     */
	public Long getCityId() {
		return cityId;
	}
	/**
     * 城市id
     */
	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}
	/**
     * 数据来源
     */
	public Integer getComeFrom() {
		return comeFrom;
	}
	/**
     * 数据来源
     */
	public void setComeFrom(Integer comeFrom) {
		this.comeFrom = comeFrom;
	}
	
	/**
     * 订单数量
     */
	public Integer getOrderQty() {
		return orderQty;
	}
	/**
     * 订单数量
     */
	public void setOrderQty(Integer orderQty) {
		this.orderQty = orderQty;
	}
}
