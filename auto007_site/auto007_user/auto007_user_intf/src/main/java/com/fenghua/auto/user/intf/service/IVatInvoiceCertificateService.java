/**
 * 
 */
package com.fenghua.auto.user.intf.service;

import java.util.List;

import com.fenghua.auto.user.intf.dto.VatInvoiceCertificateDTO;

/**
 * Service接口类
 *
 * 增值税发票资质内容
 *
 * @author 王直元
 * @createTime 2015-12-08 13:41:23
 *
 */
public interface IVatInvoiceCertificateService {

	public VatInvoiceCertificateDTO loadOneReviewedByUserId(Long userId);
	
	public List<VatInvoiceCertificateDTO> loadReviewedByUserId(Long userId);
	
	public VatInvoiceCertificateDTO loadOneReviewedByUserIdAndVatId(Long userId, Long vatId);
}
