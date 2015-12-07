/**
 * 
 */
package com.fenghua.auto.user.intf.service;

import java.util.List;

import com.fenghua.auto.user.intf.dto.UserAddressDTO;

/**
 * Service接口类
 *
 * @author 王直元
 * @createTime 2015-11-30 13:33:25
 *
 */
public interface UserAddressService {

	List<UserAddressDTO> findByBuyerId(Long buyerId);
	
	Long addAddress(Long buyerId, UserAddressDTO address);
	
	void defaultAddress(Long buyerId, Long addressId);
	
	int deleteAddress(Long buyerId, Long addressId);
	
	/**
	 * 通过id获取Serller
	 * @param id
	 * @return
	 */
	public UserAddressDTO getUserAddressById(Long id);
}
