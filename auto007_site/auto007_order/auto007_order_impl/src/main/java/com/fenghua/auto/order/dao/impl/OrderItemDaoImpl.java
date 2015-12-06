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
import com.fenghua.auto.backend.domain.user.Company;
import com.fenghua.auto.order.dao.OrderItemDao;
import com.fenghua.auto.order.domain.OrderItem;

/**
 *
 * DAO实现类
 *
 * @author 王直元
 * @createTime 2015-11-25 11:11:35
 *
 */
@Repository
public class OrderItemDaoImpl extends BaseDaoImpl<OrderItem> implements OrderItemDao {

	@Override
	public List<OrderItem> selectByOrderID(Long orderHeaderID) {
		Assert.notNull(orderHeaderID);
		List<OrderItem> orderItems = new ArrayList<OrderItem>();
		try {
			orderItems = sqlSessionTemplate.selectList(getSqlName(SqlId.SQL_SELECT_ORDERITEM_BY_ORDERHEADERID), orderHeaderID);
		} catch (Exception e) {
			throw new DaoException(String.format("根据Fixed查询对象出错！语句：%s", getSqlName(SqlId.SQL_SELECT_ORDERITEM_BY_ORDERHEADERID)), e);
		}
		return orderItems;
	}
}
