package com.house.smart.remote;


public enum SmartHouseButtons {
    BUTTON1(0, "BUTTON1", "0", SmartHouseButtonsType.SENDING_BUTTON),
    BUTTON2(1, "BUTTON2", "1", SmartHouseButtonsType.SENDING_BUTTON),
    BUTTON3(2, "BUTTON3", "2", SmartHouseButtonsType.SENDING_BUTTON),
    BUTTON4(3, "BUTTON4", "3", SmartHouseButtonsType.SENDING_BUTTON),
    BUTTON5(4, "BUTTON5", "4", SmartHouseButtonsType.SENDING_BUTTON),
    BUTTON6(5, "BUTTON6", "5", SmartHouseButtonsType.SENDING_BUTTON),
    BUTTON7(6, "BUTTON7", "6", SmartHouseButtonsType.SENDING_BUTTON),
    BUTTON8(7, "BUTTON8", "7", SmartHouseButtonsType.SENDING_BUTTON),
    BUTTON9(8, "BUTTON9", "8", SmartHouseButtonsType.SENDING_BUTTON),
    BUTTON10(9, "BUTTON10", "9", SmartHouseButtonsType.SENDING_BUTTON),
    BUTTON11(10, "BUTTON11", "10", SmartHouseButtonsType.SENDING_BUTTON),
    BUTTON12(11, "BUTTON12", "11", SmartHouseButtonsType.SENDING_BUTTON);

    private CharSequence buttonName;
    private SmartHouseButtonsType buttonCategory;

    public int getId() {
        return id;
    }

    private int id;

    public CharSequence getButtonString() {
        return buttonString;
    }

    public CharSequence getButtonName() {
        return buttonName;
    }

    public SmartHouseButtonsType getButtonCategory() {
        return buttonCategory;
    }



    private CharSequence buttonString;

    SmartHouseButtons(int id, CharSequence text, CharSequence buttonString, SmartHouseButtonsType category) {
        this.buttonName = text;
        this.buttonCategory = category;
        this.buttonString = buttonString;
    }

    public CharSequence getText() {
        return buttonName;
    }

    private static final int size = SmartHouseButtons.values().length;
}
