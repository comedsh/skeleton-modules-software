package com.fenghua.auto.webapp.controller.user;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;

import javax.security.sasl.AuthenticationException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.fenghua.auto.backend.common.utils.Constants;
import com.fenghua.auto.backend.common.utils.ValidateTime;
import com.fenghua.auto.backend.common.utils.uploadPicture;
import com.fenghua.auto.backend.common.utils.graphValidate.PictureCheckCode;
import com.fenghua.auto.backend.common.utils.message.SMSMessage;
import com.fenghua.auto.backend.core.utils.MessageAndErrorUtil;
import com.fenghua.auto.backend.core.utils.MessageHelper;
import com.fenghua.auto.backend.core.utils.SpringValidationHelper;
import com.fenghua.auto.backend.core.utils.UserSecurityUtils;
import com.fenghua.auto.backend.domain.mto.CommonMessageTransferObject;
import com.fenghua.auto.backend.domain.mto.LabelMessage;
import com.fenghua.auto.backend.domain.mto.MessageTransferObject;
import com.fenghua.auto.backend.service.SysConfigService;
import com.fenghua.auto.user.backend.domain.Company;
import com.fenghua.auto.user.backend.domain.PaymentType;
import com.fenghua.auto.user.backend.domain.ResetPassRequest;
import com.fenghua.auto.user.backend.domain.User;
import com.fenghua.auto.user.backend.service.AuthService;
import com.fenghua.auto.user.backend.service.CompanyService;
import com.fenghua.auto.user.backend.service.PaymentTypeService;
import com.fenghua.auto.user.backend.service.UserForgetPassService;
import com.fenghua.auto.user.backend.service.UserService;

/**
 * 用户功能模块
 * 
 * @author chengbin
 * @createTime 2015.11.2
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private AuthService authService;

	@Autowired
	private UserService userService;

	@Autowired
	private UserForgetPassService userForgetPassService;

	@Autowired
	private CompanyService companyService;

	@Autowired
	private PaymentTypeService paymentTypeService;

	@Autowired
	private SysConfigService configService;

	/**
	 * 增加一个个人用户注册
	 * @author chengbin 
	 * @return
	 * @createTime 2015.11.4
	 */
	@RequestMapping(value = "/personalRegister", method = RequestMethod.POST)
	public @ResponseBody MessageTransferObject personalRegister(@Validated User user, @RequestParam String telcode,
			@RequestParam String code, HttpServletRequest request, Locale locale) {
		CommonMessageTransferObject transferObject = new CommonMessageTransferObject();
		// 获取session里面的电话验证码
		String validateTel = (String) request.getSession().getAttribute("validateTel");
		// 获取图形验证码
		String verifyCode = (String) request.getSession().getAttribute("rand");
		Long invalidTime = Long.parseLong(configService.selectByConfigName(Constants.PHONECODE_TIME).getConfigValue());
		// 获取当前时间
		Date newTime = new Date();
		// 获取之前获取手机验证码的时间
		Date oldTime = (Date) request.getSession().getAttribute("date");
		// 判断手机验证码是否失效
		if (ValidateTime.validateTimeInvalid(newTime, oldTime, invalidTime)) {
			transferObject.addErrors(MessageAndErrorUtil.getError("user.validate.timeout", "telcode"));
		} else if (validateTel.equals(telcode) && verifyCode.equalsIgnoreCase(code)) {// 如果手机验证码和图片验证码都输入正确
			String userPwd = user.getPassword();
			
			userService.insert(user);
			transferObject.addMessages(MessageAndErrorUtil.getMessage("user.register.success", "success"));
			// 把用户名和密码存入安全的session中
			userService.autoLogin(user.getName(), userPwd, request);
			// 尝试绑定(微信或qq)（如果存在）
			try {
				authService.binding(UserSecurityUtils.getCurrentUser());
			} catch (AuthenticationException e) {
				e.printStackTrace();
			}
		} else {
			if (!validateTel.equals(telcode)) {
				transferObject.addErrors(MessageAndErrorUtil.getError("user.telphone.error", "mobilephone"));
			} else {
				transferObject.addErrors(MessageAndErrorUtil.getError("user.pictureCode.error", "pictureCode"));
			}
		}
		return transferObject;
	}

	/**
	 * 增加一个企业用户注册
	 * @author chengbin 
	 * @return
	 * @createTime 2015.11.4
	 */
	@RequestMapping(value = "/companyRegister", method = RequestMethod.POST)
	public @ResponseBody MessageTransferObject companyRegister(@Validated User user, @Valid Company company,
			@RequestParam String telcode, @RequestParam String code, @Valid PaymentType paymenttype,
			HttpServletRequest request, Locale locale) {
		CommonMessageTransferObject transferObject = new CommonMessageTransferObject();
		// 手机验证码
		String validateTel = (String) request.getSession().getAttribute("validateTel");
		// 图形验证码
		String verifyCode = (String) request.getSession().getAttribute("rand");
		// 营业执照上传路径
		String licence = request.getSession().getAttribute("licence").toString();
		// 纳税人上传路径
		String certificate = request.getSession().getAttribute("certificate").toString();
		// 判断营业执照和纳税人照片是否上传成功
		if (licence != null && !licence.equals("") && certificate != null && !certificate.equals("")) {
			Long invalidTime = Long
					.parseLong(configService.selectByConfigName(Constants.PHONECODE_TIME).getConfigValue());
			Date newTime = new Date();
			Date oldTime = (Date) request.getSession().getAttribute("date");
			if (ValidateTime.validateTimeInvalid(newTime, oldTime, invalidTime)) {
				transferObject.addErrors(MessageAndErrorUtil.getError("user.validate.timeout", "telcode"));
			} else if (validateTel.equals(telcode) && verifyCode.equalsIgnoreCase(code)) {
				String userPwd = user.getPassword();
				company.setBusinessLicence(licence);
				company.setTaxpayerLicence(certificate);
				userService.insert(user, company, paymenttype);
				transferObject.addMessages(MessageAndErrorUtil.getMessage("user.register.success", "success"));
				// 把用户名和密码存入安全的session中
				userService.autoLogin(user.getName(), userPwd, request);
			} else {
				if (!validateTel.equals(telcode)) {
					transferObject.addErrors(MessageAndErrorUtil.getError("user.telphone.error", "contactsMobile"));
				} else {
					transferObject.addErrors(MessageAndErrorUtil.getError("user.pictureCode.error", "pictureCode"));
				}
			}
		} else {
			transferObject.addErrors(MessageAndErrorUtil.getError("user.pictureUpload.error", "pictureUpload"));
		}
		return transferObject;
	}
	/**
	 * 获取所有的用户
	 * @return
	 */
	@RequestMapping(value = "/allUser", method = RequestMethod.GET)
	public ModelAndView getPageList(HttpServletRequest req, Map<String, Object> model) {
		Integer curpage = 0;
		String str = req.getParameter("pageNumber");
		if(str != null) {
			curpage = Integer.parseInt(str)>1 ? Integer.parseInt(str)-1 : 0;
		}
		PageRequest pageRequest = new PageRequest(curpage, Constants.PAGESIZE);
		Page<User> pages = userService.getPageList(new User(), pageRequest);
		model.put("param", pages);
		return new ModelAndView("/NewFile",model);
	}

	/**
	 * 校验用户名是否唯一 
	 * shang yang
	 * @param name
	 * @return
	 */
	@RequestMapping(value = "/validator/username/{value}", method = RequestMethod.GET)
	public @ResponseBody MessageTransferObject validateName(@PathVariable("value") String name) {
		return SpringValidationHelper.validate(User.class, name, "name");
	}

	/**
	 * 验证邮箱的唯一性 bin.cheng
	 * @param email
	 * @return
	 */
	@RequestMapping(value = "/validator/telphone/{value}", method = RequestMethod.GET)
	public @ResponseBody MessageTransferObject validatePhone(@PathVariable("value") String email) {

		return SpringValidationHelper.validate(User.class, email, "email");

	}

	/**
	 * 验证电话号码的唯一性
	 * bin.cheng
	 * @param email
	 * @return
	 */
	@RequestMapping(value = "/validator/email/{value}", method = RequestMethod.GET)
	public @ResponseBody MessageTransferObject validateEmail(@PathVariable("value") String mobilephone) {

		return SpringValidationHelper.validate(User.class, mobilephone, "mobilephone");

	}

	/**
	 * 通过用户名获取对应的信息
	 * bin.cheng
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/buyerInformation", method = RequestMethod.GET)
	public ModelAndView getInformation(Map<String, Object> model) {
		// 获取当前用户的用户名
		String name = UserSecurityUtils.getCurrentUserName();
		User user = userService.getUserByName(name);
		if (user.getRoleId() == Constants.ROLE_PERSONAL) {
			// 个体买家
			model.put("userInformation", user);
		} else if (user.getRoleId() == Constants.ROLE_COMPANY) {
			// 企业买家
			model.put("userInformation", user);
			Company company = companyService.getById(user.getCompanyId());
			model.put("companyInformation", company);
			// 目前前段用的radio 只支持一种支付方式
			List<PaymentType> paymentTypes = paymentTypeService.getById(user.getId());
			model.put("paymentType", paymentTypes);
		}
		return new ModelAndView("personal.information", model);
	}

	/**
	 * 通过name判断是否应该显示图形验证码
	 * bin.cheng 
	 * @param name
	 * @param req
	 * @param res
	 */
	@RequestMapping(value = "/showPictureCode/{name}", method = RequestMethod.GET)
	public @ResponseBody CommonMessageTransferObject getValidatePic(@PathVariable("name") String name,
			HttpServletRequest req, HttpServletResponse res) {
		CommonMessageTransferObject transferObject = new CommonMessageTransferObject();
		LabelMessage message = new LabelMessage();
		message.setMessage("true");
		if (name == null || name.equals("")) {
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
			if (Pattern.compile(regex_tel).matcher(name).matches()) {
				user = userService.getUserByTelephone(name);
			}
			// 邮箱
			if (Pattern.compile(regex_email).matcher(name).matches()) {
				user = userService.getUserByEmail(name);
			}
			// 用户名
			if (Pattern.compile(regex_name).matcher(name).matches()) {
				user = userService.getUserByName(name);
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

	/**
	 * 获取图片验证码
	 * bin.cheng 
	 * @param req
	 * @param res
	 */
	@RequestMapping(value = "/pictureCode", method = RequestMethod.GET)
	public void getPictureCode(HttpServletRequest req, HttpServletResponse res) {
		try {
			PictureCheckCode.validatePicCheck(req, res);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取手机验证码
	 * bin.cheng
	 * @param mobilephone
	 * @param req
	 * @param res
	 */
	@RequestMapping(value = "/telphoneCode/{mobilephone}", method = RequestMethod.GET)
	public @ResponseBody CommonMessageTransferObject getTelphoneCode(@PathVariable("mobilephone") String mobilephone,
			HttpServletRequest req, HttpServletResponse res) {
		CommonMessageTransferObject transferObject = new CommonMessageTransferObject();
		LabelMessage message = new LabelMessage();
		String str = null;
		try {
			str = SMSMessage.send(mobilephone, req, res);
			if (str != null) {
				HttpSession session = req.getSession();
				session.setAttribute("validateTel", str);
				Date date = new Date();
				session.setAttribute("date", date);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		message.setMessage(str);
		message.setField("phoneCode");
		transferObject.addMessages(message);
		return transferObject;
	}

	/**
	 * 通过用户id查找对应的用户注册信息
	 * bin.cheng
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody User getUserById(@PathVariable("id") Long id, Model model) {
		return userService.getUserById(id);
	}

	/**
	 * 找回邮箱或密码跳转页面
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/findPassbyphoneOrEmail", method = RequestMethod.GET)
	public String findPassbyphoneOrEmail(HttpServletRequest request, Model model) {
		return "forgot.findPassbyphoneOrEmail";
	}

	/**
	 * 手机找回密码第一步
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/findPassByPhone", method = RequestMethod.POST)
	public String findPassByPhone(HttpServletRequest request, Model model) {
		String path;
		String message = null;
		String validateTel = (String) request.getSession().getAttribute("validateTel");
		String verifyCode = (String) request.getSession().getAttribute("rand");
		if (new Date().getTime() - ((Date) request.getSession().getAttribute("date")).getTime() > 1000 * 120) {
			message = MessageHelper.getMessage("forgot.verificationexpire");
			path = "forgot.findPassbyphoneOrEmail";
		} else if (validateTel.equals(request.getParameter("iPhone_code"))
				&& verifyCode.equalsIgnoreCase(request.getParameter("code"))) {
			path = "forgot.findPassbyphoneSecond";
			// 把用户名和密码存入安全的session中
		} else {
			if (!validateTel.equals(request.getParameter("iPhone_code"))) {
				message = MessageHelper.getMessage("forgot.phoneError");
				path = "forgot.findPassbyphoneOrEmail";
			} else {
				message = MessageHelper.getMessage("forgot.verificationCodeError");
				path = "forgot.findPassbyphoneOrEmail";
			}
		}
		model.addAttribute("message", message);
		request.getSession().setAttribute("phone", request.getParameter("mobile"));
		return path;
	}

	/**
	 * 根据电话号码跟新密码
	 * 
	 * @param user
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/updatePasswordByPhone", method = RequestMethod.POST)
	public ModelAndView updatePasswordByPhone(HttpServletRequest request, Model model) {
		Map<String, String> model1 = new HashMap<String, String>();
		Long id = null;
		String path = "";
		String phone = (String) request.getSession().getAttribute("phone");
		id = userService.updatePasswordByPhone(request.getParameter("pwd_new"), phone);

		if (request.getParameter("pwd_new_agin").equals(request.getParameter("pwd_new"))) {
			if (id != null && id != 0) {
				//msg.setCode(phone);
				model1.put("message", phone);
				path = "forgot.findPassbyphoneLast";
			} else {
				String message = MessageHelper.getMessage("user.modify.error");
				model1.put("message", message);
				//msg.setMsg(message);
				path = "forgot.findPassbyphoneSecond";
			}
		} else {
			model1.put("message",MessageHelper.getMessage("forgot.passDisagree"));
			path = "forgot.findPassbyphoneSecond";
		}

		//model1.put("message", msg);
		return new ModelAndView(path, model1);
	}

	/**
	 * 根据用户id跟新密码
	 * 
	 * @param user
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/updatePasswordByUserId", method = RequestMethod.POST)
	public ModelAndView updatePasswordByUserId(HttpServletRequest request, Model model) {
		Map<String, String> model1 = new HashMap<String, String>();
		Long id = null;
		String path = "";
		Long userId = (Long) request.getSession().getAttribute("userId");
		User user = null;
		user = userService.getUserByuserId(userId);
		id = userService.updatePasswordByUserId(request.getParameter("email_pwd"), userId);
		if (id != null && id != 0) {
			model1.put("message", user.getEmail());
			path = "forgot.findPassbyEmailLast";
		} else {
			String message = MessageHelper.getMessage("user.modify.error");
			model1.put("message", message);
			path = "forgot.findPassbyEmailThired";
		}
		return new ModelAndView(path, model1);
	}

	/**
	 * 忘记密码 发送邮件链接(邮箱找回密码第一步)
	 * 
	 * @param email
	 * @param phone
	 * @param model
	 */
	@RequestMapping(value = "/forGotPassword", method = RequestMethod.POST)
	public String forGotPassword(HttpServletRequest request, Model model) {
		User user = null;
		user = userService.getUserByEmail(request.getParameter("email"));
		String message = "";
		String path = "";
		if (user == null) {
			message = MessageHelper.getMessage("forgot.noEmail");
			model.addAttribute("message", message);
			model.addAttribute("lab", "email");
			path = "forgot.findPassbyphoneOrEmail";
		} else {
			userForgetPassService.insert(request.getParameter("email"));
			request.getSession().setAttribute("email", request.getParameter("email"));
			path = "forgot.findPassbyEmailSecond";
		}

		return path;
	}

	/**
	 * 查询发送邮件
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/ReSendPass", method = RequestMethod.POST)
	public void ReSendPass(HttpServletRequest request, Model model) {
		String email = (String) request.getSession().getAttribute("email");// session获取email
		userForgetPassService.insert(email);

	}

	/**
	 * 验证找回密码邮箱链接
	 * 
	 * @param spittle
	 * @param result
	 * @param model
	 * @return
	 */
	@SuppressWarnings("unused")
	@RequestMapping(value = "/checkResetLink")
	public ModelAndView checkResetLink(@RequestParam String token, HttpServletRequest request, Model model) {
		List<ResetPassRequest> list = null;
		list = userForgetPassService.selectByCodeAndUser(token);
		Calendar c = Calendar.getInstance();
		// 现在的时间(单位：毫秒)
		long curtime = c.getTimeInMillis();
		Map<String, String> map = new HashMap<String, String>();
		if (list != null && list.size() > 0) {
			ResetPassRequest resetPassRequest = list.get(0);
			request.getSession().setAttribute("userId", resetPassRequest.getUserId());
			Timestamp token_exptime = resetPassRequest.getValidTo();
			if (System.currentTimeMillis() > token_exptime.getTime()) {
				// 激活码过期，先删除该用户记录，然后重新发送邮件
				userForgetPassService.deleteByUserId(resetPassRequest.getUserId(), token);
				return new ModelAndView("/user/forgetPass/findPassFail", map);
			} else {
				userForgetPassService.deleteByUserId(resetPassRequest.getUserId(), token);
				return new ModelAndView("forgot.findPassbyEmailThired", map);
			}
		} else {
			return new ModelAndView("/user/forgetPass/findPassFail", map);
		}

	}

	/**
	 * 营业执照上传 
	 * bin.cheng
	 * @param picture
	 * @param response
	 * @param request
	 */
	@RequestMapping(value = "/upload/businesslicense/{houseMaps}", method = RequestMethod.GET)
	public @ResponseBody MessageTransferObject uploadBusiness(@PathVariable("houseMaps") MultipartFile picture,
			HttpServletResponse response, HttpServletRequest request, Model model) {
		CommonMessageTransferObject mto = new CommonMessageTransferObject();
		LabelMessage message = new LabelMessage();
		String name = "licence";
		response.setContentType("text/html");
		String path = uploadPicture.upload(picture, response, request, name);
		message.setMessage(path);
		message.setField("path");
		mto.addMessages(message);
		return mto;
	}

	/**
	 * 纳税人资格证上传 
	 * bin.cheng
	 * @param picture
	 * @param response
	 * @param request
	 */
	@RequestMapping(value = "/upload/Taxpayer/{houseMapss}", method = RequestMethod.GET)
	public @ResponseBody MessageTransferObject uploadTaxpayer(@PathVariable("houseMapss") MultipartFile picture,
			HttpServletResponse response, HttpServletRequest request, Model model) {
		CommonMessageTransferObject mto = new CommonMessageTransferObject();
		LabelMessage message = new LabelMessage();
		String name = "certificate";
		response.setContentType("text/html");
		String path = uploadPicture.upload(picture, response, request, name);
		message.setMessage(path);
		message.setField("path");
		mto.addMessages(message);
		return mto;
	}
}
