/**
 * 
 */
package com.fenghua.auto.backend.core.exception;

import org.apache.commons.lang.StringUtils;

import com.fenghua.auto.backend.core.utills.MessageHelper;

/**
 * 
 * @author zhiyuan.wang@auto007.com
 *
 */
public class BizException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private String errorCode;
	private String messageCode;
	private Object[] messageArgs;
	
	public BizException(String messageCode, Object... messageArgs) {
		super();
		this.messageCode = messageCode;
		this.messageArgs = messageArgs;
	}
	
	public BizException(String errorCode, String messageCode, Object... messageArgs) {
		super();
		this.errorCode = errorCode;
		this.messageCode = messageCode;
		this.messageArgs = messageArgs;
	}
	public BizException(String errorCode, String message, String messageCode, Object... messageArgs) {
		super(message);
		this.errorCode = errorCode;
		this.messageCode = messageCode;
		this.messageArgs = messageArgs;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getI18nMessage() {
		if(!StringUtils.isBlank(messageCode)) {
			return (!StringUtils.isBlank(errorCode) ? errorCode : "")+MessageHelper.getMessage(messageCode, this.messageArgs);
		}
		return (!StringUtils.isBlank(errorCode) ? errorCode : "")+messageCode;
	}
	public String getMessageCode() {
		return messageCode;
	}
	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}
}
