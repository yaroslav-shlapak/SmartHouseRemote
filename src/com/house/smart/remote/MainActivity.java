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
	private Context context;
	private SharedPreferences sharedPrefIp, sharedPrefPort;
	private String textIp, textPort, defaultIp, defaultPort;
	private SharedPreferences sharedPrefNameButon1, sharedPrefNameButon2,
			sharedPrefNameButon3, sharedPrefNameButon4, sharedPrefNameButon5,
			sharedPrefNameButon6, sharedPrefNameButon7, sharedPrefNameButon8,
			sharedPrefNameButon9;
	private SharedPreferences sharedPrefStringButon1, sharedPrefStringButon2,
			sharedPrefStringButon3, sharedPrefStringButon4,
			sharedPrefStringButon5, sharedPrefStringButon6,
			sharedPrefStringButon7, sharedPrefStringButon8,
			sharedPrefStringButon9;
	private Button button1, button2, button3, button4, button5, button6, button7, button8, button9;

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
			Intent i = new Intent(getApplicationContext(),
					ButtonsSettingsActivity.class);

			switch (v.getId()) {
			case R.id.button1:
				i.putExtra(BUTTON_NAME, R.string.buttonName1);
				i.putExtra(BUTTON_STRING, R.string.textButton1);
				startActivity(i);
				break;
			case R.id.button2:
				i.putExtra(BUTTON_NAME, R.string.buttonName2);
				i.putExtra(BUTTON_STRING, R.string.textButton2);
				startActivity(i);
				break;
			case R.id.button3:
				i.putExtra(BUTTON_NAME, R.string.buttonName3);
				i.putExtra(BUTTON_STRING, R.string.textButton3);
				startActivity(i);
				break;
			case R.id.button4:
				i.putExtra(BUTTON_NAME, R.string.buttonName4);
				i.putExtra(BUTTON_STRING, R.string.textButton4);
				startActivity(i);
				break;
			case R.id.button5:
				i.putExtra(BUTTON_NAME, R.string.buttonName5);
				i.putExtra(BUTTON_STRING, R.string.textButton5);
				startActivity(i);
				break;
			case R.id.button6:
				i.putExtra(BUTTON_NAME, R.string.buttonName6);
				i.putExtra(BUTTON_STRING, R.string.textButton6);
				startActivity(i);
				break;
			case R.id.button7:
				i.putExtra(BUTTON_NAME, R.string.buttonName7);
				i.putExtra(BUTTON_STRING, R.string.textButton7);
				startActivity(i);
				break;
			case R.id.button8:
				i.putExtra(BUTTON_NAME, R.string.buttonName8);
				i.putExtra(BUTTON_STRING, R.string.textButton8);
				startActivity(i);
				break;
			case R.id.button9:
				i.putExtra(BUTTON_NAME, R.string.buttonName9);
				i.putExtra(BUTTON_STRING, R.string.textButton9);
				startActivity(i);
				break;
			default:

				break;
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
		button1.setText(sharedPrefNameButon1.getString(
				getString(R.string.buttonName1), getResources().getString(R.string.buttonName1)));
		button2.setText(sharedPrefNameButon2.getString(
				getString(R.string.buttonName2), getResources().getString(R.string.buttonName2)));
		button3.setText(sharedPrefNameButon3.getString(
				getString(R.string.buttonName3), getResources().getString(R.string.buttonName3)));
		button4.setText(sharedPrefNameButon4.getString(
				getString(R.string.buttonName4), getResources().getString(R.string.buttonName4)));
		button5.setText(sharedPrefNameButon5.getString(
				getString(R.string.buttonName5), getResources().getString(R.string.buttonName5)));
		button6.setText(sharedPrefNameButon6.getString(
				getString(R.string.buttonName6), getResources().getString(R.string.buttonName6)));
		button7.setText(sharedPrefNameButon7.getString(
				getString(R.string.buttonName7), getResources().getString(R.string.buttonName7)));
		button8.setText(sharedPrefNameButon8.getString(
				getString(R.string.buttonName8), getResources().getString(R.string.buttonName8)));
		button9.setText(sharedPrefNameButon9.getString(
				getString(R.string.buttonName9), getResources().getString(R.string.buttonName9)));
	}

	private void initOnLongClickListeners() {
		// TODO Auto-generated method stub
		button1.setOnLongClickListener(onLongClickListener);
		button2.setOnLongClickListener(onLongClickListener);
		button3.setOnLongClickListener(onLongClickListener);
		button4.setOnLongClickListener(onLongClickListener);
		button5.setOnLongClickListener(onLongClickListener);
		button6.setOnLongClickListener(onLongClickListener);
		button7.setOnLongClickListener(onLongClickListener);
		button8.setOnLongClickListener(onLongClickListener);
		button9.setOnLongClickListener(onLongClickListener);
	}

	private void initOnClickListeners() {
		// TODO Auto-generated method stub
		button1.setOnClickListener(onClickListener);
		button2.setOnClickListener(onClickListener);
		button3.setOnClickListener(onClickListener);
		button4.setOnClickListener(onClickListener);
		button5.setOnClickListener(onClickListener);
		button6.setOnClickListener(onClickListener);
		button7.setOnClickListener(onClickListener);
		button8.setOnClickListener(onClickListener);
		button9.setOnClickListener(onClickListener);
	}

	private void createButtons() {
		// TODO Auto-generated method stub
		button1 = (Button) findViewById(R.id.button1);
		button2 = (Button) findViewById(R.id.button2);
		button3 = (Button) findViewById(R.id.button3);
		button4 = (Button) findViewById(R.id.button4);
		button5 = (Button) findViewById(R.id.button5);
		button6 = (Button) findViewById(R.id.button6);
		button7 = (Button) findViewById(R.id.button7);
		button8 = (Button) findViewById(R.id.button8);
		button9 = (Button) findViewById(R.id.button9);
	}

	private void createSharedPrefName() {
		// TODO Auto-generated method stub
		sharedPrefNameButon1 = context.getSharedPreferences(
				getString(R.string.buttonName1), Context.MODE_PRIVATE);
		sharedPrefNameButon2 = context.getSharedPreferences(
				getString(R.string.buttonName2), Context.MODE_PRIVATE);
		sharedPrefNameButon3 = context.getSharedPreferences(
				getString(R.string.buttonName3), Context.MODE_PRIVATE);
		sharedPrefNameButon4 = context.getSharedPreferences(
				getString(R.string.buttonName4), Context.MODE_PRIVATE);
		sharedPrefNameButon5 = context.getSharedPreferences(
				getString(R.string.buttonName5), Context.MODE_PRIVATE);
		sharedPrefNameButon6 = context.getSharedPreferences(
				getString(R.string.buttonName6), Context.MODE_PRIVATE);
		sharedPrefNameButon7 = context.getSharedPreferences(
				getString(R.string.buttonName7), Context.MODE_PRIVATE);
		sharedPrefNameButon8 = context.getSharedPreferences(
				getString(R.string.buttonName8), Context.MODE_PRIVATE);
		sharedPrefNameButon9 = context.getSharedPreferences(
				getString(R.string.buttonName9), Context.MODE_PRIVATE);
	}

	private void createSharedPrefString() {
		// TODO Auto-generated method stub
		sharedPrefStringButon1 = context.getSharedPreferences(
				getString(R.string.textButton1), Context.MODE_PRIVATE);
		sharedPrefStringButon2 = context.getSharedPreferences(
				getString(R.string.textButton2), Context.MODE_PRIVATE);
		sharedPrefStringButon3 = context.getSharedPreferences(
				getString(R.string.textButton3), Context.MODE_PRIVATE);
		sharedPrefStringButon4 = context.getSharedPreferences(
				getString(R.string.textButton4), Context.MODE_PRIVATE);
		sharedPrefStringButon5 = context.getSharedPreferences(
				getString(R.string.textButton5), Context.MODE_PRIVATE);
		sharedPrefStringButon6 = context.getSharedPreferences(
				getString(R.string.textButton6), Context.MODE_PRIVATE);
		sharedPrefStringButon7 = context.getSharedPreferences(
				getString(R.string.textButton7), Context.MODE_PRIVATE);
		sharedPrefStringButon8 = context.getSharedPreferences(
				getString(R.string.textButton8), Context.MODE_PRIVATE);
		sharedPrefStringButon9 = context.getSharedPreferences(
				getString(R.string.textButton9), Context.MODE_PRIVATE);
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
		switch (v.getId()) {
		case R.id.button1:
			return sharedPrefStringButon1.getString(
					getString(R.string.textButton1), getResources().getString(R.string.textButton1));
		case R.id.button2:
			return sharedPrefStringButon2.getString(
					getString(R.string.textButton2), getResources().getString(R.string.textButton2));
		case R.id.button3:
			return sharedPrefStringButon3.getString(
					getString(R.string.textButton3), getResources().getString(R.string.textButton3));
		case R.id.button4:
			return sharedPrefStringButon4.getString(
					getString(R.string.textButton4), getResources().getString(R.string.textButton4));
		case R.id.button5:
			return sharedPrefStringButon5.getString(
					getString(R.string.textButton5), getResources().getString(R.string.textButton5));
		case R.id.button6:
			return sharedPrefStringButon6.getString(
					getString(R.string.textButton6), getResources().getString(R.string.textButton6));
		case R.id.button7:
			return sharedPrefStringButon7.getString(
					getString(R.string.textButton7), getResources().getString(R.string.textButton7));
		case R.id.button8:
			return sharedPrefStringButon8.getString(
					getString(R.string.textButton8), getResources().getString(R.string.textButton8));
		case R.id.button9:
			return sharedPrefStringButon9.getString(
					getString(R.string.textButton9), getResources().getString(R.string.textButton9));
		default:
			return "";
		}

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
