package com.fenghua.auto.sku.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fenghua.auto.backend.dao.BaseDao;
import com.fenghua.auto.backend.service.impl.BaseServiceImpl;
import com.fenghua.auto.sku.dao.SkuStockDao;
import com.fenghua.auto.sku.domain.SkuStock;
import com.fenghua.auto.sku.service.SkuStockService;

/** 
  *<des>
  *</des>
  * @author  lijie
  * @date 2015年11月24日
  * @version 
  */
@Service
public class SkuStockServiceImpl extends BaseServiceImpl<SkuStock> implements SkuStockService{

	@Autowired
	private SkuStockDao skuStockDao;
	
	@Override
	public SkuStock queryStockBySkuId(Long skuId) {
		SkuStock skuStock = new SkuStock();
		skuStock.setSkuId(skuId);
		return selectOne(skuStock);
	}

	@Override
	public SkuStock queryStockByReposityId(Long reposityId) {
		SkuStock skuStock = new SkuStock();
		skuStock.setRepertoryId(reposityId);
		return selectOne(skuStock);
	}



	@Override
	protected BaseDao<SkuStock> getBaseDao() {
		return skuStockDao;
	}


}
