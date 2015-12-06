package com.fenghua.auto.backend.core.utills;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

/**
 * @author shang yang
 *
 * @version 
 *
 * @createTime：2015年11月26日 上午10:08:49 
 *
 */

@Component
public class ApplicationContextHolder implements ApplicationContextAware{
	
	private static ApplicationContext context;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		
		context = applicationContext;
		
	}
	
	public static ApplicationContext getApplicationContext(){
		
		return context;
	
	}
	
	/**
	 * this method is DO NOT public provided
	 * 
	 * @author shang yang
	 *
	 * @version 
	 * 
	 * @createTime: 2015年11月26日 上午11:00:23
	 *
	 */
	public static Object getBean( String beanName ){
		
		return context.getBean( beanName );
	
	}
	
	public static MessageSource getMessageSource(){
		
		return (MessageSource) ApplicationContextHolder.getBean("messageSource");
		
	}
	
}
