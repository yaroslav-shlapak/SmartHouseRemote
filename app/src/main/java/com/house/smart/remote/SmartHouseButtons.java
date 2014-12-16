package com.house.smart.remote;


public enum SmartHouseButtons {
    BUTTON1("BUTTON1", "0", SmartHouseButtonsType.SENDING_BUTTON),
    BUTTON2("BUTTON2", "1", SmartHouseButtonsType.SENDING_BUTTON),
    BUTTON3("BUTTON3", "2", SmartHouseButtonsType.SENDING_BUTTON),
    BUTTON4("BUTTON4", "3", SmartHouseButtonsType.SENDING_BUTTON),
    BUTTON5("BUTTON5", "4", SmartHouseButtonsType.SENDING_BUTTON),
    BUTTON6("BUTTON6", "5", SmartHouseButtonsType.SENDING_BUTTON),
    BUTTON7("BUTTON7", "6", SmartHouseButtonsType.SENDING_BUTTON),
    BUTTON8("BUTTON8", "7", SmartHouseButtonsType.SENDING_BUTTON),
    BUTTON9("BUTTON9", "8", SmartHouseButtonsType.SENDING_BUTTON),
    BUTTON10("BUTTON10", "9", SmartHouseButtonsType.SENDING_BUTTON),
    BUTTON11("BUTTON11", "10", SmartHouseButtonsType.SENDING_BUTTON),
    BUTTON12("BUTTON12", "11", SmartHouseButtonsType.SENDING_BUTTON);

    private CharSequence buttonName;
    private SmartHouseButtonsType buttonCategory;

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

    SmartHouseButtons(CharSequence text, CharSequence buttonString, SmartHouseButtonsType category) {
        this.buttonName = text;
        this.buttonCategory = category;
        this.buttonString = buttonString;
    }

    public CharSequence getText() {
        return buttonName;
    }

    private static final int size = SmartHouseButtons.values().length;
}
