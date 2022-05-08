package com.kozos.progtechbeadando.Database;

import android.provider.BaseColumns;

public class CustomersContract {
    public static final String TABLE_NAME = "customers";

    public static final String SQL_CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" +
            CustomersContract.CustomersEntry._ID + " INTEGER PRIMARY KEY," +
            CustomersContract.CustomersEntry.COLUMN_NAME_NAME + " TEXT," +
            CustomersContract.CustomersEntry.COLUMN_NAME_ADDRESS + " TEXT)";

    public static final String SQL_DELETE_TABLE =
            "DROP TABLE IF EXISTS " + TABLE_NAME;

    public static class CustomersEntry implements BaseColumns {
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_ADDRESS = "address";
    }
}
