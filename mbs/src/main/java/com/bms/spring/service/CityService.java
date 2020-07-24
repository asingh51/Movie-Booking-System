package com.bms.spring.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bms.spring.model.City;
import com.bms.spring.repository.CityRepository;

@Service
public class CityService {

	@Autowired
	private CityRepository cityRepo;
	
	public Optional<City> getCityByName(String cname){
		return cityRepo.getCityByName(cname);
	}
	
	public Optional<Integer> getCityIdByName(String cName) {
		return cityRepo.getCityIdByCityName(cName);
	}

	public void addCity(City city) {
		cityRepo.save(city);
	}
	
}
