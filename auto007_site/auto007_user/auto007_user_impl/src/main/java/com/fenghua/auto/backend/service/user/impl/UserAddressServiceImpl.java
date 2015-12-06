/**
 * 
 */
package com.fenghua.auto.backend.service.user.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fenghua.auto.backend.dao.BaseDao;
import com.fenghua.auto.backend.dao.user.UserAddressDao;
import com.fenghua.auto.backend.domain.user.CityArea;
import com.fenghua.auto.backend.domain.user.UserAddress;
import com.fenghua.auto.backend.service.impl.BaseServiceImpl;
import com.fenghua.auto.backend.service.user.CityAreaService;
import com.fenghua.auto.backend.service.user.UserAddressService;

/**
 * Service实现类
 *
 * @author 王直元
 * @createTime 2015-11-30 13:33:25
 *
 */
@Service
public class UserAddressServiceImpl extends BaseServiceImpl<UserAddress> implements UserAddressService {

	@Autowired
	private UserAddressDao dao;
	
	@Autowired
	private CityAreaService cityAreaService;
	
	@Override
	protected BaseDao<UserAddress> getBaseDao() {
		return dao;
	}

	@Override
	public List<UserAddress> findByBuyerId(Long buyerId) {
		UserAddress userAddrQuery = new UserAddress();
		userAddrQuery.setUserId(buyerId);
		UserAddress defaultAddress = null;
		List<UserAddress> userAddrList = selectList(userAddrQuery);
		if(userAddrList != null && !userAddrList.isEmpty()) {
			for (UserAddress userAddress : userAddrList) {
				if(userAddress.getDefaultAddr().booleanValue()) {
					defaultAddress = userAddress;
					break;
				}
			}
			if(defaultAddress == null) {
				defaultAddress = userAddrList.get(0);
			} else {
				userAddrList.remove(defaultAddress);
			}
			userAddrList.add(0, defaultAddress);
		}
		return userAddrList;
	}

	@Override
	public Long addAddress(Long buyerId, UserAddress address) {
		address.setUserId(buyerId);
		address.setCreatedTs(new Date());
		address.setLastModifiedTs(new Date());
		address.setDefaultAddr(false);
		if(address.getProvinceId() != null) {
			CityArea ca = cityAreaService.loadCityArea(address.getProvinceId());
			if(ca != null) {
				address.setProvinceName(ca.getName());
			}
		}
		if(address.getCityId() != null) {
			CityArea ca = cityAreaService.loadCityArea(address.getCityId());
			if(ca != null) {
				address.setCityName(ca.getName());
			}
		}
		if(address.getAreaId() != null) {
			CityArea ca = cityAreaService.loadCityArea(address.getAreaId());
			if(ca != null) {
				address.setAreaName(ca.getName());
			}
		}
		if(address.getId() != null && address.getId() > 0) {
			dao.updateByIdSelective(address);
		} else {
			dao.insert(address);
		}
		
		return address.getId();
	}

	@Override
	public void defaultAddress(Long buyerId, Long addressId) {
		List<UserAddress> addressList = findByBuyerId(buyerId);
		if(addressList != null) {
			UserAddress address = null;
			for (UserAddress userAddress : addressList) {
				if(userAddress.getId().longValue() == addressId.longValue()) {
					address = new UserAddress();
					address.setId(userAddress.getId());
					address.setDefaultAddr(true);
					dao.updateByIdSelective(address);
				} else {
					address = new UserAddress();
					address.setId(userAddress.getId());
					address.setDefaultAddr(false);
					dao.updateByIdSelective(address);
				}
			}
		}
	}

	@Override
	public int deleteAddress(Long buyerId, Long addressId) {
		UserAddress address = dao.selectById(addressId);
		if(address != null && address.getUserId().longValue() == buyerId.longValue()) {
			return dao.deleteById(addressId);
		}
		return 0;
	}
}
