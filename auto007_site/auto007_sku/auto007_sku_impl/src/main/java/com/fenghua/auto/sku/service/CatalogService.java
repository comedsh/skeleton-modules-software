/**
 * 
 */
package com.fenghua.auto.sku.service;

import java.util.List;

import com.fenghua.auto.backend.service.BaseService;
import com.fenghua.auto.sku.domain.Catalog;
import com.fenghua.auto.sku.vo.CatalogSkuVo;
import com.fenghua.auto.sku.vo.DropMenuItem;

/**
 * Service接口类
 *
 * @author lijie
 * @createTime 2015-11-27 11:44:10
 *
 */
public interface CatalogService extends BaseService<Catalog> {

	public List<CatalogSkuVo> queryCatalogBySkuId(long skuId); 
	
	public List<DropMenuItem> getDropMenu();
	
}
