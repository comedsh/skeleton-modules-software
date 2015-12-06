/**
 * 
 */
package com.fenghua.auto.sku.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fenghua.auto.backend.dao.BaseDao;
import com.fenghua.auto.sku.dao.CatalogAttributeDao;
import com.fenghua.auto.sku.domain.CatalogAttribute;
import com.fenghua.auto.backend.service.impl.BaseServiceImpl;
import com.fenghua.auto.sku.service.CatalogAttributeService;

/**
 * Service实现类
 *
 * @author lijie
 * @createTime 2015-11-27 11:44:10
 *
 */
@Service
public class CatalogAttributeServiceImpl extends BaseServiceImpl<CatalogAttribute> implements CatalogAttributeService {

	@Autowired
	private CatalogAttributeDao dao;
	
	@Override
	protected BaseDao<CatalogAttribute> getBaseDao() {
		return dao;
	}

}
