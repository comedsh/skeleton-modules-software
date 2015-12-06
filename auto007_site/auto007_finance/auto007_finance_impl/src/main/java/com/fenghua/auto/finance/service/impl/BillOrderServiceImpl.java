/**
 * 
 */
package com.fenghua.auto.finance.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fenghua.auto.backend.dao.BaseDao;
import com.fenghua.auto.finance.dao.BillOrderDao;
import com.fenghua.auto.finance.domain.BillOrder;
import com.fenghua.auto.backend.service.impl.BaseServiceImpl;
import com.fenghua.auto.finance.service.BillOrderService;

/**
 * Service实现类
 *
 * @author 王直元
 * @createTime 2015-11-25 11:11:35
 *
 */
@Service
public class BillOrderServiceImpl extends BaseServiceImpl<BillOrder> implements BillOrderService {

	@Autowired
	private BillOrderDao dao;
	
	@Override
	protected BaseDao<BillOrder> getBaseDao() {
		return dao;
	}

}
