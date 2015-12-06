package com.fenghua.auto.backend.domain.securtity;
/** 
  *<des>
  *
  *
  *  暂用于用户 安全框架动态权限测试，后续根据项目权限需求再进行修改
  * 
  *</des>
  * @author  lijie
  * @date 2015年10月26日
  * @version 
  */
public class Role {
	
	private String id;// 角色编码
	private String name;// 角色名
	
	
	public Role() {
		
	}
	public Role(String id, String name) {
		this.id = id;
		this.name = name;
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
	
	
}
