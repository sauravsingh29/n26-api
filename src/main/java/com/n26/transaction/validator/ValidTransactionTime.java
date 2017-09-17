/**
 * 
 */
package com.n26.transaction.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * @author Saurav
 *
 */
@Documented
@Constraint(validatedBy = TransactionTimeValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidTransactionTime {

	String message() default "invalid.timestamp.message";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
