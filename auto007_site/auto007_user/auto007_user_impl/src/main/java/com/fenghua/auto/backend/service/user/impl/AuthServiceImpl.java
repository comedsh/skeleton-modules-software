 package com.fenghua.auto.backend.service.user.impl;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fenghua.auto.backend.core.security.UserInfo;
import com.fenghua.auto.backend.core.utills.QQtokenUtils;
import com.fenghua.auto.backend.core.utils.UserSecurityUtils;
import com.fenghua.auto.backend.domain.user.User;
import com.fenghua.auto.backend.service.user.AuthService;
import com.fenghua.auto.backend.service.user.UserService;
import com.qq.connect.QQConnectException;

/**
 * qq登陆验证实现
 * 
 * @author zhangfr
 *
 */
@Service
public class AuthServiceImpl implements AuthService {
	private static final Logger logger = LoggerFactory.getLogger(AuthServiceImpl.class);
	@Autowired
	private UserService userService;

	@Override
	public User hasUser(HttpServletRequest request ) throws QQConnectException {
			String QQtoken=QQtokenUtils.getAccessTokenFromQQ(request);
			if(QQtoken==null){
				throw new QQConnectException("qq绑定异常！");
			}
			String QQopenID=QQtokenUtils.getOpenID(QQtoken);
			request.getSession().setAttribute("QQtoken", QQtoken);
			request.getSession().setAttribute("QQopenID", QQopenID);
			User user = userService.getUserByQQ(QQopenID);
			if(user==null){
				logger.debug("判断是否为qq绑定用户:账户未绑定  --end");
			}
			return user;
		}
	
	@Override
	public void binding(UserInfo userInfo) {
		String QQopenID = (String) UserSecurityUtils.getSession().getAttribute("QQopenID");
		String WeChatOpenid = (String) UserSecurityUtils.getSession().getAttribute("WeChatOpenid");
		if (QQopenID != null) {
			logger.debug("开始绑定qq账户----start");
			userService.updateQQNumberByUserID(QQopenID,userInfo.getUserId());
			UserSecurityUtils.getSession().removeAttribute("QQopenID");
			logger.debug("成功绑定qq账户----end");
		}else if(WeChatOpenid!=null){
			logger.debug("开始绑定WeChat账户----start");
			userService.updateWeChatByUserID(WeChatOpenid,userInfo.getUserId());
			UserSecurityUtils.getSession().removeAttribute("WeChatOpenid");
			logger.debug("成功绑定WeChat账户----end");
		}
	}
	
	/**
	 * 微信AppID
	 */
	private String weixinAppID="wxd5dd582f1865247e";
	/**
	 * 微信AppSecret
	 */
	private String weinxinAppSecret="782aad0425146a81516c297ce87e8217";
	/**
	 * 微信回掉地址
	 */
	private String redirect_uri="http://dev.auto007.com/auth/weixinAafterlogin";
	@Override
	public String getWeiXinURL(HttpServletRequest request) {
		String state = UUID.randomUUID().toString();
		String scope="snsapi_login";
		String weixinURL="https://open.weixin.qq.com/connect/qrconnect?appid="+weixinAppID
				+"&redirect_uri="+redirect_uri
				+"&response_type=code&scope="+scope
				+"&state="+state
				+"#wechat_redirect";
		request.getSession().setAttribute(WEIXIN_STATE, state);
		return weixinURL;
	}

	@Override
	public String getWeiXinOpenIDURL(String code) {
		String WeiXinOpenIDURL="https://api.weixin.qq.com/sns/oauth2/access_token?appid="+weixinAppID
				+"&secret="+weinxinAppSecret
				+"&code="+code
				+"&grant_type=authorization_code";
		return WeiXinOpenIDURL;
	}
}
