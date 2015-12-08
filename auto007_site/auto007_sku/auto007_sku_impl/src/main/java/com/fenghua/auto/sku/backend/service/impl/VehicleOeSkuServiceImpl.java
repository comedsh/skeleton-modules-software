
/**
 * 
 */
package com.fenghua.auto.sku.backend.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fenghua.auto.backend.dao.BaseDao;
import com.fenghua.auto.sku.backend.dao.VehicleOeSkuDao;
import com.fenghua.auto.sku.backend.domain.VehicleOeSku;
import com.fenghua.auto.backend.service.impl.BaseServiceImpl;
import com.fenghua.auto.sku.backend.service.VehicleOeSkuService;
import com.fenghua.auto.sku.backend.vo.OeListVo;

/**
 * Service实现类
 *
 * @author lijie
 * @createTime 2015-11-27 16:00:19
 *
 */
@Service
public class VehicleOeSkuServiceImpl extends BaseServiceImpl<VehicleOeSku> implements VehicleOeSkuService {

	@Autowired
	private VehicleOeSkuDao dao;
	
	@Override
	protected BaseDao<VehicleOeSku> getBaseDao() {
		return dao;
	}
	
	public List<OeListVo> queryOeListGroupByBrand(Long skuId){
		VehicleOeSku oeSku = new VehicleOeSku();
		oeSku.setSkuId(skuId);
		List<VehicleOeSku> oeList = selectList(oeSku);
		List<OeListVo>  list = new ArrayList<>();
		OeListVo oeVo = null;
		for(VehicleOeSku oe :oeList){
			oeVo = findOe(list, oe.getBrand());
			if(oeVo == null){
				oeVo = new OeListVo();
				oeVo.setOeItems(new ArrayList<OeListVo>());
				oeVo.setBrand(oe.getBrand());
				list.add(oeVo);
			}
			
			oeVo.getOeItems().add(new OeListVo(oe.getOeCode()));	
		}
		return list; 
	}

	private OeListVo findOe(List<OeListVo>  list , String brand){
		for(OeListVo oe : list){
			if(brand.equals(oe.getBrand())){
				return oe;
			}
		}
		return null;
	}
}
