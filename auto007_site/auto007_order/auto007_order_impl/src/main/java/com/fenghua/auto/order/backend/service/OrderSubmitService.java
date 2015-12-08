/**
 * 
 */
package com.fenghua.auto.order.backend.service;

import java.util.List;

import com.fenghua.auto.order.backend.domain.ShoppingCart;
import com.fenghua.auto.order.backend.dto.OrderMasterResultDTO;
import com.fenghua.auto.order.backend.dto.OrderMasterSubmitDTO;
import com.fenghua.auto.order.backend.dto.OrderSubmitDTO;

/**
 * Service接口类
 *
 * @author 王直元
 * @createTime 2015-11-25 11:11:35
 *
 */
public interface OrderSubmitService {

	/**
	 * 初始化提交订单
	 * 通过传入的DTO中的选择的商品，进行价格+库存+支付方式+配送等的计算操作，把计算结果返回到DTO中
	 * @param shoppingCarts List<ShoppingCart>
	 * @return OrderSubmitDTO
	 */
	public OrderSubmitDTO initSubmit(List<ShoppingCart> shoppingCarts, Long buyerId);
	
	/**
	 * 提交订单
	 * 对订单的价格进行计算，锁定库存，生成主订单+子订单+支付单；
	 * 返回生成的主订单号、子订单号、支付单号信息，便于提示用户下一步处理
	 * @param submitDTO OrderMasterSubmitDTO
	 * @return List<OrderMasterResultDTO>
	 */
	public List<OrderMasterResultDTO> submit(OrderMasterSubmitDTO submitDTO);
}
