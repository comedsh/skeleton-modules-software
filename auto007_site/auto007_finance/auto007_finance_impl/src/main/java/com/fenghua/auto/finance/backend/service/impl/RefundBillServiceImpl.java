/**
 * 
 */
package com.fenghua.auto.finance.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fenghua.auto.backend.dao.BaseDao;
import com.fenghua.auto.backend.service.impl.BaseServiceImpl;
import com.fenghua.auto.finance.backend.dao.RefundBillDao;
import com.fenghua.auto.finance.backend.domain.RefundBill;
import com.fenghua.auto.finance.backend.service.RefundBillService;

/**
 * Service实现类
 *
 * @author 王直元
 * @createTime 2015-11-25 11:11:35
 *
 */
@Service
public class RefundBillServiceImpl extends BaseServiceImpl<RefundBill> implements RefundBillService {

	@Autowired
	private RefundBillDao dao;
	
	@Override
	protected BaseDao<RefundBill> getBaseDao() {
		return dao;
	}

}
