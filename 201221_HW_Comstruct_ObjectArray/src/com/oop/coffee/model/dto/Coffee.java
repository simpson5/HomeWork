package com.oop.coffee.model.dto;

public class Coffee {
	private String origine;
	private String location;
	
	public Coffee() {}
	
	public Coffee(String origine, String location) {
		this.origine = origine;
		this.location = location;
	}
	
	public String getOrigine() {
		return origine;
	}

	public void setOrigine(String origine) {
		this.origine = origine;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	public void printCoffee() {
		System.out.println("원산지: " + origine);
		System.out.println("지역: " + location);
	}
	
}
