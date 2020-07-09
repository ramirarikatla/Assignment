package com.example.mastercard.service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

@Service
public class CityService {

	public Map<String, List<String>> routeMap = new HashMap<>();
	public boolean routeExist = false;

	@PostConstruct
	public Map<String, List<String>> populateMapWithOriginAndDestinations() {
		Path path;
		Stream<String> lines = null;
		try {

			path = Paths.get(getClass().getClassLoader().getResource("city.txt").toURI());
			lines = Files.lines(path);
			List<String> routes = lines.map(s -> s.replaceAll(" ", "")).collect(Collectors.toList());
			for (String route : routes) {
				String[] cities = route.split(",");

				if (routeMap.containsKey(cities[0])) {
					List<String> destinationList = routeMap.get(cities[0]);
					destinationList.add(cities[1]);
				} else {
					List<String> destinationList = new ArrayList<>();
					destinationList.add(cities[1]);
					routeMap.put(cities[0], destinationList);
				}
			}

		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

		catch (IOException e) {
			e.printStackTrace();
		}

		finally {
			if (lines != null) {
				lines.close();
			}
		}
		return routeMap;
	}

	public String checkOriginDestination(String origin, String destination) {
		routeExist = false;

		if ("yes".equalsIgnoreCase(checkRouteMap(origin, destination))) {

			return "yes";
		} else {

			return checkRouteMap(destination, origin);
		}
	}

	private String checkRouteMap(String origin, String destination) {

		if (routeMap.containsKey(origin)) {
			for (String destinationCity : routeMap.get(origin)) {
				if (destination.equalsIgnoreCase(destinationCity)) {
					routeExist = true;
					break;
				} else {
					checkRouteMap(destinationCity, destination);
				}
			}

		}
		if (routeExist)
			return "yes";
		else
			return "no";

	}
}
