package com.fenghua.auto.backend.domain.validation;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * @author shang yang
 *
 * @version 
 *
 * @createTime：2015年11月26日 下午2:32:36 
 *
 */

@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@Documented
@Constraint( validatedBy = NotDuplicatedValidator.class )
public @interface NotDuplicated {
	
	// the service uses to check
	// TODO
	String service() default "";
	
	// the method name of the service
	// TODO
	String method() default "";
	
	String sql() default "";
	
	String message() default "{default not replicated message, warnings, need to configure the message from message properites}";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };	
	
}
