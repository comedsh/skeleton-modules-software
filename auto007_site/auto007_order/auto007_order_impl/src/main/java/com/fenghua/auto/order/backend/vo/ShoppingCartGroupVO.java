/**
 * 
 */
package com.fenghua.auto.order.backend.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.fenghua.auto.user.intf.dto.SellerDTO;

/**
 * 
 * @author zhiyuan.wang@auto007.com
 *
 */
public class ShoppingCartGroupVO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<ShoppingCartVO> cartList;
	private SellerDTO seller;
	
	public ShoppingCartGroupVO(SellerDTO seller) {
		super();
		this.seller = seller;
	}
	
	public ShoppingCartGroupVO() {
		super();
	}
	
	public void addCart(ShoppingCartVO cart) {
		if(this.cartList == null) {
			this.cartList = new ArrayList<ShoppingCartVO>();
		}
		this.cartList.add(cart);
	}
	
	public BigDecimal getTotalOrignAmount() {
		BigDecimal ta = new BigDecimal(0.0000);
		if(this.cartList != null) {
			for (ShoppingCartVO shoppingCartVO : cartList) {
				ta = ta.add(shoppingCartVO.getTotalOrignAmount());
			}
		}
		return ta;
	}
	
	public BigDecimal getTotalAmount() {
		BigDecimal ta = new BigDecimal(0.0000);
		if(this.cartList != null) {
			for (ShoppingCartVO shoppingCartVO : cartList) {
				ta = ta.add(shoppingCartVO.getTotalAmount());
			}
		}
		return ta;
	}
	
	public List<ShoppingCartVO> getCartList() {
		return cartList;
	}
	public void setCartList(List<ShoppingCartVO> cartList) {
		this.cartList = cartList;
	}

	public SellerDTO getSeller() {
		return seller;
	}

	public void setSeller(SellerDTO seller) {
		this.seller = seller;
	}
}
