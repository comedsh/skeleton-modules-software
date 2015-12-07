/**
 * 
 */
package com.fenghua.auto.order.backend.vo;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fenghua.auto.order.backend.domain.ShoppingCart;

/**
 * @author zhiyuan.wang@auto007.com
 *
 */
public class ShoppingCartVO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private ShoppingCart cart;
	private Sku sku;
	
	public ShoppingCartVO(ShoppingCart cart, Sku sku) {
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
	public Sku getSku() {
		return sku;
	}
	public void setSku(Sku sku) {
		this.sku = sku;
	}
}
