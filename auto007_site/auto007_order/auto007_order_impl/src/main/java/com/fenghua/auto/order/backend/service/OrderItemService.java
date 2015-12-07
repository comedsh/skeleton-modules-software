/**
 * 
 */
package com.fenghua.auto.order.backend.service;

import java.util.List;

import com.fenghua.auto.backend.service.BaseService;
import com.fenghua.auto.order.backend.domain.OrderItem;

/**
 * Service接口类
 *
 * @author 王直元
 * @createTime 2015-11-25 11:11:35
 *
 */
public interface OrderItemService extends BaseService<OrderItem> {
	/**
	 * 订单明细根据(子)订单id
	 * @param id
	 * @return
	 */
	List<OrderItem> selectByOrderID(Long orderHeaderID);

}
