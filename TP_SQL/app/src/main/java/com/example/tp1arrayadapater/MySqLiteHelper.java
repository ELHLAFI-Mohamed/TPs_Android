package com.example.tp1arrayadapater;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MySqLiteHelper extends SQLiteOpenHelper {
    private static final String NOM_BdD ="Contact.db";
    private static final int VERSION_BdD = 1;
    private static final String REQ_CREATION_BdD = "create table contact(" +
            " _id integer primary key autoincrement,"+
            " nom TEXT not null," +
            " prenom TEXT not null ); " ;

    public MySqLiteHelper( Context context) {
        super(context, NOM_BdD,null,VERSION_BdD);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(REQ_CREATION_BdD);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS CONTACT");
        onCreate(db);
    }
}
