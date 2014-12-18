package com.house.smart.remote;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by y.shlapak on Dec 16, 2014.
 */
public class UDPSQLiteHelper extends SQLiteOpenHelper {

    public static final String TABLE_NAME = "udp_table";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_IP = "ip";
    public static final String COLUMN_PORT = "port";

    private static final String DATABASE_NAME = "smarthouse.db";
    private static final int DATABASE_VERSION = 1;

    // Database creation sql statement
    private static final String DATABASE_CREATE = "create table "
            + TABLE_NAME + "(" + COLUMN_ID
            + " integer primary key autoincrement, " + COLUMN_IP + " text not null," + COLUMN_PORT + " text not null);";

    public UDPSQLiteHelper(Context context) {
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

    public void addUdpValue(UdpValue udpValue) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_IP, udpValue.getIp());
        values.put(COLUMN_PORT, udpValue.getPort());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public UdpValue getUdpValue(int id) {
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.query(TABLE_NAME, new String[] {COLUMN_ID, COLUMN_IP, COLUMN_PORT},
                COLUMN_ID + "=?", new String[] {String.valueOf(id)}, null, null, null, null);
        if(cursor != null)
            cursor.moveToFirst();

        return new UdpValue(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2));
    }

    // Getting All Contacts
    public List<UdpValue> getAllUdpValues() {

        List<UdpValue> udpValuesList = new ArrayList<UdpValue>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                UdpValue udpValue = new UdpValue();
                udpValue.setId(Integer.parseInt(cursor.getString(0)));
                udpValue.setIp(cursor.getString(1));
                udpValue.setPort(cursor.getString(2));
                // Adding contact to list
                udpValuesList.add(udpValue);
            } while (cursor.moveToNext());
        }

        // return contact list
        return udpValuesList;
    }

    public int getUdpValuesCount() {
        String countQuery = "select * from" + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        return cursor.getCount();
    }

    public int updateUdpValue(ButtonValue buttonValue) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_IP, buttonValue.getButtonName());
        values.put(COLUMN_PORT, buttonValue.getButtonString());

        // updating row
        return db.update(TABLE_NAME, values, COLUMN_ID + " = ?",
                new String[] { String.valueOf(buttonValue.getId()) });
    }

    public void deleteUdpValue(ButtonValue buttonValue) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, COLUMN_ID + " = ?",
                new String[] { String.valueOf(buttonValue.getId()) });
        db.close();
    }


}
