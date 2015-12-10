package com.fenghua.auto.order.backend.service;

import java.util.List;

import com.fenghua.auto.order.backend.domain.OrderHeader;
import com.fenghua.auto.order.backend.util.OrderListQuery;
import com.fenghua.auto.order.backend.vo.OrderMasterVO;

/**
 * 订单列表服务
 * @author zhangfr
 *
 */
public interface OrderListService {
	/**
	 * 查询订单列表
	 * @param query
	 * @return
	 */
	List<OrderMasterVO> queryOrderMasterVO(OrderListQuery query);
}
