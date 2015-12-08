package com.fenghua.auto.user.backend.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.fenghua.auto.backend.dao.DaoException;
import com.fenghua.auto.backend.dao.constants.SqlId;
import com.fenghua.auto.backend.dao.impl.BaseDaoImpl;
import com.fenghua.auto.user.backend.dao.CityAreaDao;
import com.fenghua.auto.user.backend.domain.CityArea;
/**
 * 省份城市dao实现
 * @author chengbin
 *
 */
@Repository
public class CityAreaDaoImpl extends BaseDaoImpl<CityArea> implements CityAreaDao {
	
	@Override
	public List<CityArea> selectProvince() {
		List<CityArea> cityArea = new ArrayList<CityArea>();
		try {
			cityArea = sqlSessionTemplate.selectList(getSqlName(SqlId.SQL_SELECT_BY_PROVINCE),Short.parseShort("1"));
		} catch (Exception e) {
			throw new DaoException(String.format("根据Fixed查询对象出错！语句：%s", getSqlName(SqlId.SQL_SELECT_BY_PROVINCE)), e);
		}
		return cityArea;
	}
	
	@Override
	public List<CityArea> selectCity(Long parentId) {
		Assert.notNull(parentId);
		List<CityArea> cityArea = new ArrayList<CityArea>();
		CityArea city_area = new CityArea();
		city_area.setParentId(parentId);
		city_area.setLevel(Short.parseShort("2"));
		try {
			cityArea = sqlSessionTemplate.selectList(getSqlName(SqlId.SQL_SELECT_BY_CITY),city_area);
		} catch (Exception e) {
			throw new DaoException(String.format("根据Fixed查询对象出错！语句：%s", getSqlName(SqlId.SQL_SELECT_BY_CITY)), e);
		}
		return cityArea;
	}
	
	@Override
	public List<CityArea> selectArea(Long parentId) {
		Assert.notNull(parentId);
		List<CityArea> cityArea = new ArrayList<CityArea>();
		CityArea city_area = new CityArea();
		city_area.setParentId(parentId);
		city_area.setLevel(Short.parseShort("3"));
		try {
			cityArea = sqlSessionTemplate.selectList(getSqlName(SqlId.SQL_SELECT_BY_AREA),city_area);
		} catch (Exception e) {
			throw new DaoException(String.format("根据Fixed查询对象出错！语句：%s", getSqlName(SqlId.SQL_SELECT_BY_AREA)), e);
		}
		return cityArea;
	}
}
