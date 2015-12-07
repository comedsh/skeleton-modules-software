/**
 * 
 */
package com.fenghua.auto.finance.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fenghua.auto.backend.dao.BaseDao;
import com.fenghua.auto.backend.service.impl.BaseServiceImpl;
import com.fenghua.auto.finance.backend.dao.TransactionFlowDao;
import com.fenghua.auto.finance.backend.domain.TransactionFlow;
import com.fenghua.auto.finance.backend.service.TransactionFlowService;

/**
 * Service实现类
 *
 * @author 王直元
 * @createTime 2015-11-25 11:11:35
 *
 */
@Service
public class TransactionFlowServiceImpl extends BaseServiceImpl<TransactionFlow> implements TransactionFlowService {

	@Autowired
	private TransactionFlowDao dao;
	
	@Override
	protected BaseDao<TransactionFlow> getBaseDao() {
		return dao;
	}

}
