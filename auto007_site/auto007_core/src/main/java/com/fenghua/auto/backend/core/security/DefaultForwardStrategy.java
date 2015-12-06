package com.fenghua.auto.backend.core.security;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.web.RedirectStrategy;

/** 
 *<des>
 *
 *  request forward 
 *</des>
 * @author  lijie
 * @date 2015年11月16日
 * @version 
 */

public class DefaultForwardStrategy implements RedirectStrategy {

	private static final Log logger = LogFactory.getLog(RedirectStrategy.class);


	private boolean contextRelative = false;
   

    public void sendRedirect(HttpServletRequest request, HttpServletResponse response, String url) throws IOException {
        	
    	String forwardUrl = calculateRedirectUrl(request.getContextPath(), url);
        forwardUrl = response.encodeRedirectURL(forwardUrl);    
        logger.debug("Forward to '" + forwardUrl + "'");
     
        try {      
			request.getRequestDispatcher(forwardUrl).forward(request, response);
		} catch (ServletException e) {
			logger.error(throwable2String(e));
		}
    }

    private String calculateRedirectUrl(String contextPath, String url) {
        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            if (contextRelative) {
                return url;
            } else {
                return contextPath + url;
            }
        }

        if (!contextRelative) {
            return url;
        }

        url = url.substring(url.indexOf("://") + 3); // strip off protocol
        url = url.substring(url.indexOf(contextPath) + contextPath.length());

        if (url.length() > 1 && url.charAt(0) == '/') {
            url = url.substring(1);
        }

        return url;
    }

    public void setContextRelative(boolean useRelativeContext) {
        this.contextRelative = useRelativeContext;
    }

	private  String throwable2String(Throwable e) {
		StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        return sw.toString();
	} 
}
