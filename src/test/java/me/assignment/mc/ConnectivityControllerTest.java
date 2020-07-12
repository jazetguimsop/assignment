package me.assignment.mc;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

public class ConnectivityControllerTest extends ConnectivityAbstractTest {
	@Override
	@Before
	public void setUp() {
		super.setUp();
	}

	@Test
	public void isConnectedN2N() throws Exception {
		String uri = "/connected";
		MvcResult mvcResult = mvc
				.perform(MockMvcRequestBuilders.get(uri).param("origin", "Newark").param("destination", "NewYork"))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals("no", content);
	}

	@Test
	public void isConnectedB2N() throws Exception {
		String uri = "/connected";
		MvcResult mvcResult = mvc
				.perform(MockMvcRequestBuilders.get(uri).param("origin", "Boston").param("destination", "Newark"))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals("yes", content);
	}

	@Test
	public void isConnectedB2P() throws Exception {
		String uri = "/connected";
		MvcResult mvcResult = mvc
				.perform(MockMvcRequestBuilders.get(uri).param("origin", "Boston").param("destination", "Philadelphia"))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals("yes", content);
	}

	@Test
	public void isConnectedP2B() throws Exception {
		String uri = "/connected";
		MvcResult mvcResult = mvc
				.perform(MockMvcRequestBuilders.get(uri).param("origin", "Philadelphia").param("destination", "Boston"))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals("no", content);
	}

	@Test
	public void isConnectedP2A() throws Exception {
		String uri = "/connected";
		MvcResult mvcResult = mvc
				.perform(MockMvcRequestBuilders.get(uri).param("origin", "Philadelphia").param("destination", "Albany"))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals("no", content);
	}

	@Test
	public void isConnectedT2B() throws Exception {
		String uri = "/connected";
		MvcResult mvcResult = mvc
				.perform(MockMvcRequestBuilders.get(uri).param("origin", "Trenton").param("destination", "Boston"))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals("no", content);
	}

}