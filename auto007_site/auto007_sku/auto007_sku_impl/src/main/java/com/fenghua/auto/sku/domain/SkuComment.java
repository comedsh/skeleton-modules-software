package com.fenghua.auto.sku.domain;

import java.util.Date;

import com.fenghua.auto.backend.domain.DomainObject;
import com.fenghua.auto.backend.domain.user.User;

public class SkuComment implements DomainObject{
    private Long id;

    private Long skuId;

    private Long orderId;

    private Long orderDetailId;

    private Integer star;

    private String userId;

    private Date createTime;

    private Integer status;

    private  Integer commentOrigin;

    private String comtent;
    
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(Long orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public Integer getStar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public  Integer getCommentOrigin() {
        return commentOrigin;
    }

    public void setCommentOrigin( Integer commentOrigin) {
        this.commentOrigin = commentOrigin;
    }

    public String getComtent() {
        return comtent;
    }

    public void setComtent(String comtent) {
        this.comtent = comtent == null ? null : comtent.trim();
    }

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
    
    
}