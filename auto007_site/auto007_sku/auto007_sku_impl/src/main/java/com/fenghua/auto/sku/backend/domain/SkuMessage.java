package com.fenghua.auto.sku.backend.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import com.fenghua.auto.backend.domain.AbstractDomainObject;
import com.fenghua.auto.backend.domain.DomainObject;
import com.fenghua.auto.backend.domain.mto.MessageTransferObject;

public class SkuMessage extends AbstractDomainObject implements DomainObject, MessageTransferObject {
	@NotNull	
	@Size(min=4, max=20)
    private String code;
	 @NotNull	
	@Size(min=4, max=20)
	private String title;
	@NotNull	
	@Size(min=4, max=20)
	private String brand;
	@NotNull
	@Pattern(regexp="^\\d*[1-9]\\d*$")
	private String stockCount;
	@NotNull	 
	@Pattern(regexp="\\d+.?\\d{1,2}")
	private String price;
	@NotNull
	@Pattern(regexp="\\d+.?\\d{1,2}")
	private String salePrice;
	@NotNull	
	@Size(min=6, max=20)
	private String contentsHtml;
	@NotNull
	private String smallUrl;	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getStockCount() {
		return stockCount;
	}
	public void setStockCount(String stockCount) {
		this.stockCount = stockCount;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(String salePrice) {
		this.salePrice = salePrice;
	}
	public String getContentsHtml() {
		return contentsHtml;
	}
	public void setContentsHtml(String contentsHtml) {
		this.contentsHtml = contentsHtml;
	}
	public String getSmallUrl() {
		return smallUrl;
	}
	public void setSmallUrl(String smallUrl) {
		this.smallUrl = smallUrl;
	}
		
}
