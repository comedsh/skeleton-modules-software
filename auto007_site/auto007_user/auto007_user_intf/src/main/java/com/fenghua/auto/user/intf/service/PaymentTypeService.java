package com.fenghua.auto.user.intf.service;

import java.util.List;

import com.fenghua.auto.backend.service.BaseService;
import com.fenghua.auto.user.intf.dto.PaymentType;

/**
 * 企业service
 * 
 * @author chengbin
 * @createTime 2015.11.2
 *
 */
public interface PaymentTypeService extends BaseService<PaymentType>{
	/**
	 * 通过id查询PaymentType
	 * @return
	 */
	public List<PaymentType> getById(Long id);
	
	public List<PaymentType> findByBuyerAndSellerIds(Long buyerIds, Long[] sellerIds);
}
