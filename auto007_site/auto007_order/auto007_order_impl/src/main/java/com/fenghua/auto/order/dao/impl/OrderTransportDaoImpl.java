/**
 * 
 */
package com.fenghua.auto.order.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.fenghua.auto.backend.dao.DaoException;
import com.fenghua.auto.backend.dao.constants.SqlId;
import com.fenghua.auto.backend.dao.impl.BaseDaoImpl;
import com.fenghua.auto.backend.domain.user.PaymentType;
import com.fenghua.auto.order.dao.OrderTransportDao;
import com.fenghua.auto.order.domain.OrderTransport;

/**
 *
 * DAO实现类
 *
 * @author 王直元
 * @createTime 2015-11-25 11:11:35
 *
 */
@Repository
public class OrderTransportDaoImpl extends BaseDaoImpl<OrderTransport> implements OrderTransportDao {

	@Override
	public OrderTransport selectByOrderHeaderId(Long orderHeaderId) {
		Assert.notNull(orderHeaderId);
		OrderTransport orderTransport = null;
		try {
			orderTransport = sqlSessionTemplate.selectOne(getSqlName(SqlId.SQL_SELECT_ORDERTRANSPORT_BY_ORDERHEADERID), orderHeaderId);
		} catch (Exception e) {
			throw new DaoException(String.format("添加对象出错！语句：%s", getSqlName(SqlId.SQL_SELECT_ORDERTRANSPORT_BY_ORDERHEADERID)), e);
		}
		return orderTransport;
	}
}
