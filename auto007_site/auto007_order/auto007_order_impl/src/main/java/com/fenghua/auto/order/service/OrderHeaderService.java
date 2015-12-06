/**
 * 
 */
package com.fenghua.auto.order.service;

import java.util.List;

import com.fenghua.auto.backend.service.BaseService;
import com.fenghua.auto.order.domain.OrderHeader;
import com.fenghua.auto.order.domain.OrderMaster;

/**
 * Service接口类
 *
 * @author 王直元
 * @createTime 2015-11-25 11:11:35
 *
 */
public interface OrderHeaderService extends BaseService<OrderHeader> {
	/**
	 * 根据主订单id查询子订单
	 * @param orderMasterID
	 * @return
	 */
	List<OrderHeader> selectByOrderMasterID(Long orderMasterID);
	/**
	 * 根据订单id获取主订单
	 * @param orderId
	 * @return
	 */
	OrderMaster selectMasterById(Long orderId);
	
}
