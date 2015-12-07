package com.fenghua.auto.user.backend.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.fenghua.auto.backend.dao.BaseDao;
import com.fenghua.auto.user.backend.domain.User;;
/**
 * 用户dao
 * @author chengbin
 * @createtime 2015.11.2
 *
 */
@Repository
public interface UserDao extends BaseDao<User> {
	/**
	 * 通过用户name查询对应数据
	 * @param name
	 * @return
	 */
	public List<User> selectByName(String name);
	/**
	 * 增加用户
	 * @param user
	 */
	public void insert(User user);
	/**
	 * 返回主键id
	 * @param user
	 */
	public Long getPaymentId(User user); 
	/**
	 * 通过用户email查询对应数据
	 * @param email
	 * @return
	 */
	public List<User> selectByEmail(String email); 
	
	/**
	 * 通过用户email查询对应数据
	 * @param email
	 * @return
	 */
	public void updateFailTimes(String name,short count); 
	/**
	 * 通过用户telephone查询对应数据
	 * @param telephone
	 * @return
	 */
	public List<User> selectByTelephone(String telephone); 
	
	public User selectByUserId(Long userId);
	/**
	 * 
	 * @param phone
	 * @param password
	 * @return
	 */
	public Long updatePasswordByPhone(User user); 
	/**
	 * 
	 * @param user
	 * @return
	 */
	public Long updatePasswordByUserId(User user); 

	/**
	 * 
	 * @param accessToken
	 * @return
	 */
	public List<User> getUserByQQ(String accessToken);
	/**
	 * 根据用户id更新其qq账号
	 * @param user
	 */
	public void updateQQNumberByUserID(User user);
	/**
	 * 根据用户微信账号查询用户
	 * @param openid
	 * @return
	 */
	public List<User> getUserByWeChat(String openid);
	/**
	 * 根据用户id更新微信账号
	 * @param user
	 */
	public void updateWeChatByUserID(User user);
}
