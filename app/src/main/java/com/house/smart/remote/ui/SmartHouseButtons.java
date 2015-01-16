package com.house.smart.remote.ui;


import com.house.smart.remote.Constants;

public enum SmartHouseButtons {
    BUTTON1(0, Constants.DEFAULT_BUTTON_NAME, "0", SmartHouseButtonsType.SENDING_BUTTON),
    BUTTON2(1, Constants.DEFAULT_BUTTON_NAME, "1", SmartHouseButtonsType.SENDING_BUTTON),
    BUTTON3(2, Constants.DEFAULT_BUTTON_NAME, "2", SmartHouseButtonsType.SENDING_BUTTON),
    BUTTON4(3, Constants.DEFAULT_BUTTON_NAME, "3", SmartHouseButtonsType.SENDING_BUTTON),
    BUTTON5(4, Constants.DEFAULT_BUTTON_NAME, "4", SmartHouseButtonsType.SENDING_BUTTON),
    BUTTON6(5, Constants.DEFAULT_BUTTON_NAME, "5", SmartHouseButtonsType.SENDING_BUTTON),
    BUTTON7(6, Constants.DEFAULT_BUTTON_NAME, "6", SmartHouseButtonsType.SENDING_BUTTON),
    BUTTON8(7, Constants.DEFAULT_BUTTON_NAME, "7", SmartHouseButtonsType.SENDING_BUTTON),
    BUTTON9(8, Constants.DEFAULT_BUTTON_NAME, "8", SmartHouseButtonsType.SENDING_BUTTON),
    BUTTON10(9, Constants.DEFAULT_BUTTON_NAME, "9", SmartHouseButtonsType.SENDING_BUTTON),
    BUTTON11(10, Constants.DEFAULT_BUTTON_NAME, "10", SmartHouseButtonsType.SENDING_BUTTON),
    BUTTON12(11, Constants.DEFAULT_BUTTON_NAME, "11", SmartHouseButtonsType.SENDING_BUTTON),
    BUTTON13(12, Constants.DEFAULT_BUTTON_NAME, "12", SmartHouseButtonsType.SENDING_BUTTON),
    BUTTON14(13, Constants.DEFAULT_BUTTON_NAME, "13", SmartHouseButtonsType.SENDING_BUTTON),
    BUTTON15(14, Constants.DEFAULT_BUTTON_NAME, "14", SmartHouseButtonsType.SENDING_BUTTON);

    private static final int SIZE = SmartHouseButtons.values().length;
    private String name;
    private int id;
    private String string;
    private String image;
    private SmartHouseButtonsType category;

    SmartHouseButtons(int id, String name, String string, SmartHouseButtonsType category) {
        this.name = name;
        this.category = category;
        this.id = id;
        this.string = string;
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
