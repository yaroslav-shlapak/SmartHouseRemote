package com.house.smart.remote.database;

import com.house.smart.remote.ui.SmartHouseButtons;

public class ButtonValue {

	private long id;

    public ButtonValue(long id, String buttonName, String buttonString, String buttonHexValue, int buttonHexAddOption) {
        this.id = id;
        this.buttonName = buttonName;
        this.buttonString = buttonString;
        this.buttonHexAddOption = buttonHexAddOption;
        this.buttonHexValue = buttonHexValue;
    }

    private String buttonName;
	private String buttonString;
	private String buttonImage;
    private int buttonHexAddOption;
    private String buttonHexValue;

    public String getButtonHexValue() {
        return buttonHexValue;
    }
    public void setButtonHexValue(String buttonHexValue) {
        this.buttonHexValue = buttonHexValue;
    }
    public int getButtonHexAddOption() {
        return buttonHexAddOption;
    }
    public void setButtonHexAddOption(int buttonHexAddOption) {
        this.buttonHexAddOption = buttonHexAddOption;
    }
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getButtonName() {
		return buttonName;
	}
	public void setButtonName(String buttonName) {
		this.buttonName = buttonName;
	}
	public String getButtonString() {
		return buttonString;
	}
	public void setButtonString(String buttonString) {
		this.buttonString = buttonString;
	}
	public String getButtonImage() {
		return buttonImage;
	}
	public void setButtonImage(String buttonImage) {
		this.buttonImage = buttonImage;
	}

    public ButtonValue(int id, String buttonName, String buttonString) {
        this.id = id;
        this.buttonName = buttonName;
        this.buttonString = buttonString;
    }

    public ButtonValue(String buttonName, String buttonString) {
        this.buttonName = buttonName;
        this.buttonString = buttonString;
    }

    public ButtonValue() {

    }

    public ButtonValue(SmartHouseButtons smartHouseButtons) {
        this.buttonName = smartHouseButtons.getName();
        this.buttonString = smartHouseButtons.getString();
        this.id = smartHouseButtons.getId();
    }
}
