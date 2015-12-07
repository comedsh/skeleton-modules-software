package com.fenghua.auto.user.backend.authentication;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.fenghua.auto.backend.core.security.UserInfo;
import com.fenghua.auto.backend.service.security.AccountService;
import com.fenghua.auto.user.backend.domain.Role;
import com.fenghua.auto.user.backend.domain.User;
import com.fenghua.auto.user.backend.service.RoleService;
import com.fenghua.auto.user.backend.service.UserService;



/** 
  *<des>
  *</des>
  * @author  lijie
  * @date 2015年10月21日
  * @version 
  */
public class CustomUserDetailService implements UserDetailsService{

	private static final Logger logger = LoggerFactory
			.getLogger(CustomUserDetailService.class);

	@SuppressWarnings("unused")
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.debug("loadUserByUsername(String) - start"); //$NON-NLS-1$  
		
		Collection<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
		//判断用户是用的用户名，电话或者邮箱登录的
		String regex_tel ="^((13[0-9])|(15[^4,\\D])|(18[0-9]))\\d{8}$";
		String regex_email ="^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
		String regex_name ="^[a-zA-Z\\u4e00-\\u9fa5][a-zA-Z0-9\\u4e00-\\u9fa5]{3,19}$";
		User users = null;
		if(Pattern.compile(regex_tel).matcher(username).matches()) {
			users = userService.getUserByTelephone(username);
		}
		if(Pattern.compile(regex_email).matcher(username).matches()) {
			
			users = userService.getUserByEmail(username);
		}
		if(Pattern.compile(regex_name).matcher(username).matches()) {
			
			users = userService.getUserByName(username);
		}
		
		if (users == null) {
			String message = "用户" + username + "不存在";
			logger.error(message);
			throw new UsernameNotFoundException(message);
		} 
		username = users.getName();
		String password =users.getPassword();
		
		// 获得用户的角色
		Long roleId = users.getRoleId();
		Iterator<Role> roles = roleService.getRoleById(roleId).iterator();
		while (roles.hasNext()) {
			Role role = roles.next();		
			SimpleGrantedAuthority grantedAuthorityImpl = new SimpleGrantedAuthority(role.getName());
			logger.debug("用户：[" + users.getName() + "]拥有角色：["+ role.getName() + "],即spring security中的access");
			auths.add(grantedAuthorityImpl);
		}
		UserInfo userInfo = new UserInfo(username, password, auths);
		userInfo.setUserId(users.getId());
		userInfo.setCompanyId(users.getCompanyId());
		logger.debug("loadUserByUsername(String) - end");
		return userInfo;
	}

	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

}
