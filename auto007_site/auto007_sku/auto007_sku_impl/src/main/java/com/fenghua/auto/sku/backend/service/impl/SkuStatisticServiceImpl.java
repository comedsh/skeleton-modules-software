/**
 * 
 */
package com.fenghua.auto.sku.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fenghua.auto.backend.dao.BaseDao;
import com.fenghua.auto.sku.backend.dao.SkuStatisticDao;
import com.fenghua.auto.sku.backend.domain.SkuStatistic;
import com.fenghua.auto.backend.service.impl.BaseServiceImpl;
import com.fenghua.auto.sku.backend.service.SkuStatisticService;

/**
 * Service实现类
 *
 * @author lijie
 * @createTime 2015-12-08 13:58:40
 *
 */
@Service
public class SkuStatisticServiceImpl extends BaseServiceImpl<SkuStatistic> implements SkuStatisticService {

	@Autowired
	private SkuStatisticDao dao;
	
	@Override
	protected BaseDao<SkuStatistic> getBaseDao() {
		return dao;
	}

}
