package com.house.smart.remote;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.EditText;

import com.house.smart.remote.database.ButtonValueDataSource;
import com.house.smart.remote.database.UdpValue;
import com.house.smart.remote.database.UdpValueDataSource;

public class IpSettingsActivity extends Activity {
	private UdpValueDataSource udpValueDataSource;
	private EditText etIp, etPort;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ip_settings);
		
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		etIp = (EditText) findViewById(R.id.ip_address);
		etPort = (EditText) findViewById(R.id.port_address);

        udpValueDataSource = new UdpValueDataSource(this);
        udpValueDataSource.open();

        Log.v("IpSettings", "database opened");
		String textIp = udpValueDataSource.getUdpValue(1).getIp();
		String textPort = udpValueDataSource.getUdpValue(1).getPort();

        Log.v("IpSettings", "database read");
		
		etIp.setText(textIp);
		etPort.setText(textPort);
		
	}

	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_ip_settings, menu);
		return super.onCreateOptionsMenu(menu);
		
		
	}

    @Override
    protected void onPause() {
        super.onPause();
        udpValueDataSource.close();
    }
	
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle presses on the action bar items
	    switch (item.getItemId()) {
	        case R.id.action_undo:
                udpValueDataSource.close();
	        	finish();
	            return true;
	        case R.id.action_accept:
                UdpValue udpValue = new UdpValue(1, etIp.getText().toString(), etPort.getText().toString());
                udpValueDataSource.updateUdpValue(udpValue);

                udpValueDataSource.close();
	    		finish();
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}
}
