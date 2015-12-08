package com.fenghua.auto.sku.backend.service;

import java.util.List;
import java.util.Map;

import com.fenghua.auto.backend.service.BaseService;
import com.fenghua.auto.sku.backend.domain.SkuComment;

/** 
  *<des>
  *</des>
  * @author  lijie
  * @date 2015年11月24日
  * @version 
  */
public interface SkuCommentService  extends BaseService<SkuComment>{

	public long countBySkuId(Long skuId);
	
	/**
	 * 统计好评度 = 获取的好评数/评论总数
	 * @return
	 */
	public Map<String,Object> countComentBySkuId(Long skuId);
	
	
	/**
	 * 获取评论信息
	 * @param skuId
	 * @return
	 */
	public  Map<String,Object> queryCommentBySkuId(Long skuId);
}
