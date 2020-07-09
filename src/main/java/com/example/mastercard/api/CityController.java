package com.example.mastercard.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.mastercard.service.CityService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/connected")
public class CityController {
	@Autowired
	private CityService cityService;

	@GetMapping

	@ApiOperation(value = "checkGivenCitiesConnect", nickname = "CitiesConnect", 
					notes = "Provide origin and destination cities and check if they connect")
	public String checkGivenCitiesConnected(
			@ApiParam(name = "origin", value = "origin city name", required = true) @RequestParam String origin,
			@ApiParam(name = "destination", value = "destination city name", required = true) @RequestParam String destination) {
		if(!StringUtils.hasText(origin))return "invalid origin";
		if(!StringUtils.hasText(destination))return "invalid destination";
		return cityService.checkOriginDestination(origin, destination);

	}

}
