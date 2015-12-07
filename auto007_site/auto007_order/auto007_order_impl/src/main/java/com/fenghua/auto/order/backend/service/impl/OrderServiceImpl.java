package com.fenghua.auto.order.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fenghua.auto.backend.common.utils.BeanMapper;
import com.fenghua.auto.order.backend.domain.OrderMaster;
import com.fenghua.auto.order.backend.service.OrderMasterService;
import com.fenghua.auto.order.intf.dto.OrderMasterDTO;
import com.fenghua.auto.order.intf.service.OrderService;

/**
 * 
 * @author zhiyuan.wang@auto007.com
 *
 */
@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderMasterService orderMasterService;
	
	@Override
	public OrderMasterDTO loadOrderMasterDTO(Long masterId) {
		OrderMaster master = orderMasterService.selectById(masterId);
		return BeanMapper.map(master, OrderMasterDTO.class);
	}

	@Override
	public OrderMasterDTO loadOrderMasterDTO(String masterNo) {
		OrderMaster master = orderMasterService.getByOrderMasterNo(masterNo);
		return BeanMapper.map(master, OrderMasterDTO.class);
	}

}
