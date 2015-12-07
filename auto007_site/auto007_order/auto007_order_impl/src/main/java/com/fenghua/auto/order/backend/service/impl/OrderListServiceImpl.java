package com.fenghua.auto.order.backend.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fenghua.auto.backend.core.utils.MessageHelper;
import com.fenghua.auto.order.backend.domain.OrderHeader;
import com.fenghua.auto.order.backend.domain.OrderItem;
import com.fenghua.auto.order.backend.domain.OrderMaster;
import com.fenghua.auto.order.backend.domain.OrderTransport;
import com.fenghua.auto.order.backend.service.OrderHeaderService;
import com.fenghua.auto.order.backend.service.OrderItemService;
import com.fenghua.auto.order.backend.service.OrderListService;
import com.fenghua.auto.order.backend.service.OrderMasterService;
import com.fenghua.auto.order.backend.service.OrderTransportService;
import com.fenghua.auto.order.backend.vo.BuyerOrderHeaderVO;
import com.fenghua.auto.order.backend.vo.BuyerOrderMasterVO;
import com.fenghua.auto.order.backend.vo.OrderItemVO;
import com.fenghua.auto.sku.intf.dto.SkuDTO;
import com.fenghua.auto.sku.intf.service.SkuService;
import com.fenghua.auto.user.intf.dto.SellerDTO;
import com.fenghua.auto.user.intf.service.SellerService;
import com.fenghua.auto.user.intf.service.UserService;

/**
 * 
 * @author zhangfr
 *
 */
@Service
public class OrderListServiceImpl implements OrderListService {
	@Autowired
	private OrderHeaderService orderHeaderService;
	@Autowired
	private UserService userService;
	@Autowired
	private SellerService sellerService;
	@Autowired
	private OrderTransportService orderTransportService;
	@Autowired
	private OrderItemService orderItemService;
	@Autowired
	private SkuService skuService;
	@Autowired
	private OrderMasterService orderMasterService;

	@Override
	public List<BuyerOrderMasterVO> loadByBuyerId(Long userId) {
		// 创建返回对象
		List<BuyerOrderMasterVO> buyerOrderMasterVOs = new ArrayList<BuyerOrderMasterVO>();
		// 主订单封装对象
		BuyerOrderMasterVO buyerOrderMasterVO;
		// 获取全部主订单
		List<OrderMaster> orderMasters = orderMasterService.selectByBuyerID(userId);
		if (orderMasters==null||orderMasters.size() == 0) {
			return null;
		}
		 //子订单封装对象
		for (OrderMaster orderMaster : orderMasters) {
			//获取所有订单对象
			List<BuyerOrderHeaderVO> BuyerOrderHeaderVOs = loadByOrderMasterID(orderMaster.getId());
			String receiver=BuyerOrderHeaderVOs.get(0).getOrderHeader().getReceiver();
			buyerOrderMasterVO = new BuyerOrderMasterVO(orderMaster,BuyerOrderHeaderVOs,receiver);
			buyerOrderMasterVOs.add(buyerOrderMasterVO);
		}
		return buyerOrderMasterVOs;

	}
	//根据主单号获取其所有的子单
	@Override
	public List<BuyerOrderHeaderVO> loadByOrderMasterID(Long orderMasterID) {
		List<BuyerOrderHeaderVO> buyerOrderHeaderVOs = new ArrayList<BuyerOrderHeaderVO>();
		List<OrderHeader> orderHeaders = orderHeaderService.selectByOrderMasterID(orderMasterID);
		if (orderHeaders == null || orderHeaders.size() == 0) {
			return null;
		}
		for (OrderHeader orderHeader : orderHeaders) {
			BuyerOrderHeaderVO buyerOrderHeaderVO = creatBuyerOrderHeaderVO(orderHeader);
			buyerOrderHeaderVOs.add(buyerOrderHeaderVO);
		}
		return buyerOrderHeaderVOs;
	}
	@Override
	public BuyerOrderMasterVO loadByOrderID(Integer orderType,Long orderId) {
		if((orderType==null||orderId==null)&&(orderType!=1||orderType!=2)){
			throw new RuntimeException(MessageHelper.getMessage("system.erro"));
		}
		BuyerOrderMasterVO buyerOrderMasterVO=null;
		if(orderType==1){
			 buyerOrderMasterVO = getBuyerOrderMasterVOByMasterId(orderId);
		}else if(orderType==2){
			buyerOrderMasterVO = getBuyerOrderMasterVOByHeaderId(orderId);
		}
		return buyerOrderMasterVO;
	}
	/**
	 * 根据orderHeader创建一个BuyerOrderHeaderVO
	 * @param orderHeader
	 * @return
	 */
	private BuyerOrderHeaderVO creatBuyerOrderHeaderVO(OrderHeader orderHeader){
		List<OrderItemVO> orderItemVOs = new ArrayList<OrderItemVO>();
		BuyerOrderHeaderVO buyerOrderHeaderVO;
		OrderItemVO orderItemVO;
		SellerDTO seller = sellerService.getSellerById(orderHeader.getSellerId());
		String sellerName=null;
		if(seller!=null){
			sellerName = seller.getName();
		}
		OrderTransport orderTransport = orderTransportService.selectByOrderHeaderId(orderHeader.getId());
		List<OrderItem> orderItems = orderItemService.selectByOrderID(orderHeader.getId());
		if (orderItems == null || orderItems.size() == 0) {
			//throw new RuntimeException("系统异常！");
		}
		SkuDTO sku;
		String img;
		for (OrderItem orderItem : orderItems) {
			sku = skuService.loadSku(orderItem.getSkuId());
			orderItemVO = new OrderItemVO(orderItem, sku);
			orderItemVOs.add(orderItemVO);
		}
		buyerOrderHeaderVO = new BuyerOrderHeaderVO(orderHeader, sellerName,
				orderTransport, orderItemVOs);
		return buyerOrderHeaderVO;
	}
	/**
	 * 根据子弹获取订单对象（一个主单，一个订单）
	 * @return
	 */
	private BuyerOrderMasterVO getBuyerOrderMasterVOByHeaderId(Long orderId) {
		//获取主单
		OrderMaster orderMaster = orderHeaderService.selectMasterById(orderId);
		//获取订单
		OrderHeader orderHeader = orderHeaderService.selectById(orderId);
		List<BuyerOrderHeaderVO> buyerOrderHeaderVOs=new ArrayList<BuyerOrderHeaderVO>();
		BuyerOrderHeaderVO buyerOrderHeaderVO=creatBuyerOrderHeaderVO(orderHeader);
		buyerOrderHeaderVOs.add(buyerOrderHeaderVO);
		BuyerOrderMasterVO buyerOrderMasterVO = new BuyerOrderMasterVO(orderMaster,buyerOrderHeaderVOs);
		return buyerOrderMasterVO;
	}
	/**
	 * 根据主单获取所有订单对象（一个主单多个订单）
	 * @param orderId
	 * @return
	 */
	private BuyerOrderMasterVO getBuyerOrderMasterVOByMasterId(Long orderId) {
		// 主订单封装对象
		BuyerOrderMasterVO buyerOrderMasterVO;
		// 获取主订单
		OrderMaster orderMaster = orderMasterService.selectById(orderId);
		//获取所有订单对象
		List<BuyerOrderHeaderVO> BuyerOrderHeaderVO = loadByOrderMasterID(orderMaster.getId());
		//将主单和所有子单封装
		buyerOrderMasterVO = new BuyerOrderMasterVO(orderMaster,BuyerOrderHeaderVO);
		return buyerOrderMasterVO;
	}
}
