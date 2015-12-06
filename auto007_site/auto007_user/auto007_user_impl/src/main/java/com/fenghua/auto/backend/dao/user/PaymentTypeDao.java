package com.fenghua.auto.backend.dao.user;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.fenghua.auto.backend.dao.BaseDao;
import com.fenghua.auto.backend.domain.user.PaymentType;;
/**
 * 支付方式dao
 * @author chengbin
 * @createtime 2015.11.2
 *
 */
@Repository
public interface PaymentTypeDao extends BaseDao<PaymentType> {
	/**
	 * 通过插入支付数据返回主键id
	 * @param payment
	 * @return
	 */
	public Long getPaymentId(PaymentType payment); 
	/**
	 * 通过
	 * @param payment
	 * @return
	 */
	public List<PaymentType> getById(Long id); 
	
	
}
