package com.balvikas.dhwani.mapper;

import org.springframework.stereotype.Component;

import com.balvikas.dhwani.dto.StateDto;
import com.balvikas.dhwani.entity.State;

@Component
public class MainMapper {

	
	public State dtoToEntity(StateDto dto) {
		
		State entity=new State();
		entity.setStateName(dto.getStateName());
		
		return entity;
		
	}
	public StateDto entityToDto(State entity) {
		
		StateDto dto=new StateDto();
		dto.setStateName(entity.getStateName());
		
		return dto;
		
	}
}
