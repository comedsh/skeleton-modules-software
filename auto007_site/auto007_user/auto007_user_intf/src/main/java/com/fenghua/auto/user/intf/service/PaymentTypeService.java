package com.fenghua.auto.user.intf.service;

import java.util.List;

import com.fenghua.auto.user.intf.dto.PaymentTypeDTO;

/**
 * 企业service
 * 
 * @author chengbin
 * @createTime 2015.11.2
 *
 */
public interface PaymentTypeService {
	/**
	 * 通过id查询PaymentType
	 * @return
	 */
	public List<PaymentTypeDTO> getById(Long id);
	
	public List<PaymentTypeDTO> findByBuyerAndSellerIds(Long buyerIds, Long[] sellerIds);
}
