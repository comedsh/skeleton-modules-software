package com.fenghua.auto.ocatalog.backend.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fenghua.auto.ocatalog.backend.dao.OcatalogsDao;
import com.fenghua.auto.ocatalog.backend.service.OcatalogsService;

@Service
public class OcatalogsServiceImpl implements OcatalogsService {

	@Autowired
	protected OcatalogsDao ocatalogsDao;
	
	public List<Map<String, Object>> allBrands(){
		return ocatalogsDao.allBrands();
	}
}
