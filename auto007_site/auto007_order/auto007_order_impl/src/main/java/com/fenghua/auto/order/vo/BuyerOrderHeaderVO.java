package com.fenghua.auto.order.vo;

import java.io.Serializable;
import java.util.List;

import com.fenghua.auto.order.domain.OrderHeader;
import com.fenghua.auto.order.domain.OrderImage;
import com.fenghua.auto.order.domain.OrderMaster;
import com.fenghua.auto.order.domain.OrderTransport;
/**
 * 订单列表VO
 * @author zhangfr
 *
 */
public class BuyerOrderHeaderVO implements Serializable {
	
	/**
	 * 订单
	 */
	private OrderHeader orderHeader;
	/**
	 * 卖家姓名
	 */
	private String sellerName;
	/**
	 * 物流信息
	 */
	private OrderTransport orderTransport;
	/**
	 * 订单明细
	 */
	private List<OrderItemVO> orderItemVOs;
	
	public BuyerOrderHeaderVO(OrderHeader orderHeader,String sellerName,OrderTransport orderTransport,List<OrderItemVO> orderItemVOs){
		this.orderHeader=orderHeader;
		this.sellerName=sellerName;
		this.orderTransport=orderTransport;
		this.orderItemVOs=orderItemVOs;
	}
	public BuyerOrderHeaderVO(){
	}
	

	public OrderHeader getOrderHeader() {
		return orderHeader;
	}
	public void setOrderHeader(OrderHeader orderHeader) {
		this.orderHeader = orderHeader;
	}
	public String getSellerName() {
		return sellerName;
	}
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	public OrderTransport getOrderTransport() {
		return orderTransport;
	}
	public void setOrderTransport(OrderTransport orderTransport) {
		this.orderTransport = orderTransport;
	}
	public List<OrderItemVO> getOrderItemVOs() {
		return orderItemVOs;
	}
	public void setOrderItemVOs(List<OrderItemVO> orderItemVOs) {
		this.orderItemVOs = orderItemVOs;
	}
	
	
	
	
}	
