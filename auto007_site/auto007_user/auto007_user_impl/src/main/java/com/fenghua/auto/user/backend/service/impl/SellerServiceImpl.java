/**
 * 
 */
package com.fenghua.auto.user.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fenghua.auto.backend.dao.BaseDao;
import com.fenghua.auto.backend.service.impl.BaseServiceImpl;
import com.fenghua.auto.user.backend.dao.SellerDao;
import com.fenghua.auto.user.backend.domain.Seller;
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
public class SellerServiceImpl extends BaseServiceImpl<Seller> implements SellerService,com.fenghua.auto.user.intf.service.SellerService {

	@Autowired
	private SellerDao dao;
	
	@Override
	protected BaseDao<Seller> getBaseDao() {
		return dao;
	}

	@Override
	public SellerDTO getSellerById(Long id) {
		
		return null;
	}
	
}
