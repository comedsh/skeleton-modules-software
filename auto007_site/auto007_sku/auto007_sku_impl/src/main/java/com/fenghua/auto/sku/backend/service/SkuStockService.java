package com.fenghua.auto.sku.backend.service;

import java.util.List;

import com.fenghua.auto.backend.service.BaseService;
import com.fenghua.auto.sku.backend.domain.SkuStock;

/** 
  *<des>
  *</des>
  * @author  lijie
  * @date 2015年11月24日
  * @version 
  */
public interface SkuStockService extends BaseService<SkuStock>{

	
	public SkuStock queryStockBySkuId(Long skuId);

	public SkuStock queryStockByReposityId(Long reposityId);
	
	
	

}
