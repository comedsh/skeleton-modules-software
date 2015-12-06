package com.fenghua.auto.backend.core.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

/**
 * <des> 
 * 自定义安全拦截器
 * 
 * </des>
 * 
 * @author lijie
 * @date 2015年10月21日
 * @version
 */
public class CustomFilterSecurityInterceptor extends AbstractSecurityInterceptor implements Filter {
	private static final Logger logger = LoggerFactory.getLogger(CustomFilterSecurityInterceptor.class);

	private FilterInvocationSecurityMetadataSource securityMetadataSource;

	@Override
	public Class<? extends Object> getSecureObjectClass() {
		return FilterInvocation.class;
	}

	@Override
	public SecurityMetadataSource obtainSecurityMetadataSource() {

		return this.securityMetadataSource;
	}

	public void setSecurityMetadataSource(FilterInvocationSecurityMetadataSource securityMetadataSource) {

		this.securityMetadataSource = securityMetadataSource;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		logger.debug("doFilter(ServletRequest, ServletResponse, FilterChain) - start"); //$NON-NLS-1$

		FilterInvocation fi = new FilterInvocation(request, response, chain);
		invoke(fi);

		logger.debug("doFilter(ServletRequest, ServletResponse, FilterChain) - end"); //$NON-NLS-1$

	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub

	}

	public void invoke(FilterInvocation fi) throws IOException, ServletException {
		InterceptorStatusToken token = super.beforeInvocation(fi);
		try {
			FilterChain chain = fi.getChain();
			chain.doFilter(fi.getRequest(), fi.getResponse());

		} finally {
			super.afterInvocation(token, null);
		}
	}

}
