package com.fenghua.auto.user.backend.iservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fenghua.auto.backend.common.utils.BeanMapper;
import com.fenghua.auto.user.backend.dao.CityAreaDao;
import com.fenghua.auto.user.backend.domain.CityArea;
import com.fenghua.auto.user.intf.dto.CityAreaDTO;
import com.fenghua.auto.user.intf.service.ICityAreaService;

/**
 * CityArea接口实现
 * @author chengbin
 * @createTime 2015.11.2
 *
 */
@Service
public class ICityAreaServiceImpl implements ICityAreaService {
	
	@Autowired
	private CityAreaDao cityAreaDao;
	
	@Override
	public List<CityAreaDTO> selectProvince() {
		List<CityArea> areas = cityAreaDao.selectProvince();
		if(areas != null && !areas.isEmpty()) {
			return BeanMapper.mapList(areas, CityAreaDTO.class);
		}
		return null;
	}
	@Override
	public List<CityAreaDTO> selectCity(Long parentId) {
		List<CityArea> areas = cityAreaDao.selectCity(parentId);
		if(areas != null && !areas.isEmpty()) {
			return BeanMapper.mapList(areas, CityAreaDTO.class);
		}
		return null;
	}
	@Override
	public List<CityAreaDTO> selectArea(Long parentId) {
		List<CityArea> areas = cityAreaDao.selectArea(parentId);
		if(areas != null && !areas.isEmpty()) {
			return BeanMapper.mapList(areas, CityAreaDTO.class);
		}
		return null;
	}
	@Override
	public CityAreaDTO loadCityArea(Long id) {
		CityArea area = cityAreaDao.selectById(id);
		if(area != null) {
			return BeanMapper.map(area, CityAreaDTO.class);
		}
		return null;
	}
}
