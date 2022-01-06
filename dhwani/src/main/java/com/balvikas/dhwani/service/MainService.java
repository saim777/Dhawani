package com.balvikas.dhwani.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.balvikas.dhwani.dto.ChildDto;
import com.balvikas.dhwani.dto.DistrictDto;
import com.balvikas.dhwani.dto.StateDto;
import com.balvikas.dhwani.entity.Child;
import com.balvikas.dhwani.entity.District;
import com.balvikas.dhwani.entity.State;
import com.balvikas.dhwani.mapper.ChildMapper;
import com.balvikas.dhwani.mapper.MainMapper;
import com.balvikas.dhwani.repository.ChildRepository;
import com.balvikas.dhwani.repository.DistrictRepository;
import com.balvikas.dhwani.repository.MainRepository;

@Service
public class MainService {

	@Autowired
	MainRepository mainRepository;

	@Autowired
	DistrictRepository districtRepository;

	@Autowired
	MainMapper mainMapper;
	
	@Autowired
	ChildRepository childRepository;

	@Autowired
	ChildMapper childMapper;

	Logger LOGGER = LoggerFactory.getLogger(MainService.class);

	public StateDto saveState(StateDto stateDto) {

		State stateEntity = mainMapper.dtoToEntity(stateDto);

		stateEntity = mainRepository.save(stateEntity);

		StateDto responseDto = mainMapper.entityToDto(stateEntity);

		return responseDto;

	}

	public ResponseEntity saveDistrict(DistrictDto districtDto) {
	
		try {
			Optional<State> optionlEntity = mainRepository.findByStateName(districtDto.getStateName());

			if (optionlEntity.isPresent()) {

				State entity = optionlEntity.get();

				District districtEntity = new District();
				districtEntity.setDistrictName(districtDto.getDistrictName());
				districtEntity.setStateId(entity.getId());
				
				districtEntity = districtRepository.save(districtEntity);
				
				
				

				DistrictDto responseDto = new DistrictDto();

				responseDto.setDistrictName(districtEntity.getDistrictName());

				return new ResponseEntity(responseDto, HttpStatus.OK);
			}

			else
				return new ResponseEntity("state not found", HttpStatus.NOT_FOUND);

		} catch (Exception e) {
			return new ResponseEntity("server error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	public ChildDto saveChild(ChildDto childDto) {

		Child childEntity = childMapper.dtoToEntity(childDto);

		childEntity = childRepository.save(childEntity);

		ChildDto responseDto = childMapper.entityToDto(childEntity);

		return responseDto;

	}

}
