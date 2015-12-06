/**
 * 
 */
package com.fenghua.auto.finance.wxpay.service;

import java.io.Serializable;

/**
 * @author Sullivan
 *
 */
public class WXRefundOrder implements Serializable {
	private static final long serialVersionUID = -6461233184406051757L;
    private String orderTradeNo = "";
    private String orderNo = "";
    private String refundOrderNo = "";
    private String refundTradeNo = "";		//微信退款单号
    /**
	 * 单位为分，请注意 
	 */
    private int refundFee; //退款总金额,单位为分,可以做部分退款
    /**
	 * 单位为分，请注意 
	 */
    private int cashFee;	//现金支付金额，单位为分，只能为整数
    /**
	 * 单位为分，请注意 
	 */
    private int cashRefundFee; //现金退款金额，单位为分，只能为整数
    /**
	 * 单位为分，请注意 
	 */
    private int totalFee;	//订单总金额，单位为分，只能为整数，详见支付金额
    
    private boolean success = false;
    private String errorMsg;
	/**
	 * @param orderTradeNo
	 * @param orderNo
	 * @param refundOrderNo
	 * @param refundTradeNo
	 * @param refundFee 单位为分，请注意 
	 * @param cashFee 单位为分，请注意 
	 * @param cashRefundFee 单位为分，请注意 
	 * @param totalFee 单位为分，请注意 
	 */
	public WXRefundOrder(String orderTradeNo, String orderNo, String refundOrderNo, String refundTradeNo, int refundFee,
			int cashFee, int cashRefundFee, int totalFee) {
		super();
		this.orderTradeNo = orderTradeNo;
		this.orderNo = orderNo;
		this.refundOrderNo = refundOrderNo;
		this.refundTradeNo = refundTradeNo;
		this.refundFee = refundFee;
		this.cashFee = cashFee;
		this.cashRefundFee = cashRefundFee;
		this.totalFee = totalFee;
		this.success = true;
	}
	
	public WXRefundOrder(String errorMsg) {
		super();
		this.success = false;
		this.errorMsg = errorMsg;
	}
	
	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
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

	public String getRefundTradeNo() {
		return refundTradeNo;
	}

	public void setRefundTradeNo(String refundTradeNo) {
		this.refundTradeNo = refundTradeNo;
	}
	/**
	 * 单位为分，请注意 
	 */
	public int getRefundFee() {
		return refundFee;
	}
	/**
	 * 单位为分，请注意 
	 */
	public void setRefundFee(int refundFee) {
		this.refundFee = refundFee;
	}
	/**
	 * 单位为分，请注意 
	 */
	public int getCashFee() {
		return cashFee;
	}
	/**
	 * 单位为分，请注意 
	 */
	public void setCashFee(int cashFee) {
		this.cashFee = cashFee;
	}
	/**
	 * 单位为分，请注意 
	 */
	public int getCashRefundFee() {
		return cashRefundFee;
	}
	/**
	 * 单位为分，请注意 
	 */
	public void setCashRefundFee(int cashRefundFee) {
		this.cashRefundFee = cashRefundFee;
	}
	/**
	 * 单位为分，请注意 
	 */
	public int getTotalFee() {
		return totalFee;
	}
	/**
	 * 单位为分，请注意 
	 */
	public void setTotalFee(int totalFee) {
		this.totalFee = totalFee;
	}
}
