package com.fenghua.auto.backend.service;

import com.fenghua.auto.backend.domain.core.SysConfig;
/**
 * 获取config配置文件信息
 * @author bin.cheng
 *
 */
public interface SysConfigService {
	/**
	 * 根据配置名查询配置详细信息
	 * @param configName
	 * @return
	 */
	public SysConfig selectByConfigName(String configName);
	/**
	 * 返回int类型的configValue
	 * @param configName
	 * @return
	 */
	public Integer getConfigAsInt(String configName);
	/**
	 * 返回Long类型的configValue
	 * @param configName
	 * @return
	 */
	public Long getConfigAsLong(String configName);
	/**
	 * 返回String类型的configValue
	 * @param configName
	 * @return
	 */
	public String getConfigAsString(String configName);
	/**
	 * 返回Byte类型的configValue
	 * @param configName
	 * @return
	 */
	public Byte getConfigAsByte(String configName);
}
