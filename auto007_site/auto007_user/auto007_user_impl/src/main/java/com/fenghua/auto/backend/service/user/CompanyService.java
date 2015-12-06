package com.fenghua.auto.backend.service.user;

import com.fenghua.auto.backend.domain.user.Company;

/**
 * 企业service
 * 
 * @author chengbin
 * @createTime 2015.11.2
 *
 */
public interface CompanyService {
	/**
	 * 通过id查询company
	 * @return
	 */
	public Company getById(Long id);
	/**
	 * 通过fixed查询company
	 * @return
	 */
	public Company getUserByFixed(String fixed);
	/**
	 * 通过telephone查询对应的实体
	 * @return
	 */
	public Company getContactsTelephone(String telephone);
	/**
	 * 通过email查询对应的实体
	 * @return
	 */
	public Company getCompanyByEmail(String email);
}
