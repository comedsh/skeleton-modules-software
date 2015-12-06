package com.fenghua.auto.order.vo;

import java.io.Serializable;
import java.util.List;

import com.fenghua.auto.order.domain.OrderHeader;
import com.fenghua.auto.order.domain.OrderItem;
import com.fenghua.auto.sku.domain.Sku;

/**
 * 订单明细vo
 * @author zhangfr
 *
 */
public class OrderItemVO implements Serializable {
	/**
	 * 订单明细
	 */
	private OrderItem orderItem;
	/**
	 * 商品
	 */
	private Sku sku;
	public OrderItemVO(OrderItem orderItem,Sku sku){
		this.orderItem=orderItem;
		this.sku=sku;
	}
	
	public OrderItem getOrderItem() {
		return orderItem;
	}
	public void setOrderItem(OrderItem orderItem) {
		this.orderItem = orderItem;
	}
	public Sku getSku() {
		return sku;
	}
	public void setSku(Sku sku) {
		this.sku = sku;
	}

}
