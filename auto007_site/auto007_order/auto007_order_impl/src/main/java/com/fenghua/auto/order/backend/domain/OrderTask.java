package com.fenghua.auto.order.backend.domain;

import com.fenghua.auto.backend.domain.DomainObject;
import java.util.Date;
/**
 * 订单定时任务
 *
 */
public class OrderTask implements DomainObject {
	private static final long serialVersionUID = 1L;
    private Long taskId;
    /**
     * 订单id
     */
    private Long orderId;
    /**
     * 订单编号
     */
    private String orderNo;
    /**
     * 任务类型
     */
    private Integer type;
    /**
     * 任务状态
     */
    private Integer status;
    /**
     * 开始时间
     */
    private Date beginTime;
    /**
     * 过期时间
     */
    private Date expireTime;
    /**
     * 处理类型
     */
    private Integer handleType;
    /**
     * 处理器
     */
    private String handler;
    /**
     * 执行次数
     */
    private Integer handleTimes;
    /**
     * 创建人
     */
    private Long entryId;
    /**
     * 创建时间
     */
    private Date entryTime;
    /**
     * 执行人
     */
    private Long processorId;
    /**
     * 执行时间
     */
    private Date processTime;

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    public Integer getHandleType() {
        return handleType;
    }

    public void setHandleType(Integer handleType) {
        this.handleType = handleType;
    }

    public String getHandler() {
        return handler;
    }

    public void setHandler(String handler) {
        this.handler = handler == null ? null : handler.trim();
    }

    public Integer getHandleTimes() {
        return handleTimes;
    }

    public void setHandleTimes(Integer handleTimes) {
        this.handleTimes = handleTimes;
    }

    public Long getEntryId() {
        return entryId;
    }

    public void setEntryId(Long entryId) {
        this.entryId = entryId;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public Long getProcessorId() {
        return processorId;
    }

    public void setProcessorId(Long processorId) {
        this.processorId = processorId;
    }

    public Date getProcessTime() {
        return processTime;
    }

    public void setProcessTime(Date processTime) {
        this.processTime = processTime;
    }
}