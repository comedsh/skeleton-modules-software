package com.fenghua.auto.user.intf.dto;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fenghua.auto.backend.domain.AbstractDomainObject;
import com.fenghua.auto.backend.domain.DomainObject;
import com.fenghua.auto.backend.domain.mto.MessageTransferObject;
import com.fenghua.auto.backend.domain.validation.NotDuplicated;

/**
 * 用户实体类
 * @author chengbin
 * @createTime 2015.11.5
 */
public class UserDTO extends AbstractDomainObject implements DomainObject, MessageTransferObject {
	
	private static final long serialVersionUID = 1L;

	private Long id;
	
	@NotNull
	@Size(min=4, max=20)
	@Pattern(regexp="^[a-zA-Z\u4e00-\u9fa5][a-zA-Z0-9\u4e00-\u9fa5]{3,19}$")
	@NotDuplicated( sql = "select count(*) from user where name = ?" )
	private String name;
	
	@NotNull
	@Size(min=6, max=20)
	@Pattern(regexp="^[a-zA-Z]\\w{5,19}$")
	private String password;
	
	@NotNull
	@Size(min=0, max=100)
	@Pattern(regexp="^([a-zA-Z0-9_\\.\\-])+\\@(([a-zA-Z0-9\\-])+\\.)+([a-zA-Z0-9]{2,4})+$")
	@NotDuplicated( sql = "select count(*) from user where email = ?" )
	private String email;
	
	@NotNull
	@Pattern(regexp="^1{1}[34578]{1}[0-9]{9}$")
	@NotDuplicated( sql = "select count(*) from user where mobilephone = ?" )
	private String mobilephone;
	
	private String qqNumber;

	private String wechat;

	private Long roleId;

	private Long userLevelId;

	private Long companyId;
	
	private Short failedLoginTimes;
	
	private Boolean available;
	
	private Date createdTs;

	private String createdBy;
	
	private Date lastModifiedTs;
	
	private String lastModifiedBy;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email == null ? null : email.trim();
	}

	public String getMobilephone() {
		return mobilephone;
	}

	public void setMobilephone(String mobilephone) {
		this.mobilephone = mobilephone == null ? null : mobilephone.trim();
	}

	public String getQqNumber() {
		return qqNumber;
	}

	public void setQqNumber(String qqNumber) {
		this.qqNumber = qqNumber == null ? null : qqNumber.trim();
	}

	public String getWechat() {
		return wechat;
	}

	public void setWechat(String wechat) {
		this.wechat = wechat == null ? null : wechat.trim();
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Long getUserLevelId() {
		return userLevelId;
	}

	public void setUserLevelId(Long userLevelId) {
		this.userLevelId = userLevelId;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public Short getFailedLoginTimes() {
		return failedLoginTimes;
	}

	public void setFailedLoginTimes(Short failedLoginTimes) {
		this.failedLoginTimes = failedLoginTimes;
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		Map map = new HashMap();
		map.put("1", "a");
		map.put("2", "b");
		map.put("g", "c");
		map.put("h", "d");
		for (Object key : map.keySet()) {
			System.out.println(map.get(key));
		}
	}
}