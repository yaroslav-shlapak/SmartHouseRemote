package com.house.smart.remote.ui;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

import com.house.smart.remote.R;
import com.house.smart.remote.database.ButtonValueDataSource;


public class SmartHouseButtonsAdapter extends BaseAdapter {
	private Context mContext;
    private Dimensions buttonsSize = new Dimensions();
    Button btn;
    ButtonValueDataSource buttonValueDataSource;

	// Declare button click listener variable
	private OnClickListener buttonOnClickListener;
	private OnLongClickListener buttonOnLongClickListener;
	
	
	public void setButtonOnClickListener(OnClickListener buttonOnClickListener) {

		this.buttonOnClickListener = buttonOnClickListener;
        Log.v("SmartHouseButtonsAdapter", "OnClickListener was initialized");
	}

	public void setButtonOnLongClickListener(
			OnLongClickListener buttonOnLongClickListener) {
		this.buttonOnLongClickListener = buttonOnLongClickListener;
        Log.v("SmartHouseButtonsAdapter", "OnLongClickListener was initialized");
	}

	public SmartHouseButtonsAdapter(Context c) {
        mContext = c;
        buttonValueDataSource = new ButtonValueDataSource(c);
        Log.v("SmartHouseButtonsAdapter", "SmartHouseButtonsAdapter was created");
	}

	public int getCount() {
		return mButtons.length;
	}

	public Object getItem(int position) {
		return mButtons[position];
	}

	public long getItemId(int position) {
		return 0;
	}

	// create a new ButtonView for each item referenced by the Adapter
	// create a new ButtonView for each item referenced by the Adapter
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) { // if it's not recycled, initialize some
									// attributes

			btn = new Button(mContext);
            LayoutInflater li = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            btn = (Button) li.inflate(R.layout.button_style, null);
            getButtonSize();
            btn.setWidth(buttonsSize.width);
            btn.setHeight(buttonsSize.height);

            Log.v("SmartHouseButtonsAdapter", "getView position " + String.valueOf(position));
			SmartHouseButtons keypadButton = mButtons[position];
			btn.setOnClickListener(buttonOnClickListener);
			btn.setOnLongClickListener(buttonOnLongClickListener);

			// Set CalculatorButton enumeration as tag of the button so that we
			// will use this information from our main view to identify what to
			// do
            Log.v("SmartHouseButtonsAdapter", "getView test 2");
			btn.setTag(keypadButton);

		} else {
			btn = (Button) convertView;
		}
        buttonValueDataSource.open();
		btn.setText(buttonValueDataSource.getButtonValue(mButtons[position].getId()).getButtonName());
        buttonValueDataSource.close();
		return btn;
	}

	// Create and populate keypad buttons array with CalculatorButton values
	private SmartHouseButtons[] mButtons = SmartHouseButtons.values();

    private void getButtonSize() {
        DisplayMetrics metrics = mContext.getResources().getDisplayMetrics();
        buttonsSize.height = (metrics.heightPixels - 125) / 5;
        buttonsSize.width = (metrics.widthPixels) / 3;
    }
}
