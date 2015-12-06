package com.fenghua.auto.user.authentication;

import org.springframework.security.authentication.AccountStatusException;
import org.springframework.security.core.AuthenticationException;

/** 
  *<des>
  *
  * 登录次数限制异常类
  *</des>
  * @author  lijie
  * @date 2015年11月3日
  * @version 
  */
public class AuthenticationLimitException extends AuthenticationException {

	public AuthenticationLimitException(String msg) {
		super(msg);
	}


	public AuthenticationLimitException(String msg, Throwable t) {
		super(msg, t);
	}
}
