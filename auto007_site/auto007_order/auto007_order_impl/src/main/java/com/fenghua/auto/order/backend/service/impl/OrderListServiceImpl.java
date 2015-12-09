package com.fenghua.auto.order.backend.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.security.sasl.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fenghua.auto.backend.common.utils.BeanMapper;
import com.fenghua.auto.backend.core.utils.UserSecurityUtils;
import com.fenghua.auto.order.backend.dao.OrderHeaderDao;
import com.fenghua.auto.order.backend.domain.OrderHeader;
import com.fenghua.auto.order.backend.domain.OrderItem;
import com.fenghua.auto.order.backend.domain.OrderTransport;
import com.fenghua.auto.order.backend.service.OrderHeaderService;
import com.fenghua.auto.order.backend.service.OrderItemService;
import com.fenghua.auto.order.backend.service.OrderListService;
import com.fenghua.auto.order.backend.service.OrderTransportService;
import com.fenghua.auto.order.backend.vo.OrderHeaderVO;
import com.fenghua.auto.order.backend.vo.OrderItemVO;
import com.fenghua.auto.order.backend.vo.OrderMasterVO;
import com.fenghua.auto.user.intf.dto.RoleDTO;
import com.fenghua.auto.user.intf.dto.SellerDTO;
import com.fenghua.auto.user.intf.dto.UserDTO;
import com.fenghua.auto.user.intf.service.ISellerService;
import com.fenghua.auto.user.intf.service.IUserService;

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
	private OrderItemService orderItemService;
	@Autowired
	private IUserService userService;
	@Autowired
	private ISellerService sellerSevice;
	@Autowired
	private OrderTransportService orderTransportService;
	
	@Override
	public List<OrderMasterVO> queryOrderMasterVO(OrderHeader query) {
		try {
			List<OrderHeaderVO> orderHeaders = queryOrderheaderVO(query);
		} catch (AuthenticationException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 根据OrderHeader查询对象获取子订单VO
	 * @param orderHeader
	 * @return
	 * @throws AuthenticationException
	 */
	private List<OrderHeaderVO> queryOrderheaderVO(OrderHeader query) throws AuthenticationException{
		List<OrderHeader> orderHeaders= orderHeaderService.selectList(query);
		if(orderHeaders==null||orderHeaders.size()==0){
			return null;
		}
		List<OrderHeaderVO> orderHeaderVOs= new ArrayList<OrderHeaderVO>();
		//当前用户
		UserDTO currentUser = userService.getUserByUserId(UserSecurityUtils.getCurrentUserId());
		
		for (OrderHeader header : orderHeaders) {
			OrderHeaderVO orderHeaderVO = BeanMapper.map(header, OrderHeaderVO.class);
			orderHeaderVO.setBuyer(getBuyer(header, currentUser));
			orderHeaderVO.setSellerDTO(getSeller(orderHeaderVO,currentUser));
			orderHeaderVO.setOrderTransport(orderTransportService.selectByOrderHeaderId(header.getId()));
			orderHeaderVO.setOrderItemVOs(queryOrderItemVO(header.getId()));
			orderHeaderVOs.add(orderHeaderVO);
		}
		return orderHeaderVOs;
	}
	/**
	 * 根据订单id查询订单明细VO
	 * @param id
	 * @return
	 */
	private List<OrderItemVO> queryOrderItemVO(Long headerId) {
		List<OrderItem> orderItems =orderItemService.selectByOrderID(headerId);
		if(orderItems==null||orderItems.size()==0){
			return null;
		}
		//返回对象
		List<OrderItemVO> orderItemVOs =null;
		
		return null;
	}
	/**
	 * 获取订单的卖家信息
	 * 只有买家和平台管理员需要 （考虑到性能优化）
	 * @param orderHeaderVO
	 * @param currentUser
	 * @return
	 */
	private SellerDTO getSeller(OrderHeaderVO orderHeaderVO,UserDTO currentUser) {
		Long roleId = currentUser.getRoleId();
		if(roleId==1||roleId==2||roleId==4){
			return sellerSevice.getSellerById(currentUser.getSellerId());
		}
		return null;
	}
	/**
	 * 获取订单的买家信息
	 * 只有卖家和平台管理员需要的订单列表才需要
	 * @param header
	 * @param currentUser
	 * @return
	 * @throws AuthenticationException
	 */
	private UserDTO getBuyer(OrderHeader header,UserDTO currentUser ) throws AuthenticationException{
		Long roleId = currentUser.getRoleId();
		if(roleId==3||roleId==4){
			return userService.getUserById(header.getBuyerId());
		}
		return null;
	}
	
	
	
	
	/*@Override
	public List<BuyerOrderMasterVO> loadByBuyerId(Long userId,OrderHeader orderHeader) {
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
	*//**
	 * 根据orderHeader创建一个BuyerOrderHeaderVO
	 * @param orderHeader
	 * @return
	 *//*
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
	*//**
	 * 根据子弹获取订单对象（一个主单，一个订单）
	 * @return
	 *//*
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
	*//**
	 * 根据主单获取所有订单对象（一个主单多个订单）
	 * @param orderId
	 * @return
	 *//*
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
	}*/
}
