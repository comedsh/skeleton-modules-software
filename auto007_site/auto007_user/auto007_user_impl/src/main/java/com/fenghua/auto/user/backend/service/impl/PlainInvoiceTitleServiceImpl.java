/**
 * 
 */
package com.fenghua.auto.user.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fenghua.auto.backend.dao.BaseDao;
import com.fenghua.auto.user.backend.dao.PlainInvoiceTitleDao;
import com.fenghua.auto.user.backend.domain.PlainInvoiceTitle;
import com.fenghua.auto.backend.service.impl.BaseServiceImpl;
import com.fenghua.auto.user.backend.service.PlainInvoiceTitleService;

/**
 * Service实现类
 *
 * @author 王直元
 * @createTime 2015-12-08 13:41:23
 *
 */
@Service
public class PlainInvoiceTitleServiceImpl extends BaseServiceImpl<PlainInvoiceTitle> implements PlainInvoiceTitleService {

	@Autowired
	private PlainInvoiceTitleDao dao;
	
	@Override
	protected BaseDao<PlainInvoiceTitle> getBaseDao() {
		return dao;
	}

}
