package com.fenghua.auto.sku.web;

import java.io.UnsupportedEncodingException;
import java.net.BindException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fenghua.auto.backend.common.utils.DateUtil;
import com.fenghua.auto.backend.core.utils.LabelErrorTranslator;
import com.fenghua.auto.backend.core.utils.MessageAndErrorUtil;
import com.fenghua.auto.backend.core.utils.MessageHelper;
import com.fenghua.auto.backend.dao.PageInfo;
import com.fenghua.auto.backend.dao.constants.SqlId;
import com.fenghua.auto.backend.domain.mto.CommonMessageTransferObject;
import com.fenghua.auto.backend.domain.mto.LabelError;
import com.fenghua.auto.backend.domain.mto.MessageTransferObject;
import com.fenghua.auto.sku.backend.SkuConstants;
import com.fenghua.auto.sku.backend.domain.Sku;
import com.fenghua.auto.sku.backend.domain.SkuImageHtml;
import com.fenghua.auto.sku.backend.domain.SkuMessage;
import com.fenghua.auto.sku.backend.domain.SkuStock;
import com.fenghua.auto.sku.backend.service.CatalogService;
import com.fenghua.auto.sku.backend.service.SkuService;
import com.fenghua.auto.sku.backend.vo.DropMenuItem;
import com.fenghua.auto.sku.backend.vo.SkuManageQueryParams;
import com.fenghua.auto.sku.backend.vo.SkuVo;


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
	public String queryAll( @RequestParam(value="pageNumber",required=true, defaultValue="1") int pageNumber, Model model){
		//查询上架商品
		PageInfo<Sku> pageInfo = new PageInfo<Sku>(pageNumber, 2);
		PageInfo<Sku> list = skuService.selectListByPage(new Sku(), SqlId.SQL_SELECT, pageInfo);//skuService.selectList(new Sku());
		model.addAttribute("items",pageInfo.getResult());
		model.addAttribute("pageInfo", pageInfo);
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
	 * 商品发布页面显示
	 * @return
	 */
	@RequestMapping("/publish")
	public String publish(Model model){	
		//model.addAttribute("sku", new Sku());
		return "web.product_publish";
	}
	/**
	 * 商品手动发布
	 * @return
	 */
	@RequestMapping(value="/publishUp",method=RequestMethod.POST)
	public String publishUp( @RequestParam Long skuId){
		Sku sku=new Sku();
		sku.setId(skuId);
		sku.setStatus(2);
		int result=skuService.updateById(sku);
		if(result>0){
			return "web.product_publishSuccess";
		}else{
			return "web.product_publishReview";
		}
		
	}
	/**
	 * 检查错误信息，获取信息，拦截方法
	 * @param sku
	 * @param result
	 * @return
	 */
	@RequestMapping(value="/checkError",method=RequestMethod.POST, headers="Content-Type=application/json")
	public @ResponseBody SkuMessage checkError(@Valid @RequestBody SkuMessage skuMessage,BindingResult  result) throws BindException{
		if(result.hasErrors()){
			LabelError[] errors = {};
			skuMessage.addErrors( LabelErrorTranslator.translate2LabelError( result.getFieldErrors() ).toArray(errors) );
			return skuMessage;
		}
		return skuMessage;
	}
	/**
	 * 商品立即发布
	 * @return
	 */
	@RequestMapping(value="/publishImediat",method=RequestMethod.POST)
	public String publishImediat(@Valid Sku sku,@Valid SkuStock skuStock,@Valid SkuImageHtml skuImageHtml,
			@RequestParam String oeCodes,@RequestParam String oebrands,
			@RequestParam String imageBigs,@RequestParam String imageSmalls,
			@RequestParam String attrNames,@RequestParam String attrContents,
			HttpServletRequest request,HttpServletResponse response,Model model) throws Exception{
			//是否存在该条sku信息
		    if(sku.getId()!=null && sku.getId()!=0){
		    	skuService.deleteSkumessage(sku.getId());
		    }
			sku.setStatus(2);
			Long idLong=skuService.saveProduct(sku,skuStock,skuImageHtml,oeCodes,oebrands,imageBigs,imageSmalls,attrNames,attrContents);
			if(idLong>0){
				return "web.product_publishSuccess";
			}else{
				return "web.product_publish";
			}	
	}
	/**
	 * 商品发布信息保存
	 * @param sku
	 * @param skuImageHtml
	 * @param oeCodes
	 * @param brands
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/saveProduct",method=RequestMethod.POST)
	public String saveProduct(@Valid Sku sku,@Valid SkuStock skuStock,@Valid SkuImageHtml skuImageHtml,
			@RequestParam String oeCodes,@RequestParam String oebrands,
			@RequestParam String imageBigs,@RequestParam String imageSmalls,
			@RequestParam String attrNames,@RequestParam String attrContents,
			HttpServletRequest request,HttpServletResponse response,Model model) throws Exception{		
			//是否存在该条sku信息
		    if(sku.getId()!=null && sku.getId()!=0){
		    	skuService.deleteSkumessage(sku.getId());
		    }
			sku.setStatus(1);
			Long idLong=skuService.saveProduct(sku,skuStock,skuImageHtml,oeCodes,oebrands,imageBigs,imageSmalls,attrNames,attrContents);
			Map<String, Object> listMap=this.getList(oeCodes, oebrands, attrNames, attrContents);			
			model.addAttribute("sku", sku);
			model.addAttribute("skuImageHtml", skuImageHtml);
			model.addAttribute("skuStock", skuStock);
			model.addAttribute("oeList", listMap.get("oeList"));//OE-SKU集合参数
			model.addAttribute("aTttrList", listMap.get("aTttrList"));//商品扩展参数
			model.addAttribute("imageSmalls", imageSmalls.split(";"));
			return "web.product_publishReview";
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

		List<SkuVo>  datas = skuService.querySkuListForSeller(params);
		
		
		
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
	
	@RequestMapping(value="/softDelete",method=RequestMethod.POST)
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
	
	/**
	 * 获取商品参数和商品属性集合
	 * @param oeCodes
	 * @param oebrands
	 * @param attrNames
	 * @param attrContents
	 * @return
	 */
	private Map<String, Object> getList(String oeCodes ,String oebrands,String attrNames,String attrContents){
		Map<String,Object> listMap = new HashMap<String,Object>();
		List<Map<String, Object>> oeList=new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> aTttrList=new ArrayList<Map<String, Object>>();
		//获取集合
		String[] oeCode=oeCodes.split(";");
		String[] oebrand=oebrands.split(";");
		String[] attrName=attrNames.split(";");
		String[] attrContent=attrContents.split(";");
		for(int i = 0 ; i<oeCode.length;i++){
			Map<String,Object> modelOe = new HashMap<String,Object>();
			if("0".equals(oeCode[i]) && "0".equals(oebrand[i])){
				continue;
			}else{
				modelOe.put("oeCode", oeCode[i]);
				modelOe.put("oebrand", oebrand[i]);
			}
			oeList.add(modelOe);
		}
		
		//商品扩展参数
		for(int i = 0 ; i<attrName.length;i++){
			Map<String,Object> modelAttr = new HashMap<String,Object>();
			if("0".equals(attrName[i]) && "0".equals(attrContent[i])){
				continue;
			}else{
				modelAttr.put("attrName", attrName[i]);
				modelAttr.put("attrContent", attrContent[i]);
			}
			aTttrList.add(modelAttr);
		}
		listMap.put("oeList", oeList);
		listMap.put("aTttrList", aTttrList);
		return listMap;
	}
}
