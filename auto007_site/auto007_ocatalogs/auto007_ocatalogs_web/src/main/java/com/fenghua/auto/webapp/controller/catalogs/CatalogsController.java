package com.fenghua.auto.webapp.controller.catalogs;

import com.fenghua.auto.ocatalogs.backend.dao.OcatalogsDao;
import com.fenghua.auto.ocatalogs.backend.service.OcatalogsService;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping({ "/ocatalogs" })
public class CatalogsController {

	@Autowired
	protected OcatalogsDao ocatalogsDao;

	@Autowired
	protected OcatalogsService ocatalogsService;

	@RequestMapping(method = { org.springframework.web.bind.annotation.RequestMethod.GET })
	public String ocatalogs(Model model) {
		model.addAttribute("brandList", this.ocatalogsDao.allBrands());

		return "web.ocatalogs_view";
	}

	@RequestMapping(value = { "/brand/{brand}" }, method = {
			org.springframework.web.bind.annotation.RequestMethod.GET }, produces = { "text/plain;charset=UTF-8" })
	@ResponseBody
	public String brand(@PathVariable("brand") String brand, HttpServletRequest request) {
		List<Map<String, Object>>  configLayers = this.ocatalogsDao.getConfigLayersByBrand(brand);

		Map<String, Object> fstConfigLayer = this.ocatalogsDao.getFirstLayerByBrand(brand);
		int fstConfigLayerId = Integer.parseInt(String.valueOf(fstConfigLayer.get("id")));
		String fstConfigLayerSql = fstConfigLayer.get("sql_query").toString();

		List<Map<String, Object>>  configFields = this.ocatalogsDao.getFieldsByBrandLayer(brand, fstConfigLayerId);
		List<Map<String, Object>>  configParams = this.ocatalogsDao.getParamsByBrandLayer(brand, fstConfigLayerId);

		HashMap<String, String> requstParamsMap = parseRequestParameters(request);
		Object[] params = parseDataSqlParams(requstParamsMap, configParams);

		List<Map<String, Object>>  dataList = this.ocatalogsDao.getDataList(fstConfigLayerSql, params);

		JSONObject object = new JSONObject();
		object.element("brand", brand);
		object.element("configLayers", configLayers);

		object.element("layer_id", fstConfigLayerId);
		object.element("configFields", configFields);
		object.element("dataList", dataList);

		return object.toString();
	}

	@RequestMapping(value = { "/brand/{brand}/model/layer-{layerId}" }, method = {
			org.springframework.web.bind.annotation.RequestMethod.GET }, produces = { "text/plain;charset=UTF-8" })
	@ResponseBody
	public String model(@PathVariable("brand") String brand, @PathVariable("layerId") int layerId,
			HttpServletRequest request) {
		Map<String, Object>  nextConfigLayer = this.ocatalogsDao.getNextLayerByBrand(brand, layerId);

		int getConfigLayerId = Integer.parseInt(String.valueOf(nextConfigLayer.get("id")));
		String nextConfigLayerSql = nextConfigLayer.get("sql_query").toString();

		List<Map<String, Object>>  configFields = this.ocatalogsDao.getFieldsByBrandLayer(brand, getConfigLayerId);
		List<Map<String, Object>>  configParams = this.ocatalogsDao.getParamsByBrandLayer(brand, getConfigLayerId);

		HashMap<String, String>  requstParamsMap = parseRequestParameters(request);
		Object[] params = parseDataSqlParams(requstParamsMap, configParams);

		List<Map<String, Object>> dataList = this.ocatalogsDao.getDataList(nextConfigLayerSql, params);

		JSONObject object = new JSONObject();
		object.element("brand", brand);
		object.element("layer_id", getConfigLayerId);
		object.element("configFields", configFields);
		object.element("dataList", dataList);

		return object.toString();
	}

	@RequestMapping(value = { "/brand/{brand}/system/layer-{layerId}" }, method = {
			org.springframework.web.bind.annotation.RequestMethod.GET }, produces = { "text/plain;charset=UTF-8" })
	@ResponseBody
	public String system(@PathVariable("brand") String brand, @PathVariable("layerId") int layerId,
			HttpServletRequest request) {
		JSONObject object = new JSONObject();
		return object.toString();
	}

	private Object[] parseDataSqlParams(HashMap<String, String> requstParamsMap,
			List<Map<String, Object>> configParams) {
		String fieldName = null;
		String fieldType = null;
		String fieldValue = null;

		List<Object> paramValueList = new ArrayList<Object>();
		if ((configParams != null) && (!configParams.isEmpty())) {
			for (Map<String, Object> configParam : configParams) {
				fieldName = String.valueOf(configParam.get("field_name"));
				fieldType = String.valueOf(configParam.get("field_type"));
				fieldValue = String.valueOf(requstParamsMap.get(fieldName));
				if (fieldType.equals("int"))
					paramValueList.add(Integer.valueOf(Integer.parseInt(fieldValue)));
				else if (fieldType.equals("double"))
					paramValueList.add(Double.valueOf(Double.parseDouble(fieldValue)));
				else if (fieldType.equals("long"))
					paramValueList.add(Long.valueOf(Long.parseLong(fieldValue)));
				else if (fieldType.equals("string")) {
					paramValueList.add(fieldValue);
				}
			}
		}
		Object[] params = null;
		if ((paramValueList != null) && (!paramValueList.isEmpty())) {
			params = new Object[paramValueList.size()];
			paramValueList.toArray(params);
		}
		return params;
	}

	private HashMap<String, String> parseRequestParameters(HttpServletRequest request) {
		HashMap<String, String> paramsMap = new HashMap<String, String>();
		
		@SuppressWarnings("unchecked")
		Enumeration<String> paramsEnum = request.getParameterNames();
		while (paramsEnum.hasMoreElements()) {
			String name = paramsEnum.nextElement();
			paramsMap.put(name, request.getParameter(name));
		}
		return paramsMap;
	}
}