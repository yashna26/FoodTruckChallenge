package com.project.model;

import java.io.Serializable;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserLocation implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public UserLocation() {}
	
	public UserLocation(Map<String, Location> locations) {
		this.locations = locations;
	}
	
	@JsonProperty(value = "location")
	private Map<String, Location> locations; // ( locations -> Location
	

	public Map<String, Location> getLocations() {
		return locations;
	}

	public void setLocations(Map<String, Location> locations) {
		this.locations = locations;
	}

}
