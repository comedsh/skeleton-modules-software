/**
 * 
 */
package com.fenghua.auto.finance.service;

import com.fenghua.auto.backend.service.BaseService;
import com.fenghua.auto.finance.domain.OrderPayment;

/**
 * Service接口类
 *
 * @author 王直元
 * @createTime 2015-11-25 11:10:42
 *
 */
public interface OrderPaymentService extends BaseService<OrderPayment> {

	public OrderPayment genOrderPayment(Long buyerId, Long masterOrderId);
}
