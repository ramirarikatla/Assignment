package com.example.mastercard;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.mastercard.api.CityController;

@RunWith(SpringRunner.class)
@SpringBootTest
class MasterCardApplicationTests {
	@Autowired
	private CityController cityController;

	@Test
	public void testCheckGivenCitiesConnected() {

		String result = cityController.checkGivenCitiesConnected("Boston", "Philadelphia");
		assertEquals("yes", result);
	}

}
