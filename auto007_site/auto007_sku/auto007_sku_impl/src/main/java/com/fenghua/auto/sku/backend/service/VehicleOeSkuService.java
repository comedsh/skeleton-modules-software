/**
 * 
 */
package com.fenghua.auto.sku.backend.service;

import java.util.List;

import com.fenghua.auto.backend.service.BaseService;
import com.fenghua.auto.sku.backend.domain.VehicleOeSku;
import com.fenghua.auto.sku.backend.vo.OeListVo;

/**
 * Service接口类
 *
 * @author lijie
 * @createTime 2015-11-27 16:00:19
 *
 */
public interface VehicleOeSkuService extends BaseService<VehicleOeSku> {
	
	public List<OeListVo> queryOeListGroupByBrand(Long skuId);
}
