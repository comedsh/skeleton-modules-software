/**
 * 
 */
package com.fenghua.auto.finance.wxpay.service;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fenghua.auto.finance.wxpay.sdk.common.Configure;

/**
 * @author Sullivan
 *
 */
public class WXPrepayOrderParam implements Serializable {
	private static final long serialVersionUID = -6461233184406051757L;
	private String deviceInfo = "WEB";
	/**
	 * 商品名称
	 */
	private String skuName;
	/**
	 * 商品明细
	 */
	private String skuDetail;
	private String attach;
	/**
	 * 产品ID， NATIVE 支付必填
	 */
	private String productId;
	
	/**
	 * 开始时间 
	 */
	private String timeStart;
	/**
	 * 过期时间  默认半个小时
	 */
	private String timeExpire;
	/**
	 * 支付订单号
	 */
	private String payOrderNo;
	/**
	 * 单位为分，请注意 
	 */
	private int payAmount;
	private String clientIP;
	private String notifyUrl = Configure.getCallbackUrl();
	private String tradeType = "NATIVE";
	
	/**
	 * 默认有效期30分钟
	 * @param productId  产品ID
	 * @param skuName    商品名称内容等
	 * @param skuDetail  商品明细信息
	 * @param payOrderNo 支付单号
	 * @param payAmount  支付金额   单位：分
	 */
	public WXPrepayOrderParam(String productId, String skuName, String skuDetail, String payOrderNo, int payAmount, String clientIP) {
		super();
		this.productId = productId;
		this.skuName = skuName;
		this.skuDetail = skuDetail;
		this.payOrderNo = payOrderNo;
		this.payAmount = payAmount;
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = new Date();
		Date date2 = new Date(date.getTime() + ((30*60*1000)));
		this.timeStart = df.format(date);
		this.timeExpire = df.format(date2);
		this.clientIP = clientIP;
	}
	public WXPrepayOrderParam(String productId, String skuName, String skuDetail, String payOrderNo, int payAmount,
			String timeStart, String timeExpire, String clientIP) {
		super();
		this.productId = productId;
		this.skuName = skuName;
		this.skuDetail = skuDetail;
		this.payOrderNo = payOrderNo;
		this.payAmount = payAmount;
		this.timeStart = timeStart;
		this.timeExpire = timeExpire;
		this.clientIP = clientIP;
	}
	public String getDeviceInfo() {
		return deviceInfo;
	}
	public void setDeviceInfo(String deviceInfo) {
		this.deviceInfo = deviceInfo;
	}
	public String getSkuName() {
		return skuName;
	}
	public void setSkuName(String skuName) {
		this.skuName = skuName;
	}
	public String getSkuDetail() {
		return skuDetail;
	}
	public void setSkuDetail(String skuDetail) {
		this.skuDetail = skuDetail;
	}
	public String getAttach() {
		return attach;
	}
	public void setAttach(String attach) {
		this.attach = attach;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getTimeStart() {
		return timeStart;
	}
	public void setTimeStart(String timeStart) {
		this.timeStart = timeStart;
	}
	public String getTimeExpire() {
		return timeExpire;
	}
	public void setTimeExpire(String timeExpire) {
		this.timeExpire = timeExpire;
	}
	public String getPayOrderNo() {
		return payOrderNo;
	}
	public void setPayOrderNo(String payOrderNo) {
		this.payOrderNo = payOrderNo;
	}
	public int getPayAmount() {
		return payAmount;
	}
	public void setPayAmount(int payAmount) {
		this.payAmount = payAmount;
	}
	public String getClientIP() {
		return clientIP;
	}
	public void setClientIP(String clientIP) {
		this.clientIP = clientIP;
	}
	public String getNotifyUrl() {
		return notifyUrl;
	}
	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}
	public String getTradeType() {
		return tradeType;
	}
	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}
}
