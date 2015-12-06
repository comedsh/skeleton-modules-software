package com.fenghua.auto.backend.dao.user.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.fenghua.auto.backend.dao.DaoException;
import com.fenghua.auto.backend.dao.constants.SqlId;
import com.fenghua.auto.backend.dao.impl.BaseDaoImpl;
import com.fenghua.auto.backend.dao.user.UserDao;
import com.fenghua.auto.backend.domain.user.User;
/**
 * 用户的dao实现
 * @author chengbin
 *
 */
@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	@Override
	public List<User> selectByName(String name) {
		Assert.notNull(name);
		List<User> user = new ArrayList<User>();
		try {
			user = sqlSessionTemplate.selectList(getSqlName(SqlId.SQL_SELECT_BY_NAME), name);
		} catch (Exception e) {
			throw new DaoException(String.format("根据Name查询对象出错！语句：%s", getSqlName(SqlId.SQL_SELECT_BY_NAME)), e);
		}
		return user;
	}
	
	@Override
	public void updateFailTimes(String name,short count) {
		Assert.notNull(name);
		Assert.notNull(count);
		User user = new User();
		user.setName(name);
		user.setFailedLoginTimes(count);
		try {
			sqlSessionTemplate.update(getSqlName(SqlId.SQL_UPDATE_BY_NAME), user);
		} catch (Exception e) {
			throw new DaoException(String.format("根据Name查询对象出错！语句：%s", getSqlName(SqlId.SQL_UPDATE_BY_NAME)), e);
		}
	}
	
	@Override
	public void insert(User user) {
		Assert.notNull(user);
		try {
			sqlSessionTemplate.insert(getSqlName(SqlId.SQL_INSERT), user);
		} catch (Exception e) {
			throw new DaoException(String.format("添加对象出错！语句：%s", getSqlName(SqlId.SQL_INSERT)), e);
		}
	}
	
	@Override
	public Long getPaymentId(User user) {
		Assert.notNull(user);
		Long str = null;
		try {
			sqlSessionTemplate.insert(getSqlName(SqlId.SQL_INSERT), user);
			str = user.getId();
		} catch (Exception e) {
			throw new DaoException(String.format("添加对象出错！语句：%s", getSqlName(SqlId.SQL_INSERT)), e);
		}
		return str;
	}
	
	@Override
	public Long updatePasswordByPhone(User user) {
		Long str = null;
		try {
			str=(long) sqlSessionTemplate.insert(getSqlName(SqlId.SQL_UPDATEPASSWORD_BY_PHONE), user);
			//str = user.getId();
		} catch (Exception e) {
			throw new DaoException(String.format("添加对象出错！语句：%s", getSqlName(SqlId.SQL_INSERT)), e);
		}
		return str;
	}
	@Override
	public List<User> selectByEmail(String email) {
		Assert.notNull(email);
		List<User> user = new ArrayList<User>();
		try {
			user = sqlSessionTemplate.selectList(getSqlName(SqlId.SQL_SELECT_BY_EMAIL), email);
		} catch (Exception e) {
			throw new DaoException(String.format("根据Email查询对象出错！语句：%s", getSqlName(SqlId.SQL_SELECT_BY_EMAIL)), e);
		}
		return user;
	}
	
	@Override
	public List<User> selectByTelephone(String telephone) {
		Assert.notNull(telephone);
		List<User> user = new ArrayList<User>();
		try {
			user = sqlSessionTemplate.selectList(getSqlName(SqlId.SQL_SELECT_BY_TELEPHONE), telephone);
		} catch (Exception e) {
			throw new DaoException(String.format("根据Telephone查询对象出错！语句：%s", getSqlName(SqlId.SQL_SELECT_BY_TELEPHONE)), e);
		}
		return user;
	}

	@Override
	public Long updatePasswordByUserId(User user) {
		Long str = null;
		try {
			str=(long) sqlSessionTemplate.insert(getSqlName(SqlId.SQL_UPDATEPASSWORD_BY_USERID), user);
			//str = user.getId();
		} catch (Exception e) {
			throw new DaoException(String.format("跟新密码出错！语句：%s", getSqlName(SqlId.SQL_UPDATEPASSWORD_BY_USERID)), e);
		}
		return str;
	}

	@Override
	public User selectByUserId(Long userId) {
		Assert.notNull(userId);
		User user = null;
		try {
			user = sqlSessionTemplate.selectOne(getSqlName(SqlId.SQL_SELECT_BY_USERID), userId);
		} catch (Exception e) {
			throw new DaoException(String.format("根据用户id查询对象出错！语句：%s", getSqlName(SqlId.SQL_SELECT_BY_USERID)), e);
		}
		return user;
	}

	@Override
	public List<User> getUserByQQ(String qqOpenID) {
		Assert.notNull(qqOpenID);
		List<User> user = new ArrayList<User>();
		try {
			user = sqlSessionTemplate.selectList(
					getSqlName(SqlId.SQL_SELECT_BY_QQ_Number), qqOpenID);
		} catch (Exception e) {
			throw new DaoException(String.format("根据Telephone查询对象出错！语句：%s",
					getSqlName(SqlId.SQL_SELECT_BY_QQ_Number)), e);
		}
		return user;
	}

	@Override
	public void updateQQNumberByUserID(User user) {
		Long str = null;
		try {
			sqlSessionTemplate.insert(getSqlName(SqlId.SQL_UPDATEQQNUMBER_BY_USERID), user);
		} catch (Exception e) {
			throw new DaoException(String.format("绑定qq账号出错出错！语句：%s", getSqlName(SqlId.SQL_UPDATEQQNUMBER_BY_USERID)), e);
		}
	}

	@Override
	public List<User> getUserByWeChat(String openid) {
		Assert.notNull(openid);
		List<User> user = new ArrayList<User>();
		try {
			user = sqlSessionTemplate.selectList(
					getSqlName(SqlId.SQL_SELECT_WECHAT), openid);
		} catch (Exception e) {
			throw new DaoException(String.format("根据Telephone查询对象出错！语句：%s",
					getSqlName(SqlId.SQL_SELECT_WECHAT)), e);
		}
		return user;
	}

	@Override
	public void updateWeChatByUserID(User user) {
		try {
			sqlSessionTemplate.insert(getSqlName(SqlId.SQL_UPDATEWECHAT_BY_USERID), user);
		} catch (Exception e) {
			throw new DaoException(String.format("绑定qq账号出错出错！语句：%s", getSqlName(SqlId.SQL_UPDATEWECHAT_BY_USERID)), e);
		}
	}
}
