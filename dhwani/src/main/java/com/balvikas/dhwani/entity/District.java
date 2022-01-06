package com.balvikas.dhwani.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="District")
public class District {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private Integer stateId;
	private String DistrictName;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getStateId() {
		return stateId;
	}
	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}
	public String getDistrictName() {
		return DistrictName;
	}
	public void setDistrictName(String districtName) {
		DistrictName = districtName;
	}
	

	

}
