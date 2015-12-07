/**
 * 
 */
package com.fenghua.auto.user.intf.service;

import com.fenghua.auto.user.intf.dto.SellerDTO;

/**
 * Service接口类
 *
 * @author 王直元
 * @createTime 2015-12-02 09:28:13
 *
 */
public interface SellerService {
	/**
	 * 通过id获取Serller
	 * @param id
	 * @return
	 */
	public SellerDTO getSellerById(Long id);
}
