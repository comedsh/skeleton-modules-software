package com.fenghua.auto.user.backend.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.fenghua.auto.backend.dao.DaoException;
import com.fenghua.auto.backend.dao.constants.SqlId;
import com.fenghua.auto.backend.dao.impl.BaseDaoImpl;
import com.fenghua.auto.user.backend.dao.CompanyDao;
import com.fenghua.auto.user.backend.domain.Company;
/**
 * 企业信息dao实现
 * @author chengbin
 *
 */
@Repository
public class CompanyDaoImpl extends BaseDaoImpl<Company> implements CompanyDao {

	@Override
	public List<Company> getById(Long id) {
		Assert.notNull(id);
		List<Company> company = new ArrayList<Company>();
		try {
			company = sqlSessionTemplate.selectList(getSqlName(SqlId.SQL_SELECT_PRIMARY_KEY), id);
		} catch (Exception e) {
			throw new DaoException(String.format("根据Fixed查询对象出错！语句：%s", getSqlName(SqlId.SQL_SELECT_PRIMARY_KEY)), e);
		}
		return company;
	}
	
	@Override
	public List<Company> selectByFixed(String fixed) {
		Assert.notNull(fixed);
		List<Company> company = new ArrayList<Company>();
		try {
			company = sqlSessionTemplate.selectList(getSqlName(SqlId.SQL_SELECT_BY_FIXED), fixed);
		} catch (Exception e) {
			throw new DaoException(String.format("根据Fixed查询对象出错！语句：%s", getSqlName(SqlId.SQL_SELECT_BY_FIXED)), e);
		}
		return company;
	}
	
	@Override
	public List<Company> selectByTelephone(String contactsMobile) {
		Assert.notNull(contactsMobile);
		List<Company> company = new ArrayList<Company>();
		try {
			company = sqlSessionTemplate.selectList(getSqlName(SqlId.SQL_SELECT_BY_CONTACTSTELEPHONE), contactsMobile);
		} catch (Exception e) {
			throw new DaoException(String.format("根据Fixed查询对象出错！语句：%s", getSqlName(SqlId.SQL_SELECT_BY_CONTACTSTELEPHONE)), e);
		}
		return company;
	}
	
	@Override
	public List<Company> selectByEmail(String contactsEmail) {
		Assert.notNull(contactsEmail);
		List<Company> company = new ArrayList<Company>();
		try {
			company = sqlSessionTemplate.selectList(getSqlName(SqlId.SQL_SELECT_BY_CONTACTSEMAIL), contactsEmail);
		} catch (Exception e) {
			throw new DaoException(String.format("根据Fixed查询对象出错！语句：%s", getSqlName(SqlId.SQL_SELECT_BY_CONTACTSEMAIL)), e);
		}
		return company;
	}

	@Override
	public Long getCompanyId(Company company) {
		Assert.notNull(company);
		Long str = null;
		try {
			sqlSessionTemplate.insert(getSqlName(SqlId.SQL_INSERT_SELECTIVE), company);
			str = company.getId();
		} catch (Exception e) {
			throw new DaoException(String.format("添加对象出错！语句：%s", getSqlName(SqlId.SQL_INSERT)), e);
		}
		return str;
	}
}
