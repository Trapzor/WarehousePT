package com.kozos.progtechbeadando.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ChangeLogOpenHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "changelog.db";
    private static final int DB_VERSION = 1;

    public ChangeLogOpenHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(ChangeLogContract.SQL_CREATE_TABLE );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(ChangeLogContract.SQL_DELETE_TABLE );
        sqLiteDatabase.execSQL(ChangeLogContract.SQL_CREATE_TABLE );

    }
}
