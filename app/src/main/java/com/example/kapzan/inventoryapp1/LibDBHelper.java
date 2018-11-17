package com.example.kapzan.inventoryapp1;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static android.provider.BaseColumns._ID;
import static com.example.kapzan.inventoryapp1.LibContract.BookEntry.NAME;
import static com.example.kapzan.inventoryapp1.LibContract.BookEntry.PRICE;
import static com.example.kapzan.inventoryapp1.LibContract.BookEntry.QUANTITY;
import static com.example.kapzan.inventoryapp1.LibContract.BookEntry.SUPLIER_CONTACT;
import static com.example.kapzan.inventoryapp1.LibContract.BookEntry.SUPLIER_NAME;
import static com.example.kapzan.inventoryapp1.LibContract.BookEntry.TABLE;


public class LibDBHelper extends  SQLiteOpenHelper {

    public static final String  DATABASE_NAME = "books";
    public static final int DATABASE_VERSION = 1;

    public static final String CREATE_QUERY="CREATE TABLE " +
            TABLE+"("+
            _ID+" INTEGER PRIMARY KEY AUTOINCREMENT ," +
            NAME+" TEXT, "+
            PRICE+" TEXT,"+
            QUANTITY+" TEXT,"+
            SUPLIER_NAME+" TEXT,"+
            SUPLIER_CONTACT+" TEXT"+
            ")";
    public static final String DROP_QUERY="DROP TABLE IF EXISTS "+TABLE;

    public LibDBHelper(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_QUERY);
        onCreate(db);
    }



}
