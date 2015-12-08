package com.fenghua.auto.user.intf.service;

import com.fenghua.auto.user.intf.dto.CompanyDTO;

/**
 * 企业service
 * 
 * @author chengbin
 * @createTime 2015.11.2
 *
 */
public interface ICompanyService {
	/**
	 * 通过id查询company
	 * @return
	 */
	public CompanyDTO getCompanyDTOById(Long id);
	/**
	 * 通过fixed查询company
	 * @return
	 */
	public CompanyDTO getCompanyDTOByFixed(String fixed);
	/**
	 * 通过telephone查询对应的实体
	 * @return
	 */
	public CompanyDTO getCompanyDTOByContactsTelephone(String telephone);
	/**
	 * 通过email查询对应的实体
	 * @return
	 */
	public CompanyDTO getCompanyDTOByEmail(String email);
}
