package com.bignerdranch.android.fittrainer.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Talon on 9/25/2017.
 */

public class CustomerBaseHelper extends SQLiteOpenHelper{
    // Checks the database version.
    private static final int VERSION = 1;
    // Creates the database name.
    private static final String DATABASE_NAME = "customerBase.db";

    public CustomerBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Allows the database to use the elements that make up the Customer object.
        db.execSQL("create table " + CustomerDbSchema.CustomerTable.NAME + "(" +
                                    " _id integer primary key autoincrement, " +
                                    CustomerDbSchema.CustomerTable.Cols.NAME + ", " +
                                    CustomerDbSchema.CustomerTable.Cols.UUID + ", " +
                                    CustomerDbSchema.CustomerTable.Cols.CITY + ", " +
                                    CustomerDbSchema.CustomerTable.Cols.STATE + ", " +
                                    CustomerDbSchema.CustomerTable.Cols.ADDRESS + ", " +
                                    CustomerDbSchema.CustomerTable.Cols.ZIPCODE + ")"
        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
