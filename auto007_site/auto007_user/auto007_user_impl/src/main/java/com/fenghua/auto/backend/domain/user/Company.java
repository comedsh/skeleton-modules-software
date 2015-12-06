package com.fenghua.auto.backend.domain.user;

import java.util.Date;

import com.fenghua.auto.backend.domain.DomainObject;
/**
 * 公司属性
 * @author chengbin
 *
 */
public class Company implements DomainObject {
	
	private static final long serialVersionUID = 1L;
	
    private Long id;

    private String compnayName;

    private Long cityAreaId;

    private String detailAddress;

	private String headcount;

    private String businessLicence;

    private String taxpayerLicence;

    private String taxpayerNumber;

    private String contactsName;

    private String contactsPhone;

    private String contactsMobile;

    private String contactsDept;

    private String contactsEmail;

    private Date createdTs;

    private String createdBy;

    private Date lastModifiedTs;

    private String lastModifiedBy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompnayName() {
        return compnayName;
    }

    public void setCompnayName(String compnayName) {
        this.compnayName = compnayName == null ? null : compnayName.trim();
    }

    public Long getCityAreaId() {
        return cityAreaId;
    }

    public void setCityAreaId(Long cityAreaId) {
        this.cityAreaId = cityAreaId;
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress == null ? null : detailAddress.trim();
    }

    public void setHeadcount(String headcount) {
		this.headcount = headcount;
	}

    public String getBusinessLicence() {
        return businessLicence;
    }

    public void setBusinessLicence(String businessLicence) {
        this.businessLicence = businessLicence == null ? null : businessLicence.trim();
    }

    public String getTaxpayerLicence() {
        return taxpayerLicence;
    }

    public void setTaxpayerLicence(String taxpayerLicence) {
        this.taxpayerLicence = taxpayerLicence == null ? null : taxpayerLicence.trim();
    }

    public String getTaxpayerNumber() {
        return taxpayerNumber;
    }

    public void setTaxpayerNumber(String taxpayerNumber) {
        this.taxpayerNumber = taxpayerNumber == null ? null : taxpayerNumber.trim();
    }

    public String getContactsName() {
        return contactsName;
    }

    public void setContactsName(String contactsName) {
        this.contactsName = contactsName == null ? null : contactsName.trim();
    }

    public String getContactsPhone() {
        return contactsPhone;
    }

    public void setContactsPhone(String contactsPhone) {
        this.contactsPhone = contactsPhone == null ? null : contactsPhone.trim();
    }

    public String getContactsMobile() {
        return contactsMobile;
    }

    public void setContactsMobile(String contactsMobile) {
        this.contactsMobile = contactsMobile == null ? null : contactsMobile.trim();
    }

    public String getContactsDept() {
        return contactsDept;
    }

    public void setContactsDept(String contactsDept) {
        this.contactsDept = contactsDept == null ? null : contactsDept.trim();
    }

    public String getContactsEmail() {
        return contactsEmail;
    }

    public void setContactsEmail(String contactsEmail) {
        this.contactsEmail = contactsEmail == null ? null : contactsEmail.trim();
    }

    public Date getCreatedTs() {
        return createdTs;
    }

    public void setCreatedTs(Date createdTs) {
        this.createdTs = createdTs;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
    }

    public Date getLastModifiedTs() {
        return lastModifiedTs;
    }

    public void setLastModifiedTs(Date lastModifiedTs) {
        this.lastModifiedTs = lastModifiedTs;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy == null ? null : lastModifiedBy.trim();
    }
}