package com.fenghua.auto.sku.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fenghua.auto.sku.backend.domain.SkuExtendAttrs;
import com.fenghua.auto.sku.backend.service.SkuExtendAttrsService;

/** 
  *<des>
  *</des>
  * @author  lijie
  * @date 2015年11月27日
  * @version 
  */
@Controller
@RequestMapping("/skuExtendAttrs")
public class SkuExtendAttrsController {
   
	@Autowired
	private SkuExtendAttrsService skuExtendAttrsService;
	
	@RequestMapping("/product/{id}")
	@ResponseBody
	public Map<String,Object>  queryBySkuId(@PathVariable("id") Long id){
		List<SkuExtendAttrs> list = skuExtendAttrsService.queryInfoBySkuId(id);
		Map<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("attrs", list);
		return resultMap;
	}

	
}
