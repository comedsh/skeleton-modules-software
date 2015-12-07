package com.fenghua.auto.user.backend.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.fenghua.auto.backend.dao.DaoException;
import com.fenghua.auto.backend.dao.constants.SqlId;
import com.fenghua.auto.backend.dao.impl.BaseDaoImpl;
import com.fenghua.auto.user.backend.dao.UserForgetPassDao;
import com.fenghua.auto.user.backend.domain.ResetPassRequest;

@Repository
public class UserForgetPassDaoImpl extends BaseDaoImpl<ResetPassRequest> implements UserForgetPassDao{

	@Override
	public void insert(ResetPassRequest resetPassRequest) {
		Assert.notNull(resetPassRequest);
		try {
			sqlSessionTemplate.insert(getSqlName(SqlId.SQL_INSERT), resetPassRequest);
		} catch (Exception e) {
			throw new DaoException(String.format("添加对象出错！语句：%s", getSqlName(SqlId.SQL_INSERT)), e);
		}
		
	}
	@Override
	public List<ResetPassRequest> selectByCodeAndUser(Map<String,Object> map) {
//		Assert.notNull(certificateCode);
		List<ResetPassRequest> resetPassRequest = new ArrayList<ResetPassRequest>();
		try {
			resetPassRequest = sqlSessionTemplate.selectList(getSqlName(SqlId.SQL_SELECT_BY_CODEANDUSER), map);
		} catch (Exception e) {
			throw new DaoException(String.format("查询对象出错！语句：%s", getSqlName(SqlId.SQL_SELECT_BY_CODEANDUSER)), e);
		}
		return resetPassRequest;
	}
	@Override
	public void deleteByUserId(Map<String,Object> map) {
		Assert.notNull(map);
		try {
			sqlSessionTemplate.delete(getSqlName(SqlId.SQL_DELETE_BY_USERID), map);
		} catch (Exception e) {
			throw new DaoException(String.format("删除对象出错！语句：%s", getSqlName(SqlId.SQL_DELETE_BY_USERID)), e);
		}
		
	}
}
