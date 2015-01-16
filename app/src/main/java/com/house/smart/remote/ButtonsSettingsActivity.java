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
import android.widget.TextView;

import com.house.smart.remote.database.ButtonValue;
import com.house.smart.remote.database.ButtonValueDataSource;
import com.house.smart.remote.ui.SmartHouseButtons;

public class ButtonsSettingsActivity extends Activity {

    private EditText buttonName, buttonString, buttonStringHex;
    private int buttonId;
    private CheckBox checkBoxHex;
    private LinearLayout linearLayoutHex;
    private TextView buttonStringHexLabel;
    private ButtonValueDataSource buttonValueDataSource;

    private CompoundButton.OnCheckedChangeListener onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            onCheckBoxChanged(buttonView, true);
            Log.v("ButtonsSettingsActivity.onCheckedChangeListener", "here is Johnny!");
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
        checkBoxHex = (CheckBox) findViewById(R.id.checkBoxHex);
        checkBoxHex.setOnCheckedChangeListener(onCheckedChangeListener);
        linearLayoutHex = (LinearLayout) findViewById(R.id.layoutHex);
        buttonStringHex = (EditText) findViewById(R.id.editTextHex);
        buttonStringHexLabel = (TextView) findViewById(R.id.textViewHex);
        Log.v("onLongClick", "editText was initialized");

        buttonValueDataSource = new ButtonValueDataSource(this);
        buttonValueDataSource.open();
        String textButtonName = buttonValueDataSource.getButtonValue(buttonId).getButtonName();
        String textButtonString = buttonValueDataSource.getButtonValue(buttonId).getButtonString();
        String textButtonStringHex = buttonValueDataSource.getButtonValue(buttonId).getButtonHexValue();
        int checkBoxOption = buttonValueDataSource.getButtonValue(buttonId).getButtonHexOption();

        Log.v("onLongClick", "data received from database");

        buttonName.setText(textButtonName);
        buttonString.setText(textButtonString);
        buttonStringHex.setText(textButtonStringHex);
        if(checkBoxOption == 0)
            checkBoxHex.setChecked(false);
        else if(checkBoxOption == 1)
            checkBoxHex.setChecked(true);
        Log.v("onLongClick", "on create ended");




        onCheckBoxChanged(checkBoxHex, false);
        buttonString.requestFocus();
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
                ButtonValue btnValue = new ButtonValue(btn);
                btnValue.setButtonName(buttonName.getText().toString());
                btnValue.setButtonString(buttonString.getText().toString());
                btnValue.setButtonHexValue(buttonStringHex.getText().toString());
                if(checkBoxHex.isChecked())
                    btnValue.setButtonHexOption(1);
                else
                    btnValue.setButtonHexOption(0);

                buttonValueDataSource.updateButtonValue(btnValue);
                buttonValueDataSource.close();


                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void onCheckBoxChanged(CompoundButton buttonView, boolean enableFocusRequesting) {

        boolean checked = ((CheckBox) checkBoxHex).isChecked();

        if (checked) {
            buttonStringHexLabel.setEnabled(true);
            buttonStringHex.setEnabled(true);
            buttonStringHexLabel.setTextColor(getResources().getColor(R.color.white));
            buttonStringHex.setTextColor(getResources().getColor(R.color.white));
            if(enableFocusRequesting)
                buttonStringHex.requestFocus();
        } else {
            buttonStringHexLabel.setEnabled(false);
            buttonStringHex.setEnabled(false);
            buttonStringHexLabel.setTextColor(getResources().getColor(R.color.dim_foreground_inverse_disabled_holo_light));
            buttonStringHex.setTextColor(getResources().getColor(R.color.dim_foreground_inverse_disabled_holo_light));
        }
    }



}
