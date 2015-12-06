package com.fenghua.auto.backend.domain.user;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fenghua.auto.backend.domain.DomainObject;
/**
 * 用户地址信息
 * @author thinkpad
 *
 */
public class UserAddress implements DomainObject {
	private static final long serialVersionUID = 1L;
    private Long id;

    private Long userId;

    @NotNull	
	@Size(min=2, max=20)
    private String alias;
    @NotNull	
	@Size(min=1, max=200)
    private String detailAddr;
    @NotNull	
	@Size(min=1, max=40)
    private String receiverName;
    @NotNull	
	@Size(min=8, max=20)
    private String receiverMobile;

    private Boolean defaultAddr;

    private Date createdTs;

    private String createdBy;

    private Date lastModifiedTs;

    private String lastModifiedBy;
    @NotNull
    private Long provinceId;
    @NotNull
    private Long cityId;
    @NotNull
    private Long areaId;

    private String provinceName;

    private String cityName;

    private String areaName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias == null ? null : alias.trim();
    }

    public String getDetailAddr() {
        return detailAddr;
    }

    public void setDetailAddr(String detailAddr) {
        this.detailAddr = detailAddr == null ? null : detailAddr.trim();
    }
    
    public String getAddress() {
    	return this.provinceName+this.cityName+this.areaName+this.detailAddr;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName == null ? null : receiverName.trim();
    }

    public String getReceiverMobile() {
        return receiverMobile;
    }

    public void setReceiverMobile(String receiverMobile) {
        this.receiverMobile = receiverMobile == null ? null : receiverMobile.trim();
    }

    public Boolean getDefaultAddr() {
        return defaultAddr;
    }

    public void setDefaultAddr(Boolean defaultAddr) {
        this.defaultAddr = defaultAddr;
    }

    public Date getCreatedTs() {
        return createdTs;
    }

    public void setCreatedTs(Date createdTs) {
        this.createdTs = createdTs;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
    }

    public Date getLastModifiedTs() {
        return lastModifiedTs;
    }

    public void setLastModifiedTs(Date lastModifiedTs) {
        this.lastModifiedTs = lastModifiedTs;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy == null ? null : lastModifiedBy.trim();
    }

    public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName == null ? null : provinceName.trim();
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName == null ? null : cityName.trim();
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName == null ? null : areaName.trim();
    }
}