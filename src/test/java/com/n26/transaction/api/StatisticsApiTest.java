/**
 * 
 */
package com.n26.transaction.api;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.n26.transaction.service.N26Service;
import com.n26.transaction.stat.response.StatisticsResponse;

/**
 * @author Saurav
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest(StatisticsApi.class)
public class StatisticsApiTest {

	/**
	 * 
	 */
	private static final String ACCEPT = "application/json";

	/**
	 * 
	 */
	private static final String STATISTICS_URL = "/statistics";

	@Autowired
	private MockMvc mvc;

	@MockBean
	private N26Service n26Service;

	@Test
	public void withSampleStatisticsTest() throws Exception {
		StatisticsResponse response = new StatisticsResponse();
		response.setCount(10);
		response.setAverage(100);
		response.setSum(1000);
		response.setMax(500);
		response.setMin(100);
		when(n26Service.getStatistics()).thenReturn(response);

		mvc.perform(get(STATISTICS_URL).accept(ACCEPT)).andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(ACCEPT)).andExpect(jsonPath("count", is(10)))
				.andExpect(jsonPath("sum", is(1000.0))).andExpect(jsonPath("avg", is(100.0)))
				.andExpect(jsonPath("max", is(500.0))).andExpect(jsonPath("min", is(100.0)));
	}

	@Test
	public void withNoSampleStatisticsTest() throws Exception {
		when(n26Service.getStatistics()).thenReturn(new StatisticsResponse());

		mvc.perform(get(STATISTICS_URL).accept(ACCEPT)).andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(ACCEPT)).andExpect(jsonPath("count", is(0)))
				.andExpect(jsonPath("sum", is(0.0))).andExpect(jsonPath("avg", is("NaN")))
				.andExpect(jsonPath("max", is("NaN"))).andExpect(jsonPath("min", is("NaN")));
	}

}
