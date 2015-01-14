package com.house.smart.remote.ui;


import com.house.smart.remote.Constants;

public enum SmartHouseButtons {
    BUTTON1(0, Constants.DEFAULT_BUTTON_NAME, "0", SmartHouseButtonsType.SENDING_BUTTON, Constants.DEFAULT_HEX_VALUE, Constants.DEFAULT_HEX_ADD_OPTION),
    BUTTON2(1, Constants.DEFAULT_BUTTON_NAME, "1", SmartHouseButtonsType.SENDING_BUTTON, Constants.DEFAULT_HEX_VALUE, Constants.DEFAULT_HEX_ADD_OPTION),
    BUTTON3(2, Constants.DEFAULT_BUTTON_NAME, "2", SmartHouseButtonsType.SENDING_BUTTON, Constants.DEFAULT_HEX_VALUE, Constants.DEFAULT_HEX_ADD_OPTION),
    BUTTON4(3, Constants.DEFAULT_BUTTON_NAME, "3", SmartHouseButtonsType.SENDING_BUTTON, Constants.DEFAULT_HEX_VALUE, Constants.DEFAULT_HEX_ADD_OPTION),
    BUTTON5(4, Constants.DEFAULT_BUTTON_NAME, "4", SmartHouseButtonsType.SENDING_BUTTON, Constants.DEFAULT_HEX_VALUE, Constants.DEFAULT_HEX_ADD_OPTION),
    BUTTON6(5, Constants.DEFAULT_BUTTON_NAME, "5", SmartHouseButtonsType.SENDING_BUTTON, Constants.DEFAULT_HEX_VALUE, Constants.DEFAULT_HEX_ADD_OPTION),
    BUTTON7(6, Constants.DEFAULT_BUTTON_NAME, "6", SmartHouseButtonsType.SENDING_BUTTON, Constants.DEFAULT_HEX_VALUE, Constants.DEFAULT_HEX_ADD_OPTION),
    BUTTON8(7, Constants.DEFAULT_BUTTON_NAME, "7", SmartHouseButtonsType.SENDING_BUTTON, Constants.DEFAULT_HEX_VALUE, Constants.DEFAULT_HEX_ADD_OPTION),
    BUTTON9(8, Constants.DEFAULT_BUTTON_NAME, "8", SmartHouseButtonsType.SENDING_BUTTON, Constants.DEFAULT_HEX_VALUE, Constants.DEFAULT_HEX_ADD_OPTION),
    BUTTON10(9, Constants.DEFAULT_BUTTON_NAME, "9", SmartHouseButtonsType.SENDING_BUTTON, Constants.DEFAULT_HEX_VALUE, Constants.DEFAULT_HEX_ADD_OPTION),
    BUTTON11(10, Constants.DEFAULT_BUTTON_NAME, "10", SmartHouseButtonsType.SENDING_BUTTON, Constants.DEFAULT_HEX_VALUE, Constants.DEFAULT_HEX_ADD_OPTION),
    BUTTON12(11, Constants.DEFAULT_BUTTON_NAME, "11", SmartHouseButtonsType.SENDING_BUTTON, Constants.DEFAULT_HEX_VALUE, Constants.DEFAULT_HEX_ADD_OPTION),
    BUTTON13(12, Constants.DEFAULT_BUTTON_NAME, "12", SmartHouseButtonsType.SENDING_BUTTON, Constants.DEFAULT_HEX_VALUE, Constants.DEFAULT_HEX_ADD_OPTION),
    BUTTON14(13, Constants.DEFAULT_BUTTON_NAME, "13", SmartHouseButtonsType.SENDING_BUTTON, Constants.DEFAULT_HEX_VALUE, Constants.DEFAULT_HEX_ADD_OPTION),
    BUTTON15(14, Constants.DEFAULT_BUTTON_NAME, "14", SmartHouseButtonsType.SENDING_BUTTON, Constants.DEFAULT_HEX_VALUE, Constants.DEFAULT_HEX_ADD_OPTION);

    private static final int SIZE = SmartHouseButtons.values().length;
    private String name;
    private int id;
    private String string;
    private String image;
    private SmartHouseButtonsType category;

    public String getHexValue() {
        return hexValue;
    }

    public void setHexValue(String hexValue) {
        this.hexValue = hexValue;
    }

    public int getHexAddOption() {
        return hexAddOption;
    }

    public void setHexAddOption(int hexAddOption) {
        this.hexAddOption = hexAddOption;
    }

    private String hexValue;
    private int hexAddOption;

    SmartHouseButtons(int id, String name, String string, SmartHouseButtonsType category, String hexValue, int hexAddOption) {
        this.name = name;
        this.category = category;
        this.id = id;
        this.string = string;
        this.hexValue = hexValue;
        this.hexAddOption = hexAddOption;
    }

    public static int getSize() {
        return SIZE;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
