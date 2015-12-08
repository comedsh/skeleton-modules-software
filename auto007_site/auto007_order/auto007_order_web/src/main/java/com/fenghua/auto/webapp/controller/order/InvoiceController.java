package com.fenghua.auto.webapp.controller.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.fenghua.auto.user.intf.service.IUserAddressService;

/** 
  *<des> 
  * 下单控制器，此控制器将完成 1、下单的普通发票维护和选择，2、增值税发票的选择和收票人维护
  *</des>
  * @author  zhiyuan.wang@auto007.com
  * @date 2015年11月26日
  * @version 1.0
  */
@Controller
//@RequestMapping("/order")
public class InvoiceController {
	
	@Autowired
	private IUserAddressService userAddressService;
//	
//	@ResponseBody
//	@RequestMapping(value = "/address/{id}", method=RequestMethod.GET)
//	public OrderMTO loadAddress(Model model, @PathVariable("id") Long id) throws AuthenticationException{
//		
//		OrderMTO mto = new OrderMTO();
//		UserAddressDTO address = userAddressService.getUserAddressById(id);
//		if(address == null) {
//			mto.addErrorMessage(MessageHelper.getMessage("order.address.notfound.error"));
//		} else {
//			mto.setData(address);
//		}
//		
//		return mto;
//	}
//	
//	@ResponseBody
//	@RequestMapping(value = "/address", method=RequestMethod.POST)
//	public OrderMTO saveAddress(Model model, @Valid @RequestBody UserAddressDTO address, BindingResult result) throws AuthenticationException{
//		OrderMTO mto = new OrderMTO();
//		
//		if(result.hasErrors()) {
//			LabelError[] errors = {};
//			mto.addErrors( LabelErrorTranslator.translate2LabelError( result.getFieldErrors() ).toArray(errors) );
//			return mto;
//		}
//		
//		address.setUserId(UserSecurityUtils.getCurrentUserId());
//		Long id = userAddressService.addAddress(UserSecurityUtils.getCurrentUserId(), address);
//		if(id == null || id == 0) {
//			mto.addErrorMessage(MessageHelper.getMessage("order.address.delete.error"));
//		} else {
//			List<UserAddressDTO> addressList = userAddressService.findByBuyerId(UserSecurityUtils.getCurrentUserId());
//			mto.setData(addressList);
//		}
//		
//		return mto;
//	}
//	
//	@ResponseBody
//	@RequestMapping(value = "/address/delete/{id}", method=RequestMethod.GET)
//	public OrderMTO deleteAddress(Model model, @PathVariable("id") Long id) throws AuthenticationException{
//		OrderMTO mto = new OrderMTO();
//		
//		int row = userAddressService.deleteAddress(UserSecurityUtils.getCurrentUserId(), id);
//		if(row == 0) {
//			mto.addErrorMessage(MessageHelper.getMessage("order.address.delete.error"));
//		} else {
//			List<UserAddressDTO> addressList = userAddressService.findByBuyerId(UserSecurityUtils.getCurrentUserId());
//			mto.setData(addressList);
//		}
//		
//		return mto;
//	}
//	@ResponseBody
//	@RequestMapping(value = "/address/default/{id}", method=RequestMethod.GET)
//	public OrderMTO defaultAddress(Model model, @PathVariable("id") Long id) throws AuthenticationException{
//		OrderMTO mto = new OrderMTO();
//		
//		userAddressService.defaultAddress(UserSecurityUtils.getCurrentUserId(), id);
//		List<UserAddressDTO> addressList = userAddressService.findByBuyerId(UserSecurityUtils.getCurrentUserId());
//		mto.setData(addressList);
//		
//		return mto;
//	}
}
