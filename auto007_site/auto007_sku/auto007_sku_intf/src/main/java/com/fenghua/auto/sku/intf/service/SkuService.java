package com.fenghua.auto.sku.intf.service;

import java.util.List;

import com.fenghua.auto.sku.intf.dto.SkuDTO;

/** 
  *<des>
  *</des>
  * @author  lijie
  * @date 2015年11月24日
  * @version 
  */
public interface SkuService {

   /**
    * 根据商品类别查询
    * @param catalogId
    * @return
    */
   public List<SkuDTO> querySkuByCatalogId(Long catalogId);
   
   /**
    *  根据ID列表查询
	 * @param ids
	 * @return List<SkuDTO>
	 */
	public List<SkuDTO> selectSkuByIds(Long[] ids);

	/**
	 * 根据ID查询
	 * @param skuId
	 * @return SkuDTO
	 */
	public SkuDTO loadSku(Long skuId);
}
