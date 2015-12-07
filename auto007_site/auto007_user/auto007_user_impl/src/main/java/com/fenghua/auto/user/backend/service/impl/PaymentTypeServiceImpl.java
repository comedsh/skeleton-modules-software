package com.fenghua.auto.user.backend.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fenghua.auto.backend.dao.BaseDao;
import com.fenghua.auto.backend.service.impl.BaseServiceImpl;
import com.fenghua.auto.user.backend.dao.PaymentTypeDao;
import com.fenghua.auto.user.backend.domain.PaymentType;
import com.fenghua.auto.user.backend.domain.UserPaymentType;
import com.fenghua.auto.user.backend.service.PaymentTypeService;
import com.fenghua.auto.user.backend.service.UserPaymentTypeService;

/**
 * 企业接口实现
 * @author chengbin
 * @createTime 2015.11.2
 *
 */
@Service
public class PaymentTypeServiceImpl extends BaseServiceImpl<PaymentType> implements PaymentTypeService {
	
	@Autowired
	private PaymentTypeDao paymentTypeDao;
	
	@Autowired
	private UserPaymentTypeService userPaymentTypeService;
	
	@Override
	protected BaseDao<PaymentType> getBaseDao() {
		return paymentTypeDao;
	}

	@Override
	public List<PaymentType> getById(Long id) {
		List<PaymentType> list = new ArrayList<PaymentType>();
		List<UserPaymentType> userPaymentTypes = userPaymentTypeService.getByUserId(id);
		for (UserPaymentType userPaymentType : userPaymentTypes) {
			PaymentType paymentType = paymentTypeDao.getById(userPaymentType.getPaymenttypeId()).get(0);
			list.add(paymentType);
		}
		return list;
	}

	@Override
	public List<PaymentType> findByBuyerAndSellerIds(Long buyerIds, Long[] sellerIds) {
		//TODO 按照卖家买家的配置取得支付方式
		List<PaymentType> paymentTypeList = selectAll();
		return paymentTypeList;
	}
}
