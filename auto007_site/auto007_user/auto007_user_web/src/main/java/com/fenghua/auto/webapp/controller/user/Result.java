package com.fenghua.auto.webapp.controller.user;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** 
  *<des>
  *
  *  控制器与UI交互响应类
  *</des>
  * @author  lijie
  * @date 2015年11月4日
  * @version 
  */
public class Result {
	
	private boolean success = true;

	private String code = "";

	private String msg = "";
	
	public Result() {

	}
	
	public Result(boolean success) {
		this.success = success;
	}
	
	public Result(boolean success, String msg) {
		super();
		this.success = success;
		this.msg = msg;
	}
	
	public Result(boolean success,String code, String msg) {
		super();
		this.success = success;
		this.msg = msg;
		this.code = code;
	}	


	public boolean isSuccess() {
		return success;
	}


	public void setSuccess(boolean success) {
		this.success = success;
	}


	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public boolean equals(Object o) {
		if ((this == o))
			return true;
		if (!(o instanceof Result)) {
			return false;
		}

		Result other = (Result) o;
		return new EqualsBuilder().append(this.success, other.success)
				.append(this.code, other.code)
				.append(this.msg, other.msg).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(code).append(msg).toHashCode();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("success",success).append("code", code).append("msg",msg).toString();
	}
}