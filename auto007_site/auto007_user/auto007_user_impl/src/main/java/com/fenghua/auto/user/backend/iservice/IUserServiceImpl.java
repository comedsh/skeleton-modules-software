package com.fenghua.auto.user.backend.iservice;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fenghua.auto.backend.common.utils.BeanMapper;
import com.fenghua.auto.user.backend.service.UserService;
import com.fenghua.auto.user.intf.dto.UserDTO;

/**
 * 用户接口实现
 * @author chengbin
 * @createTime 2015.11.2
 *
 */
@Service
public class IUserServiceImpl implements com.fenghua.auto.user.intf.service.IUserService {
	
	@Autowired
	private UserService userService;

	@Override
	public UserDTO getUserById(Long id) {
		return BeanMapper.map(userService.getUserById(id), UserDTO.class);
	}

	@Override
	public UserDTO getUserByName(String name) {
		return BeanMapper.map(userService.getUserByName(name), UserDTO.class);
	}

	@Override
	public UserDTO getUserByEmail(String email) {
		return BeanMapper.map(userService.getUserByEmail(email), UserDTO.class);
	}

	@Override
	public UserDTO getUserByUserId(Long userId) {
		return BeanMapper.map(userService.getUserByuserId(userId), UserDTO.class);
	}

	@Override
	public UserDTO getUserByTelephone(String telephone) {
		return BeanMapper.map(userService.getUserByTelephone(telephone), UserDTO.class);
	}

	@Override
	public void autoLogin(String userName, String passWord, HttpServletRequest request) {
		userService.autoLogin(userName, passWord, request);
	}

	@Override
	public UserDTO getUserByQQ(String openID) {
		return BeanMapper.map(userService.getUserByQQ(openID), UserDTO.class);
	}

	@Override
	public UserDTO getUserByWeChat(String openid) {
		return BeanMapper.map(userService.getUserByWeChat(openid), UserDTO.class);
	}
}
