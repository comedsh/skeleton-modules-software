package com.fenghua.auto.order.domain;

import com.fenghua.auto.backend.domain.DomainObject;
import java.util.Date;
/**
 * 物流信息
 *
 */
public class OrderTransport implements DomainObject {
	private static final long serialVersionUID = 1L;
    private Long id;

    private Long orderId;

    private String orderNo;

    private String waybillNo;

    private Long logisticsComId;

    private String logisticsComCode;

    private String logisticsComName;

    private Integer status;

    private Long entryId;

    private Date entryTime;

    private Long updateId;

    private Date updateTime;

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

    public String getWaybillNo() {
        return waybillNo;
    }

    public void setWaybillNo(String waybillNo) {
        this.waybillNo = waybillNo == null ? null : waybillNo.trim();
    }

    public Long getLogisticsComId() {
        return logisticsComId;
    }

    public void setLogisticsComId(Long logisticsComId) {
        this.logisticsComId = logisticsComId;
    }

    public String getLogisticsComCode() {
        return logisticsComCode;
    }

    public void setLogisticsComCode(String logisticsComCode) {
        this.logisticsComCode = logisticsComCode == null ? null : logisticsComCode.trim();
    }

    public String getLogisticsComName() {
        return logisticsComName;
    }

    public void setLogisticsComName(String logisticsComName) {
        this.logisticsComName = logisticsComName == null ? null : logisticsComName.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public Long getUpdateId() {
        return updateId;
    }

    public void setUpdateId(Long updateId) {
        this.updateId = updateId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}