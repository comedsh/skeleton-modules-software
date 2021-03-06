/**
 * 
 */
package com.fenghua.auto.order.backend.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fenghua.auto.backend.dao.BaseDao;
import com.fenghua.auto.backend.service.impl.BaseServiceImpl;
import com.fenghua.auto.order.backend.dao.ShoppingCartDao;
import com.fenghua.auto.order.backend.domain.ShoppingCart;
import com.fenghua.auto.order.backend.qo.ShoppingCartQO;
import com.fenghua.auto.order.backend.service.ShoppingCartService;
import com.fenghua.auto.order.backend.vo.ShoppingCartGroupVO;
import com.fenghua.auto.order.backend.vo.ShoppingCartVO;
import com.fenghua.auto.sku.intf.dto.SkuDTO;
import com.fenghua.auto.sku.intf.service.ISkuService;
import com.fenghua.auto.user.intf.service.ISellerService;

/**
 * Service实现类
 *
 * @author 王直元
 * @createTime 2015-11-26 14:10:18
 *
 */
@Service
public class ShoppingCartServiceImpl extends BaseServiceImpl<ShoppingCart> implements ShoppingCartService {

	@Autowired
	private ShoppingCartDao dao;
	
	@Autowired
	private ISkuService skuService;
	
	@Autowired
	private ISellerService sellerService;
	
	@Override
	protected BaseDao<ShoppingCart> getBaseDao() {
		return dao;
	}

	@Override
	@Transactional
	public boolean addToCart(Long pid, int qty, Long buyerId) {
		boolean added = false;
		try {
			SkuDTO sku = skuService.loadSku(pid);
			if(sku != null) {
				ShoppingCart query = new ShoppingCart();
				query.setBuyerId(buyerId);
				query.setSkuId(sku.getId());
				ShoppingCart scart = dao.selectOne(query);
				if(scart == null) {
					scart = new ShoppingCart();
					scart.setBuyerId(buyerId);
					scart.setSkuId(sku.getId());
					scart.setSellerId(sku.getSellerId());
				}
				scart.addQty(qty);
				scart.setAddTime(new Date());
				scart.setOriginalPrice(sku.getPrice());
				scart.setSalePrice(sku.getSalePrice());
				scart.setCurrentPrice(sku.getSalePrice());
				scart.setDiscountStrategyDesc("满 2000 减 200");
				if(scart.getId() != null && scart.getId() > 0) {
					dao.updateById(scart);
				} else {
					dao.insert(scart);
				}
				
				added = true;
			}
		} catch (Exception e) {
		}
		
		return added;
	}
	
	@Transactional
	public boolean putToCart(Long pid, int qty, Long buyerId) {
		if(pid == null || pid <= 0 || qty <= 0) {
			return false;
		}
		boolean added = false;
		try {
			SkuDTO sku = skuService.loadSku(pid);
			if(sku != null) {
				ShoppingCart query = new ShoppingCart();
				query.setBuyerId(buyerId);
				query.setSkuId(sku.getId());
				ShoppingCart scart = dao.selectOne(query);
				if(scart != null) {
					scart.setQty(qty);
					scart.setAddTime(new Date());
					scart.setOriginalPrice(sku.getPrice());
					scart.setSalePrice(sku.getSalePrice());
					scart.setCurrentPrice(sku.getSalePrice());
					scart.setDiscountStrategyDesc("满 2000 减 200");
					dao.updateById(scart);
					added = true;
				}
			}
		} catch (Exception e) {
		}
		
		return added;
	}
	
	@Override
	@Transactional
	public boolean removeCart(Long sid) {
		dao.deleteById(sid);
		return true;
	}

	@Override
	public boolean removeCart(Long[] sids) {
		if(sids != null && sids.length > 0) {
			for (Long sid : sids) {
				removeCart(sid);
			}
			return true;
		}
		return false;
	}

	@Override
	public List<ShoppingCartGroupVO> loadByBuyerId(Long buyerId) {
		ShoppingCartQO query = new ShoppingCartQO();
		if(buyerId == null) {
			return new ArrayList<ShoppingCartGroupVO>(0);
		}
		query.setBuyerId(buyerId);
		List<ShoppingCart> cartDOs = selectList(query);
		
		Map<Long, ShoppingCartGroupVO> map = new HashMap<Long, ShoppingCartGroupVO>();
		if(cartDOs != null) {
			for (ShoppingCart cart : cartDOs) {
				ShoppingCartVO vo = new ShoppingCartVO(cart, skuService.loadSku(cart.getSkuId()));
				if(!map.containsKey(cart.getSellerId())) {
					map.put(cart.getSellerId(), new ShoppingCartGroupVO(sellerService.getSellerById(cart.getSellerId())));
				}
				map.get(cart.getSellerId()).addCart(vo);
			}
		}
		if(!map.isEmpty()) {
			return new ArrayList<ShoppingCartGroupVO>(map.values());
		}
		return new ArrayList<ShoppingCartGroupVO>(0);
	}
	
}
