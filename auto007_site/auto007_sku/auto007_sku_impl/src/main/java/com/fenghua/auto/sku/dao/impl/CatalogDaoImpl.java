/**
 * 
 */
package com.fenghua.auto.sku.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.fenghua.auto.backend.dao.impl.BaseDaoImpl;
import com.fenghua.auto.sku.dao.CatalogDao;
import com.fenghua.auto.sku.domain.Catalog;
import com.fenghua.auto.sku.vo.CatalogSkuVo;

/**
 *
 * DAO实现类
 *
 * @author lijie
 * @createTime 2015-11-27 11:44:10
 *
 */
@Repository
public class CatalogDaoImpl extends BaseDaoImpl<Catalog> implements CatalogDao {

	@Override
	public List<CatalogSkuVo> queryCatalogBySkuId(long skuId) {
		return sqlSessionTemplate.selectList(getSqlName("selectCatalogBySkuId"), skuId);
	}

}
