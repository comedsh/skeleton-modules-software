/**
 * 
 */
package com.fenghua.auto.finance.wxpay.service;

import java.io.Serializable;

/**
 * @author Sullivan
 *
 */
public class WXRefundOrderParam implements Serializable {
	private static final long serialVersionUID = -6461233184406051757L;
	private String deviceInfo = "WEB";
	private String orderTradeNo;
	private String orderNo;
	private String refundOrderNo;
	/**
	 * 单位为分，请注意 
	 */
	private int totalAmount;
	/**
	 * 单位为分，请注意 
	 */
	private int refundAmount;
	private String operatorId;
	private String refundFeeType = "CNY";
	
	/**
	 * @param orderNo
	 * @param orderTradeNo
	 * @param refundOrderNo
	 * @param totalAmount 单位为分，请注意 
	 * @param refundAmount 单位为分，请注意 
	 * @param operatorId
	 */
	public WXRefundOrderParam(String orderNo, String orderTradeNo, String refundOrderNo, int totalAmount,
			int refundAmount, String operatorId) {
		super();
		this.orderNo = orderNo;
		this.orderTradeNo = orderTradeNo;
		this.refundOrderNo = refundOrderNo;
		this.totalAmount = totalAmount;
		this.refundAmount = refundAmount;
		this.operatorId = operatorId;
	}
	
	public String getDeviceInfo() {
		return deviceInfo;
	}
	public void setDeviceInfo(String deviceInfo) {
		this.deviceInfo = deviceInfo;
	}
	public String getOrderTradeNo() {
		return orderTradeNo;
	}
	public void setOrderTradeNo(String orderTradeNo) {
		this.orderTradeNo = orderTradeNo;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getRefundOrderNo() {
		return refundOrderNo;
	}
	public void setRefundOrderNo(String refundOrderNo) {
		this.refundOrderNo = refundOrderNo;
	}
	/**
	 * 单位为分，请注意 
	 */
	public int getTotalAmount() {
		return totalAmount;
	}
	/**
	 * 单位为分，请注意 
	 */
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
	/**
	 * 单位为分，请注意 
	 */
	public int getRefundAmount() {
		return refundAmount;
	}
	/**
	 * 单位为分，请注意 
	 */
	public void setRefundAmount(int refundAmount) {
		this.refundAmount = refundAmount;
	}
	public String getOperatorId() {
		return operatorId;
	}
	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}
	public String getRefundFeeType() {
		return refundFeeType;
	}
	public void setRefundFeeType(String refundFeeType) {
		this.refundFeeType = refundFeeType;
	}
}
