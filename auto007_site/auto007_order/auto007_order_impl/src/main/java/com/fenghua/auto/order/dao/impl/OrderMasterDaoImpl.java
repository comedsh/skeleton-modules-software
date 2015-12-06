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
import com.fenghua.auto.order.dao.OrderMasterDao;
import com.fenghua.auto.order.domain.OrderMaster;

/**
 *
 * DAO实现类
 *
 * @author 王直元
 * @createTime 2015-11-25 11:11:35
 *
 */
@Repository
public class OrderMasterDaoImpl extends BaseDaoImpl<OrderMaster> implements OrderMasterDao {

	@Override
	public List<OrderMaster> selectByBuyerID(Long userId) {
		Assert.notNull(userId);
		List<OrderMaster> orderMasters = new ArrayList<OrderMaster>();
		try {
			orderMasters = sqlSessionTemplate.selectList(
					getSqlName(SqlId.SQL_SELECT_MASTERS_BY_BUYERID), userId);
		} catch (Exception e) {
			throw new DaoException(String.format("根据Telephone查询对象出错！语句：%s",
					getSqlName(SqlId.SQL_SELECT_MASTERS_BY_BUYERID)), e);
		}
		return orderMasters;
	}
}
