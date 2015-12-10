package com.fenghua.auto.order.backend.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.security.sasl.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fenghua.auto.backend.common.utils.BeanMapper;
import com.fenghua.auto.backend.core.utils.UserSecurityUtils;
import com.fenghua.auto.order.backend.dao.OrderListDAO;
import com.fenghua.auto.order.backend.domain.OrderHeader;
import com.fenghua.auto.order.backend.service.OrderHeaderService;
import com.fenghua.auto.order.backend.service.OrderItemService;
import com.fenghua.auto.order.backend.service.OrderListService;
import com.fenghua.auto.order.backend.service.OrderMasterService;
import com.fenghua.auto.order.backend.service.OrderTransportService;
import com.fenghua.auto.order.backend.util.OrderListQuery;
import com.fenghua.auto.order.backend.vo.OrderHeaderVO;
import com.fenghua.auto.order.backend.vo.OrderMasterVO;
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
	private OrderListDAO orderListDAO;
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
	@Autowired
	private OrderMasterService orderMasterService;
	
	//++++++++++++++++++++++++++++++++++++++++++++++++++
	@Override
	public List<OrderMasterVO> queryOrderMasterVO(OrderListQuery query) {
		List<OrderMasterVO> orderMasterVOs = orderListDAO.query(query);
		return orderMasterVOs;
	}
	//++++++++++++++++++++++++++++++++++++++++++++++++++
	/**
	 * 获取订单VO列表
	 */
	public List<OrderMasterVO> queryOrderMasterVO(OrderHeader query) {
		List<OrderHeaderVO> orderHeaders=null;
		try {
			orderHeaders = queryOrderheaderVO(query);
		} catch (AuthenticationException e) {
			e.printStackTrace();
		}
		
		List<OrderMasterVO> orderMasterVOs=new ArrayList<OrderMasterVO>();
		//将获取的OrderHeaderVO列表按照主单号分组
		if(orderHeaders!=null&&orderHeaders.size()!=0){
			Map<Long, List<OrderHeaderVO>> groupHeaderVO=groupByMasterID(orderHeaders);
			Set<Entry<Long, List<OrderHeaderVO>>> entrySet = groupHeaderVO.entrySet();
			for (Entry<Long, List<OrderHeaderVO>> entry : entrySet) {
				OrderMasterVO oMVO = BeanMapper.map(orderMasterService.selectById(entry.getKey()), OrderMasterVO.class);
				oMVO.setOrderHeaders(entry.getValue());
				orderMasterVOs.add(oMVO);
			}
		}
		return orderMasterVOs;
	}
	/**
	 * 将订单按照主单号分组
	 * @param orderHeaders
	 * @return
	 */
	private Map<Long, List<OrderHeaderVO>> groupByMasterID(List<OrderHeaderVO> orderHeaders) {
		Map<Long, List<OrderHeaderVO>> masterAndOrderHeaders=new HashMap<>();
		List<OrderHeaderVO> headers=null;
		for (OrderHeaderVO orderHeaderVO : orderHeaders) {
			Long masterOrderId = orderHeaderVO.getMasterOrderId();
			//根据当前id获取其OrderHeaderVO列表
			List<OrderHeaderVO> list = masterAndOrderHeaders.get(masterOrderId);
			//如果没有此主单号的订单分组，就创建一个并加入map
			if(list==null){
				headers = new ArrayList<OrderHeaderVO>();
				headers.add(orderHeaderVO);
				masterAndOrderHeaders.put(orderHeaderVO.getMasterOrderId(),headers);
			}else{
				list.add(orderHeaderVO);
			}
		}
		return masterAndOrderHeaders;
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
			orderHeaderVO.setItems(orderItemService.selectByOrderID(header.getId()));
			orderHeaderVOs.add(orderHeaderVO);
		}
		return orderHeaderVOs;
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
}
