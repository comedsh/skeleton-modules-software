package com.fenghua.auto.user.backend.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.fenghua.auto.backend.dao.BaseDao;
import com.fenghua.auto.user.backend.domain.UserPaymentType;;
/**
 * 用户支付关系dao
 * @author chengbin
 * @createtime 2015.11.2
 *
 */
@Repository
public interface UserPaymentTypeDao extends BaseDao<UserPaymentType> {
	/**
	 * 插入一条用户与支付的关系数据
	 */
	public void insert(UserPaymentType payment); 
	/**
	 * 通过id查询UserPaymentType
	 * @return
	 */
	public List<UserPaymentType> getById(Long id); 
	/**
	 * 通过id查询UserPaymentType
	 * @return
	 */
	public List<UserPaymentType> getByUserId(Long userId); 
	
}
