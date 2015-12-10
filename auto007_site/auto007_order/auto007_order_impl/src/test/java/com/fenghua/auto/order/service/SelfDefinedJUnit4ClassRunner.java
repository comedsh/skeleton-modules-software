package com.fenghua.auto.order.service;

import java.util.Locale;

import org.junit.runners.model.InitializationError;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 
 * Important Runner Class, <br>
 * 
 * For providing some <b>environment based information</b> such as the default Locale before start the JUnit Test
 * 
 * @author shang yang
 *
 * @version 
 *
 * @createTime：2015年12月4日 下午1:07:35 
 *
 */

public class SelfDefinedJUnit4ClassRunner extends SpringJUnit4ClassRunner{
	
	/**
	 * 
	 * @param clazz
	 * @throws InitializationError
	 */
	public SelfDefinedJUnit4ClassRunner(Class<?> clazz) throws InitializationError {
		
		super(clazz);
		
		LocaleContextHolder.setLocale(Locale.CHINA);
		
		// places others' environment based information.
		
	}

}
