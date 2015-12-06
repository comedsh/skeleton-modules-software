package com.fenghua.auto.backend.core.security;

import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

/** 
  *<des>
  *</des>
  * @author  lijie
  * @date 2015年10月26日
  * @version 
  */
public class AntUrlPathMatcher {
	  private boolean requiresLowerCaseUrl = true;
	  private PathMatcher pathMatcher = new AntPathMatcher();
	  
	  public AntUrlPathMatcher()
	  {
	    this(true);
	  }
	  
	  public AntUrlPathMatcher(boolean requiresLowerCaseUrl)
	  {
	    this.requiresLowerCaseUrl = requiresLowerCaseUrl;
	  }
	  
	  public Object compile(String path)
	  {
	    if (this.requiresLowerCaseUrl) {
	      return path.toLowerCase();
	    }
	    return path;
	  }
	  
	  public void setRequiresLowerCaseUrl(boolean requiresLowerCaseUrl)
	  {
	    this.requiresLowerCaseUrl = requiresLowerCaseUrl;
	  }
	  
	  public boolean pathMatchesUrl(Object path, String url)
	  {
	    return this.pathMatcher.match((String)path, url);
	  }
	  
	  public String getUniversalMatchPattern()
	  {
	    return "/**";
	  }
	  
	  public boolean requiresLowerCaseUrl()
	  {
	    return this.requiresLowerCaseUrl;
	  }
	  
	  public String toString()
	  {
	    return getClass().getName() + "[requiresLowerCase='" + this.requiresLowerCaseUrl + "']";
	  }
}
