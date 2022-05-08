package com.kozos.progtechbeadando.Database;

import android.provider.BaseColumns;

public class ProductsContract {
    public static final String TABLE_NAME = "products";

    public static final String SQL_CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" +
            ProductsEntry._ID + " INTEGER PRIMARY KEY," +
            ProductsEntry.COLUMN_NAME_NAME + " TEXT," +
            ProductsEntry.COLUMN_NAME_PRICE + " INT," +
            ProductsEntry.COLUMN_NAME_QUANTITY + " INT)";

    public static final String SQL_DELETE_TABLE =
            "DROP TABLE IF EXISTS " + TABLE_NAME;

    public static class ProductsEntry implements BaseColumns{
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_PRICE = "price";
        public static final String COLUMN_NAME_QUANTITY = "quantity";
    }
}
