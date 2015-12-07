package com.fenghua.auto.user.intf.service;

import java.util.List;

import com.fenghua.auto.user.intf.dto.UserPaymentTypeDTO;

/**
 * 企业service
 * 
 * @author chengbin
 * @createTime 2015.11.2
 *
 */
public interface UserPaymentTypeService {
	/**
	 * 通过id查询UserPaymentType
	 * @return
	 */
	public List<UserPaymentTypeDTO> getById(Long id);
	/**
	 * 通过UserId查询UserPaymentType
	 * @return
	 */
	public List<UserPaymentTypeDTO> getByUserId(Long userId);
}
