package com.fenghua.auto.user.backend.authentication;

import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

/** 
  *<des>
  *</des>
  * @author  lijie
  * @date 2015年11月3日
  * @version 
  */
public class LoginAuthenticationProvider extends DaoAuthenticationProvider {
	  
	  @Override
	  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
	  
		    return super.authenticate(authentication);
		  
	   }
}
