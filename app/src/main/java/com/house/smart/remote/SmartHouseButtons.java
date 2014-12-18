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

    String name;
    int id;

    public String getString() {
        return string;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    String string;

    SmartHouseButtonsType category;

    SmartHouseButtons(int id, String name, String string, SmartHouseButtonsType category) {
        this.name = name;
        this.category = category;
        this.id = id;
        this.string = string;
    }

    public static int getSize() {
        return size;
    }

    private static final int size = SmartHouseButtons.values().length;


}
