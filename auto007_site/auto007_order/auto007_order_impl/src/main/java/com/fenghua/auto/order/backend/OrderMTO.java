/**
 * 
 */
package com.fenghua.auto.order.backend;

import java.util.ArrayList;

import java.util.List;

import com.fenghua.auto.backend.domain.AbstractDomainObject;
import com.fenghua.auto.backend.domain.mto.LabelError;
import com.fenghua.auto.backend.domain.mto.MessageTransferObject;

/**
 * 
 * @author zhiyuan.wang@auto007.com 
 */
public class OrderMTO extends AbstractDomainObject implements MessageTransferObject {

	private boolean success = true;
	
	private List<String> errorMessages;
	
	private Object data;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	@Override
	public void addErrors(LabelError... errors) {
		this.success = false;
		super.addErrors(errors);
	}

	public void addErrorMessage(String... errorMsgs) {
		this.success = false;
		if(this.errorMessages == null) {
			this.errorMessages = new ArrayList<String>();
		}
		for (String msg : errorMsgs) {
			this.errorMessages.add(msg);
		}
	}
	
	public boolean hasErrorMessage() {
		return this.errorMessages != null && !this.errorMessages.isEmpty();
	}
	
	public String[] getErrorMessages() {
		if(hasErrorMessage()) {
			return this.errorMessages.toArray(new String[this.errorMessages.size()]);
		}
		if(hasError()) {
			this.errorMessages = new ArrayList<String>();
			for (LabelError le : super.getErrors() ) {
				this.errorMessages.add(le.error);
			}
			return this.errorMessages.toArray(new String[this.errorMessages.size()]);
		}
		return null;
	}
	public String getErrorMessage() {
		StringBuffer sb = new StringBuffer();
		String[] errorMsgs = getErrorMessages();
		if(errorMsgs != null && errorMsgs.length > 0) {
			for (String msg : errorMsgs) {
				sb.append(msg).append("；");
			}
		}
		return sb.toString();
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
