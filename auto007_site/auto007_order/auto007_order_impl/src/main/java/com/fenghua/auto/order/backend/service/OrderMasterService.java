/**
 * 
 */
package com.fenghua.auto.order.backend.service;

import java.util.List;

import com.fenghua.auto.backend.service.BaseService;
import com.fenghua.auto.order.backend.domain.OrderMaster;

/**
 * Service接口类
 *
 * @author 王直元
 * @createTime 2015-11-25 11:11:35
 *
 */
public interface OrderMasterService extends BaseService<OrderMaster> {

	/**
	 * 根据买家id查询其主订单
	 * @param userId
	 * @return
	 */
	public List<OrderMaster> selectByBuyerID(Long userId);
	
	/**
	 * 根据主订单号查询其主订单
	 * @param orderMasterNo
	 * @return OrderMaster
	 */
	public OrderMaster getByOrderMasterNo(String orderMasterNo);
}
