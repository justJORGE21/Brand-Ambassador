package com.example.brandambassador;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.CalendarView;
import android.widget.CalendarView.OnDateChangeListener;

public class MainActivity extends Activity {
	//Initialize Variable
	String selectedDate;
	
	@Override  
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		CalendarView calendar = (CalendarView) findViewById(R.id.myCalendar);
				
		calendar.setOnDateChangeListener(new OnDateChangeListener()
			{
			@Override
			public void onSelectedDayChange (CalendarView view, int year, int month, int day)
			{
				int Day = day;
				int Month = month + 1; //Month starts with 0
				int Year = year;
				selectedDate = Month + "/" + Day + "/" + Year;
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	//Start addEvent Activity when Add Event Button is clicked
	public void addEvent (View view)
	{
		Intent intent = new Intent (this, AddEventActivity.class);
		intent.putExtra("SELECTED_DATE", selectedDate);
		startActivity (intent);
	}
	
	public void openDocs(View view) {
		Intent intent = new Intent(this, DisplayDocumentsActivity.class);	//create intent for DisplayDocumentsActivity
		startActivity(intent);	//start DisplayDocumentsActivity
	}
	
	public void doReports(View view){
		Intent intent = new Intent (this, DoReportActivity.class);
		startActivity (intent);
	
	
	}
}