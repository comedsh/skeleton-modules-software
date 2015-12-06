package com.fenghua.auto.backend.core.utils;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.validation.ConstraintViolation;
import javax.validation.metadata.ConstraintDescriptor;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.FieldError;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;

import com.fenghua.auto.backend.core.utils.MessageHelper;
import com.fenghua.auto.backend.domain.mto.LabelError;
import com.fenghua.auto.backend.domain.validation.DomainValidationException;

/**
 * 
 * Utils translates the various errors into Label Errors 
 * 
 * @author shang yang
 *
 * @version 
 *
 * @createTime：2015年11月26日 上午11:41:26 
 *
 */

public class LabelErrorTranslator {
	
	private static Log log = LogFactory.getLog( LabelErrorTranslator.class.getName() );
	
	private static final Set<String> restraintAnnotationAttributes = new HashSet<String>(3);

	static {
		restraintAnnotationAttributes.add("message");
		restraintAnnotationAttributes.add("groups");
		restraintAnnotationAttributes.add("payload");
	}	
	
	/**
	 * 
	 * Translates the @link FieldError encapsulated from Spring Validation framework. 
	 * 
	 * @author shang yang
	 *
	 * @version 
	 * 
	 * @createTime: 2015年11月26日 上午11:43:56
	 *
	 */
	public static LabelError translate2LabelError(FieldError error){
		
		LabelError labelError = null;
		
		String message = null;
		
		// translate the errors by error code one by one, filter those null messages.
		for(String code : error.getCodes() ){
			
			// first argument was default to DefaultMessageSourceResolvable; we need the actual defined arguments
			// Object[] arguments = error.getArguments().length == 1 ? null : ArrayUtils.remove(error.getArguments(), 0);
			
			// Why comments above out? because, that's the design for Spring Validation, see messages_zh_CN.properties, the arguments start from {1}
			// Goal intents to meet the validator both for Spring POST validation and Manual GET validation
			message = MessageHelper.getMessage(code, error.getArguments() );	
			
			// if found, break. because Field Error with a lot of guessing codes 
			if( !StringUtils.isEmpty(message) ) break;

		}

		if( message == null ){ 
			throw new DomainValidationException( MessageHelper.getMessage(MessageHelper.MESSAGE_SOURCE_NOTFOUND, (Object[]) error.getCodes() ) );
		}		
		
		labelError = new LabelError();
		
		labelError.setField( error.getField() );
		
		labelError.setError( message );
		
		return labelError;
		
	}
	
	public static List<LabelError> translate2LabelError(List<FieldError> errors){
		
		List<LabelError> errs = new ArrayList<LabelError>(5);
		
		for(FieldError error : errors ){
			errs.add( LabelErrorTranslator.translate2LabelError(error) );
		}
		
		return CollectionUtils.isEmpty(errs) ? null : errs;		
		
	}
	
	/**
	 * translates the violation into LabelError
	 * 
	 * @TODO refactor the following code to use @link FieldError
	 * 
	 * @see SpringValidatorAdapter#getArgumentsForConstraint
	 *  
	 * @author shang yang
	 *
	 * @version 
	 * 
	 * @createTime: 2015年11月26日 下午7:29:41
	 *
	 */
	public static <T> LabelError translate2LabelError(ConstraintViolation<T> violation){
		
		if( violation == null ) return null;
		
		String classname = violation.getLeafBean().getClass().getSimpleName(); // the object that uses for validation
		
		String field = violation.getPropertyPath().toString();
		
		Annotation ann = violation.getConstraintDescriptor().getAnnotation();
		
		String validator = ann.annotationType().getSimpleName();
		
		String code = validator +"." + StringUtils.lowerCase( classname ) + "." + StringUtils.lowerCase( field );
		
		Object[] params = getParameters( violation.getConstraintDescriptor() );
		
		String error = MessageHelper.getMessage(code, params);
		
		if( error == null ){ 
			throw new DomainValidationException( MessageHelper.getMessage(MessageHelper.MESSAGE_SOURCE_NOTFOUND, code ) );
		}		
		
		LabelError labelError = new LabelError();
		
		labelError.setField( field );
		
		labelError.setError( error );
		
		return labelError;
		
	}
	
	private static Object[] getParameters( ConstraintDescriptor<?> descriptor ){
		
		List<Object> arguments = new LinkedList<Object>();
		
		arguments.add(new Object());
		
		// Using a TreeMap for alphabetical ordering of attribute names --> also indicates error message order
		Map<String, Object> attributes = new TreeMap<String, Object>();
		
		for (Map.Entry<String, Object> entry : descriptor.getAttributes().entrySet()) {
		
			String attributeName = entry.getKey();
			
			Object attributeValue = entry.getValue();
			
			if ( !restraintAnnotationAttributes.contains(attributeName) ) {
			
				log.info( "attributeName:" + attributeName + "; attributeValue:" + attributeValue);
				
				attributes.put(attributeName, attributeValue);
			
			}
		}
		
		arguments.addAll(attributes.values());
		
		return arguments.toArray(new Object[arguments.size()]);
	
	}
	
}
