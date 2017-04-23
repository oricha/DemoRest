package org.example.kmuniz;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@WebAppConfiguration
public class DemoRestApplicationTests {

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;
	@Ignore
	@Before
	public void before() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
	}
	@Ignore
	@Test
	public void getTransactionsTest() throws Exception {

		this.mockMvc.perform(MockMvcRequestBuilders.get("/transactions/"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
	@Ignore
	@Test
	public void getTransactionTest() throws Exception {

		this.mockMvc.perform(MockMvcRequestBuilders.get("/transactions/123"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
	@Ignore
	@Test
	public void getTransactionByTypeTest() throws Exception {

		this.mockMvc.perform(MockMvcRequestBuilders.get("/type/car"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
}