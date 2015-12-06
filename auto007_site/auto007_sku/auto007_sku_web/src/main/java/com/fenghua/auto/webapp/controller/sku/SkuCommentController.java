package com.fenghua.auto.webapp.controller.sku;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fenghua.auto.sku.service.SkuCommentService;

/** 
  *<des>
  *</des>
  * @author  lijie
  * @date 2015年11月25日
  * @version 
  */
@Controller
@RequestMapping("/comment")
public class SkuCommentController {

	@Autowired
	private SkuCommentService skuCommentService;
	
	/**
	 * 获取评论总数
	 * @param skuId
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/{skuId}",method=RequestMethod.GET)
	@ResponseBody
	public Map<String,String> countBySkuId(@PathVariable("skuId") Long skuId,Model model){
		long counts = skuCommentService.countBySkuId(skuId);
		Map<String,String> maps = new HashMap<String,String>();
		maps.put("comtotal", counts+"");
		return maps;	
	}
	
	/**
	 * 统计评论好评
	 * @param skuId
	 * @return
	 */
	@RequestMapping(value="/praise/{skuId}")
	@ResponseBody
	public Map<String,Object> countCommentInfo(@PathVariable("skuId") Long skuId){
		Map<String,Object> results = skuCommentService.countComentBySkuId(skuId);
		return results;
	}
	
	/**
	 * 获取评论信息
	 * @param skuId
	 * @return
	 */
	@RequestMapping("/detail/{skuId}")
	@ResponseBody
	public Map<String,Object> getCommentInfoBySkuId(@PathVariable("skuId") Long skuId){
		Map<String,Object> results = skuCommentService.queryCommentBySkuId(skuId);
		return results;
	}
	
	
}
