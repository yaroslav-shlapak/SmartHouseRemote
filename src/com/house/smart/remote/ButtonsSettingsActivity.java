package com.house.smart.remote;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.EditText;

public class ButtonsSettingsActivity extends Activity {
	private Context context;
	private SharedPreferences sharedPrefName, sharedPrefString;
	private EditText buttonName, buttonString;
	int buttonNameInt = 0, buttonStringInt = 1;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_button_settings);
		
		getActionBar().setDisplayHomeAsUpEnabled(true);

		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			buttonNameInt = extras.getInt(MainActivity.BUTTON_NAME);
			buttonStringInt = extras.getInt(MainActivity.BUTTON_STRING);
		}
		buttonName = (EditText) findViewById(R.id.buttonName);
		buttonString = (EditText) findViewById(R.id.buttonString);

		context = getApplicationContext();
		sharedPrefName = context.getSharedPreferences(
				getString(buttonNameInt), Context.MODE_PRIVATE);
		sharedPrefString = context.getSharedPreferences(
				getString(buttonStringInt), Context.MODE_PRIVATE);

		String textButtonName = sharedPrefName.getString(
				getString(buttonNameInt), getResources().getString(buttonNameInt));
		String textButtonString = sharedPrefString.getString(
				getString(buttonStringInt), getResources().getString(buttonStringInt));

		buttonName.setText(textButtonName);
		buttonString.setText(textButtonString);

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
			finish();
			return true;
		case R.id.action_accept:
			SharedPreferences.Editor editorName = sharedPrefName.edit();
			SharedPreferences.Editor editorString = sharedPrefString.edit();
			editorName.putString(getString(buttonNameInt), buttonName
					.getText().toString());
			editorString.putString(getString(buttonStringInt), buttonString
					.getText().toString());
			editorName.commit();
			editorString.commit();
			finish();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
}
