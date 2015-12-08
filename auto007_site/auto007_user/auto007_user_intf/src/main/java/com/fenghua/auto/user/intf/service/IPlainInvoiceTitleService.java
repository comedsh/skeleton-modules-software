/**
 * 
 */
package com.fenghua.auto.user.intf.service;

import java.util.List;

import com.fenghua.auto.user.intf.dto.PlainInvoiceTitleDTO;

/**
 * Service接口类
 *
 * 普通发票Title信息
 *
 * @author 王直元
 * @createTime 2015-12-08 13:41:23
 *
 */
public interface IPlainInvoiceTitleService {

	public PlainInvoiceTitleDTO loadByUserIdAndTitleId(Long userId, Long titleId);
	
	public List<PlainInvoiceTitleDTO> loadByUserId(Long userId);
	
	/**
	 * 添加发票title
	 * userId、title字段必填
	 * @param PlainInvoiceTitleDTO
	 * @return
	 */
	public PlainInvoiceTitleDTO saveInvoiceTitle(PlainInvoiceTitleDTO invoiceTitleDTO);
	
	/**
	 * 删除发票title
	 * @param userId
	 * @param titleId
	 * @return int  删除条数
	 */
	public int deleteInvoiceTitle(Long userId, Long titleId);
}
