package com.house.smart.remote;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class SmartHouseSQLiteHelper extends SQLiteOpenHelper {

  public static final String TABLE_NAME = "button_values";
  public static final String COLUMN_ID = "_id";
  public static final String COLUMN_BUTTON_NAME = "button_name";
  public static final String COLUMN_BUTTON_STRING = "button_string";

  private static final String DATABASE_NAME = "smarthouse.db";
  private static final int DATABASE_VERSION = 1;

  // Database creation sql statement
  private static final String DATABASE_CREATE = "create table "
      + TABLE_NAME + "(" + COLUMN_ID
      + " integer primary key autoincrement, " + COLUMN_BUTTON_NAME + " text not null," + COLUMN_BUTTON_STRING
      + " text not null);";

  public SmartHouseSQLiteHelper(Context context) {
    super(context, DATABASE_NAME, null, DATABASE_VERSION);
  }

  @Override
  public void onCreate(SQLiteDatabase database) {
    database.execSQL(DATABASE_CREATE);
  }

  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    Log.w(SmartHouseSQLiteHelper.class.getName(),
        "Upgrading database from version " + oldVersion + " to "
            + newVersion + ", which will destroy all old data");
    db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    onCreate(db);
  }

} 