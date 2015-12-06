package com.fenghua.auto.backend.service.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fenghua.auto.backend.dao.user.CompanyDao;
import com.fenghua.auto.backend.domain.user.Company;
import com.fenghua.auto.backend.service.user.CompanyService;

/**
 * 企业接口实现
 * @author chengbin
 * @createTime 2015.11.2
 *
 */
@Service
public class CompanyServiceImpl implements CompanyService {
	
	@Autowired
	private CompanyDao companyDao;
	
	@Override
	public Company getById(Long id) {
		List<Company> company = companyDao.getById(id);
		if (company.size() > 0) {
			return company.get(0);
		} else {
			return null;
		}
	}
	
	@Override
	public Company getUserByFixed(String fixed) {
		List<Company> company = companyDao.selectByFixed(fixed);
		if (company.size() > 0) {
			return company.get(0);
		} else {
			return null;
		}
	}
	@Override
	public Company getContactsTelephone(String telephone) {
		List<Company> company = companyDao.selectByTelephone(telephone);
		if (company.size() > 0) {
			return company.get(0);
		} else {
			return null;
		}
	}
	@Override
	public Company getCompanyByEmail(String email) {
		List<Company> company = companyDao.selectByEmail(email);
		if (company.size() > 0) {
			return company.get(0);
		} else {
			return null;
		}
	}
}
