package com.fenghua.auto.user.authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.util.StringUtils;

import com.fenghua.auto.backend.domain.user.User;
import com.fenghua.auto.backend.service.user.UserService;


/** 
  *<des>
  *
  * 扩展用户名密码认证过滤器
  *  重写 attemptAuthentication 方法,对一些额外信息进行验证
  *  
  * 
  *</des>
  *
  * @author  lijie
  * @date 2015年10月21日
  * @version 
  */
public class CustomUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter{
	
	@Autowired
	UserService service;

	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			 throws AuthenticationException{
		
		
		if (!request.getMethod().equals("POST")) {
			throw new AuthenticationServiceException(
					"Authentication method not supported: " + request.getMethod());
		}
		
	
		checkValidateCode(request);
		
		String username = obtainUsername(request);
		String password = obtainPassword(request);

		if (username == null) {
			username = "";
		}

		if (password == null) {
			password = "";
		}

		username = username.trim();

		
		CustomUsernamePasswordAuthenticationToken authRequest = new CustomUsernamePasswordAuthenticationToken(username, password);

		// Allow subclasses to set the "details" property
		setDetails(request, authRequest);

		try{
			
			Authentication authentication = this.getAuthenticationManager().authenticate(authRequest);	
			removeInputVCode(request,username);
			return authentication;
		}catch(AuthenticationException e){
			checkLimitLogin(request,e,username);
			throw e;
		}
    }
	
	
	/**
	 * 检查验证码
	 */
	private void checkValidateCode(HttpServletRequest request) throws AuthenticationException{
		String vCode = request.getParameter("vCode");
		if(StringUtils.isEmpty(vCode))
			return;
		//验证验证码 AuthenticationCodeException
		//比对保存在session中的验证码
		String verifyCode = (String) request.getSession().getAttribute("rand");
		if(!vCode.equals(verifyCode)){
			throw new AuthenticationCodeException("invalid code");
		}
		   
	}
	
	/**
	 * 检查用户登录次数
	 */
	private void checkLimitLogin(HttpServletRequest request,AuthenticationException e,String name) throws AuthenticationException{
		//用户名存在，更新入库
		User user = service.getUserByName(name);
		int count = 0;
		if(user!= null) {
			if(user.getFailedLoginTimes() != null) {
				count = user.getFailedLoginTimes();
			}
			service.updateFailTimes(name,(short)(count+1));
			if(count > 1) {
				request.setAttribute("showVCode", true);
			}
		} else {
			//用户名不存在，应该用session来存失败次数
			HttpSession s = request.getSession(true);
			if(s == null)
				return;
			//以用户名作为键
			Object limitCounts = s.getAttribute("-t");
			if(limitCounts == null){
				limitCounts = 0;
			}
			count = (int)limitCounts+1;
			s.setAttribute("-t", count);
			if(count > 2){
				//throw new AuthenticationLimitException("locked account");
				request.setAttribute("showVCode", true);
			}
		}
	}
	
	private void removeInputVCode(HttpServletRequest request,String name){
		request.removeAttribute("showVCode");
		User user = service.getUserByName(name);
		if(user!=null) {
			if(user.getFailedLoginTimes() != null) {
				service.updateFailTimes(name,(short)(0));
			}
		} 
		request.getSession().removeAttribute("-t");
	}
}
