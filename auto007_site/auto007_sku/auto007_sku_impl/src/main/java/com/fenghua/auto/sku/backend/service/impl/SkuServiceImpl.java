package com.fenghua.auto.sku.backend.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.fenghua.auto.backend.common.utils.DateUtil;
import com.fenghua.auto.backend.dao.BaseDao;
import com.fenghua.auto.backend.service.impl.BaseServiceImpl;
import com.fenghua.auto.sku.backend.SkuConstants;
import com.fenghua.auto.sku.backend.dao.SkuDao;
import com.fenghua.auto.sku.backend.domain.CatalogSku;
import com.fenghua.auto.sku.backend.domain.Sku;
import com.fenghua.auto.sku.backend.domain.VehicleOeSku;
import com.fenghua.auto.sku.backend.service.CatalogService;
import com.fenghua.auto.sku.backend.service.CatalogSkuService;
import com.fenghua.auto.sku.backend.service.SkuService;
import com.fenghua.auto.sku.backend.service.VehicleOeSkuService;
import com.fenghua.auto.sku.backend.vo.CatalogSkuVo;
import com.fenghua.auto.sku.backend.vo.SkuManageQueryParams;
import com.fenghua.auto.sku.backend.vo.SkuVo;

/** 
  *<des>
  *</des>
  * @author  lijie
  * @date 2015年11月24日
  * @version 
  */
@Service
public class SkuServiceImpl extends BaseServiceImpl<Sku> implements SkuService{

	@Autowired
	private SkuDao skuDao;
	
	@Autowired
	private CatalogService catalogService;
	
	@Autowired
	private VehicleOeSkuService vehicleOeSkuService;
	
	@Autowired
	private CatalogSkuService catalogSkuService;

	@Override
	protected BaseDao<Sku> getBaseDao() {
		// TODO Auto-generated method stub
		return skuDao;
	}


	@Override
	public List<Sku> querySkuByCatalogId(Long catalogId) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<SkuVo> querySkuList(SkuManageQueryParams params) {

		Map<String,Object> queryParamMap = new HashMap<String,Object>();
		//Long userId = UserSecurityUtils.getCurrentUserId();
		//用户登录ID
		queryParamMap.put("sellerId", 1);
		if (params != null) {
			// 查询全部
			Set<Long> skuIdSets = new HashSet<Long>();
			if (!StringUtils.isEmpty(params.getName())) {
				// 和OE列表联合查询
				String paramName = params.getName().trim();
				VehicleOeSku oeSku = new VehicleOeSku();
				oeSku.setOeCode(paramName);

				List list = vehicleOeSkuService.selectList(oeSku);
				convertObjToSet(skuIdSets, list);
				
				if(list.isEmpty()){
					//名称或sku编码
					queryParamMap.put("name",paramName+"%");
				}
			}
			
			if (!StringUtils.isEmpty(params.getCatalogId())) {
				// 和类目表联合
				CatalogSku catalogSku = new CatalogSku();
				catalogSku.setCatalogId(params.getCatalogId());

				List list = catalogSkuService.selectList(catalogSku);
				convertObjToSet(skuIdSets, list);
			}
			if(skuIdSets.size() > 0){
				queryParamMap.put("idList", skuIdSets);
			}
			
			if(!StringUtils.isEmpty(params.getStatus())){
				queryParamMap.put("status", params.getStatus());
			}
			if(!StringUtils.isEmpty(params.getPublishTime())){
				//1 三个月内，2 今年，3 去年
				String[] strs = null;
				if(SkuConstants.THREE_MONTH == params.getPublishTime()){
					strs = DateUtil.getThreeMonthDate();
				
				}
				if(SkuConstants.THIS_YEAR == params.getPublishTime()){
					strs = DateUtil.getThisYearInterval();
				}
				if(SkuConstants.LAST_YEAR == params.getPublishTime()){
					strs = DateUtil.getLastYearInterval();
				}
				queryParamMap.put("beginTime", strs[0]);
				queryParamMap.put("endTime",  strs[1]);
			}
		}
		//查询SKU
		List<Map<String,Object>> datas = skuDao.querySkuInfo(queryParamMap);
		 List<SkuVo> list = changeMaptoSkuVoList(datas);
	   
		 VehicleOeSku oeSku = new VehicleOeSku();
		
		 for(SkuVo skuVo : list){		
			 //获取SKU_OE
			 oeSku.setSkuId(skuVo.getId());
					 
			 //设置Oe值
			 initOe(oeSku, skuVo);
 
			//设置SKU_类目
		    initCatalogList(oeSku, skuVo);
			
		 }

		return list;
	}

    private void initOe(VehicleOeSku oeSku,SkuVo skuVo){
    	 List<VehicleOeSku> oeList = vehicleOeSkuService.selectList(oeSku);
    	 VehicleOeSku defaultOe = oeList.isEmpty()?null:oeList.get(0);
		 if(defaultOe != null){
			 skuVo.setDefaultOe(defaultOe.getOeCode());
		 }
		 skuVo.setOeSize(oeList.size());
    }
	
	private void initCatalogList(VehicleOeSku oeSku,SkuVo skuVo){
		List<CatalogSkuVo> list = catalogService.queryCatalogBySkuId(skuVo.getId());
		List<String> strList = new ArrayList<String>();
		for(CatalogSkuVo oe : list){
			strList.add(oe.getName());	
		}
		skuVo.setCatalogList(strList);
	}
	
	private List<SkuVo> changeMaptoSkuVoList(List<Map<String,Object>> datas){
		List<SkuVo> list = new ArrayList<>();
		if(datas.size() > 0){
			SkuVo skuVo = null;
			for(Map<String,Object> map : datas){
				skuVo = new SkuVo();
				skuVo.setBrand(map.get("brand") == null? "":map.get("brand").toString());
				skuVo.setCreateTime(map.get("create_time") == null? "":map.get("create_time").toString());
				skuVo.setId(map.get("id") == null? null:Long.valueOf(map.get("id").toString()));
				skuVo.setName(map.get("name") == null? "":map.get("name").toString());
				skuVo.setUrl(map.get("url") == null? "":map.get("url").toString());
				skuVo.setSkuNo(map.get("code") == null? "":map.get("code").toString());
				skuVo.setPrice(map.get("sale_price") == null? "":map.get("sale_price").toString());
				skuVo.setStatus(map.get("status") == null? null:Integer.valueOf(map.get("status").toString()));
				skuVo.setStatusName(SkuConstants.SkuStatusEnum.findName(skuVo.getStatus()));
				list.add(skuVo);
			}
		}
		return list;
	}
	
	private void convertObjToSet(Set<Long> skuIdSets , List list){
		for(Object obj : list){
			if(obj instanceof VehicleOeSku){
				skuIdSets.add(((VehicleOeSku)obj).getSkuId());
			}
           if(obj instanceof CatalogSku){
        	   skuIdSets.add(((CatalogSku)obj).getSkuId());
			}
		}
	}


	@Override
	public List<Sku> updateSkuStatus(Long[] ids, Integer status) {
		// TODO Auto-generated method stub
		//根据ID获取索要修改的商品
		List<Sku> datas = selectSkuByIds(ids);
		Object[] checkResult = null;
		//删除
		if(status == SkuConstants.SkuStatusEnum.DELETE.getValue()){
			//上架商品不能删除,检查商品是否是 下架或草稿状态
			checkResult = checkSkuStatus(datas, 
					new Integer[]{SkuConstants.SkuStatusEnum.DOWN_SHELF.getValue(),
							SkuConstants.SkuStatusEnum.SAVE.getValue()});

		}
		//下架
		if(status == SkuConstants.SkuStatusEnum.DOWN_SHELF.getValue()){
			//只能是上架状态
			checkResult = checkSkuStatus(datas, 
					new Integer[]{SkuConstants.SkuStatusEnum.UP_SHELF.getValue()});
		}
		//上架
		if(status == SkuConstants.SkuStatusEnum.UP_SHELF.getValue()){
			//删除状态不能上架，只能是草稿和下架状态
			checkResult = checkSkuStatus(datas, 
					new Integer[]{SkuConstants.SkuStatusEnum.DOWN_SHELF.getValue(),
							SkuConstants.SkuStatusEnum.SAVE.getValue()});
			
		}
		//
		List<Sku> validSkuList = (List<Sku>) checkResult[0];
		List<Sku> invalidSkuList = (List<Sku>) checkResult[1];
		//做入库操作
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("status", status);
		params.put("ids", validSkuList);
		if(validSkuList.size() > 0){
			int result = skuDao.updateSkuStatus(params);			
		}	
		return invalidSkuList;
	}


	private Object[] checkSkuStatus(List<Sku> datas , Integer... status){
		List<Integer> list = Arrays.asList(status);
		List<Sku> validSkuList = new ArrayList<Sku>();
		List<Sku> invalidSkuList = new ArrayList<Sku>();
		for(Sku sku : datas){
			if(list.contains(sku.getStatus())){
				validSkuList.add(sku);
			}else{
				invalidSkuList.add(sku);
			}
		}
		return new Object[]{validSkuList,invalidSkuList};
	}


	@Override
	public List<Sku> selectSkuByIds(Long[] ids) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("ids", ids);
		return skuDao.selectSkuByIds(params);
	}

}
