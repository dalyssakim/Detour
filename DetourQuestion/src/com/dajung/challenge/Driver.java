package com.dajung.challenge;


public class Driver {
	
	private Point departure;
	private Point destination;

	
	public Driver(Point departure, Point destination){
		this.departure = departure;
		this.destination = destination;
	}


	public Point getDeparture() {
		return departure;
	}


	public void setDeparture(Point departure) {
		this.departure = departure;
	}


	public Point getDestination() {
		return destination;
	}


	public void setDestination(Point destination) {
		this.destination = destination;
	}
	
	
}
