package com.kozos.progtechbeadando.Database;

import android.provider.BaseColumns;

public class OrdersContract {
    public static final String TABLE_NAME = "orders";

    public static final String SQL_CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" +
            OrdersContract.OrdersEntry._ID + " INTEGER PRIMARY KEY," +
            OrdersContract.OrdersEntry.COLUMN_NAME_CUSTOMER_ID + " INT," +
            OrdersContract.OrdersEntry.COLUMN_NAME_PRODUCT_ID + " INT," +
            OrdersContract.OrdersEntry.COLUMN_NAME_DATE + " DATE)";

    public static final String SQL_DELETE_TABLE =
            "DROP TABLE IF EXISTS " + TABLE_NAME;

    public static class OrdersEntry implements BaseColumns {
        public static final String COLUMN_NAME_CUSTOMER_ID = "customer_id";
        public static final String COLUMN_NAME_PRODUCT_ID = "product_id";
        public static final String COLUMN_NAME_DATE = "date";
    }
}
