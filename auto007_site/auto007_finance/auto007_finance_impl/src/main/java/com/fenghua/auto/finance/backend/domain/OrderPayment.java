package com.fenghua.auto.finance.backend.domain;

import com.fenghua.auto.backend.domain.DomainObject;
import java.math.BigDecimal;
import java.util.Date;

public class OrderPayment implements DomainObject {
	private static final long serialVersionUID = 1L;
//    ID	id	bigint			TRUE	FALSE	TRUE
//    支付单号	pay_no	varchar(32)	32		FALSE	FALSE	TRUE
//    订单主_ID	master_order_id	bigint			FALSE	TRUE	TRUE
//    主订单号	master_order_no	varchar(32)	32		FALSE	FALSE	TRUE
//    交易单号	trade_no	varchar(60)	60		FALSE	FALSE	TRUE
//    应付金额	need_pay_amount	decimal(18,4)	18	4	FALSE	FALSE	TRUE
//    已支付金额	payed_amount	decimal(18,4)	18	4	FALSE	FALSE	TRUE
//    已退款金额	refund_amount	decimal(18,4)	18	4	FALSE	FALSE	FALSE
//    支付状态	pay_status	int			FALSE	FALSE	TRUE
//    支付方式	pay_method	int			FALSE	FALSE	TRUE
//    支付帐号类型	account_type	int			FALSE	FALSE	FALSE
//    帐号名称	account_name	int			FALSE	FALSE	FALSE
//    开户行	bank_code	varchar(32)	32		FALSE	FALSE	FALSE
//    支付帐号	account_no	int			FALSE	FALSE	FALSE
//    提交时间	submit_time	datetime			FALSE	FALSE	TRUE
//    支付时间	payed_time	datetime			FALSE	FALSE	FALSE
//    收款人ID	payee_id	bigint			FALSE	FALSE	FALSE
//    收款人名称	payee_name	varchar(32)	32		FALSE	FALSE	FALSE
//    收款时间	payee_time	datetime			FALSE	FALSE	FALSE
//    买家ID	buyer_id	bigint			FALSE	FALSE	TRUE
    private Long id;

    private String payNo;

    private Long masterOrderId;

    private String masterOrderNo;

    private String tradeNo;

    private BigDecimal needPayAmount;

    private BigDecimal payedAmount;

    private BigDecimal refundAmount;

    private Integer payStatus;
    /**
     * 结算方式
     */
    private Long paymentType;
    /**
     * 付款方式：线下支付，微信支付，支付宝支付
     */
    private Integer payMethod;

    private Integer accountType;

    private Integer accountName;

    private String bankCode;

    private Integer accountNo;

    private Date submitTime;

    private Date payedTime;

    private Long payeeId;

    private String payeeName;

    private Date payeeTime;

    private Long buyerId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPayNo() {
        return payNo;
    }

    public void setPayNo(String payNo) {
        this.payNo = payNo == null ? null : payNo.trim();
    }

    public Long getMasterOrderId() {
        return masterOrderId;
    }

    public void setMasterOrderId(Long masterOrderId) {
        this.masterOrderId = masterOrderId;
    }

    public String getMasterOrderNo() {
        return masterOrderNo;
    }

    public void setMasterOrderNo(String masterOrderNo) {
        this.masterOrderNo = masterOrderNo == null ? null : masterOrderNo.trim();
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo == null ? null : tradeNo.trim();
    }

    public BigDecimal getNeedPayAmount() {
        return needPayAmount;
    }

    public void setNeedPayAmount(BigDecimal needPayAmount) {
        this.needPayAmount = needPayAmount;
    }

    public BigDecimal getPayedAmount() {
        return payedAmount;
    }

    public void setPayedAmount(BigDecimal payedAmount) {
        this.payedAmount = payedAmount;
    }

    public BigDecimal getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(BigDecimal refundAmount) {
        this.refundAmount = refundAmount;
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    public Integer getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(Integer payMethod) {
        this.payMethod = payMethod;
    }

    public Integer getAccountType() {
        return accountType;
    }

    public void setAccountType(Integer accountType) {
        this.accountType = accountType;
    }

    public Integer getAccountName() {
        return accountName;
    }

    public void setAccountName(Integer accountName) {
        this.accountName = accountName;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode == null ? null : bankCode.trim();
    }

    public Integer getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(Integer accountNo) {
        this.accountNo = accountNo;
    }

    public Date getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
    }

    public Date getPayedTime() {
        return payedTime;
    }

    public void setPayedTime(Date payedTime) {
        this.payedTime = payedTime;
    }

    public Long getPayeeId() {
        return payeeId;
    }

    public void setPayeeId(Long payeeId) {
        this.payeeId = payeeId;
    }

    public String getPayeeName() {
        return payeeName;
    }

    public void setPayeeName(String payeeName) {
        this.payeeName = payeeName == null ? null : payeeName.trim();
    }

    public Date getPayeeTime() {
        return payeeTime;
    }

    public void setPayeeTime(Date payeeTime) {
        this.payeeTime = payeeTime;
    }

    public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }

	public Long getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(Long paymentType) {
		this.paymentType = paymentType;
	}
}