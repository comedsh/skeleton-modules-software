package com.fenghua.auto.backend.service.user.impl;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.mail.MessagingException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.fenghua.auto.backend.core.utills.mail.SimpleMailSender;
import com.fenghua.auto.backend.dao.SysConfigDao;
import com.fenghua.auto.backend.dao.user.UserDao;
import com.fenghua.auto.backend.dao.user.UserForgetPassDao;
import com.fenghua.auto.backend.domain.user.ResetPassRequest;
import com.fenghua.auto.backend.domain.core.SysConfig;
import com.fenghua.auto.backend.domain.user.User;
import com.fenghua.auto.backend.service.user.UserForgetPassService;
/**
 * 忘记密码接口实现
 * @author heting
 *
 */
@Service
public class UserForgetPassServiceImpl implements UserForgetPassService {
	private static final Log LOG = LogFactory.getLog(UserForgetPassServiceImpl.class);
	@Autowired
	private UserForgetPassDao userForgetPassDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private BCryptPasswordEncoder encoder;
	@Autowired
	private SysConfigDao configDao;
	@Override
	public void insert(String email) {
		String encodeString=encoder.encode(email+UUID.randomUUID().toString());
		List<User> list=null;
		Long userId=null;
//		Calendar c = Calendar.getInstance();
//		long time = c.getTimeInMillis();
//		String token_exptime=(time+1000*20)+"";//获取超时时间 
		//获取发邮件链接超时间隔时间
		SysConfig config=null;	
		config=configDao.selectByConfigName("email_effetime");
		String effectime=(config==null)?"0":config.getConfigValue();
		int effectimeIn=Integer.parseInt(effectime);
		Timestamp token_exptime = new Timestamp(System.currentTimeMillis() + effectimeIn * 60 * 1000);
		list =userDao.selectByEmail(email);
		//获取用户id
		if(list!=null){
		 userId=list.get(0).getId();
		}
		ResetPassRequest resetPassRequest=new ResetPassRequest();
		resetPassRequest.setUserId(userId);
		resetPassRequest.setCertificateCode(encodeString);
		resetPassRequest.setValidTo(token_exptime);
		//保存找回密码链接信息
		userForgetPassDao.insert(resetPassRequest);
		this.sendResetPasswordEmail(encodeString,email);
		
	}
	/**
	 * 发送邮件
	 * @param mailInfo
	 */
	
	private void sendResetPasswordEmail(String encodeString,String email) {
         String resetPassHref = "http://localhost:8080/user/checkResetLink?token="
                 + encodeString;
		 String emailContent = "请勿回复本邮件.点击下面的链接,重设密码<br/><a href="
                 + resetPassHref + " target='_BLANK'>" + resetPassHref
                 + "</a>";
		try {
			SimpleMailSender.sendHtmlMail(email, "找回您的账户密码", emailContent);
		} catch (MessagingException e) {
			LOG.error("doBasicProfiling Exception:", e);
			e.printStackTrace();
		}
	}
	@Override
	public List<ResetPassRequest> selectByCodeAndUser(String certificateCode) {
		Map<String,Object> map = new HashMap<String,Object>();	
		map.put("certificateCode", certificateCode);
		return userForgetPassDao.selectByCodeAndUser(map);
	}
	@Override
	public void deleteByUserId(Long UserId,String token) {
		Map<String,Object> map = new HashMap<String,Object>();	
		map.put("UserId", UserId);
		map.put("token", token);
		userForgetPassDao.deleteByUserId(map);
	}

}
