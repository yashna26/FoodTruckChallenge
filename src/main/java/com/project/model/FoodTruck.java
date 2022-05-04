package com.project.model;

import java.math.BigDecimal;
import java.util.List;

import com.opencsv.bean.CsvBindByName;

public class FoodTruck {
	
	public FoodTruck() {}
	
	public FoodTruck(String truckName, String address) {
		this.truckName = truckName;
		this.address = address;
	}
	
	@CsvBindByName(column = "Applicant")
	private String truckName;
	
	@CsvBindByName(column = "Address")
	private String address;
	
	@CsvBindByName(column = "FoodItems")
	private String foodItems;
	
	@CsvBindByName(column = "LocationDescription")
	private String locationDescription;

	@CsvBindByName(column = "Latitude")
	private BigDecimal latitude;
	
	@CsvBindByName(column = "Longitude")
	private BigDecimal longitude;
	
	@CsvBindByName(column = "dayshours")
	private String daysHours;
	
	public String getDaysHours() {
		return daysHours;
	}

	public void setDaysHours(String daysHours) {
		this.daysHours = daysHours;
	}

	public String getTruckName() {
		return truckName;
	}

	public void setTruckName(String truckName) {
		this.truckName = truckName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFoodItems() {
		return foodItems;
	}

	public void setFoodItems(String foodItems) {
		this.foodItems = foodItems;
	}

	public void setLocationDescription(String locationDescription) {
		this.locationDescription = locationDescription;
	}
	
	public String getLocationDescription() {
		return locationDescription;
	}

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
