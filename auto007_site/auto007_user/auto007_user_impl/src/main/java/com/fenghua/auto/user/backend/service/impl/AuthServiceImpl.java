package com.fenghua.auto.user.backend.service.impl;

import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fenghua.auto.backend.common.utils.HTTPTools;
import com.fenghua.auto.backend.common.utils.JsonTools;
import com.fenghua.auto.backend.common.utils.QQtokenUtils;
import com.fenghua.auto.backend.core.security.UserInfo;
import com.fenghua.auto.backend.core.utils.UserSecurityUtils;
import com.fenghua.auto.user.backend.domain.User;
import com.fenghua.auto.user.backend.service.AuthService;
import com.fenghua.auto.user.backend.service.UserService;
import com.qq.connect.QQConnectException;

/**
 * 
 * @author zhangfr
 *
 */
@Service
public class AuthServiceImpl implements AuthService {
	private static final Logger logger = LoggerFactory
			.getLogger(AuthServiceImpl.class);
	private static final String String = null;
	@Autowired
	private UserService userService;

	@Override
	public User hasUser(HttpServletRequest request) throws QQConnectException {
		String QQtoken = QQtokenUtils.getAccessTokenFromQQ(request);
		if (QQtoken == null) {
			throw new QQConnectException("qq绑定异常！");
		}
		String QQopenID = QQtokenUtils.getOpenID(QQtoken);
		request.getSession().setAttribute("QQtoken", QQtoken);
		request.getSession().setAttribute("QQopenID", QQopenID);
		User user = userService.getUserByQQ(QQopenID);
		if (user == null) {
			logger.debug("判断是否为qq绑定用户:账户未绑定  --end");
		}
		return user;
	}

	@Override
	public void binding(UserInfo userInfo) {
		String QQopenID = (String) UserSecurityUtils.getSession().getAttribute(
				"QQopenID");
		String WeChatOpenid = (String) UserSecurityUtils.getSession()
				.getAttribute("WeChatOpenid");
		if (QQopenID != null) {
			logger.debug("开始绑定qq账户----start");
			userService.updateQQNumberByUserID(QQopenID, userInfo.getUserId());
			UserSecurityUtils.getSession().removeAttribute("QQopenID");
			logger.debug("成功绑定qq账户----end");
		} else if (WeChatOpenid != null) {
			logger.debug("开始绑定WeChat账户----start");
			userService.updateWeChatByUserID(WeChatOpenid, userInfo.getUserId());
			UserSecurityUtils.getSession().removeAttribute("WeChatOpenid");
			logger.debug("成功绑定WeChat账户----end");
		}
	}

	/**
	 * 微信AppID
	 */
	private String weixinAppID = "wxd5dd582f1865247e";
	/**
	 * 微信AppSecret
	 */
	private String weinxinAppSecret = "782aad0425146a81516c297ce87e8217";
	/**
	 * 微信回掉地址
	 */
	private String redirect_uri = "http://dev.auto007.com/auth/weixinAafterlogin";

	@Override
	public String getWeiXinURL(HttpServletRequest request) {
		String state = UUID.randomUUID().toString();
		String scope = "snsapi_login";
		String weixinURL = "https://open.weixin.qq.com/connect/qrconnect?appid="
				+ weixinAppID
				+ "&redirect_uri="
				+ redirect_uri
				+ "&response_type=code&scope="
				+ scope
				+ "&state="
				+ state
				+ "#wechat_redirect";
		request.getSession().setAttribute(WEIXIN_STATE, state);
		return weixinURL;
	}

	private String getWeiXinOpenIDURL(String code) {
		String WeiXinOpenIDURL = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="
				+ weixinAppID
				+ "&secret="
				+ weinxinAppSecret
				+ "&code="
				+ code
				+ "&grant_type=authorization_code";
		return WeiXinOpenIDURL;
	}

	/*
	 * access_token 	接口调用凭证
	 *  expires_in 		access_token接口调用凭证超时时间，单位（秒） 
	 *  refresh_token	用户刷新access_token 
	 *  openid 			授权用户唯一标识 
	 *  scope 			用户授权的作用域，使用逗号（,）分隔 
	 *  unionid			只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。
	 */
	@Override
	public String addWeiXinOpenIDToSession(HttpServletRequest request,String code) {
		String openid = null;
		// 获取token openId.....
		String result = HTTPTools.doPost(getWeiXinOpenIDURL(code));
		Map mapFromJsonObjStr = JsonTools.getMapFromJsonObjStr(result);
		try {
			openid = (String) mapFromJsonObjStr.get("openid");
		} catch (Exception e) {
			logger.debug("获取微信Opein异常 :"+mapFromJsonObjStr.get("openid"));
			return null;
		}
		logger.debug("获取微信Opein :"+openid);
		request.getSession().setAttribute("WeChatOpenid", openid);
		return openid;
	}
}
