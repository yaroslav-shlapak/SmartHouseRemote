package com.house.smart.remote;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class ButtonsSQLiteHelper extends SQLiteOpenHelper {

    public static final String TABLE_NAME = "button_values";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_BUTTON_NAME = "button_name";
    public static final String COLUMN_BUTTON_STRING = "button_string";
    //public static final String COLUMN_BUTTON_IMAGE = "button_image";

    private static final String DATABASE_NAME = "smarthouse.db";
    private static final int DATABASE_VERSION = 1;

    // Database creation sql statement
    private static final String DATABASE_CREATE = "create table "
            + TABLE_NAME + "(" + COLUMN_ID
            + " integer primary key autoincrement, " + COLUMN_BUTTON_NAME + " text not null," + COLUMN_BUTTON_STRING /*+ " text not null," + COLUMN_BUTTON_IMAGE*/
            + " text not null);";

    public ButtonsSQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(ButtonsSQLiteHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void addButtonValue(ButtonValue buttonValue) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_BUTTON_NAME, buttonValue.getButtonName());
        values.put(COLUMN_BUTTON_STRING, buttonValue.getButtonString());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public ButtonValue getButtonValue(int id) {
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.query(TABLE_NAME, new String[] {COLUMN_ID, COLUMN_BUTTON_NAME, COLUMN_BUTTON_STRING},
                COLUMN_ID + "=?", new String[] {String.valueOf(id)}, null, null, null, null);
        if(cursor != null)
            cursor.moveToFirst();

        return new ButtonValue(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2));
    }

    // Getting All Contacts
    public List<ButtonValue> getAllButtonValues() {

        List<ButtonValue> buttonValuesList = new ArrayList<ButtonValue>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                ButtonValue buttonValue = new ButtonValue();
                buttonValue.setId(Integer.parseInt(cursor.getString(0)));
                buttonValue.setButtonImage(cursor.getString(1));
                buttonValue.setButtonString(cursor.getString(2));
                // Adding contact to list
                buttonValuesList.add(buttonValue);
            } while (cursor.moveToNext());
        }

        // return contact list
        return buttonValuesList;
    }

    public int getButtonValuesCount() {
        String countQuery = "select * from" + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        return cursor.getCount();
    }

    public int updateButtonValue(ButtonValue buttonValue) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_BUTTON_NAME, buttonValue.getButtonName());
        values.put(COLUMN_BUTTON_STRING, buttonValue.getButtonString());

        // updating row
        return db.update(TABLE_NAME, values, COLUMN_ID + " = ?",
                new String[] { String.valueOf(buttonValue.getId()) });
    }

    public void deleteButtonValue(ButtonValue buttonValue) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, COLUMN_ID + " = ?",
                new String[] { String.valueOf(buttonValue.getId()) });
        db.close();
    }


}