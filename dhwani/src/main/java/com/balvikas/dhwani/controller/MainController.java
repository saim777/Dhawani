package com.balvikas.dhwani.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.balvikas.dhwani.dto.ChildDto;
import com.balvikas.dhwani.dto.DistrictDto;
import com.balvikas.dhwani.dto.StateDto;
import com.balvikas.dhwani.service.MainService;

@RestController
@RequestMapping("/dhwani")
public class MainController {

	@Autowired
	MainService mainService;

	Logger LOGGER = LoggerFactory.getLogger(MainController.class);

	@PostMapping("/saveState")
	public ResponseEntity<?> saveState(@RequestBody StateDto stateDto) {

		try {
			StateDto responseDto = mainService.saveState(stateDto);
			return new ResponseEntity(responseDto, HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PostMapping("/saveDistrict")
	public ResponseEntity<?> saveState(@RequestBody DistrictDto districtDto) {

		
			return  mainService.saveDistrict(districtDto);

	}
	@PostMapping("/saveChild")
	public ResponseEntity<?> saveChild(@RequestBody ChildDto childDto) {

		try {
			ChildDto responseDto = mainService.saveChild(childDto);
			return new ResponseEntity(responseDto, HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
