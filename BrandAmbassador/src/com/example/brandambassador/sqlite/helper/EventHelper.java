package com.example.brandambassador.sqlite.helper;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.brandambassador.sqlite.model.Events;

public class EventHelper extends SQLiteOpenHelper {
	 
    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "event_info";
    private static final String KEY_ID = "id";
    private static final String KEY_TITLE = "title";
    private static final String KEY_LOCATION_LAT = "latitude";
    private static final String KEY_LOCATION_LON = "longitude";
    private static final String KEY_START_TIME = "startTime";
    private static final String KEY_END_TIME = "endTime";
    private static final String KEY_CLIENT = "client";
    private static final String KEY_EMPLOYER = "employer";
    
    private static final String[] COLUMNS = { KEY_ID, KEY_TITLE, KEY_LOCATION_LAT, KEY_LOCATION_LON, KEY_START_TIME, KEY_END_TIME,
    	KEY_CLIENT, KEY_EMPLOYER };
 
 
    public EventHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);  
    }
 
    @Override
    public void onCreate(SQLiteDatabase db) {
        // SQL statement to create book table
        String CREATE_EVENT_TABLE = "CREATE TABLE events ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " + 
                "title TEXT, "+
                "date TEXT )";
 
        // create books table
        db.execSQL(CREATE_EVENT_TABLE);
    }
 
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older books table if existed
        db.execSQL("DROP TABLE IF EXISTS events");
 
        // create fresh books table
        this.onCreate(db);
    }
    
    public void createEvent(Events event) {
       	Log.d("addEvent", event.toString());
       	
       	SQLiteDatabase db = this.getWritableDatabase();
       	
       	ContentValues values = new ContentValues();
       	values.put("title", event.getEventTitle());
    	/*values.put("25", event.getLatitude());
    	values.put("5", event.getLongitude());
    	values.put("0800", event.getStartTime());
    	values.put("1030", event.getEndTime());
    	values.put("myClient", event.getClient());
    	values.put("hourly", event.getPayType());*/
       	
       	
       	db.insert("events", null, values);
       	db.close();
    }
    
    public Events getEvent(int eventId) {
    	SQLiteDatabase db = this.getReadableDatabase();
    	
    	Cursor cursor = 
    			db.query("events",
    					COLUMNS,
    					"id = ?",
    					new String[] { String.valueOf(eventId) },
    					             null,
    					             null,
    					             null,
    					             null);
    	
    	if(cursor != null)
    		cursor.moveToFirst();
    	
    	Events event = new Events();
    	event.setId(Integer.parseInt(cursor.getString(0)));
    	event.setEventTitle(cursor.getString(1));
    	
    	Log.d("getEvent("+eventId+")", event.toString());
    	
    	return event;

    }
     /*   String selectQuery = "SELECT  * FROM " + TABLE_EVENTINFO + " WHERE "
                + KEY_ID + " = " + eventId;
     
        Log.e(LOG, selectQuery);
     
        Cursor c = db.rawQuery(selectQuery, null);
     
        if (c != null)
            c.moveToFirst();
     
        Events event = new Events();
        event.setId(c.getInt(c.getColumnIndex(KEY_ID)));
        event.setEventTitle(c.getString(c.getColumnIndex(KEY_TITLE)));
        event.setLatitude(c.getInt(c.getColumnIndex(KEY_LOCATION_LAT)));
        event.setLongitude(c.getInt(c.getColumnIndex(KEY_LOCATION_LON)));
        event.setStartTime(c.getInt(c.getColumnIndex(KEY_START_TIME)));
        event.setEndTime(c.getInt(c.getColumnIndex(KEY_END_TIME)));
        
        return event; */
    	
 
}

/*

public class EventHelper extends SQLiteOpenHelper {
	    // Logcat tag
	    private static final String LOG = "DatabaseHelper";
	
	    // Database Version
	    private static final int DATABASE_VERSION = 1;
	 
	    // Database Name
	    private static final String DATABASE_NAME = "EventsManager";
	 
	    // Table Names
	    private static final String TABLE_EVENTINFO = "event_info";
	    private static final String TABLE_PAYMENTINFO = "payment_info";
	    private static final String TABLE_ROLEINFO = "role_info";
	 
	    // Common column names
	    private static final String KEY_ID = "id";
	//    private static final String KEY_CREATED_AT = "created_at";
	 
	    // EventInfo Table - column names
	    private static final String KEY_TITLE = "title";
	    private static final String KEY_LOCATION_LAT = "latitude";
	    private static final String KEY_LOCATION_LON = "longitutde";
	    private static final String KEY_START_TIME = "start_time";
	    private static final String KEY_END_TIME = "end_time";
	    private static final String KEY_CLIENT = "client/product";
	    private static final String KEY_EMPLOYER = "hiring_company";
	 
	    // PaymentInfo Table - column names
	    private static final String KEY_PAY_RATE = "pay_rate";
	    private static final String KEY_PAY_TYPE = "pay_type";
	    
	 
	    // RoleInfo Table - column names
	    
	 
	    // Table Create Statements
	    // EventInfo table create statement
	    private static final String CREATE_TABLE_EVENTINFO = "CREATE TABLE "
	            + TABLE_EVENTINFO + " (" 
	    		+ KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," 
	    		+ KEY_TITLE + " TEXT," 
	            + KEY_LOCATION_LAT + " REAL," 
	            + KEY_LOCATION_LON + " REAL," 
	            + KEY_START_TIME + "INTEGER,"
	            + KEY_END_TIME + "INTEGER,"
	            + KEY_CLIENT + "TEXT,"
	            + KEY_EMPLOYER + "TEXT,"
	            + ");";
	 
	    // PaymentInfo table create statement
	    private static final String CREATE_TABLE_PAYMENTINFO = "CREATE TABLE " 
	    		+ TABLE_PAYMENTINFO + "(" 
	    		+ KEY_ID + " INTEGER PRIMARY KEY," 
	    		+ KEY_PAY_RATE + " REAL,"
	            + KEY_PAY_TYPE + " INTEGER," 
	    		+ ");";
	 
	    public EventHelper(Context context) {
	        super(context, DATABASE_NAME, null, DATABASE_VERSION);
	    }
	 
	    @Override
	    public void onCreate(SQLiteDatabase db) {
	 
	        // creating required tables
	        db.execSQL(CREATE_TABLE_EVENTINFO);
	   //     db.execSQL(CREATE_TABLE_PAYMENTINFO);
	    }
	 
	    @Override
	    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	        // on upgrade drop older tables
	        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EVENTINFO);
	        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PAYMENTINFO);
	 
	        // create new tables
	        onCreate(db);
	    }*/
	    
	    /* create an event *//*
	    public long createEvent(Events event) throws SQLException {
	       	SQLiteDatabase db = this.getWritableDatabase();
	    	ContentValues values = new ContentValues();
	    	values.put(KEY_TITLE, event.getEventTitle());
	    	values.put(KEY_LOCATION_LAT, event.getLatitude());
	    	values.put(KEY_LOCATION_LON, event.getLongitude());
	    	values.put(KEY_START_TIME, event.getStartTime());
	    	values.put(KEY_END_TIME, event.getEndTime());
	    	values.put(KEY_CLIENT, event.getClient());
	    	values.put(KEY_PAY_TYPE, event.getPayType());
	  	
		    long event_id = db.insert(TABLE_EVENTINFO, null, values);
		    	
	    	return event_id;
	    }
	    
	    /* get a single event *//*
	    public Events getEvent(long eventId) {
	    	SQLiteDatabase db = this.getReadableDatabase();
	    	
	        String selectQuery = "SELECT  * FROM " + TABLE_EVENTINFO + " WHERE "
	                + KEY_ID + " = " + eventId;
	     
	        Log.e(LOG, selectQuery);
	     
	        Cursor c = db.rawQuery(selectQuery, null);
	     
	        if (c != null)
	            c.moveToFirst();
	     
	        Events event = new Events();
	        event.setId(c.getInt(c.getColumnIndex(KEY_ID)));
	        event.setEventTitle(c.getString(c.getColumnIndex(KEY_TITLE)));
	        event.setLatitude(c.getInt(c.getColumnIndex(KEY_LOCATION_LAT)));
	        event.setLongitude(c.getInt(c.getColumnIndex(KEY_LOCATION_LON)));
	        event.setStartTime(c.getInt(c.getColumnIndex(KEY_START_TIME)));
	        event.setEndTime(c.getInt(c.getColumnIndex(KEY_END_TIME)));
	        
	        return event;
	    }
	    
	    /* get all events */	    /*
	    public List<Events> getAllEvents() {
	        List<Events> eventsList = new ArrayList<Events>();
	        String selectQuery = "SELECT  * FROM " + TABLE_EVENTINFO;
	     
	        Log.i(getDatabaseName(), "ow");
	     
	        SQLiteDatabase db = this.getReadableDatabase();
	        Cursor c = db.rawQuery(selectQuery, null);
	     
	        // looping through all rows and adding to list
	        if (c.moveToFirst()) {
	            do {
	                Events event = new Events();
	                event.setId(c.getInt(c.getColumnIndex(KEY_ID)));
	    	        event.setEventTitle(c.getString(c.getColumnIndex(KEY_TITLE)));
	    	        event.setLatitude(c.getInt(c.getColumnIndex(KEY_LOCATION_LAT)));
	    	        event.setLongitude(c.getInt(c.getColumnIndex(KEY_LOCATION_LON)));
	    	        event.setStartTime(c.getInt(c.getColumnIndex(KEY_START_TIME)));
	    	        event.setEndTime(c.getInt(c.getColumnIndex(KEY_END_TIME)));
	     
	                // adding to event list
	                eventsList.add(event);
	            } while (c.moveToNext());
	        }
	     
	        return eventsList;
	    }
}*/
