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
import com.fenghua.auto.backend.domain.user.User;
import com.fenghua.auto.order.dao.OrderHeaderDao;
import com.fenghua.auto.order.domain.OrderHeader;

/**
 *
 * DAO实现类
 *
 * @author 王直元
 * @createTime 2015-11-25 11:11:35
 *
 */
@Repository
public class OrderHeaderDaoImpl extends BaseDaoImpl<OrderHeader> implements OrderHeaderDao {

	@Override
	public List<OrderHeader> selectByOrderMasterID(Long orderMasterID) {
		Assert.notNull(orderMasterID);
		List<OrderHeader> orderHeaders = new ArrayList<OrderHeader>();
		try {
			orderHeaders = sqlSessionTemplate.selectList(getSqlName(SqlId.SQL_SELECT_ORDERHEADERS_BY_ORDERMASTERID), orderMasterID);
		} catch (Exception e) {
			throw new DaoException(String.format("根据Email查询对象出错！语句：%s", getSqlName(SqlId.SQL_SELECT_ORDERHEADERS_BY_ORDERMASTERID)), e);
		}
		return orderHeaders;
	}

}
