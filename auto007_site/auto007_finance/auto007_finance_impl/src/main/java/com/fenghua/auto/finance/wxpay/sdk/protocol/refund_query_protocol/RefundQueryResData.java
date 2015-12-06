package com.fenghua.auto.finance.wxpay.sdk.protocol.refund_query_protocol;

/**
 * User: rizenguo
 * Date: 2014/10/25
 * Time: 16:36
 */
public class RefundQueryResData {
    //协议层
    private String return_code = "";
    private String return_msg = "";

    //协议返回的具体数据（以下字段在return_code 为SUCCESS 的时候有返回）
    private String result_code = "";
//    SYSTEMERROR	接口返回错误	系统超时	请尝试再次掉调用API。
//    INVALID_TRANSACTIONID	无效transaction_id	请求参数未按指引进行填写	请求参数错误，检查原交易号是否存在或发起支付交易接口返回失败
//    PARAM_ERROR	参数错误	请求参数未按指引进行填写	请求参数错误，请检查参数再调用退款申请
//    APPID_NOT_EXIST	APPID不存在	参数中缺少APPID	请检查APPID是否正确
//    MCHID_NOT_EXIST	MCHID不存在	参数中缺少MCHID	请检查MCHID是否正确
//    APPID_MCHID_NOT_MATCH	appid和mch_id不匹配	appid和mch_id不匹配	请确认appid和mch_id是否匹配
//    REQUIRE_POST_METHOD	请使用post方法	未使用post传递参数 	请检查请求参数是否通过post方法提交
//    SIGNERROR	签名错误	参数签名结果不正确	请检查签名参数和方法是否都符合签名算法要求
//    XML_FORMAT_ERROR	XML格式错误	XML格式错误	请检查XML参数格式是否正确
    private String err_code = "";
    private String err_code_des = "";
    private String appid = "";
    private String mch_id = "";
    private String nonce_str = "";
    private String device_info = "";
    private String sign = "";
    
    private String transaction_id = "";
    private String out_trade_no = "";
    private String out_refund_no_$n = "";
    private String refund_id_$n = "";
    private String refund_fee_$n = ""; //退款总金额,单位为分,可以做部分退款
//    SUCCESS—退款成功
//    FAIL—退款失败
//    PROCESSING—退款处理中
//    NOTSURE—未确定，需要商户原退款单号重新发起
//    CHANGE—转入代发，退款到银行发现用户的卡作废或者冻结了，导致原路退款银行卡失败，资金回流到商户的现金帐号，需要商户人工干预，通过线下或者财付通转账的方式进行退款。
    private String refund_status_$n	 = ""; //退款状态：
    private int refund_count = 0;   //退款记录数

    /*<xml>
	    <appid><![CDATA[wx2421b1c4370ec43b]]></appid>
	    <mch_id><![CDATA[10000100]]></mch_id>
	    <nonce_str><![CDATA[TeqClE3i0mvn3DrK]]></nonce_str>
	    <out_refund_no_0><![CDATA[1415701182]]></out_refund_no_0>
	    <out_trade_no><![CDATA[1415757673]]></out_trade_no>
	    <refund_count>1</refund_count>
	    <refund_fee_0>1</refund_fee_0>
	    <refund_id_0><![CDATA[2008450740201411110000174436]]></refund_id_0>
	    <refund_status_0><![CDATA[PROCESSING]]></refund_status_0>
	    <result_code><![CDATA[SUCCESS]]></result_code>
	    <return_code><![CDATA[SUCCESS]]></return_code>
	    <return_msg><![CDATA[OK]]></return_msg>
	    <sign><![CDATA[1F2841558E233C33ABA71A961D27561C]]></sign>
	    <transaction_id><![CDATA[1008450740201411110005820873]]></transaction_id>
	 </xml>*/
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

    public String getDevice_info() {
        return device_info;
    }

    public void setDevice_info(String device_info) {
        this.device_info = device_info;
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

    public int getRefund_count() {
        return refund_count;
    }

    public void setRefund_count(int refund_count) {
        this.refund_count = refund_count;
    }

}
