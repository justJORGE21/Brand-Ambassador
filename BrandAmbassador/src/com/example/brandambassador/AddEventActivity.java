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
import android.widget.TextView;

public class AddEventActivity extends Activity {
	EditText Title, Location, eventDate, Time_from, Time_to, PayRate, PayDay, Prod_Client, HiringComp, Role, Contacts, Notes;

	@SuppressLint ("NewApi") 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_event);
		
		setupActionBar();
		
		//Get the message from the intent that was in MainActivity
		Intent intent = getIntent();
		String Date = intent.getStringExtra("SELECTED_DATE");
		
		TextView displayDate = (TextView) findViewById(R.id.displayDate);
		displayDate.setText(Date);
	}

	/**
	 * Set up the {@link android.app.ActionBar}.
	 */
	private void setupActionBar() {
		 if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) 
		 {
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
	
	//start ReportActivity to save the event
	public void saveEvent(View view)
	{
		Intent SaveEvent = new Intent (this, ReportActivity.class);
		getEventData();
		
		SaveEvent.putExtra("TITLE", Title.getText().toString());
		SaveEvent.putExtra("LOCATION", Location.getText().toString());
		SaveEvent.putExtra("DATE", eventDate.getText().toString());
		SaveEvent.putExtra("TIME_FROM", Time_from.getText().toString());
		SaveEvent.putExtra("TIME_TO", Time_to.getText().toString());
		SaveEvent.putExtra("PAYRATE", PayRate.getText().toString());
		SaveEvent.putExtra("PAYDAY", PayDay.getText().toString());
		SaveEvent.putExtra("PROD_CLIENT", Prod_Client.getText().toString());
		SaveEvent.putExtra("HIRINGCOMP", HiringComp.getText().toString());
		SaveEvent.putExtra("ROLE", Role.getText().toString());
		SaveEvent.putExtra("CONTACTS", Contacts.getText().toString());
		SaveEvent.putExtra("NOTES", Notes.getText().toString());
		
		startActivity(SaveEvent);
	}
	
	public void getEventData ()
	{
		Title = (EditText) findViewById (R.id.enterTitle);
		Location = (EditText) findViewById (R.id.enterLocation);
		eventDate = (EditText) findViewById (R.id.displayDate);
		Time_from = (EditText) findViewById (R.id.time_from);
		Time_to = (EditText) findViewById (R.id.time_to);
		PayRate = (EditText) findViewById (R.id.enterPayRate);
		PayDay = (EditText) findViewById (R.id.enterPayDay);
		Prod_Client = (EditText) findViewById (R.id.productClient);
		HiringComp = (EditText) findViewById (R.id.enterHiringCompany);
		Role = (EditText) findViewById (R.id.enterRole);
		Contacts = (EditText) findViewById (R.id.enterContacts);
		Notes = (EditText) findViewById (R.id.enterNotes);		
	}

}
