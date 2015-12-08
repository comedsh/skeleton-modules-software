package com.fenghua.auto.sku.backend.domain;

import com.fenghua.auto.backend.domain.DomainObject;
import java.util.Date;

public class SkuReply implements DomainObject {
	private static final long serialVersionUID = 1L;
    private Long id;

    private String replyCode;

    private Date createTime;

    private String userId;

    private Long skuCommentId;

    private String comtent;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReplyCode() {
        return replyCode;
    }

    public void setReplyCode(String replyCode) {
        this.replyCode = replyCode == null ? null : replyCode.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Long getSkuCommentId() {
        return skuCommentId;
    }

    public void setSkuCommentId(Long skuCommentId) {
        this.skuCommentId = skuCommentId;
    }

    public String getComtent() {
        return comtent;
    }

    public void setComtent(String comtent) {
        this.comtent = comtent == null ? null : comtent.trim();
    }
}