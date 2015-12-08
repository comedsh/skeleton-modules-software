package com.fenghua.auto.sku.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fenghua.auto.sku.backend.domain.SkuImages;
import com.fenghua.auto.sku.backend.service.SkuImageService;

/** 
  *<des>
  *</des>
  * @author  lijie
  * @date 2015年11月25日
  * @version 
  */
@Controller
@RequestMapping("/productPic")
public class SkuImagesController {
    
	@Autowired
	private SkuImageService skuImageService;
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	@ResponseBody
	public Map<String,List<SkuImages>> queryPictureBySkuId(@PathVariable("id") Long id){
		List<SkuImages> picItems= skuImageService.queryBySkuId(id);
	
		Map<String,List<SkuImages>> maps = new HashMap<String,List<SkuImages>>();
		maps.put("items", picItems);
		return maps;
	}
}
