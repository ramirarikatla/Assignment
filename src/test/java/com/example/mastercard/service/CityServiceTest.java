package com.example.mastercard.service;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class CityServiceTest {
	@Autowired
	CityService cityService;

	@Test
	public void testCityTextFile() throws IOException {
		String expected_value = "Boston, New York";

		Path path = Paths.get("src/main/resources/city.txt");

		BufferedReader reader = Files.newBufferedReader(path);
		String line = reader.readLine();
		assertEquals(expected_value, line);
	}

	@Test
	public void testPopulateMapWithOriginAndDestinations() {

		Map<String, List<String>> routeMap = cityService.populateMapWithOriginAndDestinations();
		assertTrue(routeMap.containsKey("Boston"));

	}

	@Test

	public void testCheckOriginDestination() {

		cityService.populateMapWithOriginAndDestinations();
		String result = cityService.checkOriginDestination("Boston", "Philadelphia");
		assertEquals("yes", result);
	}

}
