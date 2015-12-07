package com.fenghua.auto.user.backend.iservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fenghua.auto.backend.common.utils.BeanMapper;
import com.fenghua.auto.user.backend.service.PaymentTypeService;
import com.fenghua.auto.user.intf.dto.PaymentTypeDTO;

/**
 * 企业接口实现
 * @author chengbin
 * @createTime 2015.11.2
 *
 */
@Service
public class IPaymentTypeServiceImpl implements com.fenghua.auto.user.intf.service.IPaymentTypeService {
	
	@Autowired
	private PaymentTypeService paymentTypeService;
	
	@Override
	public List<PaymentTypeDTO> getByUserId(Long userId) {
		return BeanMapper.mapList(paymentTypeService.getById(userId), PaymentTypeDTO.class);
	}

	@Override
	public List<PaymentTypeDTO> findByBuyerAndSellerIds(Long buyerIds, Long[] sellerIds) {
		return BeanMapper.mapList(paymentTypeService.findByBuyerAndSellerIds(buyerIds, sellerIds), PaymentTypeDTO.class);
	}
}
