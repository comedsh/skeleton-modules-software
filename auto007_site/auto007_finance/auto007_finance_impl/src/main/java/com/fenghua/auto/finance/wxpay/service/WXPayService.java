/**
 * 
 */
package com.fenghua.auto.finance.wxpay.service;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fenghua.auto.finance.wxpay.sdk.WXPay;
import com.fenghua.auto.finance.wxpay.sdk.common.Util;
import com.fenghua.auto.finance.wxpay.sdk.protocol.pay_protocol.ScanPayReqData;
import com.fenghua.auto.finance.wxpay.sdk.protocol.pay_protocol.ScanPayResData;
import com.fenghua.auto.finance.wxpay.sdk.protocol.pay_query_protocol.ScanPayQueryResData;

/**
 * @author Sullivan Wang
 *
 */
@Service
public class WXPayService {

	private static final Logger logger = LoggerFactory.getLogger(WXPayService.class);
	@Value("${wxpay.key}")
	private String key;
	@Value("${wxpay.appid}")
	private String appid;
	@Value("${wxpay.certPath}")
	private String certPath;
	@Value("${wxpay.mchid}")
	private String mchid;
	@Value("${wxpay.callbackUrl}")
	private String callbackUrl;
	
	public void init() {
		WXPay.initSDKConfiguration(key, appid, mchid, "", certPath, mchid, callbackUrl);
	}

	public WXPrepayOrder genJSAPIPrepayOrder(WXPrepayOrderParam param) {
		WXPrepayOrder prepayOrder = null;
		
		ScanPayReqData data = new ScanPayReqData(param.getDeviceInfo(), 
				param.getSkuName(), param.getSkuDetail(), 
				param.getAttach(), param.getPayOrderNo(), param.getPayAmount(), 
				param.getClientIP(), param.getNotifyUrl(), param.getTradeType(), 
				param.getProductId(),param.getTimeStart(),param.getTimeExpire());
		
		logger.info("PayOrderNo："+param.getPayOrderNo()+" start gen prepay order");
		try {
			ScanPayResData resData = (ScanPayResData) Util.getObjectFromXML(WXPay.requestScanPayService(data), ScanPayResData.class);
			if(resData != null) {
				if("SUCCESS".equals(resData.getReturn_code())) {
					if("SUCCESS".equals(resData.getResult_code())) {
						prepayOrder = new WXPrepayOrder(resData.getTrade_type(), 
								resData.getCode_url(), resData.getTransaction_id(),
								resData.getOut_trade_no(), resData.getAttach());
					} else {
						logger.error("PayOrderNo："+param.getPayOrderNo()+" gen prepay order error: "+resData.getErr_code()+" "+resData.getErr_code_des());
					}
				} else {
					logger.error("PayOrderNo："+param.getPayOrderNo()+" gen prepay order error: "+resData.getReturn_msg());
				}
			} else {
				logger.error("PayOrderNo："+param.getPayOrderNo()+" gen prepay order error: none ");
			}
		} catch (Exception e) {
			logger.error("PayOrderNo："+param.getPayOrderNo()+" gen prepay order error: " + e.getMessage(), e);
		}
		logger.error("PayOrderNo："+param.getPayOrderNo()+" end gen prepay order ");
		return prepayOrder;
	}
	
	public boolean payResultCallback(String data) {
		ScanPayQueryResData resData = (ScanPayQueryResData) Util.getObjectFromXML(data, ScanPayQueryResData.class);
		if(resData != null) {
			if(!StringUtils.isBlank(resData.getOut_trade_no()) && !StringUtils.isBlank(resData.getTransaction_id()) && NumberUtils.toDouble(resData.getTotal_fee()) > 0) {
//				handlePaySuccess(resData.getOut_trade_no(), resData.getTransaction_id(), NumberUtils.toDouble(resData.getTotal_fee())/100);
				return true;
			}
		}
		return false;
	}
	
	/*public WXRefundOrder genRefund(WXRefundOrderParam param) {
		WXRefundOrder refundOrder = null;
		
		RefundReqData reqData = new RefundReqData(
				param.getOrderTradeNo(), 
				param.getOrderNo(),
				param.getDeviceInfo(), 
				param.getRefundOrderNo(), 
				param.getTotalAmount(), 
				param.getRefundAmount(), 
				param.getOperatorId(), 
				param.getRefundFeeType());
		logger.info("OrderNo："+param.getOrderNo()+" start gen wx refund order");
		try {
			RefundResData resData = WXPay.requestRefundService(reqData);
			if(resData != null) {
				if("SUCCESS".equals(resData.getReturn_code())) {
					if("SUCCESS".equals(resData.getResult_code())) {
						refundOrder = new WXRefundOrder(
								resData.getTransaction_id(), 
								resData.getOut_trade_no(), 
								resData.getOut_refund_no(), 
								resData.getRefund_id(), 
								NumberUtils.toInt(resData.getRefund_fee()), 
								NumberUtils.toInt(resData.getCash_fee()), 
								NumberUtils.toInt(resData.getCash_refund_fee()), 
								NumberUtils.toInt(resData.getTotal_fee()));
					} else {
						refundOrder = new WXRefundOrder(resData.getErr_code()+" "+resData.getErr_code_des());
						logger.info("OrderNo："+param.getOrderNo()+" gen wx refund order error: "+resData.getErr_code()+" "+resData.getErr_code_des());
					}
				} else {
					refundOrder = new WXRefundOrder(resData.getReturn_msg());
					logger.info("OrderNo："+param.getOrderNo()+" gen wx refund order error: "+resData.getReturn_msg());
				}
			} else {
				refundOrder = new WXRefundOrder("无返回数据！");
				logger.info("OrderNo："+param.getOrderNo()+" gen wx refund order error: none ");
			}
		} catch (Exception e) {
			refundOrder = new WXRefundOrder("支付异常！"+e.getMessage());
			logger.error("OrderNo："+param.getOrderNo()+" gen wx refund order error: " + e.getMessage(), e);
		}
		logger.info("OrderNo："+param.getOrderNo()+" end gen wx refund order ");
		return refundOrder;
	}*/
}
