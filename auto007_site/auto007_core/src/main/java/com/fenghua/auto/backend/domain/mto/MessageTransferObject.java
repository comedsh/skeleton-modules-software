package com.fenghua.auto.backend.domain.mto;


/**
 * 
 * indicates the availability of message transferring
 * 
 * including the errors and messages
 * 
 * @author shang yang
 *
 * @version 
 *
 * @createTime：2015年11月26日 下午6:37:55 
 *
 */

public interface MessageTransferObject {
	
	public LabelError[] getErrors();
	
	public boolean hasError();

	public LabelMessage[] getMessages();
	
	public boolean hasMessage();
	
	public LabelWarning[] getWarnings();
	
	public boolean hasWarning();
	
}
