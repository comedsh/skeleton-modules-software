package com.fenghua.auto.sku.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fenghua.auto.backend.dao.BaseDao;
import com.fenghua.auto.backend.service.impl.BaseServiceImpl;
import com.fenghua.auto.sku.dao.SkuImageDao;
import com.fenghua.auto.sku.domain.SkuImages;
import com.fenghua.auto.sku.service.SkuImageService;

/** 
  *<des>
  *</des>
  * @author  lijie
  * @date 2015年11月24日
  * @version 
  */
@Service
/**
 * @author lenovo
 *
 */
public class SkuImageServiceImpl extends BaseServiceImpl<SkuImages> implements SkuImageService{

	@Autowired
	private SkuImageDao skuImageDao;
	
	@Override
	public List<SkuImages> queryBySkuId(Long id) {
		SkuImages skuImages = new SkuImages();
		skuImages.setSkuId(id);
		return selectList(skuImages);
	}

	@Override
	protected BaseDao<SkuImages> getBaseDao() {
		return skuImageDao;
	}
	

}
