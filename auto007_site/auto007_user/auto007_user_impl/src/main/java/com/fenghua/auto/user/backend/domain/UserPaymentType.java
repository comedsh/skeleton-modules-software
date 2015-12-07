package com.fenghua.auto.user.backend.domain;

import java.math.BigDecimal;
import java.util.Date;

import com.fenghua.auto.backend.domain.DomainObject;
/**
 * 支付方式
 * @author chengbin
 *
 */
public class UserPaymentType extends UserPaymentTypeKey  implements DomainObject {
	
	private static final long serialVersionUID = 1L;
	
    private Integer status;

    private Integer duration;

    private BigDecimal debtLimit;

    private Date createdTs;

    private String createdBy;

    private Date lastModifiedTs;

    private String lastModifiedBy;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public BigDecimal getDebtLimit() {
        return debtLimit;
    }

    public void setDebtLimit(BigDecimal debtLimit) {
        this.debtLimit = debtLimit;
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