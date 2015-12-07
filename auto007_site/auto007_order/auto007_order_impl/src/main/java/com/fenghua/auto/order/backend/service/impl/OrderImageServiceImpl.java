/**
 * 
 */
package com.fenghua.auto.order.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fenghua.auto.backend.dao.BaseDao;
import com.fenghua.auto.backend.service.impl.BaseServiceImpl;
import com.fenghua.auto.order.backend.dao.OrderImageDao;
import com.fenghua.auto.order.backend.domain.OrderImage;
import com.fenghua.auto.order.backend.service.OrderImageService;

/**
 * Service实现类
 *
 * @author 王直元
 * @createTime 2015-11-25 11:11:35
 *
 */
@Service
public class OrderImageServiceImpl extends BaseServiceImpl<OrderImage> implements OrderImageService {

	@Autowired
	private OrderImageDao dao;
	
	@Override
	protected BaseDao<OrderImage> getBaseDao() {
		return dao;
	}

}
