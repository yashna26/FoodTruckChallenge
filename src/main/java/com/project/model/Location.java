package com.project.model;

import java.io.Serializable;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Location implements Serializable {
	
	public Location() {}
	
	public Location(BigDecimal latitude, BigDecimal longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	@JsonCreator
	public Location (@JsonProperty("lat") BigDecimal latitude ) {
	    this.latitude = latitude;
	}
	
	@JsonProperty(value = "lat")
	private BigDecimal latitude;
	
	@JsonProperty(value = "lng")
	private BigDecimal longitude;


	public BigDecimal getLatitude() {
		return latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	public BigDecimal getLongitude() {
		return longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}

}
