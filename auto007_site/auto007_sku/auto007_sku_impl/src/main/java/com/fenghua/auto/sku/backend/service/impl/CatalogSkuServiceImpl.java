/**
 * 
 */
package com.fenghua.auto.sku.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fenghua.auto.backend.dao.BaseDao;
import com.fenghua.auto.sku.backend.dao.CatalogSkuDao;
import com.fenghua.auto.sku.backend.domain.CatalogSku;
import com.fenghua.auto.backend.service.impl.BaseServiceImpl;
import com.fenghua.auto.sku.backend.service.CatalogSkuService;

/**
 * Service实现类
 *
 * @author lijie
 * @createTime 2015-11-27 11:44:10
 *
 */
@Service
public class CatalogSkuServiceImpl extends BaseServiceImpl<CatalogSku> implements CatalogSkuService {

	@Autowired
	private CatalogSkuDao dao;
	
	@Override
	protected BaseDao<CatalogSku> getBaseDao() {
		return dao;
	}

}
