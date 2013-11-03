package com.example.brandambassador;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class ReportActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_reports);
		
		Intent intent = getIntent();
		
		//NEED TO STORE THIS VARIABLE LOCALLY AND SHOW IT IN THE REPORT PAGE
		String Title = intent.getStringExtra("TITLE");
		String Location = intent.getStringExtra("LOCATION");
		String Date = intent.getStringExtra("DATE");
		String Time_from = intent.getStringExtra("TIME_FROM");
		String Time_to = intent.getStringExtra("TIME_TO");
		String PayRate = intent.getStringExtra("PAYRATE");
		String PayDay = intent.getStringExtra("PAYDAY");
		String Prod_Client = intent.getStringExtra("PROD_CLIENT");
		String HiringComp = intent.getStringExtra("HIRINGCOMP");
		String Role = intent.getStringExtra("ROLE");
		String Contacts = intent.getStringExtra("CONTACTS");
		String Notes = intent.getStringExtra("NOTES");
	} 
}

