package com.fenghua.auto.backend.service.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fenghua.auto.backend.dao.user.CityAreaDao;
import com.fenghua.auto.backend.domain.user.CityArea;
import com.fenghua.auto.backend.service.user.CityAreaService;

/**
 * CityArea接口实现
 * @author chengbin
 * @createTime 2015.11.2
 *
 */
@Service
public class CityAreaServiceImpl implements CityAreaService {
	
	@Autowired
	private CityAreaDao cityAreaDao;
	
	@Override
	public List<CityArea> selectProvince() {
		return cityAreaDao.selectProvince();
	}
	@Override
	public List<CityArea> selectCity(Long parentId) {
		return cityAreaDao.selectCity(parentId);
	}
	@Override
	public List<CityArea> selectArea(Long parentId) {
		return cityAreaDao.selectArea(parentId);
	}
	@Override
	public CityArea loadCityArea(Long id) {
		return cityAreaDao.selectById(id);
	}
}
