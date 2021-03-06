package com.fenghua.auto.sku.backend.service;

import java.util.List;

import com.fenghua.auto.backend.service.BaseService;
import com.fenghua.auto.sku.backend.domain.SkuImages;

/** 
  *<des>
  *</des>
  * @author  lijie
  * @date 2015年11月24日
  * @version 
  */
public interface SkuImageService  extends BaseService<SkuImages>{

	public List<SkuImages> queryBySkuId(Long id);
}
