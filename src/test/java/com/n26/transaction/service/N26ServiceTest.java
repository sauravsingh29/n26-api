/**
 * 
 */
package com.n26.transaction.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.n26.transaction.request.TransactionRequest;
import com.n26.transaction.stat.response.StatisticsResponse;

/**
 * @author Saurav
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class N26ServiceTest {
	
	private N26Service n26Service = new N26Service();
	
	private List<TransactionRequest> transactions;
	
	@Before
	public void setUp() throws Exception{
		transactions = n26Service.getTransactions();
	}
	
	@Test
	public void creatTest() {
		TransactionRequest expected = new TransactionRequest(12.4, 1234547885);
		n26Service.create(expected);
		assertEquals(expected, transactions.get(0));
	}
	
	@Test
	public void getStatisticsTest(){
		TransactionRequest expected = new TransactionRequest(12.4, 1234547885);
		n26Service.create(expected);
		StatisticsResponse actual = n26Service.getStatistics();
		assertEquals(n26Service.getTransactions().get(0).getAmount(), actual.getSum(), 0);
	}

}
