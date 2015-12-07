package com.fenghua.auto.user.intf.service;

import java.util.List;

import com.fenghua.auto.user.intf.dto.CityAreaDTO;

/**
 * 地区service
 * 
 * @author chengbin
 * @createTime 2015.11.2
 *
 */
public interface ICityAreaService {
	/**
	 * 获取省份
	 * @return
	 */
	public List<CityAreaDTO> selectProvince();
	/**
	 * 通过父节点id获取市级城市
	 * @return
	 */
	public List<CityAreaDTO> selectCity(Long parentId);
	/**
	 * 通过父节点id获取县级城市
	 * @return
	 */
	public List<CityAreaDTO> selectArea(Long parentId);
	
	/**
	 * 获取城市区域对象 by ID
	 * @return
	 */
	public CityAreaDTO loadCityArea(Long id);
}
