/**
 * 
 */
package com.fenghua.auto.order.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fenghua.auto.backend.dao.BaseDao;
import com.fenghua.auto.backend.service.impl.BaseServiceImpl;
import com.fenghua.auto.order.backend.dao.OrderTrackDao;
import com.fenghua.auto.order.backend.domain.OrderTrack;
import com.fenghua.auto.order.backend.service.OrderTrackService;

/**
 * Service实现类
 *
 * @author 王直元
 * @createTime 2015-11-25 11:11:35
 *
 */
@Service
public class OrderTrackServiceImpl extends BaseServiceImpl<OrderTrack> implements OrderTrackService {

	@Autowired
	private OrderTrackDao dao;
	
	@Override
	protected BaseDao<OrderTrack> getBaseDao() {
		return dao;
	}

}
