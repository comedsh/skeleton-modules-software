package com.fenghua.auto.user.intf.service;

import java.util.List;

import com.fenghua.auto.user.intf.dto.CityArea;

/**
 * 地区service
 * 
 * @author chengbin
 * @createTime 2015.11.2
 *
 */
public interface CityAreaService {
	/**
	 * 获取省份
	 * @return
	 */
	public List<CityArea> selectProvince();
	/**
	 * 通过父节点id获取市级城市
	 * @return
	 */
	public List<CityArea> selectCity(Long parentId);
	/**
	 * 通过父节点id获取县级城市
	 * @return
	 */
	public List<CityArea> selectArea(Long parentId);
	
	/**
	 * 获取城市区域对象 by ID
	 * @return
	 */
	public CityArea loadCityArea(Long id);
}
