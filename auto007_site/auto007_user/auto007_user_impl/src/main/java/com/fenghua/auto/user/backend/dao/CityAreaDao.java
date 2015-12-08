package com.fenghua.auto.user.backend.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.fenghua.auto.backend.dao.BaseDao;
import com.fenghua.auto.user.backend.domain.CityArea;;
/**
 * CityArea dao
 * @author chengbin
 * @createtime 2015.11.2
 *
 */
@Repository
public interface CityAreaDao extends BaseDao<CityArea> {
	/**
	 * 获取省份
	 * @param Fixed
	 * @return
	 */
	public List<CityArea> selectProvince(); 
	/**
	 * 通过父节点id获取市级
	 * @param Fixed
	 * @return
	 */
	public List<CityArea> selectCity(Long parentId); 
	/**
	 * 通过父节点id获取县级
	 * @param Fixed
	 * @return
	 */
	public List<CityArea> selectArea(Long parentId); 
}
