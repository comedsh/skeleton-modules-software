package com.fenghua.auto.backend.core.security;

import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.util.matcher.RequestMatcher;

/** 
  *<des>
  *</des>
  * @author  lijie
  * @date 2015年11月6日
  * @version 
  */
public class CsrfSecurityRequestMatcher implements RequestMatcher{

	private Pattern allowedMethods = Pattern.compile("^(GET|HEAD|TRACE|OPTIONS)$");
	private AntUrlPathMatcher urlMatcher = new AntUrlPathMatcher();

    private List<String> execludeUrls;

    
    @Override
    public boolean matches(HttpServletRequest request) {
        if (execludeUrls != null && execludeUrls.size() > 0) {
            String servletPath = request.getServletPath();
            for (String url : execludeUrls) {
            	if (urlMatcher.pathMatchesUrl(url, servletPath)){
            		return false;
            	}
            }
        }
        return !allowedMethods.matcher(request.getMethod()).matches();
    }


    public List<String> getExecludeUrls() {
        return execludeUrls;
    }

    public void setExecludeUrls(List<String> execludeUrls) {
        this.execludeUrls = execludeUrls;
    }


}
