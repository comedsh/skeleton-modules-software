package com.fenghua.auto.webapp.controller.order;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fenghua.auto.backend.core.utils.MessageHelper;
import com.fenghua.auto.backend.core.utils.UserSecurityUtils;
import com.fenghua.auto.order.backend.OrderMTO;
import com.fenghua.auto.order.backend.domain.OrderHeader;
import com.fenghua.auto.order.backend.service.OrderListService;
import com.fenghua.auto.order.backend.vo.OrderMasterVO;

/**
 * 订单列表控制器
 * 
 * @author zhangfr
 *
 */
@Controller
@RequestMapping("/order")
public class OrderListController {
	@Autowired
	private OrderListService orderListService;
	/**
	 * 买家订单列表页面
	 * @return
	 */
	@RequestMapping("/list")
	public String list(){
		return "web.order.buyerOrder_list";
	}
	/**
	 * ajax请求加载列表数据
	 * @return
	 */
	@RequestMapping("/listData")
	@ResponseBody
	public OrderMTO listData(OrderHeader orderHeader) {
		OrderMTO oderMTO=new OrderMTO();
		try {
			orderHeader.setBuyerId(UserSecurityUtils.getCurrentUserId());
			List<OrderMasterVO> list=null;
			list = orderListService.queryOrderMasterVO(orderHeader);
			oderMTO.setData(list);
		} catch (Exception e) {
			oderMTO.addErrorMessage(MessageHelper.getMessage("loadDataError"));
		}
		return oderMTO;
	}
	
	/**
	 * 买家订单明细页面
	 * 访问此控制器需要前台传入如下两个参数
	 * @param orderType 订单类型(1：主订单，
	 * 							 2：订单)
	 * 			参数由前台传入：约定参数
	 * @param orderId 订单id
	 * @return
	 *//*
	@RequestMapping("/item")
	public ModelAndView item(Integer orderType,Long orderId) {
		ModelAndView mv=new ModelAndView("web.order.buyerOrder_item");
		try {
			BuyerOrderMasterVO buyerOrderMasterVO = orderListService.loadByOrderID(orderType,orderId);
			String json = JSON.toJSONString(buyerOrderMasterVO);
			mv.addObject("buyerOrderMasterVO", json);
		} catch (Exception e) {
		}
		return mv;
	}*/
}
