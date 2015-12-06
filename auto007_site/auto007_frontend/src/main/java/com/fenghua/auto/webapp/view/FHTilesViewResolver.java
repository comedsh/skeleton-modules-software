/**
 * 
 */
package com.fenghua.auto.webapp.view;

import java.util.Locale;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

/**
 * @author 王直元
 * 
 * 扩展视图处理器，通过改变viewName来实现根据不同语言显示不同的模版
 *
 */
public class FHTilesViewResolver extends TilesViewResolver {

	/**
	 * 
	 */
	public FHTilesViewResolver() {
	}

	@Override
	public View resolveViewName(String viewName, Locale locale) throws Exception {
		String localeViewName = viewName;
		if(locale != null) {
			localeViewName = localeViewName +"_"+ locale.toString();
		}
		
		View view = super.resolveViewName(localeViewName, locale);
		if(view == null) {
			view = super.resolveViewName(viewName, locale);
		}
		
		return view;
	}
}
