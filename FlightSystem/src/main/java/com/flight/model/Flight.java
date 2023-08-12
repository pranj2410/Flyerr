package com.flight.model;
public class Flight {
	private int id;
	private String flightName;
	private String source;
	private String destination;
	private int price;
	
	public Flight(int id, String flightName, String source, String destination, int price) {
		super();
		this.id = id;
		this.flightName = flightName;
		this.source = source;
		this.destination = destination;
		this.price = price;
	}
	
	
	public Flight() {
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFlightName() {
		return flightName;
	}
	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	
}
