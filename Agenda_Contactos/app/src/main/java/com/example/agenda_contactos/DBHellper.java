package com.example.agenda_contactos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;
import android.database.sqlite.SQLiteOpenHelper;




public class DBHellper extends SQLiteOpenHelper {
    public DBHellper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public DBHellper(Context context) {
        super();
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS contactos( nombre text(30) not null primary key, telefono text(30), direccion text(20), email (10)  ) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}