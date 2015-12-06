/**
 * 
 */
package com.fenghua.auto.order.dao;

import java.util.List;

import com.fenghua.auto.backend.dao.BaseDao;
import com.fenghua.auto.order.domain.OrderItem;

/**
 *
 * DAO接口类
 *
 * @author 王直元
 * @createTime 2015-11-25 11:11:35
 *
 */
public interface OrderItemDao extends BaseDao<OrderItem>{
	/**
	 * 根据（子订单id获取）订单明细
	 * @param orderItemId
	 * @return
	 */
	List<OrderItem> selectByOrderID(Long orderHeaderID);

}