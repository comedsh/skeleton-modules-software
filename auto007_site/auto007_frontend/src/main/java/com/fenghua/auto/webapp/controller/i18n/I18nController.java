/**
 * 
 */
package com.fenghua.auto.webapp.controller.i18n;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

/**
 * @author nn
 *
 */
@Controller
public class I18nController {
	
	@Autowired
	private CookieLocaleResolver cookieLocaleResolver;
	
	@RequestMapping(value = "/global/i18n", method = { RequestMethod.GET })
	public void cookie(HttpServletRequest request, HttpServletResponse response, Model model,
			@RequestParam(value = "langType", defaultValue = "zh") String langType) throws IOException {
		if (langType.equals("zh")) {
			Locale locale = new Locale("zh", "CN");
			cookieLocaleResolver.setLocale(request, response, locale);
		} else if (langType.equals("ru")) {
			Locale locale = new Locale("ru", "RU");
			cookieLocaleResolver.setLocale(request, response, locale);
		} else if (langType.equals("en")) {
			Locale locale = new Locale("en", "US");
			cookieLocaleResolver.setLocale(request, response, locale);
		} else {
			cookieLocaleResolver.setLocale(request, response, LocaleContextHolder.getLocale());
		}
		response.sendRedirect(request.getHeader("referer"));
	}
}
