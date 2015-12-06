package com.fenghua.auto.sku.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fenghua.auto.backend.common.utils.PrecisionUtils;
import com.fenghua.auto.backend.dao.BaseDao;
import com.fenghua.auto.backend.service.impl.BaseServiceImpl;
import com.fenghua.auto.sku.SkuConstants;
import com.fenghua.auto.sku.dao.SkuCommentDao;
import com.fenghua.auto.sku.domain.SkuComment;
import com.fenghua.auto.sku.service.SkuCommentService;
import com.fenghua.auto.sku.vo.SkuCommentVo;

/** 
  *<des>
  *</des>
  * @author  lijie
  * @date 2015年11月24日
  * @version 
  */
@Service
public class SkuCommentServiceImpl extends BaseServiceImpl<SkuComment> implements SkuCommentService{

	@Autowired
	private SkuCommentDao skuCommentDao;

	
	@Override
	public long countBySkuId(Long skuId) {
		SkuComment skuComment =  new SkuComment();
		skuComment.setSkuId(skuId);
		return selectCount(skuComment);
	}


	@Override
	protected BaseDao<SkuComment> getBaseDao() {
		return skuCommentDao;
	}


	@Override
	public Map<String, Object> countComentBySkuId(Long skuId) {
		//好评度 == 
		//获取好评度
		SkuComment comment = new SkuComment();		
		comment.setSkuId(skuId);
		Long counts = selectCount(comment);
		
	    comment.setStar(SkuConstants.SkuCommentStarEnum.FOUR.getValue());
	 	Long praiseCounts = selectCount(comment);
	
	 	String precent = PrecisionUtils.formatPercent(praiseCounts/counts);
	 	Map<String, Object> maps = new HashMap<String, Object>();
	 	//
	 	maps.put("praise", praiseCounts);
	 	
	 	//百分比
	 	maps.put("precent", precent);
	 	
	 	
		return maps;
	}


	@Override
	public Map<String, Object> queryCommentBySkuId(Long skuId) {
		List<SkuCommentVo> list = 	skuCommentDao.querySkuComments(skuId);
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("result", list);
		return result;
	}

}
