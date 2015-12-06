/**
 * 
 */
package com.fenghua.auto.backend.service.user;

import java.util.List;

import com.fenghua.auto.backend.domain.user.UserAddress;
import com.fenghua.auto.backend.service.BaseService;

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
