/**
 * 
 */
package com.fenghua.auto.order.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fenghua.auto.backend.dao.BaseDao;
import com.fenghua.auto.backend.service.impl.BaseServiceImpl;
import com.fenghua.auto.order.backend.dao.OrderTransportDetailDao;
import com.fenghua.auto.order.backend.domain.OrderTransportDetail;
import com.fenghua.auto.order.backend.service.OrderTransportDetailService;

/**
 * Service实现类
 *
 * @author 王直元
 * @createTime 2015-11-25 11:11:35
 *
 */
@Service
public class OrderTransportDetailServiceImpl extends BaseServiceImpl<OrderTransportDetail> implements OrderTransportDetailService {

	@Autowired
	private OrderTransportDetailDao dao;
	
	@Override
	protected BaseDao<OrderTransportDetail> getBaseDao() {
		return dao;
	}

}
