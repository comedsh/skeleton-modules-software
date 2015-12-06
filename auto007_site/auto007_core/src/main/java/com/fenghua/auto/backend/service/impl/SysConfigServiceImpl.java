package com.fenghua.auto.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fenghua.auto.backend.dao.SysConfigDao;
import com.fenghua.auto.backend.domain.core.SysConfig;
import com.fenghua.auto.backend.service.SysConfigService;

@Service
public class SysConfigServiceImpl implements SysConfigService {
	
	@Autowired
	SysConfigDao configDao;

	@Override
	public SysConfig selectByConfigName(String configName) {
		
		return configDao.selectByConfigName(configName);
		
	}

	@Override
	public Integer getConfigAsInt(String configName) {
		SysConfig config =  configDao.selectByConfigName(configName);
		if (config != null) {
			String value = config.getConfigValue();
			if (value != null && value.equals("")) {
				return Integer.parseInt(value);
			}
		}
		return null;
	}

	@Override
	public Long getConfigAsLong(String configName) {
		SysConfig config =  configDao.selectByConfigName(configName);
		if (config != null) {
			String value = config.getConfigValue();
			if (value != null && value.equals("")) {
				return Long.parseLong(value);
			}
		}
		return null;
	}
	
	

	@Override
	public String getConfigAsString(String configName) {
		SysConfig config =  configDao.selectByConfigName(configName);
		if (config != null) {
			String value = config.getConfigValue();
			if (value != null && value.equals("")) {
				return value;
			}
		}
		return null;
	}

	@Override
	public Byte getConfigAsByte(String configName) {
		SysConfig config =  configDao.selectByConfigName(configName);
		if (config != null) {
			String value = config.getConfigValue();
			if (value != null && value.equals("")) {
				return Byte.parseByte(value);
			}
		}
		return null;
	}
}
