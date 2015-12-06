/**
 * 
 */
package com.fenghua.auto.order.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.time.DateFormatUtils;

import com.fenghua.auto.backend.core.utills.MessageHelper;
import com.fenghua.auto.backend.domain.mto.LabelError;
import com.fenghua.auto.order.OrderConstants;
import com.fenghua.auto.order.domain.OrderMaster;

/**
 * 
 * @author zhiyuan.wang@auto007.com
 *
 */
public class OrderMasterSubmitDTO implements Serializable {

	private static final long serialVersionUID = 2263634449096339797L;
	
	private Long buyerId;

    private BigDecimal totalAmount;

    private BigDecimal discountAmount;

    private BigDecimal transportAmount;

    private BigDecimal needPayAmount;

	private Long paymentType;
	
	private Long userAddressId;
	
	private OrderInvoiceSubmitDTO orderInvoice;
	
	private boolean invoiceFlag = false;
	
	private List<OrderHeaderSubmitDTO> orderHeaders;
	
	private Integer totalQty;
	
	private Long userId;

	public OrderMasterSubmitDTO(OrderMasterSubmitDTO submitDTO, OrderHeaderSubmitDTO ohSubmitDTO) {
		this.buyerId = submitDTO.getBuyerId();

		this.paymentType = submitDTO.getPaymentType();
		
		this.userAddressId = submitDTO.getUserAddressId();
		
		try {
			this.orderInvoice = (OrderInvoiceSubmitDTO)BeanUtils.cloneBean(submitDTO.getOrderInvoice());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		this.invoiceFlag = submitDTO.isInvoiceFlag();
		
		this.orderHeaders = new ArrayList<OrderHeaderSubmitDTO>(1);
		
		this.orderHeaders.add(ohSubmitDTO);
	}
	
	public OrderMasterSubmitDTO() {
		super();
	}
	
	public OrderMaster createMaster(Long cityId) {
		OrderMaster master = new OrderMaster();
		
		master.setMasterOrderNo("M"+DateFormatUtils.format(new Date(), "yyyyMMddHHmmssSSS"));
	    
	    master.setBuyerId(this.getBuyerId());
	    master.setSellerId(this.getOneSellerId());
	    master.setTotalAmount(this.getTotalAmount());
	    master.setDiscountAmount(this.getDiscountAmount());
	    master.setTransportAmount(this.getTransportAmount());
	    master.setNeedPayAmount(this.getNeedPayAmount());
	    master.setPayedAmount(new BigDecimal(0.0));
	    master.setPaymentType(this.getPaymentType());
	    if(this.getPaymentType().intValue() == OrderConstants.PaymentType.OFFLINE_PAY.getValue()) {
	    	master.setPayMethod(OrderConstants.PaymentMethod.OFFLINE_PAY.getValue());
	    	master.setStatus(OrderConstants.OrderMasterStatus.WAIT_AUDIT.getValue());
	    } else {
	    	master.setStatus(OrderConstants.OrderMasterStatus.WAIT_PAY.getValue());
	    }
	    master.setPayStatus(OrderConstants.PaymentStatus.WAITING_PAY.getValue());
	    master.setCreateTime(new Date());
	    master.setPayTime(null);
	    master.setCityId(cityId);
	    master.setComeFrom(OrderConstants.OrderComeFrom.WEB.getValue());
	    master.setOrderQty(this.getTotalQty());
		
	    return master;
	}

	public List<LabelError> valid() {
		List<LabelError> errors = new ArrayList<LabelError>();
		
		if(this.buyerId == null || buyerId <= 0) {
			errors.add(new LabelError("buyerId", MessageHelper.getMessage("order.submit.buyerId.invalid")));
		}
		
		if(this.paymentType == null || !OrderConstants.PaymentType.has(this.paymentType.intValue())) {
			errors.add(new LabelError("paymentType", MessageHelper.getMessage("order.submit.paymentType.invalid")));
		}
		
		if(this.userAddressId == null || this.userAddressId <= 0) {
			errors.add(new LabelError("userAddressId", MessageHelper.getMessage("order.submit.userAddress.invalid")));
		}
		
		if(this.invoiceFlag == true) {
			if(this.orderInvoice == null) {
				errors.add(new LabelError("orderInvoice", MessageHelper.getMessage("order.submit.orderInvoice.invalid")));
			} else {
				errors.addAll(this.orderInvoice.valid());
			}
		}
		if(this.orderHeaders == null || this.orderHeaders.isEmpty()) {
			errors.add(new LabelError("orderHeaders", MessageHelper.getMessage("order.submit.orderHeaders.invalid")));
		} else {
			for (OrderHeaderSubmitDTO oh : this.orderHeaders) {
				errors.addAll(oh.valid());
			}
		}
		return errors;
	}
	
	public Long[] getSellerIds() {
		List<Long> sellerIdList = new ArrayList<Long>();
		if(this.getOrderHeaders() != null) {
			for (OrderHeaderSubmitDTO oddto : this.getOrderHeaders()) {
				sellerIdList.add(oddto.getSeller().getId());
			}
		}
		if(!sellerIdList.isEmpty()) {
			return sellerIdList.toArray(new Long[sellerIdList.size()]);
		}
		return null;
	}
	
	public Long getOneSellerId() {
		if(this.getOrderHeaders() != null && this.getOrderHeaders().size() == 1) {
			return this.getOrderHeaders().get(0).getSeller().getId();
		}
		return null;
	}
	
	public void calculateTotal() {
		BigDecimal totalAmount = new BigDecimal(0);
		BigDecimal discountAmount = new BigDecimal(0);
		BigDecimal needPayAmount = new BigDecimal(0);
		int qty = 0;
		
		List<Long> sellerIdList = new ArrayList<Long>();
		//计算总价格
		if(this.getOrderHeaders() != null) {
			for (OrderHeaderSubmitDTO oddto : this.getOrderHeaders()) {
				qty += oddto.getTotalQty();
				totalAmount = totalAmount.add(oddto.getTotalAmount());
				discountAmount = discountAmount.add(oddto.getDiscountAmount());
				needPayAmount = needPayAmount.add(oddto.getNeedPayAmount());
				sellerIdList.add(oddto.getSeller().getId());
			}
		}
		needPayAmount = totalAmount.subtract(discountAmount);
		this.setTotalAmount(totalAmount);
		this.setDiscountAmount(discountAmount);
		this.setNeedPayAmount(needPayAmount);
		this.setTransportAmount(new BigDecimal(0.0));
		this.setTotalQty(qty);
	}
	
	public Long getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(Long buyerId) {
		this.buyerId = buyerId;
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

	public Long getUserAddressId() {
		return userAddressId;
	}

	public void setUserAddressId(Long userAddressId) {
		this.userAddressId = userAddressId;
	}

	public Long getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(Long paymentType) {
		this.paymentType = paymentType;
	}

	public OrderInvoiceSubmitDTO getOrderInvoice() {
		return orderInvoice;
	}

	public void setOrderInvoice(OrderInvoiceSubmitDTO orderInvoice) {
		this.orderInvoice = orderInvoice;
	}

	public List<OrderHeaderSubmitDTO> getOrderHeaders() {
		return orderHeaders;
	}

	public void setOrderHeaders(List<OrderHeaderSubmitDTO> orderHeaders) {
		this.orderHeaders = orderHeaders;
	}
	
	public void addOrderHeader(OrderHeaderSubmitDTO header) {
		if(this.orderHeaders == null) {
			this.orderHeaders = new ArrayList<OrderHeaderSubmitDTO>();
		}
		this.orderHeaders.add(header);
	}

	public Integer getTotalQty() {
		return totalQty;
	}

	public void setTotalQty(Integer totalQty) {
		this.totalQty = totalQty;
	}

	public boolean isInvoiceFlag() {
		return invoiceFlag;
	}

	public void setInvoiceFlag(boolean invoiceFlag) {
		this.invoiceFlag = invoiceFlag;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
}
