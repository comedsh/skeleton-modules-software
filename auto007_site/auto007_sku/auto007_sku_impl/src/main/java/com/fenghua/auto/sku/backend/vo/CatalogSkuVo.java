package com.fenghua.auto.sku.backend.vo;

/**
 * <des> 
 * 
 * 商品类目--商品关系实体
 * </des>
 * 
 * @author lijie
 * @date 2015年12月2日
 * @version
 */
public class CatalogSkuVo {

	private Long id;

	private String code;

	private String name;

	private Integer sortNo;

	private Long skuId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSortNo() {
		return sortNo;
	}

	public void setSortNo(Integer sortNo) {
		this.sortNo = sortNo;
	}

	public Long getSkuId() {
		return skuId;
	}

	public void setSkuId(Long skuId) {
		this.skuId = skuId;
	}

}
