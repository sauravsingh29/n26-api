/**
 * 
 */
package com.n26.transaction.service;

import static com.n26.helper.N26Util.isValidTimeStamp;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.n26.transaction.request.TransactionRequest;
import com.n26.transaction.stat.response.StatisticsResponse;

/**
 * @author Saurav
 *
 */
@Service
public class N26Service {

	private static final Logger LOGGER = LoggerFactory.getLogger(N26Service.class);

	private List<TransactionRequest> transactions = new CopyOnWriteArrayList<TransactionRequest>();

	public void create(TransactionRequest transactionRequest) {
		LOGGER.info("Started method {}", "create");
		transactions.add(transactionRequest);
	}

	@Async
	public void clean() {
		LOGGER.info("Started method {}", "clean");
		while (true) {
			if (!CollectionUtils.isEmpty(transactions)) {
				final TransactionRequest transactionRequest = transactions.get(0);
				if (!isValidTimeStamp(transactionRequest.getTimestamp())) {
					LOGGER.warn("timestame = {}, amount = {}", transactionRequest.getTimestamp(), transactionRequest.getAmount());
					transactions.remove(transactionRequest);
				}
			}
		}
	}

	public StatisticsResponse getStatistics() {
		DoubleSummaryStatistics doubleSummaryStatistics = transactions.stream()
				.collect(Collectors.summarizingDouble(TransactionRequest::getAmount));
		StatisticsResponse response = new StatisticsResponse();
		BeanUtils.copyProperties(doubleSummaryStatistics, response);
		return response;
	}

	/**
	 * @return the transactions
	 */
	public List<TransactionRequest> getTransactions() {
		return transactions;
	}
	
	

}
