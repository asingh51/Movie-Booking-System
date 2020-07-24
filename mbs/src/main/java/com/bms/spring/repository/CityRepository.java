package com.bms.spring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.bms.spring.model.City;

public interface CityRepository extends CrudRepository<City, Integer> {

	@Query("SELECT cityId FROM City where name = ?1")
	public Optional<Integer> getCityIdByCityName(String cityName);

	public Optional<City> getCityByName(String cname);
	
}
