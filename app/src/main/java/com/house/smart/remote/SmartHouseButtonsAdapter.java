package com.house.smart.remote;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;


public class SmartHouseButtonsAdapter extends BaseAdapter {
	private Context mContext;
    private Dimensions buttonsSize = new Dimensions();

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
		Button btn;
		if (convertView == null) { // if it's not recycled, initialize some
									// attributes


			btn = new Button(mContext);

            getButtonSize();
//            Log.v("SmartHouseButtonsAdapter", "getView test 1");
//            ViewGroup.LayoutParams params = btn.getLayoutParams();
//            Log.v("SmartHouseButtonsAdapter", "getView test 2");
//            params.width = buttonsSize.width;
//            Log.v("SmartHouseButtonsAdapter", "getView test 3");
//            params.height = buttonsSize.height;
//            Log.v("SmartHouseButtonsAdapter", "getView test 4");
//            btn.setLayoutParams(params);
//            Log.v("SmartHouseButtonsAdapter", "getView test 5");
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

		btn.setText(mButtons[position].getName());
		return btn;
	}

	// Create and populate keypad buttons array with CalculatorButton values
	private SmartHouseButtons[] mButtons = { SmartHouseButtons.BUTTON1, SmartHouseButtons.BUTTON2, SmartHouseButtons.BUTTON3,
			SmartHouseButtons.BUTTON4, SmartHouseButtons.BUTTON5, SmartHouseButtons.BUTTON6, SmartHouseButtons.BUTTON7,
			SmartHouseButtons.BUTTON8, SmartHouseButtons.BUTTON9, SmartHouseButtons.BUTTON10, SmartHouseButtons.BUTTON11, 
			SmartHouseButtons.BUTTON12};

    private void getButtonSize() {
        DisplayMetrics metrics = mContext.getResources().getDisplayMetrics();
        buttonsSize.height = (metrics.heightPixels - 200) / 4;
        buttonsSize.width = (metrics.widthPixels - 75) / 3;
    }
}
