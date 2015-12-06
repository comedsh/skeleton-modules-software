package com.fenghua.auto.backend.core.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

/** 
  *<des>
  *</des>
  * @author  lijie
  * @date 2015年11月26日
  * @version 
  */
public class UserInfo extends User{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long userId;
	private Long companyId;
	
	
	public UserInfo(String username, String password,Collection<? extends GrantedAuthority> authorities){
		this(username, password, true, true, true, true, authorities);
		
	}
	public UserInfo(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
	}


		public Long getUserId() {
			return userId;
		}

		public void setUserId(Long userId) {
			this.userId = userId;
		}
		public Long getCompanyId() {
			return companyId;
		}
		public void setCompanyId(Long companyId) {
			this.companyId = companyId;
		}
		
		
}
