/**
 * 
 */
package com.fenghua.auto.user.backend.iservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fenghua.auto.backend.common.utils.BeanMapper;
import com.fenghua.auto.user.backend.service.SellerService;
import com.fenghua.auto.user.intf.dto.SellerDTO;

/**
 * Service实现类
 *
 * @author 王直元
 * @createTime 2015-12-02 09:28:13
 *
 */
@Service
public class ISellerServiceImpl implements com.fenghua.auto.user.intf.service.ISellerService {

	@Autowired
	private SellerService sellerService;

	@Override
	public SellerDTO getSellerById(Long id) {
		return BeanMapper.map(sellerService.selectById(id), SellerDTO.class);
	}
	
}
