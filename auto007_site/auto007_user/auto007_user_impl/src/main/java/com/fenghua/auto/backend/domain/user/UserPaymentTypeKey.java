package com.fenghua.auto.backend.domain.user;

import com.fenghua.auto.backend.domain.DomainObject;
/**
 * 支付方式的关联
 * @author chengbin
 *
 */
public class UserPaymentTypeKey implements DomainObject {
	
	private static final long serialVersionUID = 1L;
	
    private Long paymenttypeId;

    private Long userId;

    public Long getPaymenttypeId() {
        return paymenttypeId;
    }

    public void setPaymenttypeId(Long paymenttypeId) {
        this.paymenttypeId = paymenttypeId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}