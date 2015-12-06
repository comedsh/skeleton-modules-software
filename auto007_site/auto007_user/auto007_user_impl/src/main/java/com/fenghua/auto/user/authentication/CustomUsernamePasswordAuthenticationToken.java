package com.fenghua.auto.user.authentication;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

/** 
  *<des>
  *
  *  扩展 UsernamePasswordAuthenticationToken 类，以增加其他验证信息，比如短信验证码，图像验证码等
  *</des>
  * @author  lijie
  * @date 2015年10月26日
  * @version 
  */
public class CustomUsernamePasswordAuthenticationToken extends UsernamePasswordAuthenticationToken{

	public CustomUsernamePasswordAuthenticationToken(Object principal, Object credentials) {
		super(principal, credentials);
	}

}
