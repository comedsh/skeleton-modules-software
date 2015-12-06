package com.fenghua.auto.backend.core.utills;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.i18n.LocaleContextHolder;

/**
 * 
 * Gets the messages from the message properties files and handles the I18N 
 * 
 * @author shang yang
 *
 * @version 
 *
 * @createTime：2015年11月26日 上午11:25:37 
 *
 */

public class MessageHelper {
	
	public static final String MESSAGE_SOURCE_NOTFOUND = "NotFound.messagesource";
	
	public static final String MESSAGE_RULE_USER_USERNAME = "Rule.user.username";
	
	/**
	 * Get the messages from message property files which handles the <b>I18N</b> 
	 * 
	 * @author shang yang
	 *
	 * @version 
	 * 
	 * @createTime: 2015年11月26日 上午11:28:03
	 *
	 */
	public static String getMessage(String code, Object... arguments){
		
		String message = null;
		
		try{
		
			message = ApplicationContextHolder.getMessageSource().getMessage(code, arguments, LocaleContextHolder.getLocale() );
			
			// special case for resolving the ReloadableResourceBundleMessageSource case, 
			// if message not found, but message still returned with the value as the same as code.
			if( StringUtils.equals(code, message) ) {
				message = null;
			}
			
		}catch(NoSuchMessageException ex){
			
			return null;
			
		}
		
		return message;
		
	}
	
	/**
	 * 
	 * @author shang yang
	 *
	 * @version 
	 * 
	 * @createTime: 2015年11月26日 下午2:29:53
	 *
	 */
	public static String getMessage(String code){
		
		return MessageHelper.getMessage(code, (Object[]) null);
	}
	
}
