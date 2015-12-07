/**
 * 
 */
package com.fenghua.auto.sku.backend.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fenghua.auto.backend.dao.BaseDao;
import com.fenghua.auto.sku.backend.dao.CatalogDao;
import com.fenghua.auto.sku.backend.domain.Catalog;
import com.fenghua.auto.backend.service.impl.BaseServiceImpl;
import com.fenghua.auto.sku.backend.service.CatalogService;
import com.fenghua.auto.sku.backend.vo.CatalogSkuVo;
import com.fenghua.auto.sku.backend.vo.DropMenuItem;

/**
 * Service实现类
 *
 * @author lijie
 * @createTime 2015-11-27 11:44:10
 *
 */
@Service
public class CatalogServiceImpl extends BaseServiceImpl<Catalog> implements CatalogService {

	@Autowired
	private CatalogDao dao;
	
	@Override
	protected BaseDao<Catalog> getBaseDao() {
		return dao;
	}

	@Override
	public List<CatalogSkuVo> queryCatalogBySkuId(long skuId) {		
		return dao.queryCatalogBySkuId(skuId);
	}

	@Override
	public List<DropMenuItem>  getDropMenu(){
	  	List<DropMenuItem> list = new ArrayList<DropMenuItem>();
    	List<Catalog> catalogList = selectAll();
        for(Catalog c : catalogList){

        	list.add(new DropMenuItem(c.getId().intValue(), c.getName()));	
        }
		return list;
	}

}
