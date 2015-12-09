package com.fenghua.auto.webapp.controller.catalogs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fenghua.auto.ocatalogs.backend.dao.OcatalogsDao;

@Controller
@RequestMapping("/ocatalogs")
public class CatalogsController {

//	private static final Log LOG = LogFactory.getLog("");

	@Autowired
	protected OcatalogsDao ocatalogsDao;

	@RequestMapping(method = RequestMethod.GET)
	public String ocatalogs(Model model) {

		/**
		 * @TODO 原厂目录初始化页面， 需要获取品牌名和图片（cat_brand）
		 */
		model.addAttribute("brandList", ocatalogsDao.allBrands());

		return "web.ocatalogs_view";
	}

	@RequestMapping(value = "/brand/{brand}/layer-{layerId}", method = RequestMethod.GET, headers = { "application/json" })
	public @ResponseBody Map<String, List<Map<String, Object>>> brand(@PathVariable("brand") String brand,@PathVariable("layerId") int layerId,
			Model model) {

		List<Map<String, Object>> configList = catalogJdbcTemplate
				.queryForList("select * from cat_config order by cat_seq ");
		String lstNodeValue = String.valueOf(configList.get(0).get("cat_name"));

		StringBuilder sql = new StringBuilder();
		sql.append("select distinct ");
		sql.append(lstNodeValue);
		sql.append(" market from cat_model where brand = ? ");

		List<Map<String, Object>> catDataList = catalogJdbcTemplate.queryForList(sql.toString(), brand);

		Map<String, List<Map<String, Object>>> dataMap = new HashMap<String, List<Map<String, Object>>>();

		dataMap.put("configList", configList);
		dataMap.put("catDataList", catDataList);

		return dataMap;
	}

}
