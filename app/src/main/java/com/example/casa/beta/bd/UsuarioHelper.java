package com.example.casa.beta.bd;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.example.casa.beta.bd.UsuarioContract.*;

/**
 * Created by CASA on 17-05-2017.
 */

public class UsuarioHelper extends SQLiteOpenHelper{
        public static final int DATABASE_VERSION = 1;
        public static final String DATABASE_NAME = "Usuario.db";
    public UsuarioHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(SQL_CREATE_ENTRIES);
        onInsert(db, "daguila", "Daguila27", "pechugaslaru");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion){
        onUpgrade(db, oldVersion, newVersion);
    }
    public void onInsert(SQLiteDatabase db, String mail, String name, String contra){
    // Contenedor de valores
    ContentValues values = new ContentValues();

    // Pares clave-valor
    values.put(UsuarioEntry.COLUMN_CORREO, mail);
    values.put(UsuarioEntry.COLUMN_NOMBRE, name);
    values.put(UsuarioEntry.COLUMN_CONTRASENNA, contra);
    // Insertar...
    db.insert(UsuarioEntry.TABLE_NAME, null, values);}

}
