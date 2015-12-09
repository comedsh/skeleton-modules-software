package com.fenghua.auto.user.backend.domain;

import com.fenghua.auto.backend.domain.DomainObject;
import java.util.Date;

public class VatInvoiceCertificate implements DomainObject {
	private static final long serialVersionUID = 1L;
    private Long id;

    private Long userId;

    private String companyName;

    private String taxpayerNumber;

    private String bankName;

    private String bankAccount;

    private String registerAddress;

    private String registerPhone;

    private String taxRegCertificate;

    private String taxpayerCertificate;

    private Boolean reviewed;

    private String createdBy;

    private Date createdTs;

    private String modifiedBy;

    private Date modifiedTs;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getTaxpayerNumber() {
        return taxpayerNumber;
    }

    public void setTaxpayerNumber(String taxpayerNumber) {
        this.taxpayerNumber = taxpayerNumber == null ? null : taxpayerNumber.trim();
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName == null ? null : bankName.trim();
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount == null ? null : bankAccount.trim();
    }

    public String getRegisterAddress() {
        return registerAddress;
    }

    public void setRegisterAddress(String registerAddress) {
        this.registerAddress = registerAddress == null ? null : registerAddress.trim();
    }

    public String getRegisterPhone() {
        return registerPhone;
    }

    public void setRegisterPhone(String registerPhone) {
        this.registerPhone = registerPhone == null ? null : registerPhone.trim();
    }

    public String getTaxRegCertificate() {
        return taxRegCertificate;
    }

    public void setTaxRegCertificate(String taxRegCertificate) {
        this.taxRegCertificate = taxRegCertificate == null ? null : taxRegCertificate.trim();
    }

    public String getTaxpayerCertificate() {
        return taxpayerCertificate;
    }

    public void setTaxpayerCertificate(String taxpayerCertificate) {
        this.taxpayerCertificate = taxpayerCertificate == null ? null : taxpayerCertificate.trim();
    }

    public Boolean getReviewed() {
        return reviewed;
    }

    public void setReviewed(Boolean reviewed) {
        this.reviewed = reviewed;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
    }

    public Date getCreatedTs() {
        return createdTs;
    }

    public void setCreatedTs(Date createdTs) {
        this.createdTs = createdTs;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy == null ? null : modifiedBy.trim();
    }

    public Date getModifiedTs() {
        return modifiedTs;
    }

    public void setModifiedTs(Date modifiedTs) {
        this.modifiedTs = modifiedTs;
    }
}