package com.fenghua.auto.sku.backend.vo;

import java.util.List;

/**
 * <des> </des>
 * 
 * @author lijie
 * @date 2015年12月3日
 * @version
 */
public class OeListVo {
	
	private String brand; //品牌
	private String oe; //oe号
	
	private List<OeListVo> oeItems; //oe列表
	
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getOe() {
		return oe;
	}
	public void setOe(String oe) {
		this.oe = oe;
	}
	public List<OeListVo> getOeItems() {
		return oeItems;
	}
	public void setOeItems(List<OeListVo> oeItems) {
		this.oeItems = oeItems;
	}
	public OeListVo(String brand, String oe) {
		this.brand = brand;
		this.oe = oe;
	}
	public OeListVo(String oe) {
		super();
		this.oe = oe;
	}
	public OeListVo(){}
    
	 
}
