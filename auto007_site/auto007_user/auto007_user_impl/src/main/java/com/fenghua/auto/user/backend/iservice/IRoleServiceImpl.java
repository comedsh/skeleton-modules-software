package com.fenghua.auto.user.backend.iservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fenghua.auto.backend.common.utils.BeanMapper;
import com.fenghua.auto.user.backend.service.RoleService;
import com.fenghua.auto.user.intf.dto.RoleDTO;

/**
 * 角色接口实现
 * @author chengbin
 * @createTime 2015.11.2
 *
 */
@Service
public class IRoleServiceImpl implements com.fenghua.auto.user.intf.service.IRoleService {
	
	@Autowired
	private RoleService roleService;

	@Override
	public RoleDTO getRoleById(Long id) {
		return BeanMapper.map(roleService.selectById(id), RoleDTO.class);
	}
	
}
