package com.fenghua.auto.sku.backend.service;

import java.util.List;
import java.util.Map;

import com.fenghua.auto.backend.service.BaseService;
import com.fenghua.auto.sku.backend.domain.Sku;
import com.fenghua.auto.sku.backend.domain.SkuImageHtml;
import com.fenghua.auto.sku.backend.domain.SkuStock;
import com.fenghua.auto.sku.backend.vo.SkuManageQueryParams;
import com.fenghua.auto.sku.backend.vo.SkuVo;


/** 
  *<des>
  *</des>
  * @author  lijie
  * @date 2015年11月24日
  * @version 
  */
public interface SkuService extends BaseService<Sku>{

   /**根据商品类别查询
    * 
    * @param catalogId
    * @return
    */
   public List<Sku> querySkuByCatalogId(Long catalogId);
   
   /**
    * 根据 参数查询
    * @param jsonStr
    * @return
    */
   public List<Map<String,Object>> querySkuList(SkuManageQueryParams params);
   
   
   /**
    * 商品发布信息保存
    * @param sku
    * @param skuImageHtml
    * @param oeCodes
    * @param brands
    * @return
    */
   public Long saveProduct( Sku sku,SkuStock skuStock ,SkuImageHtml skuImageHtml,String oeCodes
		   ,String brands,String imageBigs,String imageSmalls,String attrNames,String attrContents);
/**
 * 删除商品关联的所有信息
 * @param skuId
 * @return
 */
	public Long deleteSkumessage( Long skuId) throws Exception;
	
   /**
    * 卖家SKU管理查询
    * @param params
    * @return
    */
   public List<SkuVo> querySkuListForSeller(SkuManageQueryParams params);
   
   public List<Sku> updateSkuStatus(Long[] ids,Integer status);
   
   public List<Sku> selectSkuByIds(Long[] ids);


}
