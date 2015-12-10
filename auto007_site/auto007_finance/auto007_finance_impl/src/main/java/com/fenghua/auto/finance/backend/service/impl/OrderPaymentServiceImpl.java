/**
 * 
 */
package com.fenghua.auto.finance.backend.service.impl;

import java.util.Date;

import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fenghua.auto.backend.core.exception.BizException;
import com.fenghua.auto.backend.dao.BaseDao;
import com.fenghua.auto.backend.service.impl.BaseServiceImpl;
import com.fenghua.auto.finance.backend.dao.OrderPaymentDao;
import com.fenghua.auto.finance.backend.domain.OrderPayment;
import com.fenghua.auto.finance.backend.service.OrderPaymentService;
import com.fenghua.auto.finance.wxpay.service.WXPayService;
import com.fenghua.auto.finance.wxpay.service.WXPrepayOrder;
import com.fenghua.auto.order.intf.OrderConstants;
import com.fenghua.auto.order.intf.dto.OrderMasterDTO;
import com.fenghua.auto.order.intf.service.IOrderService;

/**
 * Service实现类
 *
 * @author 王直元
 * @createTime 2015-11-25 11:11:35
 *
 */
@Service
public class OrderPaymentServiceImpl extends BaseServiceImpl<OrderPayment> implements OrderPaymentService {

	@Autowired
	private OrderPaymentDao dao;
	@Autowired
	private IOrderService orderService;
	@Autowired
	private WXPayService wxPayService;
	
	@Override
	protected BaseDao<OrderPayment> getBaseDao() {
		return dao;
	}

	@Override
	@Transactional
	public OrderPayment genOrderPayment(Long buyerId, Long masterOrderId) {
		
		OrderMasterDTO master = orderService.loadOrderMasterDTO(masterOrderId);
		if(master != null && master.getBuyerId().longValue() == buyerId.longValue()
				&& master.getPaymentType().intValue() == OrderConstants.PaymentType.ONLINE_PAY.getValue()) {
			if(master.getStatus().intValue() == OrderConstants.OrderMasterStatus.WAIT_PAY.getValue()) {
				OrderPayment query = new OrderPayment();
				query.setMasterOrderId(master.getId());
				query.setBuyerId(buyerId);
				OrderPayment payment = dao.selectOne(query);
				if(payment != null) {
					if(payment.getPayStatus().intValue() == OrderConstants.PaymentStatus.PAYED.getValue()) {
						throw new BizException("order.payment.has.payed");
					}
				} else {
					payment = new OrderPayment();
					payment.setId(null);
				    payment.setPayNo("P"+DateFormatUtils.format(new Date(), "yyyyMMddHHmmssSSS"));
				    payment.setMasterOrderId(master.getId());
				    payment.setMasterOrderNo(master.getMasterOrderNo());
				    payment.setTradeNo("");
				    payment.setNeedPayAmount(master.getNeedPayAmount());
				    payment.setPayedAmount(null);
				    payment.setRefundAmount(null);
				    payment.setPayStatus(OrderConstants.PaymentStatus.WAITING_PAY.getValue());
				    payment.setPaymentType(master.getPaymentType());
				    payment.setPayMethod(null);
	//			    payment.setAccountType(accountType);
	//			    payment.setAccountName(accountName);
	//			    payment.setBankCode(bankCode);
	//			    payment.setAccountNo(accountNo);
				    payment.setSubmitTime(new Date());
				    payment.setPayedTime(null);
	//			    payment.setpayeeId;
	//			    payment.setpayeeName;
	//			    payment.setpayeeTime;
				    payment.setBuyerId(buyerId);
				    dao.insert(payment);
				}
				return payment;
			} else {
				throw new BizException("order.payment.status.invalid");
			}
		} else {
			throw new BizException("order.payment.parameter.invalid");
		}
	}

	@Override
	public WXPrepayOrder genWxPrepayOrder(Long orderPaymentId) {
		OrderPayment payment = dao.selectById(orderPaymentId);
		if(payment == null) {
			throw new BizException("payment.order.not.exist");
		}
		return null;
	}
	
	
}
