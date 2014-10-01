package com.house.smart.remote;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	public final static String BUTTON_NAME = "com.house.smart.remote.BUTTON.NAME";
	public final static String BUTTON_STRING = "com.house.smart.remote.BUTTON.STRIMG";
	private final static int BUTTONS_NUMBER = 9;
	private Context context;
	private SharedPreferences sharedPrefIp, sharedPrefPort;
	private String textIp, textPort, defaultIp, defaultPort;
	
	private SharedPreferences [] sharedPrefNameButton = new SharedPreferences[BUTTONS_NUMBER];
	private SharedPreferences [] sharedPrefStringButton = new SharedPreferences[BUTTONS_NUMBER];
	private Button[] buttons = new Button[BUTTONS_NUMBER];
	
	private final static int[] buttonsRid = {R.id.button1, R.id.button2, R.id.button3, R.id.button4, 
		R.id.button5, R.id.button6, R.id.button7, R.id.button8, R.id.button9};
	
	private final static int[] buttonStrNames = {R.string.buttonName1, R.string.buttonName2, R.string.buttonName3, 
		R.string.buttonName4, R.string.buttonName5, R.string.buttonName6, R.string.buttonName7, R.string.buttonName8,
		R.string.buttonName9};
	private final static int[] buttonStrStrings = {R.string.textButton1, R.string.textButton2, R.string.textButton3, 
		R.string.textButton4, R.string.textButton5, R.string.textButton6, R.string.textButton7, R.string.textButton8,
		R.string.textButton9};

	private OnClickListener onClickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			sendData(v);
		}
	};

	private OnLongClickListener onLongClickListener = new OnLongClickListener() {

		@Override
		public boolean onLongClick(View v) {
			// TODO Auto-generated method stub
			Intent intent = new Intent(getApplicationContext(),
					ButtonsSettingsActivity.class);
			
			for(int i = 0; i < BUTTONS_NUMBER; i++) {
				if(buttonsRid[i] == v.getId()) {
					intent.putExtra(BUTTON_NAME, buttonStrNames[i]);
					intent.putExtra(BUTTON_STRING, buttonStrStrings[i]);
					startActivity(intent);
					break;
				}
			}
			return true;
		}

	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		createButtons();
		initOnClickListeners();
		initOnLongClickListeners();
		
		initIPandPort();
		createSharedPrefName();
		createSharedPrefString();
		
		initButtonsNames();
	}
	
	public void onResume() {
		super.onResume();
		initButtonsNames();
	}

	private void initButtonsNames() {
		// TODO Auto-generated method stub
		for(int i = 0; i < BUTTONS_NUMBER; i++)
			buttons[i].setText(sharedPrefNameButton[i].getString(
					getString(buttonStrNames[i]), getResources().getString(buttonStrNames[i])));
	}

	private void initOnLongClickListeners() {
		// TODO Auto-generated method stub
		for(int i = 0; i < BUTTONS_NUMBER; i++)
			buttons[i].setOnLongClickListener(onLongClickListener);
	}

	private void initOnClickListeners() {
		// TODO Auto-generated method stub
		for(int i = 0; i < BUTTONS_NUMBER; i++)
			buttons[i].setOnClickListener(onClickListener);
	}

	private void createButtons() {
		// TODO Auto-generated method stub
		for(int i = 0; i < BUTTONS_NUMBER; i++)
			buttons[i] = (Button) findViewById(buttonsRid[i]);
	}

	private void createSharedPrefName() {
		// TODO Auto-generated method stub
		for(int i = 0; i < BUTTONS_NUMBER; i++)
			sharedPrefNameButton[i] = context.getSharedPreferences(
					getString(buttonStrNames[i]), Context.MODE_PRIVATE);
	}

	private void createSharedPrefString() {
		// TODO Auto-generated method stub
		for(int i = 0; i < BUTTONS_NUMBER; i++)
			sharedPrefStringButton[i] = context.getSharedPreferences(
					getString(buttonStrStrings[i]), Context.MODE_PRIVATE);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return super.onCreateOptionsMenu(menu);
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle presses on the action bar items
		switch (item.getItemId()) {
		case R.id.ip_settings:
			openIpSettings();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	private void openIpSettings() {
		// TODO Auto-generated method stub
		Intent intent = new Intent(this, IpSettingsActivity.class);
		startActivity(intent);
	}

	private void sendData(View view) {
		Context context = getApplicationContext();

		textIp = sharedPrefIp.getString(getString(R.string.preference_ip),
				defaultIp);
		textPort = sharedPrefPort.getString(
				getString(R.string.preference_port), defaultPort);

		String host = textIp;
		if (!host.matches("\\b(?:\\d{1,3}\\.){3}\\d{1,3}\\b")) {
			CharSequence text = "Error: Invalid IP Address";
			Toast toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
			toast.show();
			return;
		}

		String port = textPort;
		if (!port
				.matches("^(6553[0-5]|655[0-2]\\d|65[0-4]\\d\\d|6[0-4]\\d{3}|[1-5]\\d{4}|[1-9]\\d{0,3}|0)$")) {
			CharSequence text = "Error: Invalid Port Number";
			Toast toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
			toast.show();
			return;
		}

		String dataText = getButtonText(view);
		String dataHex = "";
		if (dataText.length() < 1 && dataHex.length() < 2) {
			CharSequence text = "Error: Text/Hex required to send";
			Toast toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
			toast.show();
			return;
		}
		String uriString = "udp://" + host + ":" + port + "/";
		if (dataHex.length() >= 2) {
			uriString += Uri.encode("0x" + dataHex);
		} else {
			uriString += Uri.encode(dataText);
		}
		Uri uri = Uri.parse(uriString);
		Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
		intent.addFlags(Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP);
		intent.addCategory(Intent.CATEGORY_DEFAULT);

		startActivity(intent);
	}

	private String getButtonText(View v) {
		String result = "";
		for(int i = 0; i < BUTTONS_NUMBER; i++) {
			if(buttonsRid[i] == v.getId()) {
				result = sharedPrefStringButton[i].getString(
						getString(buttonStrStrings[i]), getResources().getString(buttonStrStrings[i]));
				break;
			}
		}
		return result;
	}
	
	private void initIPandPort() {
		context = getApplicationContext();
		sharedPrefIp = context.getSharedPreferences(
				getString(R.string.preference_ip), Context.MODE_PRIVATE);
		sharedPrefPort = context.getSharedPreferences(
				getString(R.string.preference_port), Context.MODE_PRIVATE);

		defaultIp = getResources().getString(R.string.defaultIP);
		defaultPort = getResources().getString(R.string.defaultPort);
	}

}
