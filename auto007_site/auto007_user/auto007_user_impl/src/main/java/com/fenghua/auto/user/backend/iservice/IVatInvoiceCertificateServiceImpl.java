package com.fenghua.auto.user.backend.iservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fenghua.auto.backend.common.utils.BeanMapper;
import com.fenghua.auto.user.backend.domain.VatInvoiceCertificate;
import com.fenghua.auto.user.backend.service.VatInvoiceCertificateService;
import com.fenghua.auto.user.intf.dto.VatInvoiceCertificateDTO;
import com.fenghua.auto.user.intf.service.IVatInvoiceCertificateService;

/**
 * 
 * @author zhiyuan.wang@auto007.com
 *
 */
@Service
public class IVatInvoiceCertificateServiceImpl implements IVatInvoiceCertificateService {

	@Autowired
	private VatInvoiceCertificateService vatInvoiceCertificateService;
	
	@Override
	public VatInvoiceCertificateDTO loadOneReviewedByUserId(Long userId) {
		VatInvoiceCertificate query = new VatInvoiceCertificate();
		query.setUserId(userId);
		query.setReviewed(true);
		return BeanMapper.map(vatInvoiceCertificateService.selectOne(query), VatInvoiceCertificateDTO.class);
	}

	@Override
	public List<VatInvoiceCertificateDTO> loadReviewedByUserId(Long userId) {
		VatInvoiceCertificate query = new VatInvoiceCertificate();
		query.setUserId(userId);
		query.setReviewed(true);
		return BeanMapper.mapList(vatInvoiceCertificateService.selectList(query), VatInvoiceCertificateDTO.class);
	}

	@Override
	public VatInvoiceCertificateDTO loadOneReviewedByUserIdAndVatId(Long userId, Long vatId) {
		VatInvoiceCertificate query = new VatInvoiceCertificate();
		query.setUserId(userId);
		query.setId(vatId);
		query.setReviewed(true);
		return BeanMapper.map(vatInvoiceCertificateService.selectOne(query), VatInvoiceCertificateDTO.class);
	}

}
