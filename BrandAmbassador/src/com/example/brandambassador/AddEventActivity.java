package com.example.brandambassador;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class AddEventActivity extends Activity {
	EditText Title, Location, eventDate, Time_from, Time_to, PayRate, PayDay, Prod_Client, HiringComp, Role, Contacts, Notes;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_event);
		
		//Get the message from the intent that was in MainActivity
		Intent intent = getIntent();
		String Date = intent.getStringExtra("SELECTED_DATE");
		
		TextView displayDate = (TextView) findViewById(R.id.displayDate);
		displayDate.setText(Date);
	}
	
	
	//start ReportActivity to save the event
	public void saveEvent(View view)
	{
		Intent SaveEvent = new Intent (this, DoReportActivity.class);
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
