/**
 * 
 */
package com.fenghua.auto.user.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fenghua.auto.backend.dao.BaseDao;
import com.fenghua.auto.user.backend.dao.VatInvoiceCertificateDao;
import com.fenghua.auto.user.backend.domain.VatInvoiceCertificate;
import com.fenghua.auto.backend.service.impl.BaseServiceImpl;
import com.fenghua.auto.user.backend.service.VatInvoiceCertificateService;

/**
 * Service实现类
 *
 * @author 王直元
 * @createTime 2015-12-08 13:41:23
 *
 */
@Service
public class VatInvoiceCertificateServiceImpl extends BaseServiceImpl<VatInvoiceCertificate> implements VatInvoiceCertificateService {

	@Autowired
	private VatInvoiceCertificateDao dao;
	
	@Override
	protected BaseDao<VatInvoiceCertificate> getBaseDao() {
		return dao;
	}

}
