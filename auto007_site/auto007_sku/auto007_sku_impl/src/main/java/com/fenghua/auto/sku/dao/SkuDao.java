package com.fenghua.auto.sku.dao;


import java.util.List;
import java.util.Map;

import com.fenghua.auto.backend.dao.BaseDao;
import com.fenghua.auto.sku.domain.Sku;
import com.fenghua.auto.sku.vo.SkuVo;

/** 
  *<des>
  *</des>
  * @author  lijie
  * @date 2015年11月24日
  * @version 
  */
public interface SkuDao extends BaseDao<Sku>{

	public List<SkuVo> querySkuList(SkuVo skuVo);
	
	public List<Map<String,Object>> querySkuInfo(Map<String,Object> params);
	
	public int updateSkuStatus(Map<String,Object> params);
	
	public List<Sku> selectSkuByIds(Map<String, Object> params);
}
