package com.fenghua.auto.order.backend.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.time.DateFormatUtils;

import com.fenghua.auto.backend.domain.mto.LabelError;
import com.fenghua.auto.order.backend.domain.OrderHeader;
import com.fenghua.auto.order.backend.domain.OrderMaster;
import com.fenghua.auto.order.intf.OrderConstants;

/**
 * 
 * @author zhiyuan.wang@auto007.com
 *
 */

public class OrderHeaderSubmitDTO implements Serializable {

	private static final long serialVersionUID = 7087623229639728262L;

    private Long buyerId;

    private Seller seller;

    private BigDecimal totalAmount;

    private BigDecimal discountAmount;

    private BigDecimal needPayAmount;

    private BigDecimal transportAmount;

    private Integer payMethod;

    private Integer deliveryMethod = 1;

    private String receiver;

    private String receiverPhone;

    private String receiverIdcard;

    private String receiverAddress;

    private Integer invoiceFlag;

    private Integer comeFrom;

    private String remark;
    
    private Integer totalQty;
    
	private List<OrderItemSubmitDTO> items;
	
	public OrderHeader createHeader(OrderMaster master, UserAddress userAddr) {
		OrderHeader header = new OrderHeader();
		header.setId(null);
	    header.setOrderNo("O"+DateFormatUtils.format(new Date(), "yyyyMMddHHmmssSSS"));
	    header.setStatus(OrderConstants.OrderHeaderStatus.NEW.getValue());
//	    header.setforkStatus;
	    header.setBuyerId(this.buyerId);
	    header.setSellerId(this.getSeller().getId());
//	    header.setwarehouseId;
	    header.setMasterOrderId(master.getId());
	    header.setTotalAmount(this.totalAmount);
	    header.setDiscountAmount(this.discountAmount);
	    header.setNeedPayAmount(this.needPayAmount);
	    header.setTransportAmount(this.transportAmount);
	    header.setPayedAmount(new BigDecimal(0.0));
	    header.setPaymentType(master.getPaymentType());
	    if(header.getPaymentType().intValue() == OrderConstants.PaymentType.OFFLINE_PAY.getValue()) {
	    	header.setPayMethod(OrderConstants.PaymentMethod.OFFLINE_PAY.getValue());
	    	header.setStatus(OrderConstants.OrderHeaderStatus.WAIT_AUDIT.getValue());
	    } else {
	    	header.setStatus(OrderConstants.OrderHeaderStatus.WAIT_PAY.getValue());
	    }
	    header.setPayStatus(OrderConstants.PaymentStatus.WAITING_PAY.getValue());
	    header.setDeliveryMethod(this.getDeliveryMethod());
	    header.setCreateTime(new Date());
//	    header.setpayTime;
//	    header.setconfirmTime;
//	    header.setsendTime;
//	    header.setreceiveDelayTimes;
//	    header.setreceiveExpireTime;
//	    header.setreceivedTime;
	    header.setCityId(userAddr.getCityId());
//	    header.setsender;
//	    header.setsenderAddress;
	    header.setReceiver(userAddr.getReceiverName());
	    header.setReceiverPhone(userAddr.getReceiverMobile());
//	    header.setReceiverIdcard("");
	    header.setReceiverAddress(userAddr.getAddress());
//	    header.setInvoiceFlag();
	    header.setComeFrom(master.getComeFrom());
	    header.setRemark(this.getRemark());
		return header;
	}
	
	public List<LabelError> valid() {
		List<LabelError> errors = new ArrayList<LabelError>();
		
		return errors;
	}
	
	public List<OrderItemSubmitDTO> getItems() {
		return items;
	}

	public void setItems(List<OrderItemSubmitDTO> items) {
		this.items = items;
	}
	
	public void addItem(OrderItemSubmitDTO item) {
		if(this.items == null) {
			this.items = new ArrayList<OrderItemSubmitDTO>();
		}
		this.items.add(item);
	}

	public Long getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(Long buyerId) {
		this.buyerId = buyerId;
	}

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
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

	public Integer getPayMethod() {
		return payMethod;
	}

	public void setPayMethod(Integer payMethod) {
		this.payMethod = payMethod;
	}

	public Integer getDeliveryMethod() {
		return deliveryMethod;
	}

	public void setDeliveryMethod(Integer deliveryMethod) {
		this.deliveryMethod = deliveryMethod;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getReceiverPhone() {
		return receiverPhone;
	}

	public void setReceiverPhone(String receiverPhone) {
		this.receiverPhone = receiverPhone;
	}

	public String getReceiverIdcard() {
		return receiverIdcard;
	}

	public void setReceiverIdcard(String receiverIdcard) {
		this.receiverIdcard = receiverIdcard;
	}

	public String getReceiverAddress() {
		return receiverAddress;
	}

	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getTotalQty() {
		return totalQty;
	}

	public void setTotalQty(Integer totalQty) {
		this.totalQty = totalQty;
	}
}
