/**
 * 
 */
package com.fenghua.auto.sku.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fenghua.auto.backend.dao.BaseDao;
import com.fenghua.auto.sku.dao.SkuCatalogAttrValueDao;
import com.fenghua.auto.sku.domain.SkuCatalogAttrValue;
import com.fenghua.auto.backend.service.impl.BaseServiceImpl;
import com.fenghua.auto.sku.service.SkuCatalogAttrValueService;

/**
 * Service实现类
 *
 * @author lijie
 * @createTime 2015-11-27 11:44:10
 *
 */
@Service
public class SkuCatalogAttrValueServiceImpl extends BaseServiceImpl<SkuCatalogAttrValue> implements SkuCatalogAttrValueService {

	@Autowired
	private SkuCatalogAttrValueDao dao;
	
	@Override
	protected BaseDao<SkuCatalogAttrValue> getBaseDao() {
		return dao;
	}

}
