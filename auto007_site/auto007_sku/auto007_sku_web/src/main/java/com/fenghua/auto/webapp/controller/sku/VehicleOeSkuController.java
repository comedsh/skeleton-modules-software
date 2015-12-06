package com.fenghua.auto.webapp.controller.sku;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fenghua.auto.sku.service.VehicleOeSkuService;
import com.fenghua.auto.sku.vo.OeListVo;

/** 
  *<des>
  * OE_SKU
  *</des>
  * @author  lijie
  * @date 2015年12月3日
  * @version 
  */
@RequestMapping("/productOe")
@Controller
public class VehicleOeSkuController {

	@Autowired
	private VehicleOeSkuService vehicleOeSkuService;
	
	@RequestMapping(value="/{skuId}",method=RequestMethod.GET)
	@ResponseBody
	public List<OeListVo> queryOeListGroupByBrand(@PathVariable("skuId") Long skuId){
		return vehicleOeSkuService.queryOeListGroupByBrand(skuId);
	}
	
}
