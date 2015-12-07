package com.fenghua.auto.user.backend.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.fenghua.auto.backend.dao.DaoException;
import com.fenghua.auto.backend.dao.constants.SqlId;
import com.fenghua.auto.backend.dao.impl.BaseDaoImpl;
import com.fenghua.auto.user.backend.dao.RoleDao;
import com.fenghua.auto.user.backend.domain.Role;
/**
 * 用户角色的dao实现
 * @author chengbin
 *
 */
@Repository
public class RoleDaoImpl extends BaseDaoImpl<Role> implements RoleDao {

	@Override
	public List<Role> getRoleById(Long id) {
		Assert.notNull(id);
		List<Role> role = new ArrayList<Role>();
		try {
			role = sqlSessionTemplate.selectList(getSqlName(SqlId.SQL_SELECT_PRIMARY_KEY), id);
		} catch (Exception e) {
			throw new DaoException(String.format("根据Name查询对象出错！语句：%s", getSqlName(SqlId.SQL_SELECT_PRIMARY_KEY)), e);
		}
		return role;
	}

	@Override
	public Long getIdInsert(Role role) {
		Assert.notNull(role);
		Long str = null;
		try {
			sqlSessionTemplate.insert(getSqlName(SqlId.SQL_INSERT), role);
			str = role.getId();
		} catch (Exception e) {
			throw new DaoException(String.format("添加对象出错！语句：%s", getSqlName(SqlId.SQL_INSERT)), e);
		}
		return str;
	}
}
