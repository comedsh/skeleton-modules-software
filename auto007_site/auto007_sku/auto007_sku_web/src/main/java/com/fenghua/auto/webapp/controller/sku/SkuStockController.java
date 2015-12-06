package com.fenghua.auto.webapp.controller.sku;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fenghua.auto.sku.domain.SkuStock;
import com.fenghua.auto.sku.service.SkuService;
import com.fenghua.auto.sku.service.SkuStockService;

/** 
  *<des>
  *</des>
  * @author  lijie
  * @date 2015年11月25日
  * @version 
  */
@Controller
@RequestMapping("/stock")
public class SkuStockController {

	@Autowired
	private SkuStockService skuStockService;
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	@ResponseBody
	public SkuStock queryStockBySkuId(@PathVariable("id") Long id){
		SkuStock stock = skuStockService.queryStockBySkuId(id);
		if(stock != null){
			long saledCount = (stock.getStockCount()-stock.getStockAvailability());
			stock.setSaledCount(saledCount);
		}		
		return stock;
		
	}
}
