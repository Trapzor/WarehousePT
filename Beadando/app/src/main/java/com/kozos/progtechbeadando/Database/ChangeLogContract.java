package com.kozos.progtechbeadando.Database;

import android.provider.BaseColumns;

public class ChangeLogContract {
    public static final String TABLE_NAME = "changelog";

    public static final String SQL_CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" +
            ChangeLogContract.ChangeLogEntry._ID + " INTEGER PRIMARY KEY," +
            ChangeLogContract.ChangeLogEntry.COLUMN_NAME_DESCRIPTION + " TEXT)";

    public static final String SQL_DELETE_TABLE =
            "DROP TABLE IF EXISTS " + TABLE_NAME;

    public static class ChangeLogEntry implements BaseColumns {
        public static final String COLUMN_NAME_DESCRIPTION = "description";
    }
}
