/**
 * 
 */
package com.fenghua.auto.finance.wxpay.service;

import java.io.Serializable;

/**
 * @author Sullivan
 *
 */
public class WXPrepayOrder implements Serializable {
	private static final long serialVersionUID = 8137320590334086712L;
    private String tradeType = "";			//是——调用接口提交的交易类型，取值如下：JSAPI，NATIVE，APP
    private String codeUrl = "";			//trade_type为NATIVE是有返回，可将该参数值生成二维码展示出来进行扫码支付
    private String transactionId = "";
    private String orderNo = "";
    private String attach = "";
	
	public WXPrepayOrder(String tradeType, String codeUrl, String transactionId, String orderNo, String attach) {
		super();
		this.tradeType = tradeType;
		this.codeUrl = codeUrl;
		this.transactionId = transactionId;
		this.orderNo = orderNo;
		this.attach = attach;
	}

	public String getTradeType() {
		return tradeType;
	}

	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}

	public String getCodeUrl() {
		return codeUrl;
	}

	public void setCodeUrl(String codeUrl) {
		this.codeUrl = codeUrl;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getAttach() {
		return attach;
	}

	public void setAttach(String attach) {
		this.attach = attach;
	}
}
