package com.house.smart.remote;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;

import com.house.smart.remote.database.ButtonValue;
import com.house.smart.remote.database.ButtonValueDataSource;
import com.house.smart.remote.ui.SmartHouseButtons;

public class ButtonsSettingsActivity extends Activity {

    private EditText buttonName, buttonString;
    private int buttonId;
    private ButtonValueDataSource buttonValueDataSource;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_settings);

        getActionBar().setDisplayHomeAsUpEnabled(true);

        buttonValueDataSource = new ButtonValueDataSource(this);
        buttonValueDataSource.open();

        Bundle extras = getIntent().getExtras();
        if (extras != null)
            buttonId = extras.getInt(Constants.BUTTON_ID);
        else
            return;
        Log.v("onLongClick", "extra was received");
        buttonName = (EditText) findViewById(R.id.buttonName);
        buttonString = (EditText) findViewById(R.id.buttonString);
        Log.v("onLongClick", "editText was initialized");

        String textButtonName = buttonValueDataSource.getButtonValue(buttonId).getButtonName();
        String textButtonString = buttonValueDataSource.getButtonValue(buttonId).getButtonString();
        Log.v("onLongClick", "data received from database");

        buttonName.setText(textButtonName);
        buttonString.setText(textButtonString);
        Log.v("onLongClick", "on create ended");

    }

    @Override
    protected void onPause() {
        super.onPause();
        buttonValueDataSource.close();
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
                SmartHouseButtons btn = SmartHouseButtons.values()[buttonId];
                btn.setName(buttonName.getText().toString());
                btn.setString(buttonString.getText().toString());

                buttonValueDataSource.updateButtonValue(new ButtonValue(btn));
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
