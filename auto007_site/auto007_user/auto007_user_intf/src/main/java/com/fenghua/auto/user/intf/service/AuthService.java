package com.fenghua.auto.user.intf.service;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;
import com.fenghua.auto.backend.core.security.UserInfo;
import com.fenghua.auto.user.intf.dto.UserDTO;
import com.qq.connect.QQConnectException;

/**
 * 第三方登陆验证
 * @author zhangfr
 *
 */
@Service
public interface AuthService {
	/**
	 * 微信安全验证
	 * （使用微信登陆时将存入session中。微信的回掉将会回传，）
	 */
	String WEIXIN_STATE = "state";
	/**
	 * 验证
	 * 返回用户代表此qq账号已经绑定了用户 ，否则返回null
	 * @param request
	 * @param openid 
	 * @return 返回登陆用户
	 */
	UserDTO hasUser(HttpServletRequest request) throws QQConnectException;
	/**
	 * 绑定微信或QQ
	 */
	void binding(UserInfo userInfo);
	/**
	 * 获取微信登陆url并传入state到session中（用于回掉时对比state防止攻击）
	 * @param request
	 * @return
	 */
	String getWeiXinURL(HttpServletRequest request);
	/**
	 * 获取微信openID的请求地址
	 * @param code
	 * @return
	 */
	String getWeiXinOpenIDURL(String code);
}
