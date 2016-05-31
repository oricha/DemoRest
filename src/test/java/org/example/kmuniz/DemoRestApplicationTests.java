package org.example.kmuniz;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoRestApplication.class)
@WebAppConfiguration
public class DemoRestApplicationTests {

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	@Before
	public void before() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
	}

	@Test
	public void getTransactionsTest() throws Exception {

		this.mockMvc.perform(MockMvcRequestBuilders.get("/transactions/"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void getTransactionTest() throws Exception {

		this.mockMvc.perform(MockMvcRequestBuilders.get("/transactions/123"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
}