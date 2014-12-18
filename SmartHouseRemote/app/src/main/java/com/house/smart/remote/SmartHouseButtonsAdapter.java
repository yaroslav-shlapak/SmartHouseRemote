package com.house.smart.remote;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;


public class SmartHouseButtonsAdapter extends BaseAdapter {
	private Context mContext;

    public void setButtonOnClickListener(OnClickListener buttonOnClickListener) {
        this.buttonOnClickListener = buttonOnClickListener;
    }

    public void setButtonOnLongClickListener(View.OnLongClickListener buttonOnLongClickListener) {
        this.buttonOnLongClickListener = buttonOnLongClickListener;
    }

    // Declare button click listener variable
	private OnClickListener buttonOnClickListener;
	private View.OnLongClickListener buttonOnLongClickListener;

	public SmartHouseButtonsAdapter(Context c) {
		mContext = c;
	}

	public int getCount() {
		return mButtons.length;
	}

	public SmartHouseButtons getItem(int position) {
		return mButtons[position];
	}

	public long getItemId(int position) {
		return 0;
	}

	// create a new ButtonView for each item referenced by the Adapter
	public View getView(int position, View convertView, ViewGroup parent) {
		Button btn;
		if (convertView == null) { // if it's not recycled, initialize some
									// attributes

			btn = new Button(mContext);
			SmartHouseButtons keypadButton = mButtons[position];

			btn.setOnClickListener(buttonOnClickListener);
			btn.setOnLongClickListener(buttonOnLongClickListener);
			btn.setTag(keypadButton);
		} else {
			btn = (Button) convertView;
		}

		btn.setText(mButtons[position].getText());
		return btn;
	}

	// Create and populate keypad buttons array with CalculatorButton values
	private SmartHouseButtons[] mButtons = { SmartHouseButtons.BUTTON1, SmartHouseButtons.BUTTON2, SmartHouseButtons.BUTTON3,
			SmartHouseButtons.BUTTON4, SmartHouseButtons.BUTTON5, SmartHouseButtons.BUTTON6, SmartHouseButtons.BUTTON7,
			SmartHouseButtons.BUTTON8, SmartHouseButtons.BUTTON9, SmartHouseButtons.BUTTON10, SmartHouseButtons.BUTTON11, 
			SmartHouseButtons.BUTTON12};
}
