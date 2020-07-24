package com.bms.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bms.spring.model.City;
import com.bms.spring.service.CityService;

@RestController
public class CityController {

	@Autowired
	CityService cityService;
	
	@RequestMapping(method=RequestMethod.POST, value="/cities")
	public void addCity(@RequestBody City city) {
		System.out.println(city.toString());
		cityService.addCity(city);
	}
}
