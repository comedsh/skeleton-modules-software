package com.fenghua.auto.webapp.controller.order;

import java.util.List;

import javax.security.sasl.AuthenticationException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fenghua.auto.backend.core.utils.LabelErrorTranslator;
import com.fenghua.auto.backend.core.utils.UserSecurityUtils;
import com.fenghua.auto.backend.domain.mto.LabelError;
import com.fenghua.auto.order.backend.OrderMTO;
import com.fenghua.auto.user.intf.dto.PlainInvoiceTitleDTO;
import com.fenghua.auto.user.intf.dto.VatInvoiceCertificateDTO;
import com.fenghua.auto.user.intf.service.IPlainInvoiceTitleService;
import com.fenghua.auto.user.intf.service.IVatInvoiceCertificateService;

/** 
  *<des> 
  * 下单控制器，此控制器将完成 1、下单的普通发票维护和选择，2、增值税发票的选择和收票人维护
  *</des>
  * @author  zhiyuan.wang@auto007.com
  * @date 2015年11月26日
  * @version 1.0
  */
@Controller
@RequestMapping("/order")
public class InvoiceController {
	
	@Autowired
	private IPlainInvoiceTitleService iplainInvoiceTitleService;
	@Autowired
	private IVatInvoiceCertificateService ivatInvoiceCertificateService;
	
	@ResponseBody
	@RequestMapping(value = "/invoice/title", method=RequestMethod.GET)
	public OrderMTO loadInvoiceTitles(Model model) throws AuthenticationException{
		OrderMTO mto = new OrderMTO();
		List<PlainInvoiceTitleDTO> titles = iplainInvoiceTitleService.loadByUserId(UserSecurityUtils.getCurrentUserId());
		mto.setData(titles);
		return mto;
	}
	
	@ResponseBody
	@RequestMapping(value = "/invoice/title", method=RequestMethod.DELETE)
	public OrderMTO deleteInvoiceTitles(Model model, @RequestParam(value="titleId", required=true) Long titleId) throws AuthenticationException{
		OrderMTO mto = new OrderMTO();
		iplainInvoiceTitleService.deleteInvoiceTitle(UserSecurityUtils.getCurrentUserId(), titleId);
		return mto;
	}
	@ResponseBody
	@RequestMapping(value = "/invoice/title", method=RequestMethod.POST)
	public OrderMTO saveInvoiceTitles(Model model, @Valid @RequestBody PlainInvoiceTitleDTO titleDTO, BindingResult result) throws AuthenticationException{
		OrderMTO mto = new OrderMTO();
		
		if(result.hasErrors()) {
			LabelError[] errors = {};
			mto.addErrors( LabelErrorTranslator.translate2LabelError( result.getFieldErrors() ).toArray(errors) );
			return mto;
		}
		titleDTO.setUserId(UserSecurityUtils.getCurrentUserId());
		titleDTO = iplainInvoiceTitleService.saveInvoiceTitle(titleDTO);
		mto.setData(titleDTO);
		return mto;
	}
	@ResponseBody
	@RequestMapping(value = "/invoice/vat", method=RequestMethod.GET)
	public OrderMTO loadAddress(Model model) throws AuthenticationException{
		
		OrderMTO mto = new OrderMTO();
		VatInvoiceCertificateDTO vat = ivatInvoiceCertificateService.loadOneReviewedByUserId(UserSecurityUtils.getCurrentUserId());
		mto.setData(vat);
		return mto;
	}
}
