/**
 * 
 */
package com.n26.transaction.api;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.n26.transaction.request.TransactionRequest;
import com.n26.transaction.service.N26Service;

/**
 * @author Saurav
 *
 */
@RestController
public class TransactionApi {

	private static final Logger LOGGER = LoggerFactory.getLogger(TransactionApi.class);

	@Autowired
	private N26Service n26Service;

	@PostConstruct
	public void transactionClean() {
		this.n26Service.clean();
	}

	@PostMapping(value = "/transactions", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<HttpStatus> resgister(@Valid @RequestBody TransactionRequest transactionRequest) {
		LOGGER.info("Transaction request processing using method {}", "resgister");
		n26Service.create(transactionRequest);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

}
