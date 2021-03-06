/**
 * 
 */
package com.fenghua.auto.order.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fenghua.auto.backend.dao.BaseDao;
import com.fenghua.auto.backend.service.impl.BaseServiceImpl;
import com.fenghua.auto.order.backend.dao.WaybillTrackDao;
import com.fenghua.auto.order.backend.domain.WaybillTrack;
import com.fenghua.auto.order.backend.service.WaybillTrackService;

/**
 * Service实现类
 *
 * @author 王直元
 * @createTime 2015-11-25 11:11:35
 *
 */
@Service
public class WaybillTrackServiceImpl extends BaseServiceImpl<WaybillTrack> implements WaybillTrackService {

	@Autowired
	private WaybillTrackDao dao;
	
	@Override
	protected BaseDao<WaybillTrack> getBaseDao() {
		return dao;
	}

}
