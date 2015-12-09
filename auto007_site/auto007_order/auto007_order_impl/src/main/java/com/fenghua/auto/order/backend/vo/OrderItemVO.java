package com.fenghua.auto.order.backend.vo;

import java.io.Serializable;

import com.fenghua.auto.order.backend.domain.OrderItem;
import com.fenghua.auto.sku.intf.dto.SkuDTO;

/**
 * 订单明细vo
 * @author zhangfr
 *
 */
public class OrderItemVO extends OrderItem implements Serializable {
	private static final long serialVersionUID = -4070886417887950506L;
	/**
	 * 商品
	 */
	private SkuDTO sku;
	
	
	public SkuDTO getSku() {
		return sku;
	}
	public void setSku(SkuDTO sku) {
		this.sku = sku;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
