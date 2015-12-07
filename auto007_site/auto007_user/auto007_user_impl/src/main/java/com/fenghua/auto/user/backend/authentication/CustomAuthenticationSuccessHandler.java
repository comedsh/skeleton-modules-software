package com.fenghua.auto.user.backend.authentication;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

/** 
  *<des>
  *</des>
  * @author  lijie
  * @date 2015年11月9日
  * @version 
  */
public class CustomAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler{

	protected void handle(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		String targetUrl = determineTargetUrl(request, response,authentication);

		if (response.isCommitted()) {
			logger.debug("Response has already been committed. Unable to redirect to "
					+ targetUrl);
			return;
		}

		getRedirectStrategy().sendRedirect(request, response, targetUrl);
	}
	
	protected String determineTargetUrl(HttpServletRequest request,
			HttpServletResponse response,Authentication authentication) {
		String targetUrl = determineTargetUrl(request, response);
		if(getTargetUrlParameter() !=null){
			return targetUrl;
		}
		//根据认证角色跳转不同界面
		//TODO
		//普通用户
		//企业用户
		//卖家
		//=====
		return targetUrl;
	}

}
