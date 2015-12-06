/**
 * 
 */
package com.fenghua.auto.order.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fenghua.auto.backend.dao.BaseDao;
import com.fenghua.auto.order.dao.RefundOrderDetailDao;
import com.fenghua.auto.order.domain.RefundOrderDetail;
import com.fenghua.auto.backend.service.impl.BaseServiceImpl;
import com.fenghua.auto.order.service.RefundOrderDetailService;

/**
 * Service实现类
 *
 * @author 王直元
 * @createTime 2015-11-25 11:11:35
 *
 */
@Service
public class RefundOrderDetailServiceImpl extends BaseServiceImpl<RefundOrderDetail> implements RefundOrderDetailService {

	@Autowired
	private RefundOrderDetailDao dao;
	
	@Override
	protected BaseDao<RefundOrderDetail> getBaseDao() {
		return dao;
	}

}
