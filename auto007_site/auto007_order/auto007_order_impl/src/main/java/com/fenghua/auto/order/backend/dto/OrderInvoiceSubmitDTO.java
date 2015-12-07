/**
 * 
 */
package com.fenghua.auto.order.backend.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fenghua.auto.backend.domain.mto.LabelError;
import com.fenghua.auto.order.backend.domain.OrderHeader;
import com.fenghua.auto.order.backend.domain.OrderInvoice;
import com.fenghua.auto.order.intf.OrderConstants;

/**
 * 
 * @author zhiyuan.wang@auto007.com
 *
 */
public class OrderInvoiceSubmitDTO implements Serializable {

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
    
    public OrderInvoice createInvoice(OrderHeader header) {
    	OrderInvoice invoice = new OrderInvoice();
    	
    	invoice.setId(null);
        invoice.setOrderId(header.getId());
        invoice.setValueAddId(this.valueAddId);
        invoice.setInvoiceType(this.invoiceType);
        invoice.setTitle(this.title);
        invoice.setContentType(this.contentType);
        invoice.setContent(this.content);
        invoice.setRecContact(this.recContact);
        invoice.setRecContactPhone(this.recContactPhone);
        invoice.setRecAddress(this.recAddress);
        invoice.setRecZipcode(this.recZipcode);
        invoice.setStatus(OrderConstants.InvoiceStatus.NEW.getValue());
        invoice.setEntryTime(new Date());
    	
    	return invoice;
    }
    
	public OrderInvoiceSubmitDTO(Integer invoiceType, Integer contentType, String title, String content) {
		super();
		this.invoiceType = invoiceType;
		this.contentType = contentType;
		this.title = title;
		this.content = content;
	}
	
	public OrderInvoiceSubmitDTO() {
		super();
	}

	public List<LabelError> valid() {
		List<LabelError> errors = new ArrayList<LabelError>();
		
		return errors;
	}
	
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
		this.title = title;
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
		this.content = content;
	}
	public String getRecContact() {
		return recContact;
	}
	public void setRecContact(String recContact) {
		this.recContact = recContact;
	}
	public String getRecContactPhone() {
		return recContactPhone;
	}
	public void setRecContactPhone(String recContactPhone) {
		this.recContactPhone = recContactPhone;
	}
	public String getRecAddress() {
		return recAddress;
	}
	public void setRecAddress(String recAddress) {
		this.recAddress = recAddress;
	}
	public String getRecZipcode() {
		return recZipcode;
	}
	public void setRecZipcode(String recZipcode) {
		this.recZipcode = recZipcode;
	}
}
