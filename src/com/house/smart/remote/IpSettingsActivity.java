package com.house.smart.remote;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class IpSettingsActivity extends Activity {
	private Context context;
	private SharedPreferences sharedPrefIp;
	//SharedPreferences sharedPrefPort;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ip_settings);
		context = getApplicationContext();
		sharedPrefIp = context.getSharedPreferences(getString(R.string.preference_ip), Context.MODE_PRIVATE);
		
		EditText etIp = (EditText) findViewById(R.id.ip_address);
		EditText etPort = (EditText) findViewById(R.id.port_address);
		
		SharedPreferences.Editor editor = sharedPref.edit();
		editor.putString(getString(R.string.preference_ip), etIp.getText().toString());
		editor.putString(getString(R.string.preference_port), etIp.getText().toString());
		editor.commit();
		
		
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
