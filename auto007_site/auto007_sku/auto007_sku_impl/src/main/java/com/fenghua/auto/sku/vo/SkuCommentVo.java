package com.fenghua.auto.sku.vo;
/** 
  *<des>
  *</des>
  * @author  lijie
  * @date 2015年11月30日
  * @version 
  */
public class SkuCommentVo {

	private String createTime;
	private Integer star;
	private String name;
	private String comtent;
	private String url;
	
	public Integer getStar() {
		return star;
	}
	public void setStar(Integer star) {
		this.star = star;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getComtent() {
		return comtent;
	}
	public void setComtent(String comtent) {
		this.comtent = comtent;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getCreateTime() {
		return createTime;
	}
	
	
}
