/**
 * 
 */
package com.fenghua.auto.order.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fenghua.auto.backend.dao.BaseDao;
import com.fenghua.auto.backend.service.impl.BaseServiceImpl;
import com.fenghua.auto.order.backend.dao.QualityOrderDetailDao;
import com.fenghua.auto.order.backend.domain.QualityOrderDetail;
import com.fenghua.auto.order.backend.service.QualityOrderDetailService;

/**
 * Service实现类
 *
 * @author 王直元
 * @createTime 2015-11-25 11:11:35
 *
 */
@Service
public class QualityOrderDetailServiceImpl extends BaseServiceImpl<QualityOrderDetail> implements QualityOrderDetailService {

	@Autowired
	private QualityOrderDetailDao dao;
	
	@Override
	protected BaseDao<QualityOrderDetail> getBaseDao() {
		return dao;
	}

}
