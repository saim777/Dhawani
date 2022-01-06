package com.balvikas.dhwani.mapper;

import org.springframework.stereotype.Component;
import com.balvikas.dhwani.dto.ChildDto;
import com.balvikas.dhwani.entity.Child;
@Component
public class ChildMapper {
	public Child dtoToEntity(ChildDto dto) {
		
		Child entity=new Child();
		entity.setChildName(dto.getChildName());
		
		return entity;
		
	}
	public ChildDto entityToDto(Child entity) {
		
		ChildDto dto=new ChildDto();
		dto.setChildName(entity.getChildName());
		
		return dto;
		
	}
}
