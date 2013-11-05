package com.example.brandambassador;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

public class DoReportActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		setContentView(R.layout.do_report);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.do_report, menu);
		return true;
	}

}
