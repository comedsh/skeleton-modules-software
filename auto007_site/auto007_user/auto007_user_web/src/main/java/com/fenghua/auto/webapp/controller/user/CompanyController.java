package com.fenghua.auto.webapp.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fenghua.auto.backend.core.utils.SpringValidationHelper;
import com.fenghua.auto.backend.domain.mto.MessageTransferObject;
import com.fenghua.auto.user.backend.domain.Company;
/**
 * 企业
 * @author chengbin
 *
 */
@Controller
@RequestMapping("/company")
public class CompanyController {
	/**
	 * 校验固定电话是否唯一
	 * shang yang
	 * @param fixed
	 * @return
	 */
	@RequestMapping(value = "/validator/fixed/{fixed}", method = RequestMethod.GET)
	public @ResponseBody MessageTransferObject validateName(@PathVariable("fixed") String contactsPhone ){
		
		return SpringValidationHelper.validate(Company.class, contactsPhone, "contactsPhone");
		
	}
	/**
	 * 验证联系人手机的唯一性
	 * bin.cheng
	 * @param telphone
	 * @return
	 */
	@RequestMapping(value = "/validator/telphone/{telphone}", method = RequestMethod.GET)
	public @ResponseBody MessageTransferObject validatePhone(@PathVariable("telphone") String contactsMobile ){
		
		return SpringValidationHelper.validate(Company.class, contactsMobile, "contactsMobile");
		
	}
	/**
	 * 验证邮箱的唯一性
	 * bin.cheng
	 * @param email
	 * @return
	 */
	@RequestMapping(value = "/validator/email/{email}", method = RequestMethod.GET)
	public @ResponseBody MessageTransferObject validateEmail(@PathVariable("email") String contactsEmail ){
		
		return SpringValidationHelper.validate(Company.class, contactsEmail, "contactsEmail");
	
	}
}
