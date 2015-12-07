/**
 * 
 */
package com.fenghua.auto.user.backend.iservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fenghua.auto.backend.common.utils.BeanMapper;
import com.fenghua.auto.user.backend.domain.UserAddress;
import com.fenghua.auto.user.backend.service.UserAddressService;
import com.fenghua.auto.user.intf.dto.UserAddressDTO;

/**
 * Service实现类
 *
 * @author 王直元
 * @createTime 2015-11-30 13:33:25
 *
 */
@Service
public class IUserAddressServiceImpl implements com.fenghua.auto.user.intf.service.IUserAddressService {

	@Autowired
	private UserAddressService userAddressService;
	
	@Override
	public List<UserAddressDTO> findByBuyerId(Long buyerId) {
		return BeanMapper.mapList(userAddressService.findByBuyerId(buyerId), UserAddressDTO.class);
	}

	@Override
	public Long addAddress(Long buyerId, UserAddressDTO address) {
		return userAddressService.addAddress(buyerId, BeanMapper.map(address, UserAddress.class));
	}

	@Override
	public void defaultAddress(Long buyerId, Long addressId) {
		userAddressService.defaultAddress(buyerId, addressId);
	}

	@Override
	public int deleteAddress(Long buyerId, Long addressId) {
		return userAddressService.deleteAddress(buyerId, addressId);
	}

	@Override
	public UserAddressDTO getUserAddressById(Long id) {
		return BeanMapper.map(userAddressService.selectById(id), UserAddressDTO.class);
	}
}
