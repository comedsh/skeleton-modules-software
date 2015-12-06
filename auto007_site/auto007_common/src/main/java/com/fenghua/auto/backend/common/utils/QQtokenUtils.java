package com.fenghua.auto.backend.common.utils;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qq.connect.QQConnectException;
import com.qq.connect.api.OpenID;
import com.qq.connect.api.qzone.UserInfo;
import com.qq.connect.javabeans.AccessToken;
import com.qq.connect.javabeans.qzone.UserInfoBean;
import com.qq.connect.oauth.Oauth;

/**
 * qq 令牌工具类
 * @author zhangfr
 *
 */
public class QQtokenUtils {
	private static final Logger logger = LoggerFactory.getLogger(QQtokenUtils.class);
	/**
	 * 获取qqOpenID
	 * @return
	 */
	public static String getOpenID(String token){
		OpenID openIDObj = new OpenID(token);
		String openID=null;
		try {
			openID = openIDObj.getUserOpenID();
		} catch (QQConnectException e) {
			logger.debug("获取Openid失败");
			e.printStackTrace();
		}
		return openID;
	}
	/**
	 * 获取qq AccessToken
	 * 从qq服务器传回
	 * @param request
	 * @return
	 */
	public static String getAccessTokenFromQQ(HttpServletRequest request) {
		String accessToken = null;
		try {
			AccessToken accessTokenObj = (new Oauth()).getAccessTokenByRequest(request);
			accessToken = accessTokenObj.getAccessToken();
			if (accessTokenObj.getAccessToken().equals("")) {
				logger.debug("没有获取到响应参数---QQ服务器错误");
				accessToken=null;
			}
		} catch (QQConnectException e) {
			logger.debug("获取AccessToken失败!");
			e.printStackTrace();
		}
		return accessToken;
	}
	/**
	 * 获取当前用户
	 * @param request
	 * @return
	 */
	private  UserInfoBean getLoginUser(String token,String openID){
		UserInfo qzoneUserInfo = new UserInfo(token,openID);
		UserInfoBean userInfoBean=null;
		try {
			userInfoBean = qzoneUserInfo.getUserInfo();
		} catch (QQConnectException e) {
			logger.debug("获取qqUserLogin失败!");
			e.printStackTrace();
		}
		return userInfoBean;
	}
}
