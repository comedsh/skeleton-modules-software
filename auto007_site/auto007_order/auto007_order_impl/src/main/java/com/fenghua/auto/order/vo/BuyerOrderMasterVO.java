package com.fenghua.auto.order.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fenghua.auto.order.domain.OrderMaster;

/**
 * 订单展示对象
 * @author zhangfr
 *
 */
public class BuyerOrderMasterVO implements Serializable {
	/**
	 * 主订单
	 */
	private OrderMaster orderMaster;
	/**
	 * 收货人姓名
	 */
	private String receiver;
	/**
	 * 子订单
	 */
	private List<BuyerOrderHeaderVO> buyerOrderHeaderVOs=new ArrayList<BuyerOrderHeaderVO>();
	public BuyerOrderMasterVO(OrderMaster orderMaster,
			List<BuyerOrderHeaderVO> buyerOrderHeaderVOs,String receiver) {
		this.orderMaster=orderMaster;
		this.buyerOrderHeaderVOs=buyerOrderHeaderVOs;
		this.receiver=receiver;
	}
	public BuyerOrderMasterVO(OrderMaster orderMaster,
			List<BuyerOrderHeaderVO> buyerOrderHeaderVOs) {
		this.orderMaster=orderMaster;
		this.buyerOrderHeaderVOs=buyerOrderHeaderVOs;
	}
	public OrderMaster getOrderMaster() {
		return orderMaster;
	}
	public void setOrderMaster(OrderMaster orderMaster) {
		this.orderMaster = orderMaster;
	}
	public List<BuyerOrderHeaderVO> getBuyerOrderHeaderVOs() {
		return buyerOrderHeaderVOs;
	}
	public void setBuyerOrderHeaderVOs(List<BuyerOrderHeaderVO> buyerOrderHeaderVOs) {
		this.buyerOrderHeaderVOs = buyerOrderHeaderVOs;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
}
