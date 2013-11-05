package com.example.brandambassador.sqlite.model;

public class Events {
	    int id = 0;
	    String eventTitle, client, employer;
	    boolean payType;
	    double latitude, longitude;
	    int startTime, endTime;
	    	 
	    // constructors
	    public Events() {
	    	
	    }
	    
	    public Events(String eventTitle) {
	    	super();
	    	this.eventTitle = eventTitle;
	    }
	 
	    @Override
	    public String toString() {
	    	return "Event [id= " + id + " "+ eventTitle;
	    }
	    
	    // setters
	    public void setId(int id) {
	        this.id = id;
	    }
	 
	    public void setEventTitle(String eventTitle) {
	        this.eventTitle = eventTitle;
	    }
	 
	    public void setClient(String client) {
	    	this.client = client;
	    }
	    
	    public void setEmployer(String employer) {
	    	this.employer = employer;
	    }
	    
	    public void setLatitude(double latitude) {
	    	this.latitude = latitude;
	    }
	    
	    public void setLongitude(double longitude) {
	    	this.longitude = longitude;
	    }
	    
	    public void setStartTime(int startTime) {
	    	this.startTime = startTime;
	    }
	    
	    public void setEndTime(int endTime) {
	    	this.endTime = endTime;
	    }
	    
	    public void setPayType(boolean payType) {
	    	this.payType = payType;
	    }
	    	 
	    // getters
	    public long getId() {
	        return this.id;
	    }
	 
	    public String getEventTitle() {
	        return this.eventTitle;
	    }
	    
	    public String getClient() {
	    	return this.client;
	    }
	    
	    public String getEmployer() {
	    	return this.employer;
	    }
	    
	    public double getLongitude() {
	    	return this.longitude;
	    }
	    
	    public double getLatitude() {
	    	return this.latitude;
	    }
	    
	    public int getStartTime() {
	    	return this.startTime;
	    }
	    	    
	    public int getEndTime() {
	    	return this.endTime;
	    }
	    
	    public boolean getPayType() {
	    	return this.payType;
	    }
}
