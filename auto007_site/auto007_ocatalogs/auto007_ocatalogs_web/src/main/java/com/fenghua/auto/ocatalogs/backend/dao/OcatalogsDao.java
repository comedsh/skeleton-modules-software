package com.fenghua.auto.ocatalogs.backend.dao;

import java.util.List;
import java.util.Map;

public interface OcatalogsDao {

	public List<Map<String, Object>> allBrands();
	
	public List<Map<String, Object>> getConfigLayersByBrand(String brand);
	
	public Map<String, Object> getFirstLayerByBrand(String brand);
	
	public Map<String, Object> getNextLayerByBrand(String brand, int layerId);
	
	public List<Map<String, Object>> getParamsByBrandLayer(String brand, int layerId);
	
	public List<Map<String, Object>> getFieldsByBrandLayer(String brand, int layerId);
	
	public List<Map<String, Object>> getDataList(String sqlQuery, Object[] params);
}
