package com.fenghua.auto.ocatalogs.backend.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.fenghua.auto.ocatalogs.backend.dao.OcatalogsDao;

@Repository
public class OcatalogsDaoImpl implements OcatalogsDao {
	
	@Autowired
	protected JdbcTemplate catalogJdbcTemplate;
	
	public List<Map<String, Object>> allBrands(){
		return catalogJdbcTemplate.queryForList("select * from std_cat.cat_brand");
	}
	
	public List<Map<String, Object>> getConfigLayersByBrand(String brand){
		return catalogJdbcTemplate.queryForList("select t1.id, t1.cat_name, t2.cat_name_cn from std_cat.config_layer t1 inner join config_layer_name t2 on t1.cat_name = t2.cat_name where brand = ?  order by id ", brand);
	}
	
	public Map<String, Object> getFirstLayerByBrand(String brand){
		return catalogJdbcTemplate.queryForMap("select id, sql_query from std_cat.config_layer where brand = ? order by id limit 1", new Object[]{brand});
	}

	public Map<String, Object> getNextLayerByBrand(String brand, int layerId){
		return catalogJdbcTemplate.queryForMap("select id, sql_query from std_cat.config_layer where brand = ? and id > ? order by id limit 1", brand, layerId);
	}
	
	public List<Map<String, Object>> getParamsByBrandLayer(String brand, int layerId){
		return catalogJdbcTemplate.queryForList("select id, field_name, field_type from std_cat.config_params where brand = ? and layer_id = ? order by id", brand, layerId);
	}
	
	public List<Map<String, Object>> getFieldsByBrandLayer(String brand, int layerId){
		return catalogJdbcTemplate.queryForList("select id, field_name, field_title_cn from std_cat.config_field where brand = ? and layer_id = ? order by id", brand, layerId);
	}
	
	public List<Map<String, Object>> getDataList(String sqlQuery, Object[] params){
		return catalogJdbcTemplate.queryForList(sqlQuery, params);
	}
}
