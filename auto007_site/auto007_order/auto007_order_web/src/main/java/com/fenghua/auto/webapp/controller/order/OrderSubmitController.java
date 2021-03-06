package com.fenghua.auto.webapp.controller.order;

import java.util.ArrayList;
import java.util.List;

import javax.security.sasl.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.fenghua.auto.backend.core.utils.MessageHelper;
import com.fenghua.auto.backend.core.utils.UserSecurityUtils;
import com.fenghua.auto.backend.domain.mto.LabelError;
import com.fenghua.auto.order.backend.OrderMTO;
import com.fenghua.auto.order.backend.domain.ShoppingCart;
import com.fenghua.auto.order.backend.dto.OrderMasterResultDTO;
import com.fenghua.auto.order.backend.dto.OrderMasterSubmitDTO;
import com.fenghua.auto.order.backend.dto.OrderSubmitDTO;
import com.fenghua.auto.order.backend.qo.ShoppingCartQO;
import com.fenghua.auto.order.backend.service.OrderSubmitService;
import com.fenghua.auto.order.backend.service.ShoppingCartService;
import com.fenghua.auto.sku.intf.dto.SkuDTO;
import com.fenghua.auto.sku.intf.service.ISkuService;

/** 
  *<des> 
  * 下单控制器，次控制器将完成 1、购物车下单；2、产品列表和详情的立即购买下单
  *</des>
  * @author  zhiyuan.wang@auto007.com
  * @date 2015年11月26日
  * @version 1.0
  */
@Controller
@RequestMapping("/order")
public class OrderSubmitController {
	
	@Autowired
	private OrderSubmitService orderSubmitService;
	@Autowired
	private ISkuService skuService;
	@Autowired
	private ShoppingCartService shoppingCartService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String initSubmitG(Model model,
			@RequestParam(value="pid", required = false) Long skuid,
			@RequestParam(value="num", required = false) Integer qty) throws AuthenticationException{
		List<ShoppingCart> shoppingCarts = null;
		
		if(skuid != null && skuid > 0 && qty != null && qty > 0) {
			SkuDTO sku = skuService.loadSku(skuid);
			if(sku != null) {
				shoppingCarts = new ArrayList<ShoppingCart>();
				ShoppingCart cart = new ShoppingCart();
				cart.setSkuId(skuid);
				cart.setQty(qty);
				cart.setCurrentPrice(sku.getSalePrice());
				cart.setOriginalPrice(sku.getPrice());
				cart.setSalePrice(sku.getSalePrice());
				cart.setSellerId(sku.getSellerId());
				shoppingCarts.add(cart);
			}
		}
		return initSubmit(model, shoppingCarts);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String initSubmitP(Model model,
			@RequestParam(value="sids", required = false) Long[] sids) throws AuthenticationException{
		List<ShoppingCart> shoppingCarts = null;
		
		if(sids != null && sids.length > 0) {
			ShoppingCartQO qo = new ShoppingCartQO();
			qo.setIds(sids);
			shoppingCarts = shoppingCartService.selectList(qo);
		}
		return initSubmit(model, shoppingCarts);
	}
	
	private String initSubmit(Model model, List<ShoppingCart> shoppingCarts) throws AuthenticationException {
		if(shoppingCarts == null || shoppingCarts.isEmpty()) {
			model.addAttribute("errorMsg", MessageHelper.getMessage("order.submit.parameter.error"));
			return "web.order.submit";	
		}
		
		OrderSubmitDTO dto = orderSubmitService.initSubmit(shoppingCarts, UserSecurityUtils.getCurrentUserId());
		OrderMTO mto = new OrderMTO();
		mto.setData(dto);
		String json = JSON.toJSONString(mto);
		model.addAttribute("orderSubmitDTOJson",json);
		return "web.order.submit";
	}
	
	@ResponseBody
	@RequestMapping(value="/submit", method=RequestMethod.POST)
	public OrderMTO submit(Model model, @RequestBody OrderMasterSubmitDTO dto) throws AuthenticationException{
		OrderMTO mto = new OrderMTO();
		dto.setUserId(UserSecurityUtils.getCurrentUserId());
		dto.setBuyerId(UserSecurityUtils.getCurrentUserId());
		List<LabelError> errors = dto.valid();
		if(errors != null && !errors.isEmpty()) {
			mto.addErrors(errors.toArray(new LabelError[errors.size()]));
		} else {
			List<OrderMasterResultDTO> resultDTOs = orderSubmitService.submit(dto);
			mto.setData(resultDTOs);
		}
		return mto;
	}
}
