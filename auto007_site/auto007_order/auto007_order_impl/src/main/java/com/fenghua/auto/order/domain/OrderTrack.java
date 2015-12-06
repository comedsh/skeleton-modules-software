package com.fenghua.auto.order.domain;

import com.fenghua.auto.backend.domain.DomainObject;
import java.util.Date;
/**
 * 订单跟踪
 *
 */
public class OrderTrack implements DomainObject {
	private static final long serialVersionUID = 1L;
    private Long id;
    /**
     * 订单id
     */
    private Long orderId;
    /**
     * 订单编号
     */
    private String orderNo;
    /**
     * 订单状态
     */
    private Integer orderStatus;
    /**
     * 订单内容
     */
    private String content;
    /**
     * 跟踪时间
     */
    private Date trackTime;
    /**
     * 跟单人id
     */
    private Long operatorId;
    /**
     * 跟单人姓名
     */
    private String operatorName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getTrackTime() {
        return trackTime;
    }

    public void setTrackTime(Date trackTime) {
        this.trackTime = trackTime;
    }

    public Long getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName == null ? null : operatorName.trim();
    }
}