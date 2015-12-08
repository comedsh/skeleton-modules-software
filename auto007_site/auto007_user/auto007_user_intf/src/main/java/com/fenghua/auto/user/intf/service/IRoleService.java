package com.fenghua.auto.user.intf.service;

import com.fenghua.auto.user.intf.dto.RoleDTO;

/**
 * 角色service
 * 
 * @author chengbin
 * @createTime 2015.11.2
 *
 */
public interface IRoleService {
	/**
	 * 通过角色id查询角色
	 * @return
	 */
	public RoleDTO getRoleById(Long id);
}
