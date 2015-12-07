package com.fenghua.auto.user.backend.authentication;

import org.springframework.security.authentication.AccountStatusException;

/** 
  *<des>
  *
  * 验证码异常类
  *</des>
  * @author  lijie
  * @date 2015年11月3日
  * @version 
  */
public class AuthenticationCodeException extends AccountStatusException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public AuthenticationCodeException(String msg) {
		super(msg);
	}


	public AuthenticationCodeException(String msg, Throwable t) {
		super(msg, t);
	}
}
