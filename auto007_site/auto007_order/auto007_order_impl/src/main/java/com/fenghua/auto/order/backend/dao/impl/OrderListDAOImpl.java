/**
 * 
 */
package com.fenghua.auto.order.backend.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.fenghua.auto.backend.dao.DaoException;
import com.fenghua.auto.backend.dao.constants.SqlId;
import com.fenghua.auto.backend.dao.impl.BaseDaoImpl;
import com.fenghua.auto.order.backend.dao.OrderHeaderDao;
import com.fenghua.auto.order.backend.dao.OrderListDAO;
import com.fenghua.auto.order.backend.domain.OrderHeader;
import com.fenghua.auto.order.backend.domain.OrderMaster;
import com.fenghua.auto.order.backend.util.OrderListQuery;
import com.fenghua.auto.order.backend.vo.OrderMasterVO;

/**
 *
 * DAO实现类
 *
 * @author zhangfr
 * @createTime 2015-12-09 14:49:35
 *
 */
@Repository
public class OrderListDAOImpl extends BaseDaoImpl<com.fenghua.auto.order.backend.util.OrderListQuery> implements OrderListDAO {
	@Override
	public List<OrderMasterVO> query(OrderListQuery query) {
		Assert.notNull(query);
		List<OrderMasterVO> orderMasters = new ArrayList<OrderMasterVO>();
		try {
			orderMasters = sqlSessionTemplate.selectList(
					getSqlName(SqlId.SQL_SELECT_ORDERLIST), query);
		} catch (Exception e) {
			throw new DaoException(String.format("根据Telephone查询对象出错！语句：%s",
					getSqlName(SqlId.SQL_SELECT_ORDERLIST)), e);
		}
		return orderMasters;
	}
}
