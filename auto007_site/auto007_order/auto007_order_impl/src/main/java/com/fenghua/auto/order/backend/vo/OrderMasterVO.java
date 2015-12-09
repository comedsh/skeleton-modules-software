package com.fenghua.auto.order.backend.vo;


import java.io.Serializable;
import java.util.List;

import com.fenghua.auto.order.backend.domain.OrderMaster;
import com.fenghua.auto.user.intf.dto.SellerDTO;
import com.fenghua.auto.user.intf.dto.UserDTO;

/**
 * 订单列表VO
 * @author zhangfr
 *
 */
public class OrderMasterVO extends OrderMaster implements Serializable {
	private static final long serialVersionUID = -2910860656883542567L;
	/**
	 * 子单VO
	 */
	private List<OrderHeaderVO> orderHeaders;
	public List<OrderHeaderVO> getOrderHeaders() {
		return orderHeaders;
	}
	public void setOrderHeaders(List<OrderHeaderVO> orderHeaders) {
		this.orderHeaders = orderHeaders;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
