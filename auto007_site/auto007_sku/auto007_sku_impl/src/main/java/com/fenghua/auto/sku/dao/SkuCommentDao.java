package com.fenghua.auto.sku.dao;

import java.util.List;

import com.fenghua.auto.backend.dao.BaseDao;
import com.fenghua.auto.sku.domain.SkuComment;
import com.fenghua.auto.sku.vo.SkuCommentVo;


/** 
  *<des>
  *</des>
  * @author  lijie
  * @date 2015年11月24日
  * @version 
  */
public interface SkuCommentDao extends BaseDao<SkuComment>{

	public  List<SkuCommentVo> querySkuComments(Long skuId);
}
