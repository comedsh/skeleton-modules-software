/**
 * 
 */
package com.fenghua.auto.sku.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fenghua.auto.backend.dao.BaseDao;
import com.fenghua.auto.sku.dao.SkuReplyDao;
import com.fenghua.auto.sku.domain.SkuReply;
import com.fenghua.auto.backend.service.impl.BaseServiceImpl;
import com.fenghua.auto.sku.service.SkuReplyService;

/**
 * Service实现类
 *
 * @author lijie
 * @createTime 2015-11-27 16:00:19
 *
 */
@Service
public class SkuReplyServiceImpl extends BaseServiceImpl<SkuReply> implements SkuReplyService {

	@Autowired
	private SkuReplyDao dao;
	
	@Override
	protected BaseDao<SkuReply> getBaseDao() {
		return dao;
	}

}
