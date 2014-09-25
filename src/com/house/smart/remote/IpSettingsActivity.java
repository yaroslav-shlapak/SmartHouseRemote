package com.house.smart.remote;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class IpSettingsActivity extends Activity {
	Context context;
	SharedPreferences sharedPref;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ip_settings);
		context = getApplicationContext();
		sharedPref = context.getSharedPreferences(getString(R.string.preference_ip), Context.MODE_PRIVATE);
		
		
	}

	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_ip_settings, menu);
		return super.onCreateOptionsMenu(menu);
		
		
	}
	
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle presses on the action bar items
	    switch (item.getItemId()) {
	        case R.id.action_undo:
	        	
	            return true;
	        case R.id.action_accept:

	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}
}
