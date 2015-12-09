package com.fenghua.auto.sku.backend.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.fenghua.auto.backend.dao.DaoException;
import com.fenghua.auto.backend.dao.impl.BaseDaoImpl;
import com.fenghua.auto.sku.backend.dao.SkuDao;
import com.fenghua.auto.sku.backend.dao.constants.SqlId;
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
		return sqlSessionTemplate.selectList(getSqlName(SqlId.SKU_SELECT_SKU_VO), skuVo);
	}

	@Override
	public List<Map<String, Object>> querySkuInfo(Map<String, Object> params) {
		return sqlSessionTemplate.selectList(getSqlName(SqlId.SKU_SELECT_BY_PARAMS), params);
	}

	@Override
	public int updateSkuStatus(Map<String, Object> params) {
		
		return sqlSessionTemplate.update(getSqlName(SqlId.SKU_UPDATE_SKU_STATUS), params);
	}

	@Override
	public List<Sku> selectSkuByIds(Map<String, Object> params) {
		return sqlSessionTemplate.selectList(getSqlName(SqlId.SKU_SELECT_BY_IDS), params);
	}

	@Override
	public Long saveProduct(Sku sku) {
		Assert.notNull(sku);
		Long str = null;
		try {
			sqlSessionTemplate.insert(getSqlName(com.fenghua.auto.backend.dao.constants.SqlId.SQL_INSERT), sku);
			str = sku.getId();
		} catch (Exception e) {
			throw new DaoException(String.format("添加对象出错！语句：%s", getSqlName(com.fenghua.auto.backend.dao.constants.SqlId.SQL_INSERT)), e);
		}
		return str;
	}

}
