package com.fenghua.auto.backend.service.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import com.fenghua.auto.backend.core.security.AntUrlPathMatcher;
import com.fenghua.auto.backend.domain.securtity.Resource;
import com.fenghua.auto.backend.domain.securtity.Role;
import com.fenghua.auto.backend.service.security.ResourceService;


/**
 * 资源权限控制
 * 
 * <des>
 * 最核心的地方，就是提供某个资源对应的权限定义，即getAttributes方法返回的结果。  
 *  
 * 此类在初始化时，应该取到所有资源及其对应角色的定义 
 *  
 * 说明：对于方法的spring注入，只能在方法和成员变量里注入， 
 * 如果一个类要进行实例化的时候，不能注入对象和操作对象， 
 * 所以在构造函数里不能进行操作注入的数据。
 *  *</des>
  * @author  lijie
  * @date 2015年10月21日
  * @version 
 **/
public class InvocationSecurityMetadataSourceService implements
		FilterInvocationSecurityMetadataSource {
	private static final Logger logger = LoggerFactory
			.getLogger(InvocationSecurityMetadataSourceService.class);
	
	private static Map<String, Collection<ConfigAttribute>> resourceMap = null;
	private AntUrlPathMatcher urlMatcher = new AntUrlPathMatcher();
	
    @Autowired
	private ResourceService resourceService;

	public InvocationSecurityMetadataSourceService() {
		
	}

    @PostConstruct
	public void loadResourceDefine() {
		resourceMap = new HashMap<String, Collection<ConfigAttribute>>();
		
		 //通过数据库中的信息设置，resouce和role
		List<Resource> resources=resourceService.findAll();
		if(resources == null)
			return;
		for (Resource resource : resources) {
			Set<Role> roles = resource.getRoleSet();
			List<ConfigAttribute> results = new ArrayList<ConfigAttribute>();
			if (roles != null) {
				Iterator<Role> roleIterator = roles.iterator();
				while (roleIterator.hasNext()) {
					Role role = roleIterator.next();
					results.add(new SecurityConfig(role.getName()));
				}
			}
			
			if(resource.getUrl()!=null && !"".equals(resource.getUrl())){
			   logger.info("当前资源{} 对应的 权限 为： {}",resource.getUrl(),results.toString());
			   resourceMap.put(resource.getUrl(), results);  
			}
		 }

	}

	// According to a URL, Find out permission configuration of this URL.
	public Collection<ConfigAttribute> getAttributes(Object object)
			throws IllegalArgumentException {

		logger.debug("getAttributes(Object) - start"); //$NON-NLS-1$  

		// guess object is a URL.
		String url = ((FilterInvocation) object).getRequestUrl();
		Iterator<String> ite = resourceMap.keySet().iterator();
		while (ite.hasNext()) {
			String resURL = ite.next();
			if (urlMatcher.pathMatchesUrl(url, resURL)) { // urlMatcher.pathMatchesUrl(url,
															// resURL)
				Collection<ConfigAttribute> returnCollection = resourceMap.get(resURL);
				if (logger.isDebugEnabled()) {
					logger.debug("getAttributes(Object) - end"); //$NON-NLS-1$  
				}
				return returnCollection;
			}
		}
		if (logger.isDebugEnabled()) {
			logger.debug("getAttributes(Object) - end"); //$NON-NLS-1$  
		}
		return null;
	}

	public boolean supports(Class<?> clazz) {
		return true;
	}

	public Collection<ConfigAttribute> getAllConfigAttributes() {

		return null;
	}

	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}

	
}
