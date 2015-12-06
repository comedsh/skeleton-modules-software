package com.fenghua.auto.backend.dao.user.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.fenghua.auto.backend.dao.DaoException;
import com.fenghua.auto.backend.dao.constants.SqlId;
import com.fenghua.auto.backend.dao.impl.BaseDaoImpl;
import com.fenghua.auto.backend.dao.user.UserPaymentTypeDao;
import com.fenghua.auto.backend.domain.user.UserPaymentType;
/**
 * 用户与支付方式的dao实现
 * @author chengbin
 *
 */
@Repository
public class UserPaymentTypeDaoImpl extends BaseDaoImpl<UserPaymentType> implements UserPaymentTypeDao {

	@Override
	public void insert(UserPaymentType payment) {
		Assert.notNull(payment);
		try {
			sqlSessionTemplate.insert(getSqlName(SqlId.SQL_INSERT), payment);
		} catch (Exception e) {
			throw new DaoException(String.format("添加对象出错！语句：%s", getSqlName(SqlId.SQL_INSERT)), e);
		}
	}

	@Override
	public List<UserPaymentType> getById(Long paymenttypeId) {
		Assert.notNull(paymenttypeId);
		List<UserPaymentType> userPaymentType = new ArrayList<UserPaymentType>();
		try {
			userPaymentType = sqlSessionTemplate.selectList(getSqlName(SqlId.SQL_SELECT_PRIMARY_KEY), paymenttypeId);
		} catch (Exception e) {
			throw new DaoException(String.format("添加对象出错！语句：%s", getSqlName(SqlId.SQL_SELECT_PRIMARY_KEY)), e);
		}
		return userPaymentType;
	}

	@Override
	public List<UserPaymentType> getByUserId(Long userId) {
		Assert.notNull(userId);
		List<UserPaymentType> userPaymentType = new ArrayList<UserPaymentType>();
		try {
			userPaymentType = sqlSessionTemplate.selectList(getSqlName(SqlId.SQL_SELECT_BY_USERID), userId);
		} catch (Exception e) {
			throw new DaoException(String.format("添加对象出错！语句：%s", getSqlName(SqlId.SQL_SELECT_BY_USERID)), e);
		}
		return userPaymentType;
	}
	
}
