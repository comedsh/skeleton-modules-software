package com.fenghua.auto.order.backend.domain;

import com.fenghua.auto.backend.domain.DomainObject;
import java.util.Date;
/**
 * 订单发票
 *
 */
public class OrderInvoice implements DomainObject {
	private static final long serialVersionUID = 1L;
    private Long id;
    /**
     * 订单id
     */
    private Long orderId;
    /**
     * 增值税id
     */
    private Long valueAddId;
    /**
     * 发票类型
     */
    private Integer invoiceType;
    /**
     * 发票抬头
     */
    private String title;
    /**
     * 内容类型（如：汽车配件，
     * 			 或： 配件明细xx
     * 						yy
     * 						。。。）
     */
    private Integer contentType;
    /**
     * 发票内容
     */
    private String content;
    /**
     * 收票人
     */
    private String recContact;
    /**
     * 收票人电话
     */
    private String recContactPhone;
    /**
     * 收票人地址（发票将邮寄）
     */
    private String recAddress;
    /**
     * 收票人邮编
     */
    private String recZipcode;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 创建时间
     */
    private Date entryTime;
    /**
     * 答应人id
     */
    private Long printerId;
    /**
     * 打印人姓名
     */
    private String printerName;
    /**
     * 打印时间
     */
    private Date printTime;

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

    public Long getValueAddId() {
        return valueAddId;
    }

    public void setValueAddId(Long valueAddId) {
        this.valueAddId = valueAddId;
    }

    public Integer getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(Integer invoiceType) {
        this.invoiceType = invoiceType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getContentType() {
        return contentType;
    }

    public void setContentType(Integer contentType) {
        this.contentType = contentType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getRecContact() {
        return recContact;
    }

    public void setRecContact(String recContact) {
        this.recContact = recContact == null ? null : recContact.trim();
    }

    public String getRecContactPhone() {
        return recContactPhone;
    }

    public void setRecContactPhone(String recContactPhone) {
        this.recContactPhone = recContactPhone == null ? null : recContactPhone.trim();
    }

    public String getRecAddress() {
        return recAddress;
    }

    public void setRecAddress(String recAddress) {
        this.recAddress = recAddress == null ? null : recAddress.trim();
    }

    public String getRecZipcode() {
        return recZipcode;
    }

    public void setRecZipcode(String recZipcode) {
        this.recZipcode = recZipcode == null ? null : recZipcode.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public Long getPrinterId() {
        return printerId;
    }

    public void setPrinterId(Long printerId) {
        this.printerId = printerId;
    }

    public String getPrinterName() {
        return printerName;
    }

    public void setPrinterName(String printerName) {
        this.printerName = printerName == null ? null : printerName.trim();
    }

    public Date getPrintTime() {
        return printTime;
    }

    public void setPrintTime(Date printTime) {
        this.printTime = printTime;
    }
}