/**
 * 
 */
package com.fenghua.auto.order.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fenghua.auto.backend.dao.BaseDao;
import com.fenghua.auto.backend.service.impl.BaseServiceImpl;
import com.fenghua.auto.order.backend.dao.OrderInvoiceDao;
import com.fenghua.auto.order.backend.domain.OrderInvoice;
import com.fenghua.auto.order.backend.service.OrderInvoiceService;

/**
 * Service实现类
 *
 * @author 王直元
 * @createTime 2015-11-25 11:11:35
 *
 */
@Service
public class OrderInvoiceServiceImpl extends BaseServiceImpl<OrderInvoice> implements OrderInvoiceService {

	@Autowired
	private OrderInvoiceDao dao;
	
	@Override
	protected BaseDao<OrderInvoice> getBaseDao() {
		return dao;
	}

}
