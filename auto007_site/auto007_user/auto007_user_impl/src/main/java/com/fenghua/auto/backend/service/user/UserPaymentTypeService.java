package com.fenghua.auto.backend.service.user;

import java.util.List;

import com.fenghua.auto.backend.domain.user.UserPaymentType;
import com.fenghua.auto.backend.service.BaseService;

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
