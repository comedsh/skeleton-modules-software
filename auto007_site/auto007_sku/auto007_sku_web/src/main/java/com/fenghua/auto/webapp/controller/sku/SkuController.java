package com.fenghua.auto.webapp.controller.sku;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fenghua.auto.backend.core.utills.DateUtil;
import com.fenghua.auto.backend.core.utills.MessageHelper;
import com.fenghua.auto.backend.core.utils.MessageAndErrorUtil;
import com.fenghua.auto.backend.domain.mto.CommonMessageTransferObject;
import com.fenghua.auto.backend.domain.mto.MessageTransferObject;
import com.fenghua.auto.sku.SkuConstants;
import com.fenghua.auto.sku.domain.Sku;
import com.fenghua.auto.sku.service.CatalogService;
import com.fenghua.auto.sku.service.SkuService;
import com.fenghua.auto.sku.vo.DropMenuItem;
import com.fenghua.auto.sku.vo.SkuManageQueryParams;
import com.fenghua.auto.sku.vo.SkuVo;

/** 
  *<des>
  *</des>
  * @author  lijie
  * @date 2015年11月24日
  * @version 
  */
@Controller
@RequestMapping("/product")
public class SkuController {
	
	@Autowired
	private SkuService skuService;
	
	@Autowired
	private CatalogService catalogService;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public String queryAll( Model model){
		//查询上架商品
		List<Sku> list = skuService.selectList(new Sku());
		model.addAttribute("items",list);
		return "web.product_list";
	}
	

	
	/**
	 * 根据商品ID查询商品详情信息
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public String queryById(@PathVariable("id") Long id , Model model){
		Sku sku = skuService.selectById(id);
		if(sku == null){
			//TODO 商品已下架或停售,跳转到下架提示界面
		}
		model.addAttribute("product",sku);
		return "web.product";
	}
	
	
	/**
	 * 卖家管理SKU界面
	 * @return
	 */
	@RequestMapping(value="/manage")
	public String showManagePage(Model model){
		return "web.seller_manage";
	}
	
	/**
	 * 卖家管理SKU界面查询界面 
	 * @param params 查询参数,[ name : 商品名称，OE，SKU,发布时间，商品类目，商品状态
	 *                       publishTime : 发布时间  
	 *                       catalogId:商品类目
	 *                       status：商品状态]
	 * @return
	 */
	@RequestMapping(value="/manage/query")
	@ResponseBody
	public List<SkuVo> querySkuListByParams(HttpServletRequest request){	
		String name = request.getParameter("name");
		String catalogId = request.getParameter("catalogId");
		String publishTime = request.getParameter("publishTime");
		String status = request.getParameter("status");
		SkuManageQueryParams params = new SkuManageQueryParams();
		if(!StringUtils.isEmpty(name)){
			try {
				name = new String(name.getBytes("ISO-8859-1"), "utf-8");
			} catch (UnsupportedEncodingException e) {
			
			}
			params.setName(name);
		}
		if (!StringUtils.isEmpty(catalogId)) {
			params.setCatalogId(Long.valueOf(catalogId));
		}
		if (!StringUtils.isEmpty(publishTime)) {
			params.setPublishTime(Integer.valueOf(publishTime));
		}
		if (!StringUtils.isEmpty(status)) {
			params.setStatus(Integer.valueOf(status));
		}

		List<SkuVo>  datas = skuService.querySkuList(params);
		
		
		
		return datas;
	}
	
	@RequestMapping("/dropmenu/date")
	@ResponseBody

    public List<DropMenuItem> getSkuDateDropMenu(){
		//TODO 多语言
    	List<DropMenuItem> list = new ArrayList<DropMenuItem>();
    	list.add(new DropMenuItem(SkuConstants.THREE_MONTH, MessageHelper.getMessage("sku.threemonth")));
    	list.add(new DropMenuItem(SkuConstants.THIS_YEAR, DateUtil.getThisYear()+MessageHelper.getMessage("sku.year")));
    	list.add(new DropMenuItem(SkuConstants.LAST_YEAR, DateUtil.getLastYear()+MessageHelper.getMessage("sku.year")));
    
    	 return list;
    }
    
	@RequestMapping("/dropmenu/status")
	@ResponseBody
    public List<DropMenuItem> getSkuStatusDropMenu(){
    	List<DropMenuItem> list = new ArrayList<DropMenuItem>();
    	list.add(new DropMenuItem(SkuConstants.SkuStatusEnum.UP_SHELF.getValue(),SkuConstants.SkuStatusEnum.UP_SHELF.getName()));
    	list.add(new DropMenuItem(SkuConstants.SkuStatusEnum.DOWN_SHELF.getValue(),SkuConstants.SkuStatusEnum.DOWN_SHELF.getName()));
    	list.add(new DropMenuItem(SkuConstants.SkuStatusEnum.SAVE.getValue(),SkuConstants.SkuStatusEnum.SAVE.getName()));
    	list.add(new DropMenuItem(SkuConstants.SkuStatusEnum.DELETE.getValue(),SkuConstants.SkuStatusEnum.DELETE.getName()));
    	return list;
    }
	
	
	@RequestMapping("/dropmenu/catalog")
	@ResponseBody
    public List<DropMenuItem> getSkuCatalogDropMenu(){

    	return catalogService.getDropMenu();
    }
	
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	@ResponseBody
	public MessageTransferObject softDeleteSku(@RequestParam("ids[]") Long[] ids){
		List<Sku> result = skuService.updateSkuStatus(ids, SkuConstants.SkuStatusEnum.DELETE.getValue());
		CommonMessageTransferObject msg = new CommonMessageTransferObject();
		if(result.isEmpty()){
			msg.addMessages(MessageAndErrorUtil.getMessage("sku.oper.success", ""));
		}else{		
			msg.addMessages(MessageAndErrorUtil.getMessage("sku.delete.error","", builder(result)));
		}
		
		return msg;
	}
	
	/**
	 * 上架
	 * @param ids
	 * @return
	 */
	@RequestMapping(value="/shelfUp",method=RequestMethod.POST)
	@ResponseBody
	public MessageTransferObject upShelfSku(@RequestParam("ids[]") Long[] ids){
		List<Sku> result = skuService.updateSkuStatus(ids, SkuConstants.SkuStatusEnum.UP_SHELF.getValue());
		CommonMessageTransferObject msg = new CommonMessageTransferObject();
		if(result.isEmpty()){
			msg.addMessages(MessageAndErrorUtil.getMessage( "sku.oper.success",""));
		}else{		
			msg.addMessages(MessageAndErrorUtil.getMessage("sku.upshelf.error","", builder(result)));
		}
		
		return msg;
	}
	
	/**
	 * 下架
	 * @param ids
	 * @return
	 */
	@RequestMapping(value="/shelfDown",method=RequestMethod.POST)
	@ResponseBody
	public MessageTransferObject downShelfSku(@RequestParam("ids[]") Long[] ids){
		List<Sku> result =  skuService.updateSkuStatus(ids, SkuConstants.SkuStatusEnum.DOWN_SHELF.getValue());
		CommonMessageTransferObject msg = new CommonMessageTransferObject();
		if(result.isEmpty()){
			msg.addMessages(MessageAndErrorUtil.getMessage("sku.oper.success",""));
		}else{		
			msg.addMessages(MessageAndErrorUtil.getMessage("sku.down.error","", builder(result)));
		}
		
		return msg;
	}
	
	private String builder(List<Sku> list){
		StringBuilder builder = new StringBuilder();
		for(Sku s : list){
			builder.append(s.getCode()).append(",");
		}
		if(builder.length() > 0){
			builder.delete(builder.length()-1, builder.length());
		}
		return builder.toString();
	}
}
