package com.fenghua.auto.order.service;

import java.util.List;

import com.fenghua.auto.order.vo.BuyerOrderHeaderVO;
import com.fenghua.auto.order.vo.BuyerOrderMasterVO;

/**
 * 订单列表服务
 * @author zhangfr
 *
 */
public interface OrderListService {
	/**
	 * 根据用户id获取其订单列表（主单，子单，商品，物流）
	 * @param currentUserId
	 * @return
	 */
	List<BuyerOrderMasterVO> loadByBuyerId(Long currentUserId);
	
	List<BuyerOrderHeaderVO> loadByOrderMasterID(Long orderMasterID);
	/**
	 * 访问此服务需要前台传入如下两个参数
	 * @param orderType 订单类型(1：主订单，
	 * 							 2：订单)
	 * @param orderId 订单id
	 * @return 主订单vo
	 */
	BuyerOrderMasterVO loadByOrderID(Integer orderType, Long orderId);

}
