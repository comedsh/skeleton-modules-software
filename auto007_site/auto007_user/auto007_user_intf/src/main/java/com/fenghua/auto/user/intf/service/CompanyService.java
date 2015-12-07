package com.fenghua.auto.user.intf.service;

import com.fenghua.auto.user.intf.dto.CompanyDTO;

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
	public CompanyDTO getById(Long id);
	/**
	 * 通过fixed查询company
	 * @return
	 */
	public CompanyDTO getUserByFixed(String fixed);
	/**
	 * 通过telephone查询对应的实体
	 * @return
	 */
	public CompanyDTO getContactsTelephone(String telephone);
	/**
	 * 通过email查询对应的实体
	 * @return
	 */
	public CompanyDTO getCompanyByEmail(String email);
}
