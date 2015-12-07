package com.fenghua.auto.user.backend.authentication;

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

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public AuthenticationLimitException(String msg) {
		super(msg);
	}


	public AuthenticationLimitException(String msg, Throwable t) {
		super(msg, t);
	}
}
