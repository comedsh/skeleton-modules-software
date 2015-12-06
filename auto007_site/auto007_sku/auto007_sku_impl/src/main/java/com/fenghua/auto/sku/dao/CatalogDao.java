/**
 * 
 */
package com.fenghua.auto.sku.dao;

import java.util.List;

import com.fenghua.auto.backend.dao.BaseDao;
import com.fenghua.auto.sku.domain.Catalog;
import com.fenghua.auto.sku.vo.CatalogSkuVo;
import com.fenghua.auto.sku.vo.SkuCommentVo;

/**
 *
 * DAO接口类
 *
 * @author lijie
 * @createTime 2015-11-27 11:44:10
 *
 */
public interface CatalogDao extends BaseDao<Catalog>{

	public List<CatalogSkuVo> queryCatalogBySkuId(long skuId); 
	
}