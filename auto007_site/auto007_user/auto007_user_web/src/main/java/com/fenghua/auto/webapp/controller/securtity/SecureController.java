package com.fenghua.auto.webapp.controller.securtity;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fenghua.auto.backend.common.utils.Constants;
import com.fenghua.auto.backend.core.utils.MessageAndErrorUtil;
import com.fenghua.auto.backend.core.utils.UserSecurityUtils;
import com.fenghua.auto.backend.domain.mto.CommonMessageTransferObject;
import com.fenghua.auto.backend.domain.mto.LabelMessage;
import com.fenghua.auto.backend.domain.mto.MessageTransferObject;
import com.fenghua.auto.user.backend.authentication.AuthenticationCodeException;
import com.fenghua.auto.user.backend.domain.User;
import com.fenghua.auto.user.backend.service.AuthService;
import com.fenghua.auto.user.backend.service.UserService;

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
	 private UserService userService;
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
	public void userCenter(HttpServletRequest request) {
		//尝试绑定账号(微信或qq)(如果存在)
		try {
			authService.binding(UserSecurityUtils.getCurrentUser());
		} catch (AuthenticationException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
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
		LabelMessage message = new LabelMessage();
		//forward 从requet取
		Exception e =  (Exception)request.getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
		if(e == null){
			 //非forward 从 seesion取
			 e = (Exception)request.getSession().getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
		}
	
		//用户不存在
	    if(e instanceof UsernameNotFoundException){
			transferObject.addErrors(MessageAndErrorUtil.getError("user.nameOrPassword.error", "username"));
		}
	    //用户名或密码错误
        if(e instanceof BadCredentialsException){
			transferObject.addErrors(MessageAndErrorUtil.getError("user.nameOrPassword.error", "password"));
		}
	    //输入验证码错误
        if(e instanceof AuthenticationCodeException){
			transferObject.addErrors(MessageAndErrorUtil.getError("user.pictureCode.error", "vCode"));
		}  
        Object showVCode =  request.getAttribute("showVCode");
        boolean isShow = showVCode == null? false:(Boolean)showVCode;
        if(isShow){
        	message.setField("showPictureCode");
			transferObject.addMessages(message);
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
	/**
	 * 判断是否应该显示图形验证码 bin.cheng
	 * 
	 * @param name
	 * @param req
	 * @param res
	 */
	@RequestMapping(value = "/showPictureCode", method = RequestMethod.GET)
	public @ResponseBody CommonMessageTransferObject getValidatePic(@RequestParam String username,
			HttpServletRequest req, HttpServletResponse res) {
		CommonMessageTransferObject transferObject = new CommonMessageTransferObject();
		LabelMessage message = new LabelMessage();
		message.setMessage("true");
		if (username == null || username.equals("")) {
			// 获取是否失败三次的session
			Object limitCounts = req.getSession().getAttribute("-t");
			if (limitCounts != null) {
				if ((int) limitCounts >= Constants.LIMITCOUNTS) {
					// 显示图形验证码
					message.setMessage("false");
				}
			}
		} else {
			String regex_tel = "^((13[0-9])|(15[^4,\\D])|(18[0-9]))\\d{8}$";
			String regex_email = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
			String regex_name = "^[a-zA-Z\\u4e00-\\u9fa5][a-zA-Z0-9\\u4e00-\\u9fa5]{3,19}$";
			User user = null;
			// 电话
			if (Pattern.compile(regex_tel).matcher(username).matches()) {
				user = userService.getUserByTelephone(username);
			}
			// 邮箱
			if (Pattern.compile(regex_email).matcher(username).matches()) {
				user = userService.getUserByEmail(username);
			}
			// 用户名
			if (Pattern.compile(regex_name).matcher(username).matches()) {
				user = userService.getUserByName(username);
			}
			if (user != null) {
				if (user.getFailedLoginTimes() != null) {
					if (user.getFailedLoginTimes() >= Constants.LIMITCOUNTS) {
						// 显示图形验证码
						message.setMessage("false");
					}
				}
			}
		}
		transferObject.addMessages(message);
		return transferObject;
	}
}
