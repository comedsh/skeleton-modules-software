package com.fenghua.auto.backend.core.security;

import java.util.Collection;
import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;


/** 
  *<des>
  *
  * 资源访问决策器
  * 
  *   判断用户是否具有访问某种资源的权限
  *   
  *</des>
  * @author  lijie
  * @date 2015年10月21日
  * @version 
  */
public class CustomAccessDecisionManager implements AccessDecisionManager {
	private static final Logger logger = LoggerFactory.getLogger(CustomAccessDecisionManager.class);

	
	@Override
	public void decide(Authentication authentication, Object object,
			Collection<ConfigAttribute> configAttributes)
			throws AccessDeniedException, InsufficientAuthenticationException {
   
		logger.debug("decide start"); //$NON-NLS-1$  

		if (configAttributes == null) {
			logger.debug("decide end"); //$NON-NLS-1$  
			throw new AccessDeniedException("没有权限");
		}

		logger.debug("正在访问的url是：" + object.toString());
		

		Iterator<ConfigAttribute> ite = configAttributes.iterator();
		while (ite.hasNext()) {
			ConfigAttribute ca = ite.next();
			logger.debug("needRole is：" + ca.getAttribute());
			String needRole = ((SecurityConfig) ca).getAttribute();
			for (GrantedAuthority ga : authentication.getAuthorities()) {
				logger.debug("\t授权信息是：" + ga.getAuthority());
				if (needRole.equals(ga.getAuthority())) { // ga is user's role.
					logger.debug("判断到，needRole 是" + needRole + ",用户的角色是:"+ ga.getAuthority() + "，授权数据相匹配");
					logger.debug("decide(Authentication, Object, Collection<ConfigAttribute>) - end"); //$NON-NLS-1$  

					return;
				}
			}
		}
		throw new AccessDeniedException("没有权限");
	}

	@Override
	public boolean supports(ConfigAttribute arg0) {
		
		return true;
	}

	@Override
	public boolean supports(Class<?> arg0) {
		return true;
	}

}