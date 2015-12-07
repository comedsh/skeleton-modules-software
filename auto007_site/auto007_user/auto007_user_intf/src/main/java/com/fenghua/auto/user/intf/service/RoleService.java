package com.fenghua.auto.user.intf.service;

import java.util.List;

import com.fenghua.auto.user.intf.dto.Role;

/**
 * 角色service
 * 
 * @author chengbin
 * @createTime 2015.11.2
 *
 */
public interface RoleService {
	/**
	 * 通过角色id查询角色
	 * @return
	 */
	public List<Role> getRoleById(Long id);
}
