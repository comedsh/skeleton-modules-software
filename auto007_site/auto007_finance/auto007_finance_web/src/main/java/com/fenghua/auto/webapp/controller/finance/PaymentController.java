package com.fenghua.auto.webapp.controller.finance;

import javax.security.sasl.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fenghua.auto.backend.core.exception.BizException;
import com.fenghua.auto.backend.core.utils.UserSecurityUtils;
import com.fenghua.auto.finance.backend.domain.OrderPayment;
import com.fenghua.auto.finance.backend.service.OrderPaymentService;
import com.fenghua.auto.order.intf.OrderConstants;

/** 
  *<des> 
  * 支付控制器，此控制器将完成 1、根据订单生成支付单；2、转到在线支付页面；3、用户支持操作；4、接收支付回调
  *</des>
  * @author  zhiyuan.wang@auto007.com
  * @date 2015年13月03日
  * @version 1.0
  */
@Controller
@RequestMapping("/finance/payment")
public class PaymentController {
	
	@Autowired
	private OrderPaymentService orderPaymentService;
	
	@RequestMapping(value="/order", method=RequestMethod.PUT)
	public String prePayment(Model model, @RequestParam(value="orderId", required = true) Long orderId) throws AuthenticationException{
		try {
			OrderPayment payment = orderPaymentService.genOrderPayment(UserSecurityUtils.getCurrentUserId(), orderId);
			model.addAttribute("payment", payment);
			model.addAttribute("paymentMethodList", OrderConstants.OnlinePaymentMethod.values());
		} catch (BizException e) {
			model.addAttribute("errorMsg", e.getI18nMessage());
		}
		
		return "web.finance.order.pay";
	}
}
