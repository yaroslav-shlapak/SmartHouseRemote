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
	private Context context;
	private SharedPreferences sharedPrefIp, sharedPrefPort;
	private String textIp, textPort, defaultIp, defaultPort;
	private SharedPreferences sharedPrefNameButon1, sharedPrefNameButon2, sharedPrefNameButon3, sharedPrefNameButon4, 
	sharedPrefNameButon5, sharedPrefNameButon6, sharedPrefNameButon7, sharedPrefNameButon8, sharedPrefNameButon9;
	private SharedPreferences sharedPrefStringButon1, sharedPrefStringButon2, sharedPrefStringButon3, sharedPrefStringButon4,
	sharedPrefStringButon5, sharedPrefStringButon6, sharedPrefStringButon7, sharedPrefStringButon8, sharedPrefStringButon9;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button button1 = (Button) findViewById(R.id.button1);
		Button button2 = (Button) findViewById(R.id.button2);
		Button button3 = (Button) findViewById(R.id.button3);
		Button button4 = (Button) findViewById(R.id.button4);
		Button button5 = (Button) findViewById(R.id.button5);
		Button button6 = (Button) findViewById(R.id.button6);
		Button button7 = (Button) findViewById(R.id.button7);
		Button button8 = (Button) findViewById(R.id.button8);
		Button button9 = (Button) findViewById(R.id.button9);
		
		button1.setOnClickListener(onClickListener);
		button2.setOnClickListener(onClickListener);
		button3.setOnClickListener(onClickListener);
		button4.setOnClickListener(onClickListener);
		button5.setOnClickListener(onClickListener);
		button6.setOnClickListener(onClickListener);
		button7.setOnClickListener(onClickListener);
		button8.setOnClickListener(onClickListener);
		button9.setOnClickListener(onClickListener);
		
		button1.setOnLongClickListener(onLongClickListener);
		button2.setOnLongClickListener(onLongClickListener);
		button3.setOnLongClickListener(onLongClickListener);
		button4.setOnLongClickListener(onLongClickListener);
		button5.setOnLongClickListener(onLongClickListener);
		button6.setOnLongClickListener(onLongClickListener);
		button7.setOnLongClickListener(onLongClickListener);
		button8.setOnLongClickListener(onLongClickListener);
		button9.setOnLongClickListener(onLongClickListener);
		
		context = getApplicationContext();
		sharedPrefIp = context.getSharedPreferences(getString(R.string.preference_ip), Context.MODE_PRIVATE);
		sharedPrefPort = context.getSharedPreferences(getString(R.string.preference_port), Context.MODE_PRIVATE);
		
		defaultIp = getResources().getString(R.string.defaultIP);
		defaultPort = getResources().getString(R.string.defaultPort);
		
		sharedPrefNameButon1 = context.getSharedPreferences(getString(R.string.buttonName1), Context.MODE_PRIVATE);
		sharedPrefNameButon2 = context.getSharedPreferences(getString(R.string.buttonName2), Context.MODE_PRIVATE);
		sharedPrefNameButon3 = context.getSharedPreferences(getString(R.string.buttonName3), Context.MODE_PRIVATE);
		sharedPrefNameButon4 = context.getSharedPreferences(getString(R.string.buttonName4), Context.MODE_PRIVATE);
		sharedPrefNameButon5 = context.getSharedPreferences(getString(R.string.buttonName5), Context.MODE_PRIVATE);
		sharedPrefNameButon6 = context.getSharedPreferences(getString(R.string.buttonName6), Context.MODE_PRIVATE);
		sharedPrefNameButon7 = context.getSharedPreferences(getString(R.string.buttonName7), Context.MODE_PRIVATE);
		sharedPrefNameButon8 = context.getSharedPreferences(getString(R.string.buttonName8), Context.MODE_PRIVATE);
		sharedPrefNameButon9 = context.getSharedPreferences(getString(R.string.buttonName9), Context.MODE_PRIVATE);
		
		sharedPrefStringButon1 = context.getSharedPreferences(getString(R.string.textBurtton1), Context.MODE_PRIVATE);
		sharedPrefStringButon2 = context.getSharedPreferences(getString(R.string.textBurtton2), Context.MODE_PRIVATE);
		sharedPrefStringButon3 = context.getSharedPreferences(getString(R.string.textBurtton3), Context.MODE_PRIVATE);
		sharedPrefStringButon4 = context.getSharedPreferences(getString(R.string.textBurtton4), Context.MODE_PRIVATE);
		sharedPrefStringButon5 = context.getSharedPreferences(getString(R.string.textBurtton5), Context.MODE_PRIVATE);
		sharedPrefStringButon6 = context.getSharedPreferences(getString(R.string.textBurtton6), Context.MODE_PRIVATE);
		sharedPrefStringButon7 = context.getSharedPreferences(getString(R.string.textBurtton7), Context.MODE_PRIVATE);
		sharedPrefStringButon8 = context.getSharedPreferences(getString(R.string.textBurtton8), Context.MODE_PRIVATE);
		sharedPrefStringButon9 = context.getSharedPreferences(getString(R.string.textBurtton9), Context.MODE_PRIVATE);
			
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
	        case R.id.action_settings:
	        	openButtonSettings();
	            return true;
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

	private void openButtonSettings() {
		// TODO Auto-generated method stub
		 Intent intent = new Intent(this, ButtonsSettingsActivity.class);
		 startActivity(intent);
	}

	private void sendData(View view) {
	        Context context = getApplicationContext();
			
			textIp = sharedPrefIp.getString(getString(R.string.preference_ip), defaultIp);
			textPort = sharedPrefPort.getString(getString(R.string.preference_port), defaultPort);

	        String host = textIp;
	        if (!host.matches("\\b(?:\\d{1,3}\\.){3}\\d{1,3}\\b")) {
	            CharSequence text = "Error: Invalid IP Address";
	            Toast toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
	            toast.show();
	            return;
	        }

	        String port = textPort;
	        if (!port.matches("^(6553[0-5]|655[0-2]\\d|65[0-4]\\d\\d|6[0-4]\\d{3}|[1-5]\\d{4}|[1-9]\\d{0,3}|0)$")) {
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
		   switch(v.getId()){
	           case R.id.button1:
	                return  getResources().getString(R.string.textBurtton1);
	           case R.id.button2:
	        	   return  getResources().getString(R.string.textBurtton2);
	           case R.id.button3:
	        	   return  getResources().getString(R.string.textBurtton3);
	           case R.id.button4:
	        	   return  getResources().getString(R.string.textBurtton4);
	           case R.id.button5:
	        	   return  getResources().getString(R.string.textBurtton5);
	           case R.id.button6:
	        	   return  getResources().getString(R.string.textBurtton6);
	           case R.id.button7:
	        	   return  getResources().getString(R.string.textBurtton7);
	           case R.id.button8:
	        	   return  getResources().getString(R.string.textBurtton8);
	           case R.id.button9:
	        	   return  getResources().getString(R.string.textBurtton9);
	           default:
	        	   return "";
       }

	 }
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
				   switch(v.getId()){
		           case R.id.button1:

		        	   break;
		           case R.id.button2:
		        	   
		        	   break;
		           case R.id.button3:
		        	   
		        	   break;
		           case R.id.button4:
		        	   
		        	   break;
		           case R.id.button5:
		        	   
		        	   break;
		           case R.id.button6:
		        	   
		        	   break;
		           case R.id.button7:
		        	   
		        	   break;
		           case R.id.button8:
		        	   
		        	   break;
		           case R.id.button9:
		        	   
		        	   break;
		           default:
		        	   
		        	   break;
				   }
		        	   
				return false;
			}
			
		};
		
	 

}
