package com.fenghua.auto.backend.dao;

import org.springframework.stereotype.Repository;

import com.fenghua.auto.backend.dao.BaseDao;
import com.fenghua.auto.backend.domain.core.SysConfig;
/**
 * 
 * @author bin.cheng
 *
 */
@Repository
public interface SysConfigDao extends BaseDao<SysConfig>{
	
	public SysConfig selectByConfigName(String configName);
}
