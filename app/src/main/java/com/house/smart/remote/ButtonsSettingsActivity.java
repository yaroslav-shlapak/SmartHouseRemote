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
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.house.smart.remote.database.ButtonValue;
import com.house.smart.remote.database.ButtonValueDataSource;
import com.house.smart.remote.ui.SmartHouseButtons;

public class ButtonsSettingsActivity extends Activity {

    private EditText buttonName, buttonString;
    private int buttonId;
    private CheckBox checkBoxHex;
    private LinearLayout linearLayoutHex;
    private ButtonValueDataSource buttonValueDataSource;

    private CompoundButton.OnCheckedChangeListener onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            boolean checked = ((CheckBox) buttonView).isChecked();

            // Check which checkbox was clicked
            if (checked) {
                for (int i = 0; i < linearLayoutHex.getChildCount(); i++) {
                    View v = linearLayoutHex.getChildAt(i);
                    v.setEnabled(false); // Or whatever you want to do with the view.
                }
            }
        }
    };

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_settings);

        getActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle extras = getIntent().getExtras();
        if (extras != null)
            buttonId = extras.getInt(Constants.BUTTON_ID);
        else
            return;
        Log.v("onLongClick", "extra was received");
        buttonName = (EditText) findViewById(R.id.buttonName);
        buttonString = (EditText) findViewById(R.id.buttonString);
        Log.v("onLongClick", "editText was initialized");

        buttonValueDataSource = new ButtonValueDataSource(this);
        buttonValueDataSource.open();
        String textButtonName = buttonValueDataSource.getButtonValue(buttonId).getButtonName();
        String textButtonString = buttonValueDataSource.getButtonValue(buttonId).getButtonString();

        Log.v("onLongClick", "data received from database");

        buttonName.setText(textButtonName);
        buttonString.setText(textButtonString);
        Log.v("onLongClick", "on create ended");

        checkBoxHex = (CheckBox) findViewById(R.id.checkBoxHex);
        checkBoxHex.setOnCheckedChangeListener(onCheckedChangeListener);
        linearLayoutHex = (LinearLayout) findViewById(R.id.layoutHex);

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
                buttonValueDataSource.close();
                return true;
            case R.id.action_accept:
                SmartHouseButtons btn = SmartHouseButtons.values()[buttonId];
                btn.setName(buttonName.getText().toString());
                btn.setString(buttonString.getText().toString());

                buttonValueDataSource.updateButtonValue(new ButtonValue(btn));
                buttonValueDataSource.close();
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
