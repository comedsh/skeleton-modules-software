/**
 * 
 */
package com.fenghua.auto.sku.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fenghua.auto.backend.dao.BaseDao;
import com.fenghua.auto.sku.backend.dao.SaleAreaDao;
import com.fenghua.auto.sku.backend.domain.SaleArea;
import com.fenghua.auto.backend.service.impl.BaseServiceImpl;
import com.fenghua.auto.sku.backend.service.SaleAreaService;

/**
 * Service实现类
 *
 * @author lijie
 * @createTime 2015-11-27 11:44:10
 *
 */
@Service
public class SaleAreaServiceImpl extends BaseServiceImpl<SaleArea> implements SaleAreaService {

	@Autowired
	private SaleAreaDao dao;
	
	@Override
	protected BaseDao<SaleArea> getBaseDao() {
		return dao;
	}

}
