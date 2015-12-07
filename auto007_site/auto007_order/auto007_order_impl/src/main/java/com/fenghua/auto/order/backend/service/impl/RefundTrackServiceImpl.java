/**
 * 
 */
package com.fenghua.auto.order.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fenghua.auto.backend.dao.BaseDao;
import com.fenghua.auto.backend.service.impl.BaseServiceImpl;
import com.fenghua.auto.order.backend.dao.RefundTrackDao;
import com.fenghua.auto.order.backend.domain.RefundTrack;
import com.fenghua.auto.order.backend.service.RefundTrackService;

/**
 * Service实现类
 *
 * @author 王直元
 * @createTime 2015-11-25 11:11:35
 *
 */
@Service
public class RefundTrackServiceImpl extends BaseServiceImpl<RefundTrack> implements RefundTrackService {

	@Autowired
	private RefundTrackDao dao;
	
	@Override
	protected BaseDao<RefundTrack> getBaseDao() {
		return dao;
	}

}
