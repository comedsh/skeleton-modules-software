package com.fenghua.auto.user.intf.dto;

import java.sql.Timestamp;

import com.fenghua.auto.backend.domain.DomainObject;

public class ResetPassRequestDTO implements DomainObject{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2727145844736069844L;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getCertificateCode() {
		return certificateCode;
	}
	public void setCertificateCode(String certificateCode) {
		this.certificateCode = certificateCode;
	}
	public Timestamp getValidTo() {
		return validTo;
	}
	public void setValidTo(Timestamp validTo) {
		this.validTo = validTo;
	}
	private Long userId;
	private String certificateCode;
	private Timestamp validTo;
}
