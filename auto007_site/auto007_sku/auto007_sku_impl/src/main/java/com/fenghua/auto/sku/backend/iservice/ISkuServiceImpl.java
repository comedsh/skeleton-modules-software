package com.fenghua.auto.sku.backend.iservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fenghua.auto.backend.common.utils.BeanMapper;
import com.fenghua.auto.sku.backend.service.SkuService;
import com.fenghua.auto.sku.intf.dto.SkuDTO;
import com.fenghua.auto.sku.intf.service.ISkuService;

/** 
  *<des>
  *</des>
  * @author  lijie
  * @date 2015年11月24日
  * @version 
  */
@Service
public class ISkuServiceImpl implements ISkuService{

	@Autowired
	private SkuService skuService;

	@Override
	public List<SkuDTO> querySkuByCatalogId(Long catalogId) {
		return BeanMapper.mapList(skuService.querySkuByCatalogId(catalogId), SkuDTO.class);
	}

	@Override
	public List<SkuDTO> selectSkuByIds(Long[] ids) {
		return BeanMapper.mapList(skuService.selectSkuByIds(ids), SkuDTO.class);
	}

	@Override
	public SkuDTO loadSku(Long skuId) {
		return BeanMapper.map(skuService.selectById(skuId), SkuDTO.class);
	}
}
