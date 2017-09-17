/**
 * 
 */
package com.n26.transaction.api;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.Instant;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.n26.transaction.request.TransactionRequest;
import com.n26.transaction.service.N26Service;

/**
 * @author Saurav
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest(TransactionApi.class)
public class TransactionApiTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private N26Service n26Service;

	@Test
	public void validRequestTest() throws Exception {
		long timeStamp = Instant.now().toEpochMilli();
		mvc.perform(post("/transactions").contentType("application/json")
				.content(String.format("{\"amount\": 12.3,\"timestamp\": %s}", timeStamp)))
				.andExpect(status().isCreated()).andExpect(content().bytes(new byte[0]));

		verify(n26Service).create(any(TransactionRequest.class));
	}

	@Test
	public void badRequestTest() throws Exception {
		mvc.perform(
				post("/transactions").contentType("application/json").content("{\"amount\": 12.3,\"timestamp\": 0}"))
				.andExpect(status().isNoContent()).andExpect(content().bytes(new byte[0]));
		verify(n26Service, times(0)).create(any(TransactionRequest.class));
	}

}
