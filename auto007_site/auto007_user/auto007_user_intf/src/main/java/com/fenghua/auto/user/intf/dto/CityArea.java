package com.fenghua.auto.user.intf.dto;

import com.fenghua.auto.backend.domain.AbstractDomainObject;
import com.fenghua.auto.backend.domain.DomainObject;
import com.fenghua.auto.backend.domain.mto.MessageTransferObject;
/**
 * 行政区
 * @author chengbin
 *
 */
public class CityArea extends AbstractDomainObject implements DomainObject, MessageTransferObject {
	
	private static final long serialVersionUID = 1L;

	private Long id;

    private Long parentId;

    private String name;

    private Short level;

    private String fullPath;

    private String fullName;

    private Boolean available;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Short getLevel() {
        return level;
    }

    public void setLevel(Short level) {
        this.level = level;
    }

    public String getFullPath() {
        return fullPath;
    }

    public void setFullPath(String fullPath) {
        this.fullPath = fullPath == null ? null : fullPath.trim();
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName == null ? null : fullName.trim();
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}