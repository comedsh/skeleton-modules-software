package com.fenghua.auto.webapp.controller;

import java.util.Date;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.RequestContext;

@Controller
public class IndexController {
	
	@RequestMapping(value = "/")
	public String index(HttpServletRequest request, Model model) throws Exception {
		
		//从后台代码获取国际化信息
        RequestContext requestContext = new RequestContext(request);
        model.addAttribute("index.banner", requestContext.getMessage("index.banner"));
		
		return "web.index_view";
	}

	public static void main(String[] agrs) {
		System.out.println(new Date());
		TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
		System.out.println(new Date());
	}
}
