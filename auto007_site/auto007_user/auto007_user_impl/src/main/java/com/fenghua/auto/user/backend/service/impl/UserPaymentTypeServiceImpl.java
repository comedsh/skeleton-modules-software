package com.fenghua.auto.user.backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fenghua.auto.backend.dao.BaseDao;
import com.fenghua.auto.backend.service.impl.BaseServiceImpl;
import com.fenghua.auto.user.backend.dao.UserPaymentTypeDao;
import com.fenghua.auto.user.backend.domain.UserPaymentType;
import com.fenghua.auto.user.backend.service.UserPaymentTypeService;

/**
 * 企业接口实现
 * @author chengbin
 * @createTime 2015.11.2
 *
 */
@Service
public class UserPaymentTypeServiceImpl extends BaseServiceImpl<UserPaymentType> implements UserPaymentTypeService {
	
	@Autowired
	private UserPaymentTypeDao userPaymentTypeDao;
	
	@Override
	protected BaseDao<UserPaymentType> getBaseDao() {
		return userPaymentTypeDao;
	}

	@Override
	public List<UserPaymentType> getById(Long id) {
		return userPaymentTypeDao.getById(id);
	}
	
	@Override
	public List<UserPaymentType> getByUserId(Long userId) {
		return userPaymentTypeDao.getByUserId(userId);
	}
}
