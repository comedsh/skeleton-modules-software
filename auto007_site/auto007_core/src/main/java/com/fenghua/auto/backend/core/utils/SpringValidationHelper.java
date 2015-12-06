package com.fenghua.auto.backend.core.utils;

import java.lang.reflect.Field;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.groups.Default;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fenghua.auto.backend.domain.mto.CommonMessageTransferObject;
import com.fenghua.auto.backend.domain.mto.LabelError;
import com.fenghua.auto.backend.domain.mto.MessageTransferObject;
import com.fenghua.auto.backend.domain.validation.DomainValidationException;

/**
 * @author shang yang
 *
 * @version 
 *
 * @createTime：2015年11月26日 下午6:44:39 
 *
 */

public class SpringValidationHelper {
	
	private static Log log = LogFactory.getLog( SpringValidationHelper.class.getName() );
	
	private static final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	
	public static <T> MessageTransferObject validate( Class<T> objectClass, String value, String field ){
		
		log.info("Spring Validation Helper start validate against Class:" + objectClass.getName() + "; Field:" + field + "; Value:" + value );
		
		Validator validator = factory.getValidator();
		
		T o = null;

		try {
			
			o = objectClass.newInstance();
			
			Field f = objectClass.getDeclaredField(field);
			
			f.setAccessible(true);
			
			f.set(o, value); // set value
			
			
		} catch (InstantiationException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			
			throw new DomainValidationException( e.getMessage(), e.getCause() );
			
		}
		
		Set<ConstraintViolation<T>> violations = validator.validateProperty( o, field, Default.class );
		
		ConstraintViolation<T> violation = ( violations.iterator().hasNext() ? violations.iterator().next() : null ); // always fetch the first one only
		
		CommonMessageTransferObject transferObject = new CommonMessageTransferObject();
		
		LabelError error = LabelErrorTranslator.translate2LabelError( violation );
		
		if( error != null ){
			transferObject.addErrors( error );
		}
		
		return transferObject;
	}
	
}
