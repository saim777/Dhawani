package com.balvikas.dhwani.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.balvikas.dhwani.entity.State;

public interface MainRepository extends JpaRepository<State,Integer>{

	
	Optional<State> findByStateName(String stateName);
   
	
}
