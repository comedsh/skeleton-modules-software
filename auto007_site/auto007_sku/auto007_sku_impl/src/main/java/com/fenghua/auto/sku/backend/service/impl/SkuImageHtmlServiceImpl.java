/**
 * 
 */
package com.fenghua.auto.sku.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fenghua.auto.backend.dao.BaseDao;
import com.fenghua.auto.sku.backend.dao.SkuImageHtmlDao;
import com.fenghua.auto.sku.backend.domain.SkuImageHtml;
import com.fenghua.auto.backend.service.impl.BaseServiceImpl;
import com.fenghua.auto.sku.backend.service.SkuImageHtmlService;

/**
 * Service实现类
 *
 * @author lijie
 * @createTime 2015-11-30 15:37:15
 *
 */
@Service
public class SkuImageHtmlServiceImpl extends BaseServiceImpl<SkuImageHtml> implements SkuImageHtmlService {

	@Autowired
	private SkuImageHtmlDao dao;
	
	@Override
	protected BaseDao<SkuImageHtml> getBaseDao() {
		return dao;
	}

}
