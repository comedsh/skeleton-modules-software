/**
 * 
 */
package com.fenghua.auto.order.dao;

import com.fenghua.auto.backend.dao.BaseDao;
import com.fenghua.auto.order.domain.OrderTransport;

/**
 *
 * DAO接口类
 *
 * @author 王直元
 * @createTime 2015-11-25 11:11:35
 *
 */
public interface OrderTransportDao extends BaseDao<OrderTransport>{
	/**
	 * 根据（子）订单id获取物流信息
	 * @param id
	 * @return
	 */
	OrderTransport selectByOrderHeaderId(Long orderHeaderId);

}