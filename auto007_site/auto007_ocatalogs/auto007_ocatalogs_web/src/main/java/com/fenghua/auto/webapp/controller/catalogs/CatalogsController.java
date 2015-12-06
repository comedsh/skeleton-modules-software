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

@Controller
@RequestMapping("/ocatalogs")
public class CatalogsController {

	private static final Log LOG = LogFactory.getLog("");

	@Autowired
	protected JdbcTemplate catalogJdbcTemplate;

	@RequestMapping(method = RequestMethod.GET)
	public String ocatalogs(Model model) {

		/**
		 * @TODO 原厂目录初始化页面， 需要获取品牌名和图片（cat_brand）
		 */
		model.addAttribute("brandList", catalogJdbcTemplate.queryForList("select * from cat_brand"));

		return "web.ocatalogs_view";
	}

	@RequestMapping(value = "/brand/{brand}", method = RequestMethod.GET, headers = { "application/json" })
	public @ResponseBody Map<String, List<Map<String, Object>>> brand(@PathVariable("brand") String brand,
			Model model) {

		/**
		 * @TOTO 根据品牌名获取其配置的节点以及第一节节点数据 cat_config，cat_model
		 */

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
