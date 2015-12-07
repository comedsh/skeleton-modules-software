/**
 * 
 */
package com.fenghua.auto.order.backend.dao;

import java.util.List;

import com.fenghua.auto.backend.dao.BaseDao;
import com.fenghua.auto.order.backend.domain.OrderMaster;

/**
 *
 * DAO接口类
 *
 * @author 王直元
 * @createTime 2015-11-25 11:11:35
 *
 */
public interface OrderMasterDao extends BaseDao<OrderMaster>{
	/**
	 * 根据卖家id查询其主订单
	 * @param userId
	 * @return
	 */
	List<OrderMaster> selectByBuyerID(Long userId);
	
}