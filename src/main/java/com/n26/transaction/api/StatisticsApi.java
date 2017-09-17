/**
 * 
 */
package com.n26.transaction.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.n26.transaction.service.N26Service;
import com.n26.transaction.stat.response.StatisticsResponse;

/**
 * @author Saurav
 *
 */
@RestController
public class StatisticsApi {

	@Autowired
	private N26Service n26Service;

	@GetMapping(value = "/statistics", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<StatisticsResponse> getStat() {
		return new ResponseEntity<StatisticsResponse>(n26Service.getStatistics(), HttpStatus.OK);
	}
}
