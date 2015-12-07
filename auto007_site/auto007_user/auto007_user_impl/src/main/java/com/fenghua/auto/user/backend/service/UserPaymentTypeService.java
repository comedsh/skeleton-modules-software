package com.fenghua.auto.user.backend.service;

import java.util.List;

import com.fenghua.auto.backend.service.BaseService;
import com.fenghua.auto.user.backend.domain.UserPaymentType;

/**
 * 企业service
 * 
 * @author chengbin
 * @createTime 2015.11.2
 *
 */
public interface UserPaymentTypeService extends BaseService<UserPaymentType>{
	/**
	 * 通过id查询UserPaymentType
	 * @return
	 */
	public List<UserPaymentType> getById(Long id);
	/**
	 * 通过UserId查询UserPaymentType
	 * @return
	 */
	public List<UserPaymentType> getByUserId(Long userId);
}
