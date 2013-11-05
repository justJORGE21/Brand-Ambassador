package com.example.brandambassador;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.example.brandambassador.sqlite.helper.EventHelper;
import com.example.brandambassador.sqlite.model.Events;

public class AddEventActivity extends Activity {
	public final static String SELECTED_DATE = "com.example.brandambassador.DATE";		//Extra for passing date from MainActivity to AddEventActivity
	private String Date;			//String to hold Date
	private EditText showDate;		//EditText to display Date string
	
	@SuppressLint ("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_event);
		
		//Get the message from the intent that was in MainActivity
		Intent intent = getIntent();
		Date = intent.getStringExtra(SELECTED_DATE);		//store the date selected in Date string
		showDate = (EditText) findViewById(R.id.dateEditText);	//point showDate to date EditText
		showDate.setText(Date);			//put the string in the date editText
		
		if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) { 
			// Show the Up button in the action bar.
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}	
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_event, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void createEvent(View view)  {
		EventHelper db = new EventHelper(this);
		db.createEvent(new Events("Test 2"));
		
	}
}
