package com.fenghua.auto.backend.domain.securtity;

import java.util.Set;


/** 
  *<des>
  *
  * 资源实体 
  * 
  *</des>
  * @author  lijie
  * @date 2015年10月26日
  * @version 
  */
public class Resource {

	private String id; 
	private String name; //功能名称
	private String url; //url 
	
	private Set<Role> roleSet;
	
	public Set<Role> getRoleSet() {
		return roleSet;
	}

	public void setRoleSet(Set<Role> roleSet) {
		this.roleSet = roleSet;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	
}
