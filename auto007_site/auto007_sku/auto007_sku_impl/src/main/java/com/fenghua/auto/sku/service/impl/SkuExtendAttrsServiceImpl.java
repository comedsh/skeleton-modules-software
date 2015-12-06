/**
 * 
 */
package com.fenghua.auto.sku.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fenghua.auto.backend.dao.BaseDao;
import com.fenghua.auto.sku.dao.SkuExtendAttrsDao;
import com.fenghua.auto.sku.domain.SkuExtendAttrs;
import com.fenghua.auto.backend.service.impl.BaseServiceImpl;
import com.fenghua.auto.sku.service.SkuExtendAttrsService;

/**
 * Service实现类
 *
 * @author lijie
 * @createTime 2015-11-27 16:00:19
 *
 */
@Service
public class SkuExtendAttrsServiceImpl extends BaseServiceImpl<SkuExtendAttrs> implements SkuExtendAttrsService {

	@Autowired
	private SkuExtendAttrsDao dao;
	
	@Override
	protected BaseDao<SkuExtendAttrs> getBaseDao() {
		return dao;
	}

	@Override
	public List<SkuExtendAttrs> queryInfoBySkuId(Long skuId) {
		SkuExtendAttrs skuExtendAttrs = new SkuExtendAttrs();
		skuExtendAttrs.setSkuId(skuId);
		
		return selectList(skuExtendAttrs);
	}
	
	

}
