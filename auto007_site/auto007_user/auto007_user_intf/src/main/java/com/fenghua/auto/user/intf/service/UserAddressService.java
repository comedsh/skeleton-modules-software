/**
 * 
 */
package com.fenghua.auto.user.intf.service;

import java.util.List;

import com.fenghua.auto.backend.service.BaseService;
import com.fenghua.auto.user.intf.dto.UserAddress;

/**
 * Service接口类
 *
 * @author 王直元
 * @createTime 2015-11-30 13:33:25
 *
 */
public interface UserAddressService extends BaseService<UserAddress> {

	List<UserAddress> findByBuyerId(Long buyerId);
	
	Long addAddress(Long buyerId, UserAddress address);
	
	void defaultAddress(Long buyerId, Long addressId);
	
	int deleteAddress(Long buyerId, Long addressId);
}
