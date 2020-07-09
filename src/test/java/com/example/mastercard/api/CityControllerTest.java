package com.example.mastercard.api;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import com.example.mastercard.service.CityService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = CityController.class)
class CityControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CityService cityService;
	
	
	
	@Test
	public void testCheckGivenCitiesConnectedEndPoint() throws Exception{
		Mockito.when(
				cityService.checkOriginDestination(Mockito.anyString(),
						Mockito.anyString())).thenReturn("yes");
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/connected?origin=Philadelphia&destination=Albany").accept(MediaType.ALL);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();
		assertEquals(HttpStatus.OK.value(), response.getStatus());
		assertEquals("yes", result.getResponse().getContentAsString());
	}
	@Test
	public void testCheckGivenCitiesConnectedEndPointWithBlankOrigin() throws Exception{
		Mockito.when(
				cityService.checkOriginDestination(Mockito.anyString(),
						Mockito.anyString())).thenReturn("yes");
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/connected?origin=&destination=Albany").accept(MediaType.ALL);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();
		assertEquals(HttpStatus.OK.value(), response.getStatus());
		assertEquals("invalid origin", result.getResponse().getContentAsString());
	}
	
	@Test
	public void testCheckGivenCitiesConnectedEndPointWithBlankDestination() throws Exception{
		Mockito.when(
				cityService.checkOriginDestination(Mockito.anyString(),
						Mockito.anyString())).thenReturn("yes");
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/connected?origin=Philadelphia&destination=").accept(MediaType.ALL);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();
		assertEquals(HttpStatus.OK.value(), response.getStatus());
		assertEquals("invalid destination", result.getResponse().getContentAsString());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
