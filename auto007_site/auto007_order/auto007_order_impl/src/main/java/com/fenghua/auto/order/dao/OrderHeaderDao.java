/**
 * 
 */
package com.fenghua.auto.order.dao;

import java.util.List;

import com.fenghua.auto.backend.dao.BaseDao;
import com.fenghua.auto.order.domain.OrderHeader;

/**
 *
 * DAO接口类
 *
 * @author 王直元
 * @createTime 2015-11-25 11:11:35
 *
 */
public interface OrderHeaderDao extends BaseDao<OrderHeader>{
	/**
	 * 根据主订单号查询所有子订单
	 */
	List<OrderHeader> selectByOrderMasterID(Long orderMasterID);
}