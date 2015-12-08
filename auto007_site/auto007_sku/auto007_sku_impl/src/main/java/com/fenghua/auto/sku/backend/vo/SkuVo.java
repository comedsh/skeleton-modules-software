package com.fenghua.auto.sku.backend.vo;

import java.util.List;

/** 
  *<des>
  *卖家管理SKU界面展示
  *</des>
  * @author  lijie
  * @date 2015年12月1日
  * @version 
  */
public class SkuVo {
	
	private Long id; //sku id
	private String createTime; //发布时间
	private String url;  //商品图片
	private String brand; //品牌
	private String name;  //名称
	private String skuNo; //Sku编号
	private String price; //售价
	
	private List<String> catalogList; //商品类目
	private Integer status;//商品状态
	private String statusName; //商品状态名称
	private String defaultOe; //oe号
	private Integer oeSize; //oe列表大小
	
	private boolean edit; //编辑
	private boolean delete; //删除
	private boolean shelfUp; //上架
	private boolean shelfDown; //下架
	
		
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSkuNo() {
		return skuNo;
	}
	public void setSkuNo(String skuNo) {
		this.skuNo = skuNo;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	

	public List<String> getCatalogList() {
		return catalogList;
	}
	public void setCatalogList(List<String> catalogList) {
		this.catalogList = catalogList;
	}
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	public String getDefaultOe() {
		return defaultOe;
	}
	public void setDefaultOe(String defaultOe) {
		this.defaultOe = defaultOe;
	}
	public Integer getOeSize() {
		return oeSize;
	}
	public void setOeSize(Integer oeSize) {
		this.oeSize = oeSize;
	}
	public boolean isEdit() {
		return edit;
	}
	public void setEdit(boolean edit) {
		this.edit = edit;
	}
	public boolean isDelete() {
		return delete;
	}
	public void setDelete(boolean delete) {
		this.delete = delete;
	}
	public boolean isShelfUp() {
		return shelfUp;
	}
	public void setShelfUp(boolean shelfUp) {
		this.shelfUp = shelfUp;
	}
	public boolean isShelfDown() {
		return shelfDown;
	}
	public void setShelfDown(boolean shelfDown) {
		this.shelfDown = shelfDown;
	}
	

}
