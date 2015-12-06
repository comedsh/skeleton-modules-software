package com.fenghua.auto.sku.vo;
/** 
  *<des>
  *</des>
  * @author  lijie
  * @date 2015年12月2日
  * @version 
  */
public class SkuManageQueryParams {

	private String name;//商品名称  or OE or SK
	private Integer publishTime; //三个月内,2015,2014 
	private Long catalogId;
	private Integer status;
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(Integer publishTime) {
		this.publishTime = publishTime;
	}
	public Long getCatalogId() {
		return catalogId;
	}
	public void setCatalogId(Long catalogId) {
		this.catalogId = catalogId;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
   
	
}
