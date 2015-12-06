package com.fenghua.auto.backend.domain.mto;


/**
 * 
 * translate the 
 * 
 * @author shang yang
 *
 * @version 
 *
 * @createTime：2015年11月23日 下午2:46:14 
 *
 */

public class LabelError {
		
	public String field;
	
	public String error;

	public LabelError(String field, String error) {
		super();
		this.field = field;
		this.error = error;
	}

	public LabelError() {
		super();
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
	
}
