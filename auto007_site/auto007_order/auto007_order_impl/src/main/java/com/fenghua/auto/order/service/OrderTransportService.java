/**
 * 
 */
package com.fenghua.auto.order.service;

import com.fenghua.auto.backend.service.BaseService;
import com.fenghua.auto.order.domain.OrderTransport;

/**
 * Service接口类
 *
 * @author 王直元
 * @createTime 2015-11-25 11:11:35
 *
 */
public interface OrderTransportService extends BaseService<OrderTransport> {
	/**
	 * 根据订单id获取物流信息
	 * @param id
	 * @return
	 */
	OrderTransport selectByOrderHeaderId(Long orderHeaderId);

}
