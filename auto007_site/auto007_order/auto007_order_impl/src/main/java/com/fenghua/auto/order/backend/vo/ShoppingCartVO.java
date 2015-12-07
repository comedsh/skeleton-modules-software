/**
 * 
 */
package com.fenghua.auto.order.backend.vo;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fenghua.auto.order.backend.domain.ShoppingCart;
import com.fenghua.auto.sku.intf.dto.SkuDTO;

/**
 * @author zhiyuan.wang@auto007.com
 *
 */
public class ShoppingCartVO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private ShoppingCart cart;
	private SkuDTO sku;
	
	public ShoppingCartVO(ShoppingCart cart, SkuDTO sku) {
		super();
		this.cart = cart;
		this.sku = sku;
	}
	public ShoppingCartVO() {
		super();
	}
	
	public BigDecimal getTotalAmount() {
		BigDecimal ta = cart.getCurrentPrice().multiply(new BigDecimal(cart.getQty()));
		return ta;
	}
	
	public BigDecimal getTotalOrignAmount() {
		BigDecimal ta = cart.getOriginalPrice().multiply(new BigDecimal(cart.getQty()));
		return ta;
	}
	public ShoppingCart getCart() {
		return cart;
	}
	public void setCart(ShoppingCart cart) {
		this.cart = cart;
	}
	public SkuDTO getSku() {
		return sku;
	}
	public void setSku(SkuDTO sku) {
		this.sku = sku;
	}
}
