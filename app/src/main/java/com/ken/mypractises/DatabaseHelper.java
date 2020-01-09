package com.ken.mypractises;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Shop1.db";

    public static final String TABLE_NAME = "Shop1_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "Date_inserted";
    public static final String COL_3 = "Issued_Towels";
    public static final String COL_4 = " Collected_Towels";
    public static final String COL_5 = "Barber_1";
    public static final String COL_6 = "Barber_2";
    public static final String COL_7 = "Barber_3";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,Date_inserted DEFAULT CURRENT_TIMESTAMP,Issued_Towels INTEGER,Collected_Towels INTEGER,Barber_1 INTEGER,Barber_2 INTEGER,Barber_3 INTEGER)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

    }

    public boolean insertData1(String itowels, String ctowels, String bar11, String bar12, String bar13) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_3, itowels);
        contentValues.put(COL_4, ctowels);
        contentValues.put(COL_5, bar11);
        contentValues.put(COL_6, bar12);
        contentValues.put(COL_7, bar13);

        long result1 = db.insert(TABLE_NAME, null, contentValues);
        if (result1 == -1)
            return false;
        else
            return true;
    }

    public Cursor getAllData1() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }
    public Integer deleteData(String id){
        SQLiteDatabase db = this.getWritableDatabase();
       return db.delete(TABLE_NAME,"ID= ?" ,new String[]{id});


    }

}
