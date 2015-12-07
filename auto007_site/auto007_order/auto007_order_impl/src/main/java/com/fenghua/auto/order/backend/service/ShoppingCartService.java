/**
 * 
 */
package com.fenghua.auto.order.backend.service;

import java.util.List;

import com.fenghua.auto.backend.service.BaseService;
import com.fenghua.auto.order.backend.domain.ShoppingCart;
import com.fenghua.auto.order.backend.vo.ShoppingCartGroupVO;

/**
 * Service接口类
 *
 * @author 王直元
 * @createTime 2015-11-26 14:10:18
 *
 */
public interface ShoppingCartService extends BaseService<ShoppingCart> {

	public boolean addToCart(Long pid, int qty, Long buyerId);
	
	public boolean putToCart(Long pid, int qty, Long buyerId);
	
	public boolean removeCart(Long sid);
	
	public boolean removeCart(Long[] sids);
	
	public List<ShoppingCartGroupVO> loadByBuyerId(Long buyerId);
}
