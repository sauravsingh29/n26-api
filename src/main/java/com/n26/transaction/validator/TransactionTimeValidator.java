/**
 * 
 */
package com.n26.transaction.validator;

import static com.n26.helper.N26Util.isValidTimeStamp;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Validate that the annotated Long timestamp is older than current time stamp
 * in Epoch UTC.
 * 
 * @author Saurav
 * 
 */
public class TransactionTimeValidator implements ConstraintValidator<ValidTransactionTime, Long> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.validation.ConstraintValidator#initialize(java.lang.annotation.
	 * Annotation)
	 */
	@Override
	public void initialize(ValidTransactionTime constraintAnnotation) {
		// Nothing to as of now.
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.validation.ConstraintValidator#isValid(java.lang.Object,
	 * javax.validation.ConstraintValidatorContext)
	 */
	@Override
	public boolean isValid(Long value, ConstraintValidatorContext context) {
		return isValidTimeStamp(value);
	}

}
