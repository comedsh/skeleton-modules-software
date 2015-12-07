/**
 * 
 */
package com.fenghua.auto.order.intf.service;

import com.fenghua.auto.order.intf.dto.OrderMasterDTO;

/**
 * 
 * 订单模块对外接口
 * 
 * @author zhiyuan.wang@auto007.com
 *
 */

public interface OrderService {

	public OrderMasterDTO loadOrderMasterDTO(Long masterId);
	public OrderMasterDTO loadOrderMasterDTO(String masterNo);
	
}
