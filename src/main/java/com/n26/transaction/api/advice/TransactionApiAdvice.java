/**
 * 
 */
package com.n26.transaction.api.advice;

import java.util.function.Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.n26.transaction.api.TransactionApi;

/**
 * @author Saurav
 *
 */
@RestControllerAdvice(assignableTypes = TransactionApi.class)
public class TransactionApiAdvice {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TransactionApiAdvice.class);

	@Autowired
    private MessageSource messageSource;
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<HttpStatus> resourceNotFound(MethodArgumentNotValidException ex) {
		// Not required but just for shake of logging with i18n supported
		ex.getBindingResult().getAllErrors().forEach(new Consumer<ObjectError>() {
			@Override
			public void accept(ObjectError e) {
				LOGGER.error(messageSource.getMessage(e.getDefaultMessage(), null, LocaleContextHolder.getLocale()));
			}
		});
        return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
    }
	
}
