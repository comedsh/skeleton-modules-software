/**
 * 
 */
package com.fenghua.auto.order.backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fenghua.auto.backend.dao.BaseDao;
import com.fenghua.auto.backend.service.impl.BaseServiceImpl;
import com.fenghua.auto.order.backend.dao.OrderItemDao;
import com.fenghua.auto.order.backend.domain.OrderItem;
import com.fenghua.auto.order.backend.service.OrderItemService;

/**
 * Service实现类
 *
 * @author 王直元
 * @createTime 2015-11-25 11:11:35
 *
 */
@Service
public class OrderItemServiceImpl extends BaseServiceImpl<OrderItem> implements OrderItemService {

	@Autowired
	private OrderItemDao dao;
	
	@Override
	protected BaseDao<OrderItem> getBaseDao() {
		return dao;
	}

	@Override
	public List<OrderItem> selectByOrderID(Long orderHeaderID) {
		return dao.selectByOrderID(orderHeaderID);
	}

}
