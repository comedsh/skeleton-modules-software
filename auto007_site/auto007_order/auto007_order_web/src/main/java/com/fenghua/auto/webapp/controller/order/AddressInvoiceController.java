package com.fenghua.auto.webapp.controller.order;

import java.util.List;

import javax.security.sasl.AuthenticationException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fenghua.auto.backend.core.utils.LabelErrorTranslator;
import com.fenghua.auto.backend.core.utills.MessageHelper;
import com.fenghua.auto.backend.core.utils.UserSecurityUtils;
import com.fenghua.auto.backend.domain.mto.LabelError;
import com.fenghua.auto.backend.domain.user.UserAddress;
import com.fenghua.auto.backend.service.user.UserAddressService;
import com.fenghua.auto.order.OrderMTO;

/** 
  *<des> 
  * 下单控制器，次控制器将完成 1、购物车下单；2、产品列表和详情的立即购买下单
  *</des>
  * @author  zhiyuan.wang@auto007.com
  * @date 2015年11月26日
  * @version 1.0
  */
@Controller
@RequestMapping("/shopping")
public class AddressInvoiceController {
	
	@Autowired
	private UserAddressService userAddressService;
	
	@ResponseBody
	@RequestMapping(value = "/address/{id}", method=RequestMethod.GET)
	public OrderMTO loadAddress(Model model, @PathVariable("id") Long id) throws AuthenticationException{
		
		OrderMTO mto = new OrderMTO();
		UserAddress address = userAddressService.selectById(id);
		if(address == null) {
			mto.addErrorMessage(MessageHelper.getMessage("order.address.notfound.error"));
		} else {
			mto.setData(address);
		}
		
		return mto;
	}
	
	@ResponseBody
	@RequestMapping(value = "/address", method=RequestMethod.POST)
	public OrderMTO saveAddress(Model model, @Valid @RequestBody UserAddress address, BindingResult result) throws AuthenticationException{
		OrderMTO mto = new OrderMTO();
		
		if(result.hasErrors()) {
			LabelError[] errors = {};
			mto.addErrors( LabelErrorTranslator.translate2LabelError( result.getFieldErrors() ).toArray(errors) );
			return mto;
		}
		
		address.setUserId(UserSecurityUtils.getCurrentUserId());
		Long id = userAddressService.addAddress(UserSecurityUtils.getCurrentUserId(), address);
		if(id == null || id == 0) {
			mto.addErrorMessage(MessageHelper.getMessage("order.address.delete.error"));
		} else {
			List<UserAddress> addressList = userAddressService.findByBuyerId(UserSecurityUtils.getCurrentUserId());
			mto.setData(addressList);
		}
		
		return mto;
	}
	
	@ResponseBody
	@RequestMapping(value = "/address/delete/{id}", method=RequestMethod.GET)
	public OrderMTO deleteAddress(Model model, @PathVariable("id") Long id) throws AuthenticationException{
		OrderMTO mto = new OrderMTO();
		
		int row = userAddressService.deleteAddress(UserSecurityUtils.getCurrentUserId(), id);
		if(row == 0) {
			mto.addErrorMessage(MessageHelper.getMessage("order.address.delete.error"));
		} else {
			List<UserAddress> addressList = userAddressService.findByBuyerId(UserSecurityUtils.getCurrentUserId());
			mto.setData(addressList);
		}
		
		return mto;
	}
	@ResponseBody
	@RequestMapping(value = "/address/default/{id}", method=RequestMethod.GET)
	public OrderMTO defaultAddress(Model model, @PathVariable("id") Long id) throws AuthenticationException{
		OrderMTO mto = new OrderMTO();
		
		userAddressService.defaultAddress(UserSecurityUtils.getCurrentUserId(), id);
		List<UserAddress> addressList = userAddressService.findByBuyerId(UserSecurityUtils.getCurrentUserId());
		mto.setData(addressList);
		
		return mto;
	}
}
