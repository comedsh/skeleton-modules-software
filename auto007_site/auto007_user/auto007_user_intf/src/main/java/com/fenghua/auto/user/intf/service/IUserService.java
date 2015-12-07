package com.fenghua.auto.user.intf.service;

import javax.servlet.http.HttpServletRequest;

import com.fenghua.auto.user.intf.dto.UserDTO;
/**
 * 个人注册service
 * 
 * @author chengbin
 * @createTime 2015.11.2
 *
 */
public interface IUserService {
	/**
	 * 通过id获取用户
	 * @param id
	 * @return
	 */
	public UserDTO getUserById(Long id);
	/**
	 * 通过name查询用户
	 * @return
	 */
	public UserDTO getUserByName(String name);
	/**
	 * 通过email查询用户
	 * @return
	 */
	public UserDTO getUserByEmail(String email);
	/**
	 * 根据用户id查询用户相信信息
	 * @param userId
	 * @return
	 */
	public UserDTO getUserByUserId(Long userId);
	/**
	 * 通过telephone查询用户
	 * @return
	 */
	public UserDTO getUserByTelephone(String telephone);

	/**
	 * 自动登录，把用户名和密码写入security session中
	 * @param userName
	 * @param passWord
	 * @param locale
	 * @param request
	 */
	public void autoLogin(String userName, String passWord, HttpServletRequest request);

	/**
	 * 根据qq openID查询用户
	 * @param openID
	 * @return
	 */
	public UserDTO getUserByQQ(String openID);
	/**
	 * 根据微信号 openID查询用户
	 * @param openid
	 * @return
	 */
	public UserDTO getUserByWeChat(String openid);
}
