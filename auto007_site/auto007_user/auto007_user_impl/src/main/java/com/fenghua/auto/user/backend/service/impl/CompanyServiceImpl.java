package com.fenghua.auto.user.backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fenghua.auto.user.backend.dao.CompanyDao;
import com.fenghua.auto.user.backend.domain.Company;
import com.fenghua.auto.user.backend.service.CompanyService;

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
