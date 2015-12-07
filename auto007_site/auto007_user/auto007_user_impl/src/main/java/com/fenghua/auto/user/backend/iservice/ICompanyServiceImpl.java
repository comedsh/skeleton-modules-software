package com.fenghua.auto.user.backend.iservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fenghua.auto.backend.common.utils.BeanMapper;
import com.fenghua.auto.user.backend.domain.Company;
import com.fenghua.auto.user.backend.service.CompanyService;
import com.fenghua.auto.user.intf.dto.CompanyDTO;

/**
 * 企业接口实现
 * @author chengbin
 * @createTime 2015.11.2
 *
 */
@Service
public class ICompanyServiceImpl implements com.fenghua.auto.user.intf.service.ICompanyService {
	
	@Autowired
	private CompanyService companyService;
	
	@Override
	public CompanyDTO getCompanyDTOById(Long id) {
		Company c = companyService.getById(id);
		if(c != null) {
			return BeanMapper.map(c, CompanyDTO.class);
		}
		return null;
	}

	@Override
	public CompanyDTO getCompanyDTOByFixed(String fixed) {
		Company c = companyService.getUserByFixed(fixed);
		return BeanMapper.map(c, CompanyDTO.class);
	}

	@Override
	public CompanyDTO getCompanyDTOByContactsTelephone(String telephone) {
		Company c = companyService.getContactsTelephone(telephone);
		return BeanMapper.map(c, CompanyDTO.class);
	}

	@Override
	public CompanyDTO getCompanyDTOByEmail(String email) {
		Company c = companyService.getCompanyByEmail(email);
		return BeanMapper.map(c, CompanyDTO.class);
	}
}
