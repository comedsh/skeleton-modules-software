package com.fenghua.auto.order.backend.vo;

import java.io.Serializable;

import com.fenghua.auto.order.backend.domain.OrderItem;
import com.fenghua.auto.sku.intf.dto.SkuDTO;

/**
 * 订单明细vo
 * @author zhangfr
 *
 */
public class OrderItemVO implements Serializable {
	private static final long serialVersionUID = -4070886417887950506L;
	/**
	 * 订单明细
	 */
	private OrderItem orderItem;
	/**
	 * 商品
	 */
	private SkuDTO sku;
	public OrderItemVO(OrderItem orderItem,SkuDTO sku){
		this.orderItem=orderItem;
		this.sku=sku;
	}
	
	public OrderItem getOrderItem() {
		return orderItem;
	}
	public void setOrderItem(OrderItem orderItem) {
		this.orderItem = orderItem;
	}
	public SkuDTO getSku() {
		return sku;
	}
	public void setSku(SkuDTO sku) {
		this.sku = sku;
	}

}
