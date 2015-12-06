/**
 * 
 */
package com.fenghua.auto.order.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fenghua.auto.backend.dao.BaseDao;
import com.fenghua.auto.order.dao.OrderTaskDao;
import com.fenghua.auto.order.domain.OrderTask;
import com.fenghua.auto.backend.service.impl.BaseServiceImpl;
import com.fenghua.auto.order.service.OrderTaskService;

/**
 * Service实现类
 *
 * @author 王直元
 * @createTime 2015-11-25 11:11:35
 *
 */
@Service
public class OrderTaskServiceImpl extends BaseServiceImpl<OrderTask> implements OrderTaskService {

	@Autowired
	private OrderTaskDao dao;
	
	@Override
	protected BaseDao<OrderTask> getBaseDao() {
		return dao;
	}

}
