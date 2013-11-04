package com.example.brandambassador.sqlite.helper;

import com.example.brandambassador.sqlite.model.Events;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class EventHelper extends SQLiteOpenHelper {
	    // Logcat tag
	    private static final String LOG = "DatabaseHelper";
	 
	    // Database Version
	    private static final int DATABASE_VERSION = 1;
	 
	    // Database Name
	    private static final String DATABASE_NAME = "EventsManger";
	 
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
	            + TABLE_EVENTINFO + "(" 
	    		+ KEY_ID + " INTEGER PRIMARY KEY," 
	    		+ KEY_TITLE + " TEXT," 
	            + KEY_LOCATION_LAT + " FLOAT," 
	            + KEY_LOCATION_LON + " FLOAT," 
	            + KEY_START_TIME + "DATETIME,"
	            + KEY_END_TIME + "DATETIME,"
	            + KEY_CLIENT + "TEXT,"
	            + KEY_EMPLOYER + "TEXT,"
	            + ")";
	 
	    // PaymentInfo table create statement
	    private static final String CREATE_TABLE_PAYMENTINFO = "CREATE TABLE " 
	    		+ TABLE_PAYMENTINFO + "(" 
	    		+ KEY_ID + " INTEGER PRIMARY KEY," 
	    		+ KEY_PAY_RATE + " FLOAT,"
	            + KEY_PAY_TYPE + " TEXT," 
	    		+ ")";
	 
	    public EventHelper(Context context) {
	        super(context, DATABASE_NAME, null, DATABASE_VERSION);
	    }
	 
	    @Override
	    public void onCreate(SQLiteDatabase db) {
	 
	        // creating required tables
	        db.execSQL(CREATE_TABLE_EVENTINFO);
	        db.execSQL(CREATE_TABLE_PAYMENTINFO);
	    }
	 
	    @Override
	    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	        // on upgrade drop older tables
	        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EVENTINFO);
	        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PAYMENTINFO);
	 
	        // create new tables
	        onCreate(db);
	    }
	    
	    public long createEvent(Events event) {
	    	SQLiteDatabase db = this.getWritableDatabase();
	    	
	    	ContentValues values = new ContentValues();
	    	values.put(KEY_TITLE, event.getEventTitle());
	    	values.put(KEY_LOCATION_LAT, event.getLat());
	    	values.put(KEY_LOCATION_LON, event.getLon());
	    	values.put(KEY_START_TIME, event.getStartTime());
	    	values.put(KEY_END_TIME, event.getEndTime());
	    	values.put(KEY_CLIENT, event.getClient());
	    	values.put(KEY_PAY_TYPE, getPayType());
	    	
	    	long event_id = db.insert(TABLE_EVENTINFO, null, values);
	    	
	    	return event_id;
	    }
}
