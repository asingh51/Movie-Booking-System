package com.bms.spring.repository;

import org.springframework.data.repository.CrudRepository;

import com.bms.spring.model.Cinema;

public interface CinemaRepository extends CrudRepository<Cinema, Integer> {

}
