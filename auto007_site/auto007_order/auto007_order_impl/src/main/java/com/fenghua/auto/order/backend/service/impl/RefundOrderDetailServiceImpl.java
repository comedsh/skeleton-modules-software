/**
 * 
 */
package com.fenghua.auto.order.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fenghua.auto.backend.dao.BaseDao;
import com.fenghua.auto.backend.service.impl.BaseServiceImpl;
import com.fenghua.auto.order.backend.dao.RefundOrderDetailDao;
import com.fenghua.auto.order.backend.domain.RefundOrderDetail;
import com.fenghua.auto.order.backend.service.RefundOrderDetailService;

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
