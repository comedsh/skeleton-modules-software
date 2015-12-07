package com.fenghua.auto.webapp.controller.securtity;

import java.util.HashMap;
import java.util.Map;

import javax.security.sasl.AuthenticationException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fenghua.auto.backend.core.utils.MessageHelper;
import com.fenghua.auto.backend.core.utils.UserSecurityUtils;
import com.fenghua.auto.backend.domain.mto.CommonMessageTransferObject;
import com.fenghua.auto.backend.domain.mto.LabelError;
import com.fenghua.auto.backend.domain.mto.MessageTransferObject;
import com.fenghua.auto.user.backend.authentication.AuthenticationCodeException;
import com.fenghua.auto.user.backend.service.AuthService;

/** 
  *<des>
  *
  * 控制用户登录
  * 
  *</des>
  * @author  lijie
  * @date 2015年11月4日
  * @version 
  */
@Controller
@RequestMapping("/secure")
public class SecureController {
	private static final Logger logger = LoggerFactory.getLogger(SecureController.class);
	@Autowired
	 private AuthService authService;
	 @Autowired
     @Qualifier("org.springframework.security.authenticationManager")//编辑软件会提示错误
     private static AuthenticationManager authenticationManager;
	
	/** Session失效
	 * @return
	 */
	@RequestMapping(value="/session/invalid",method=RequestMethod.GET)
	public String invalid() {
		logger.debug("会话 超时");
		return "web.login";
	}
	
	@RequestMapping(value = "/login")
	public String login(){
		return "web.login";
	}
	
	/**
	 * @author shang yang
	 * @version 
	 * @createTime: 2015年11月25日 下午10:20:46
	 *
	 */
	@RequestMapping(value = "/registration")
	public String registration(){
		return "register.information";
	}
	
	/** 跳转到注册页面
	 * @return
	 */
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String forwordRegister() {
		return "register.information";
	}
	
	/**
	 * 退出系统
	 * @return
	 */
	@RequestMapping(value="/logout")
	public String logout() {
		return "web.login";
	}
		
	/**
	 * 登录调用接口
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/userCenter")
	@ResponseBody
	public MessageTransferObject userCenter(HttpServletRequest request) {
		CommonMessageTransferObject transferObject = new CommonMessageTransferObject();
		LabelError error = new LabelError();
		String message = MessageHelper.getMessage("user.register.success");
		error.setError(message);
		error.setField("success");
		transferObject.addErrors(error);
		//尝试绑定账号（微信或qq）（如果存在）
		try {
			authService.binding(UserSecurityUtils.getCurrentUser());
		} catch (AuthenticationException e) {
			e.printStackTrace();
		}
		return transferObject;
	}
	
	/**
	 * 登录成功后，跳转到用户中心
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/main")
	public String main(Model model,HttpServletRequest request) {
		return "user.center";
	}
	
	/**
	 * 跳转到登录页面
	 * @param user
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/fowardLogin")
	public ModelAndView showLoginPage(HttpServletRequest req, HttpServletResponse res, Model model) {
		Map<String,String> map = new HashMap<String, String>();
		map.put("userName", req.getParameter("userName"));
		return new ModelAndView("register.success",map);
	}
	
	/**
	 * 登录 失败
	 * @return
	 */
	@RequestMapping(value="/failure",method=RequestMethod.POST)
	@ResponseBody
	public  MessageTransferObject failure(HttpServletRequest request, HttpServletResponse response) {
		CommonMessageTransferObject transferObject = new CommonMessageTransferObject();
		LabelError error = new LabelError();
		//forward 从requet取
		Exception e =  (Exception)request.getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
		if(e == null){
			 //非forward 从 seesion取
			 e = (Exception)request.getSession().getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
		}
	
		//用户不存在
	    if(e instanceof UsernameNotFoundException){
	    	String message = MessageHelper.getMessage("user.name.exist");
			error.setError(message);
			error.setField("userName");
			transferObject.addErrors(error);
	    	
		}
	    //用户名或密码错误
        if(e instanceof BadCredentialsException){
        	String message = MessageHelper.getMessage("user.nameOrPassword.error");
			error.setError(message);
			error.setField("nameOrPassword");
			transferObject.addErrors(error);
		}
	    //输入验证码错误
        if(e instanceof AuthenticationCodeException){
        	String message = MessageHelper.getMessage("user.pictureCode.error");
			error.setError(message);
			error.setField("pictureCode");
			transferObject.addErrors(error);
		}  
        Object showVCode =  request.getAttribute("showVCode");
        boolean isShow = showVCode == null? false:(Boolean)showVCode;
        if(isShow){
        	String message = MessageHelper.getMessage("user.showPicCode.error");
			error.setError(message);
			error.setField("pictureCode");
			transferObject.addErrors(error);
        }  
        return transferObject;
	}
	

	/**
	 * 403
	 * @return
	 */
	@RequestMapping(value="/403",method=RequestMethod.GET)
	public ModelAndView forbidden() {
		return new ModelAndView("",null);
	}
}
