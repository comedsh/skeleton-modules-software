package com.fenghua.auto.sku.backend.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.fenghua.auto.backend.dao.impl.BaseDaoImpl;
import com.fenghua.auto.sku.backend.dao.SkuDao;
import com.fenghua.auto.sku.backend.domain.Sku;
import com.fenghua.auto.sku.backend.vo.SkuVo;

/** 
  *<des>
  *</des>
  * @author  lijie
  * @date 2015年11月24日
  * @version 
  */
@Repository
public class SkuDaoImpl extends BaseDaoImpl<Sku> implements SkuDao{

	@Override
	public List<SkuVo> querySkuList(SkuVo skuVo) {
		return sqlSessionTemplate.selectList(getSqlName("selectSkuVo"), skuVo);
	}

	@Override
	public List<Map<String, Object>> querySkuInfo(Map<String, Object> params) {
		return sqlSessionTemplate.selectList(getSqlName("selectByParams"), params);
	}

	@Override
	public int updateSkuStatus(Map<String, Object> params) {
		
		return sqlSessionTemplate.update(getSqlName("updateSkuStatus"), params);
	}

	@Override
	public List<Sku> selectSkuByIds(Map<String, Object> params) {
		return sqlSessionTemplate.selectList(getSqlName("selectSkuByIds"), params);
	}

}
