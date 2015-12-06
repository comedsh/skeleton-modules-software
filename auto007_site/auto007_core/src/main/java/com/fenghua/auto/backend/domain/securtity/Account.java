package com.fenghua.auto.backend.domain.securtity;
import java.util.Set;


/**
 * <des> 
 * 
 *   用户信息类
 * 
 * </des>
 * 
 * @author lijie
 * @date 2015年10月26日
 * @version
 */
public class Account {
	private String id;

	private String name;

	private String password;

	private Set<Role> roleSet;// 角色

	public Account() {

	}

	public Account(String name, String password) {

		this.name = name;
		this.password = password;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Role> getRoleSet() {
		return roleSet;
	}

	public void setRoleSet(Set<Role> roleSet) {
		this.roleSet = roleSet;
	}

}
