package com.fenghua.auto.backend.service.security;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.fenghua.auto.backend.domain.securtity.Resource;

/** 
  *<des>
  * 
  *  资源服务类
  *  
  *   暂用于用户 安全框架动态权限测试，后续根据项目权限需求再进行修改
  *  
  *</des>
  * @author  lijie
  * @date 2015年10月26日
  * @version 
  */
@Service
public class ResourceService {

	public List<Resource> findAll() {
		return null;
	}
	
	
	@PreAuthorize("hasRole('admin')")
	public void addResource(){
		
	}
	
	
}
