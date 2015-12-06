package com.fenghua.auto.backend.domain.core;

import java.util.Date;

import com.fenghua.auto.backend.domain.DomainObject;

public class SysConfig implements DomainObject {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String configName;
	

    private String configValue;

    private Date createdTs;

    private String createdBy;

    private Date lastModifiedBy;

    private String lastModifiedTs;

    public String getConfigName() {
        return configName;
    }

    public void setConfigName(String configName) {
        this.configName = configName == null ? null : configName.trim();
    }

    public String getConfigValue() {
        return configValue;
    }

    public void setConfigValue(String configValue) {
        this.configValue = configValue == null ? null : configValue.trim();
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

    public Date getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(Date lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public String getLastModifiedTs() {
        return lastModifiedTs;
    }

    public void setLastModifiedTs(String lastModifiedTs) {
        this.lastModifiedTs = lastModifiedTs == null ? null : lastModifiedTs.trim();
    }
}