package com.example.brandambassador;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.CalendarView;
import android.widget.CalendarView.OnDateChangeListener;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	TextView selectedDate;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		CalendarView calendar = (CalendarView) findViewById(R.id.myCalendar);
		selectedDate = (TextView) findViewById (R.id.selectedDate);
		
		calendar.setOnDateChangeListener(new OnDateChangeListener()
			{
			@Override
			public void onSelectedDayChange (CalendarView view, int year, int month, int day)
			{
				int Day = day;
				int Month = month + 1; //Month starts with 0
				int Year = year;
				
				selectedDate.setText(Month + "/" + Day + "/" + Year);
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void addEvent (View view)
	{
		Intent intent = new Intent(this, AddEventActivity.class);			//create intent for AddEventActivity
		intent.putExtra(AddEventActivity.SELECTED_DATE, selectedDate.getText()); //pass the selected date to AddEventActivity
		startActivity(intent);  //start AddEventActivity
	}
	
	public void openDocs(View view) {
		Intent intent = new Intent(this, DisplayDocumentsActivity.class);	//create intent for DisplayDocumentsActivity
		startActivity(intent);	//start DisplayDocumentsActivity
	}
}