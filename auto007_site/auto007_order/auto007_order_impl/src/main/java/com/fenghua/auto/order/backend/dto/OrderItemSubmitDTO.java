/**
 * 
 */
package com.fenghua.auto.order.backend.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fenghua.auto.backend.domain.mto.LabelError;
import com.fenghua.auto.order.backend.domain.OrderHeader;
import com.fenghua.auto.order.backend.domain.OrderItem;
import com.fenghua.auto.order.intf.OrderConstants;

/**
 * 
 * @author zhiyuan.wang@auto007.com
 *
 */

public class OrderItemSubmitDTO implements Serializable {

	private static final long serialVersionUID = -5121402151734459095L;

	private Long cartId;
	
	private Long skuId;

    private String skuCode;

    private String skuName;
    
    private String skuIcon;
    
    private String brand;

    private BigDecimal originalPrice;

    private BigDecimal salePrice;

    private BigDecimal tradePrice;

    private Integer qty;

    private String note;
    
    public OrderItem createItem(OrderHeader header, Long userId) {
    	OrderItem item = new OrderItem();
    	
    	item.setId(null);
        item.setOrderId(header.getId());
        item.setSellerId(header.getSellerId());
        item.setBuyerId(header.getBuyerId());
        item.setSkuId(this.skuId);
        item.setSkuCode(this.skuCode);
        item.setSkuName(this.skuName);
        item.setOriginalPrice(this.originalPrice);
        item.setSalePrice(this.salePrice);
        item.setTradePrice(this.tradePrice);
        item.setQty(this.qty);
        item.setStatus(OrderConstants.OrderDetailStatus.NORMAL.getValue());
//        item.setforkStatus;
        item.setNote(this.note);
//        item.setEvaluatedFlag(evaluatedFlag);;
//        item.setevaluatedTime;
        item.setEntryId(userId);
        item.setEntryDate(new Date());
        item.setSkuIcon(this.skuIcon);
    	
    	return item;
    }
    
    public List<LabelError> valid() {
		List<LabelError> errors = new ArrayList<LabelError>();
		
		return errors;
	}
    
	public Long getSkuId() {
		return skuId;
	}

	public void setSkuId(Long skuId) {
		this.skuId = skuId;
	}

	public String getSkuCode() {
		return skuCode;
	}

	public void setSkuCode(String skuCode) {
		this.skuCode = skuCode;
	}

	public String getSkuName() {
		return skuName;
	}

	public void setSkuName(String skuName) {
		this.skuName = skuName;
	}

	public String getSkuIcon() {
		return skuIcon;
	}

	public void setSkuIcon(String skuIcon) {
		this.skuIcon = skuIcon;
	}

	public BigDecimal getOriginalPrice() {
		return originalPrice;
	}

	public void setOriginalPrice(BigDecimal originalPrice) {
		this.originalPrice = originalPrice;
	}

	public BigDecimal getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(BigDecimal salePrice) {
		this.salePrice = salePrice;
	}

	public BigDecimal getTradePrice() {
		return tradePrice;
	}

	public void setTradePrice(BigDecimal tradePrice) {
		this.tradePrice = tradePrice;
	}
	
	public BigDecimal getTotalAmount() {
		return tradePrice.multiply(new BigDecimal(qty));
	}

	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Long getCartId() {
		return cartId;
	}

	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}
}
