package com.kozos.progtechbeadando.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class CustomersOpenHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "customers.db";
    private static final int DB_VERSION = 1;

    public CustomersOpenHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CustomersContract.SQL_CREATE_TABLE );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(CustomersContract.SQL_DELETE_TABLE );
        sqLiteDatabase.execSQL(CustomersContract.SQL_CREATE_TABLE );

    }
}
