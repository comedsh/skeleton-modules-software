package com.fenghua.auto.sku.service;

import java.util.List;
import java.util.Map;

import com.fenghua.auto.backend.service.BaseService;
import com.fenghua.auto.sku.domain.Sku;
import com.fenghua.auto.sku.vo.SkuManageQueryParams;
import com.fenghua.auto.sku.vo.SkuVo;

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
   public List<SkuVo> querySkuList(SkuManageQueryParams params);
   
   public List<Sku> updateSkuStatus(Long[] ids,Integer status);
   
   public List<Sku> selectSkuByIds(Long[] ids);


}
