package com.example.brandambassador.sqlite.model;

public class Events {
	    int id;
	    String eventTitle;
	    int status;
	    String created_at;
	 
	    // constructors
	    public Events() {
	    }
	 
	   
	 
	    
	 
	    // setters
	    public void setId(int id) {
	        this.id = id;
	    }
	 
	    public void setEventTitle(String eventTitle) {
	        this.eventTitle = eventTitle;
	    }
	 
	    
	 
	    // getters
	    public long getId() {
	        return this.id;
	    }
	 
	    public String getEventTitle() {
	        return this.eventTitle;
	    }

}
