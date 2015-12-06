package com.fenghua.auto.user.authentication;

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

	public AuthenticationCodeException(String msg) {
		super(msg);
	}


	public AuthenticationCodeException(String msg, Throwable t) {
		super(msg, t);
	}
}
