package com.fenghua.auto.backend.domain.validation;

/**
 * @author shang yang
 *
 * @version 
 *
 * @createTime：2015年11月26日 下午7:08:25 
 *
 */

public class DomainValidationException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1995509117399394539L;
	
	public DomainValidationException(String message){
		super(message);
	}
	
	public DomainValidationException(String message, Throwable throwable ){
		super(message, throwable);
	}
	
}
