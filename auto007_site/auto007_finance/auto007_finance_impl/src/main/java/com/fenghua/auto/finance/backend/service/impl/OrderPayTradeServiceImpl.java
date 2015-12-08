/**
 * 
 */
package com.fenghua.auto.finance.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fenghua.auto.backend.dao.BaseDao;
import com.fenghua.auto.backend.service.impl.BaseServiceImpl;
import com.fenghua.auto.finance.backend.dao.OrderPayTradeDao;
import com.fenghua.auto.finance.backend.domain.OrderPayTrade;
import com.fenghua.auto.finance.backend.service.OrderPayTradeService;

/**
 * Service实现类
 *
 * @author 王直元
 * @createTime 2015-11-25 11:11:35
 *
 */
@Service
public class OrderPayTradeServiceImpl extends BaseServiceImpl<OrderPayTrade> implements OrderPayTradeService {

	@Autowired
	private OrderPayTradeDao dao;
	
	@Override
	protected BaseDao<OrderPayTrade> getBaseDao() {
		return dao;
	}

}
