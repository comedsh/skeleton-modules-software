package com.fenghua.auto.sku.domain;

import java.util.Date;

import com.fenghua.auto.backend.domain.DomainObject;

public class SkuImages implements DomainObject{
    private Long id;

    private String title;

    private Integer sortNo;

    private Date createTime;

    private Date updateTime;

    private Long skuId;
    
    private String url;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getSortNo() {
        return sortNo;
    }

    public void setSortNo(Integer sortNo) {
        this.sortNo = sortNo;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }
    

    public String getUrl() {
        return url;
    }


    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }


}