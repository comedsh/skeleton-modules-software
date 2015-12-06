package com.fenghua.auto.backend.domain.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.StringUtils;

import com.fenghua.auto.backend.core.utills.ApplicationContextHolder;

/**
 * @author shang yang
 *
 * @version 
 *
 * @createTime：2015年11月26日 下午2:59:56 
 *
 */


public class NotDuplicatedValidator implements ConstraintValidator<NotDuplicated, CharSequence>{
	
	String service;
	
	String method;
	
	String sql;
	
	Class<?> type;
	
	@Override
	public void initialize(NotDuplicated parameters) {
		
		sql = parameters.sql();
		
	}
	
	@Override
	public boolean isValid(CharSequence value, ConstraintValidatorContext context) {
		
		if( StringUtils.isEmpty(value) ){
			return false;
		}
		
		// 1. TODO, validate by service and method
		
		// 2. validate by sql
		JdbcTemplate template = (JdbcTemplate)ApplicationContextHolder.getBean("jdbcTemplate");
		Long count = (Long) template.queryForObject(sql, Long.class, value);
		
		return count > 0 ? false : true;
	}

}
