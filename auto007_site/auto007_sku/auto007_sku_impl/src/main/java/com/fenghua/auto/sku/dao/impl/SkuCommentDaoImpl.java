package com.fenghua.auto.sku.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.fenghua.auto.backend.dao.impl.BaseDaoImpl;
import com.fenghua.auto.sku.dao.SkuCommentDao;
import com.fenghua.auto.sku.domain.SkuComment;
import com.fenghua.auto.sku.vo.SkuCommentVo;

/** 
  *<des>
  *</des>
  * @author  lijie
  * @date 2015年11月24日
  * @version 
  */
@Repository
public class SkuCommentDaoImpl extends BaseDaoImpl<SkuComment> implements SkuCommentDao{

	@Override
	public List<SkuCommentVo> querySkuComments(Long skuId) {
		return sqlSessionTemplate.selectList(getSqlName("selectConments"), skuId);
	}

}
