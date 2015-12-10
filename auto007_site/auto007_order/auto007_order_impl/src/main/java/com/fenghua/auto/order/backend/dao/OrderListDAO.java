/**
 * 
 */
package com.fenghua.auto.order.backend.dao;

import java.util.List;

import com.fenghua.auto.backend.dao.BaseDao;
import com.fenghua.auto.order.backend.domain.OrderHeader;
import com.fenghua.auto.order.backend.util.OrderListQuery;
import com.fenghua.auto.order.backend.vo.OrderMasterVO;

/**
 *
 * DAO接口类
 *
 * @author zhangfr
 * @createTime 2015-12-09 14:49:35
 *
 */
public interface OrderListDAO extends BaseDao<com.fenghua.auto.order.backend.util.OrderListQuery>{
	/**
	 * 查询订单
	 * @param query
	 * @return
	 */
	List<OrderMasterVO> query(OrderListQuery query);
}