package com.fenghua.auto.user.backend.service.impl;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Service;

import com.fenghua.auto.backend.common.utils.Constants;
import com.fenghua.auto.user.backend.authentication.CustomUsernamePasswordAuthenticationToken;
import com.fenghua.auto.user.backend.dao.CompanyDao;
import com.fenghua.auto.user.backend.dao.UserDao;
import com.fenghua.auto.user.backend.dao.UserPaymentTypeDao;
import com.fenghua.auto.user.backend.domain.Company;
import com.fenghua.auto.user.backend.domain.PaymentType;
import com.fenghua.auto.user.backend.domain.User;
import com.fenghua.auto.user.backend.domain.UserPaymentType;
import com.fenghua.auto.user.backend.service.UserService;

/**
 * 用户接口实现
 * @author chengbin
 * @createTime 2015.11.2
 *
 */
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private CompanyDao companyDao;
	
	@Autowired
	private UserPaymentTypeDao usercompanyDao;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
    @Qualifier("org.springframework.security.authenticationManager")//编辑软件会提示错误
    private AuthenticationManager authenticationManager;

	@Override
	public void delete(Long id) {
		userDao.deleteById(id);
	}

	@Override
	public void update(User personal) {
		userDao.updateById(personal);
	}
	
	@Override
	public void updateFailTimes(String name,short count) {
		userDao.updateFailTimes(name,count);
	}

	@Override
	public void insert(User personal) {
		
		String passWord = encoder.encode( personal.getPassword());
		personal.setPassword(passWord);
		personal.setRoleId(Constants.ROLE_PERSONAL);
		personal.setAvailable(true);
		personal.setCreatedTs(new Date());
		personal.setLastModifiedTs(new Date());
		userDao.insert(personal);
	}
	@Override
	public void insert(User personal, Company company, PaymentType payment) {
		
		//企业数据
		company.setCreatedTs(new Date());
		company.setLastModifiedTs(new Date());
		Long companyId = companyDao.getCompanyId(company);
		//支付数据
//		String str = payment.getTypename();
//		if(str.equals("0")) {
//			payment.setTypename("月结");
//		} else if(str.equals("1")) {
//			payment.setTypename("季结");
//		}
//		payment.setNeedapprove("Y");
//		payment.setCreatedTs(new Date());
//		Long paymentId = paymentTypeDao.getPaymentId(payment);
		//个人数据
		String passWord = encoder.encode( personal.getPassword());
		personal.setPassword(passWord);
		personal.setCompanyId(companyId);
		personal.setRoleId(Constants.ROLE_COMPANY);
		personal.setAvailable(true);
		personal.setCreatedTs(new Date());
		personal.setLastModifiedTs(new Date());
		Long userId = userDao.getPaymentId(personal);
		//user与支付关系数据
		Long paymentId = Long.parseLong(payment.getTypename());
		UserPaymentType payment_type = new UserPaymentType();
		payment_type.setUserId(userId);
		payment_type.setStatus(0);
		payment_type.setPaymenttypeId(paymentId);
		usercompanyDao.insert(payment_type);
	}

	@Override
	public User getUserById(Long id) {
		return userDao.selectById(id);
	}
	

	@Override
	public Page<User> getAll(User user, PageRequest pageRequest) {
		return userDao.selectPageList(user, pageRequest);
	}

	@Override
	public User getUserByName(String name) {
		List<User> user = userDao.selectByName(name);
		if (user.size() > 0) {
			return user.get(0);
		} else {
			return null;
		}
	}
	
	@Override
	public User getUserByEmail(String email) {
		List<User> user = userDao.selectByEmail(email);
		if (user.size() > 0) {
			return user.get(0);
		} else {
			return null;
		}
	}
	
	@Override
	public User getUserByTelephone(String telephone) {
		List<User> user = userDao.selectByTelephone(telephone);
		if (user.size() > 0) {
			return user.get(0);
		} else {
			return null;
		}
	}
	

	@Override
	public User getUserByQQ(String openID) {
		List<User> user = userDao.getUserByQQ(openID);
		if (user != null&&user.size()==1) {
			return user.get(0);
		} else {
			return null;
		}
	}
	
	@Override
	public void autoLogin(String userName, String passWord,HttpServletRequest request){
		CustomUsernamePasswordAuthenticationToken token = new CustomUsernamePasswordAuthenticationToken(userName, passWord);
		try {
			token.setDetails(new WebAuthenticationDetails(request));
			Authentication authenticatedUser = authenticationManager.authenticate(token);
			SecurityContextHolder.getContext().setAuthentication(authenticatedUser);
			request.getSession().setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,
					SecurityContextHolder.getContext());
		} catch (AuthenticationException e) {
			e.printStackTrace();
		}
	}
	@Override
	public Long updatePasswordByPhone(String pwdNew,String phone) {
		User user=new User();
		String passWord = encoder.encode(pwdNew);
		user.setPassword(passWord);
		user.setMobilephone(phone);
		return userDao.updatePasswordByPhone(user);
	}

	@Override
	public Long updatePasswordByUserId(String pwdNew, Long UserId) {
		User user=new User();
		String passWord = encoder.encode(pwdNew);
		user.setPassword(passWord);
		user.setId(UserId);
		return userDao.updatePasswordByUserId(user);	}

	@Override
	public User getUserByuserId(Long userId) {
		return userDao.selectByUserId(userId);
	}

	@Override
	public void updateQQNumberByUserID(String qqOpenID, Long userId) {
		User user=new User();
		user.setQqNumber(qqOpenID);
		user.setId(userId);
		userDao.updateQQNumberByUserID(user);
	}

	@Override
	public User getUserByWeChat(String openid) {
		List<User> user = userDao.getUserByWeChat(openid);
		if (user != null&&user.size()==1) {
			return user.get(0);
		} else {
			return null;
		}
	}

	@Override
	public void updateWeChatByUserID(String weChatOpenid, Long userId) {
		User user=new User();
		user.setWechat(weChatOpenid);
		user.setId(userId);
		userDao.updateWeChatByUserID(user);
	}
}
