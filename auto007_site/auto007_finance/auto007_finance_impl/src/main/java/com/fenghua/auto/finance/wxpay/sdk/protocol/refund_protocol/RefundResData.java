package com.fenghua.auto.finance.wxpay.sdk.protocol.refund_protocol;

/**
 * User: rizenguo
 * Date: 2014/10/25
 * Time: 16:12
 */
public class RefundResData {

    //协议层
    private String return_code = "";
    private String return_msg = "";
    /*返回状态码	return_code	是	String(16)	SUCCESS	SUCCESS/FAIL
    	返回信息	return_msg	否	String(128)	签名失败	 返回信息，如非空，为错误原因 签名失败 参数格式校验错误*/

    //协议返回的具体数据（以下字段在return_code 为SUCCESS 的时候有返回）
    private String result_code = "";
    private String err_code = "";
   /* SYSTEMERROR	接口返回错误	系统超时	请用相同参数再次调用API
    INVALID_TRANSACTIONID	无效transaction_id	请求参数未按指引进行填写	请求参数错误，检查原交易号是否存在或发起支付交易接口返回失败
    PARAM_ERROR	参数错误	请求参数未按指引进行填写	请求参数错误，请重新检查再调用退款申请
    APPID_NOT_EXIST	APPID不存在	参数中缺少APPID	请检查APPID是否正确
    MCHID_NOT_EXIST	MCHID不存在	参数中缺少MCHID	请检查MCHID是否正确
    APPID_MCHID_NOT_MATCH	appid和mch_id不匹配	appid和mch_id不匹配	请确认appid和mch_id是否匹配
    REQUIRE_POST_METHOD	请使用post方法	未使用post传递参数 	请检查请求参数是否通过post方法提交
    SIGNERROR	签名错误	参数签名结果不正确	请检查签名参数和方法是否都符合签名算法要求
    XML_FORMAT_ERROR	XML格式错误	XML格式错误	请检查XML参数格式是否正确*/
    private String err_code_des = "";
    
    private String appid = "";
    private String mch_id = "";
    private String sub_mch_id = "";
    private String device_info = "";
    private String nonce_str = "";
    private String sign = "";

    private String transaction_id = "";
    private String out_trade_no = "";
    private String out_refund_no = "";
    private String refund_id = "";		//微信退款单号
    private String refund_fee = "";
    private String coupon_refund_fee = ""; 	//代金券或立减优惠退款金额=订单金额-现金退款金额，注意：立减优惠金额不会退回
    private String coupon_refund_count =""; //代金券或立减优惠使用数量
    private String coupon_refund_id =""; //代金券或立减优惠ID
    private String cash_fee ="";	//现金支付金额，单位为分，只能为整数
    private String cash_refund_fee =""; //现金退款金额，单位为分，只能为整数
    private String total_fee ="";	//订单总金额，单位为分，只能为整数，详见支付金额
    private String fee_type =""; 		//CNY	订单金额货币类型，符合ISO 4217标准的三位字母代码
    private String refund_channel = "";		//ORIGINAL—原路退款  BALANCE—退回到余额
    
    public String getReturn_code() {
        return return_code;
    }

    public void setReturn_code(String return_code) {
        this.return_code = return_code;
    }

    public String getReturn_msg() {
        return return_msg;
    }

    public void setReturn_msg(String return_msg) {
        this.return_msg = return_msg;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getMch_id() {
        return mch_id;
    }

    public void setMch_id(String mch_id) {
        this.mch_id = mch_id;
    }

    public String getSub_mch_id() {
        return sub_mch_id;
    }

    public void setSub_mch_id(String sub_mch_id) {
        this.sub_mch_id = sub_mch_id;
    }

    public String getDevice_info() {
        return device_info;
    }

    public void setDevice_info(String device_info) {
        this.device_info = device_info;
    }

    public String getNonce_str() {
        return nonce_str;
    }

    public void setNonce_str(String nonce_str) {
        this.nonce_str = nonce_str;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getResult_code() {
        return result_code;
    }

    public void setResult_code(String result_code) {
        this.result_code = result_code;
    }

    public String getErr_code() {
        return err_code;
    }

    public void setErr_code(String err_code) {
        this.err_code = err_code;
    }

    public String getErr_code_des() {
        return err_code_des;
    }

    public void setErr_code_des(String err_code_des) {
        this.err_code_des = err_code_des;
    }

    public String getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getOut_refund_no() {
        return out_refund_no;
    }

    public void setOut_refund_no(String out_refund_no) {
        this.out_refund_no = out_refund_no;
    }

    public String getRefund_id() {
        return refund_id;
    }

    public void setRefund_id(String refund_id) {
        this.refund_id = refund_id;
    }

    public String getRefund_fee() {
        return refund_fee;
    }

    public void setRefund_fee(String refund_fee) {
        this.refund_fee = refund_fee;
    }

    public String getCoupon_refund_fee() {
        return coupon_refund_fee;
    }

    public void setCoupon_refund_fee(String coupon_refund_fee) {
        this.coupon_refund_fee = coupon_refund_fee;
    }

	public String getCoupon_refund_count() {
		return coupon_refund_count;
	}

	public void setCoupon_refund_count(String coupon_refund_count) {
		this.coupon_refund_count = coupon_refund_count;
	}

	public String getCoupon_refund_id() {
		return coupon_refund_id;
	}

	public void setCoupon_refund_id(String coupon_refund_id) {
		this.coupon_refund_id = coupon_refund_id;
	}

	public String getCash_fee() {
		return cash_fee;
	}

	public void setCash_fee(String cash_fee) {
		this.cash_fee = cash_fee;
	}

	public String getCash_refund_fee() {
		return cash_refund_fee;
	}

	public void setCash_refund_fee(String cash_refund_fee) {
		this.cash_refund_fee = cash_refund_fee;
	}

	public String getTotal_fee() {
		return total_fee;
	}

	public void setTotal_fee(String total_fee) {
		this.total_fee = total_fee;
	}

	public String getFee_type() {
		return fee_type;
	}

	public void setFee_type(String fee_type) {
		this.fee_type = fee_type;
	}

	public String getRefund_channel() {
		return refund_channel;
	}

	public void setRefund_channel(String refund_channel) {
		this.refund_channel = refund_channel;
	}
}
