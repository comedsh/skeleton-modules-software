/**
 * 
 */
package com.fenghua.auto.sku.service;

import java.util.List;

import com.fenghua.auto.backend.service.BaseService;
import com.fenghua.auto.sku.domain.SkuExtendAttrs;

/**
 * Service接口类
 *
 * @author lijie
 * @createTime 2015-11-27 16:00:19
 *
 */
public interface SkuExtendAttrsService extends BaseService<SkuExtendAttrs> {

	public List<SkuExtendAttrs> queryInfoBySkuId(Long skuId);
}
