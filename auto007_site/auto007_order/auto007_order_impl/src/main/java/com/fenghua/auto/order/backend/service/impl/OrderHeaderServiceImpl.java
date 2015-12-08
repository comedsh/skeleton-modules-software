/**
 * 
 */
package com.fenghua.auto.order.backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fenghua.auto.backend.core.utils.MessageHelper;
import com.fenghua.auto.backend.dao.BaseDao;
import com.fenghua.auto.backend.service.impl.BaseServiceImpl;
import com.fenghua.auto.order.backend.dao.OrderHeaderDao;
import com.fenghua.auto.order.backend.domain.OrderHeader;
import com.fenghua.auto.order.backend.domain.OrderMaster;
import com.fenghua.auto.order.backend.service.OrderHeaderService;
import com.fenghua.auto.order.backend.service.OrderMasterService;

/**
 * Service实现类
 *
 * @author 王直元
 * @createTime 2015-11-25 11:11:35
 *
 */
@Service
public class OrderHeaderServiceImpl extends BaseServiceImpl<OrderHeader> implements OrderHeaderService {

	@Autowired
	private OrderHeaderDao dao;
	@Autowired
	private OrderMasterService orderMasterService;
	
	@Override
	protected BaseDao<OrderHeader> getBaseDao() {
		return dao;
	}

	@Override
	public List<OrderHeader> selectByOrderMasterID(Long orderMasterID) {
		List<OrderHeader> orderHeaders = dao.selectByOrderMasterID(orderMasterID);
		return orderHeaders;
	}

	@Override
	public OrderMaster selectMasterById(Long orderId) {
		OrderHeader orderHeader = dao.selectById(orderId);
		if(orderHeader==null){
			throw new RuntimeException(MessageHelper.getMessage("system.erro"));
		}
		Long masterOrderId = orderHeader.getMasterOrderId();
		return orderMasterService.selectById(masterOrderId);
	}

}
