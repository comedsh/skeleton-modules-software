package com.fenghua.auto.order.domain;

import com.fenghua.auto.backend.domain.DomainObject;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
/**
 * 销售订单
 *
 */
public class OrderHeader implements DomainObject {
	private static final long serialVersionUID = 1L;
    private Long id;
    /**
     * 订单编号
     */
    private String orderNo;
    /**
     * 订单状态
     */
    private Integer status;
    /**
     * 分支状态
     */
    private Integer forkStatus;
    /**
     * 买家id
     */
    private Long buyerId;
    /**
     * 卖家id
     */
    private Long sellerId;
    /**
     * 仓库id
     */
    private Long warehouseId;
    /**
     * 主订单id
     */
    private Long masterOrderId;
    /**
     * 订单总金额
     */
    private BigDecimal totalAmount;
    /**
     * 优惠金额
     */
    private BigDecimal discountAmount;
    /**
     * 需支付金额
     */
    private BigDecimal needPayAmount;
    /**
     * 运费
     */
    private BigDecimal transportAmount;
    /**
     * 已支付金额
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
     * 支付状态
     */
    private Integer payStatus;
    /**
     * 配送方式
     */
    private Integer deliveryMethod;
    /**
     * 下单时间
     */
    private Date createTime;
    /**
     * 付款时间
     */
    private Date payTime;
    /**
     * 卖家审核时间
     */
    private Date confirmTime;
    /**
     * 发货时间
     */
    private Date sendTime;
    /**
     * 收货延期次数
     */
    private Integer receiveDelayTimes;
    /**
     * 收货过期时间
     */
    private Date receiveExpireTime;
    /**
     * 收货时间
     */
    private Date receivedTime;
    /**
     * 城市
     */
    private Long cityId;
    /**
     * 发货人
     */
    private String sender;
    /**
     * 发货地址
     */
    private String senderAddress;
    /**
     * 收货人
     */
    private String receiver;
    /**
     * 收货人电话
     */
    private String receiverPhone;
    /**
     * 收货人证件号码
     */
    private String receiverIdcard;
    /**
     * 收货人地址
     */
    private String receiverAddress;
    /**
     * 是否开发票
     */
    private Integer invoiceFlag;
    /**
     * 单据来源
     */
    private Integer comeFrom;
    /**
     * 是否评价
     */
    private Integer evaluatedFlag;
    /**
     * 订单备注
     */
    private String remark;
    /**
     * 评价时间
     */
    private Date evaluatedTime;
    
    private List<OrderItem> items;
    private OrderInvoice orderInvoice;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getForkStatus() {
        return forkStatus;
    }

    public void setForkStatus(Integer forkStatus) {
        this.forkStatus = forkStatus;
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

    public Long getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
    }

    public Long getMasterOrderId() {
        return masterOrderId;
    }

    public void setMasterOrderId(Long masterOrderId) {
        this.masterOrderId = masterOrderId;
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

    public BigDecimal getNeedPayAmount() {
        return needPayAmount;
    }

    public void setNeedPayAmount(BigDecimal needPayAmount) {
        this.needPayAmount = needPayAmount;
    }

    public BigDecimal getTransportAmount() {
        return transportAmount;
    }

    public void setTransportAmount(BigDecimal transportAmount) {
        this.transportAmount = transportAmount;
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

    public Integer getDeliveryMethod() {
        return deliveryMethod;
    }

    public void setDeliveryMethod(Integer deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
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

    public Date getConfirmTime() {
        return confirmTime;
    }

    public void setConfirmTime(Date confirmTime) {
        this.confirmTime = confirmTime;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public Integer getReceiveDelayTimes() {
        return receiveDelayTimes;
    }

    public void setReceiveDelayTimes(Integer receiveDelayTimes) {
        this.receiveDelayTimes = receiveDelayTimes;
    }

    public Date getReceiveExpireTime() {
        return receiveExpireTime;
    }

    public void setReceiveExpireTime(Date receiveExpireTime) {
        this.receiveExpireTime = receiveExpireTime;
    }

    public Date getReceivedTime() {
        return receivedTime;
    }

    public void setReceivedTime(Date receivedTime) {
        this.receivedTime = receivedTime;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender == null ? null : sender.trim();
    }

    public String getSenderAddress() {
        return senderAddress;
    }

    public void setSenderAddress(String senderAddress) {
        this.senderAddress = senderAddress == null ? null : senderAddress.trim();
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver == null ? null : receiver.trim();
    }

    public String getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone == null ? null : receiverPhone.trim();
    }

    public String getReceiverIdcard() {
        return receiverIdcard;
    }

    public void setReceiverIdcard(String receiverIdcard) {
        this.receiverIdcard = receiverIdcard == null ? null : receiverIdcard.trim();
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress == null ? null : receiverAddress.trim();
    }

    public Integer getInvoiceFlag() {
        return invoiceFlag;
    }

    public void setInvoiceFlag(Integer invoiceFlag) {
        this.invoiceFlag = invoiceFlag;
    }

    public Integer getComeFrom() {
        return comeFrom;
    }

    public void setComeFrom(Integer comeFrom) {
        this.comeFrom = comeFrom;
    }

    public Integer getEvaluatedFlag() {
        return evaluatedFlag;
    }

    public void setEvaluatedFlag(Integer evaluatedFlag) {
        this.evaluatedFlag = evaluatedFlag;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getEvaluatedTime() {
        return evaluatedTime;
    }

    public void setEvaluatedTime(Date evaluatedTime) {
        this.evaluatedTime = evaluatedTime;
    }

	public List<OrderItem> getItems() {
		return items;
	}

	public void setItems(List<OrderItem> items) {
		this.items = items;
	}

	public OrderInvoice getOrderInvoice() {
		return orderInvoice;
	}

	public void setOrderInvoice(OrderInvoice orderInvoice) {
		this.orderInvoice = orderInvoice;
	}

	public Long getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(Long paymentType) {
		this.paymentType = paymentType;
	}
}