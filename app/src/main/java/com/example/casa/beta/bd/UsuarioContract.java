package com.example.casa.beta.bd;

import android.provider.BaseColumns;

/**
 * Created by CASA on 17-05-2017.
 */

public class UsuarioContract {
    private UsuarioContract(){}

    public static class UsuarioEntry implements BaseColumns{
        public static final String TABLE_NAME = "Usuario";
        public static final String COLUMN_CORREO = "correo_usuario";
        public static final String COLUMN_NOMBRE = "nombre_usuario";
        public static final String COLUMN_CONTRASENNA = "contrasenna_usuario";
    }

    private static final String ID_TYPE = " INTEGER PRIMARY KEY AUTOINCREMENT";
    private static final String TEXT_TYPE = " TEXT";
    private static final String COMA_SEP = ", ";
    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + UsuarioEntry.TABLE_NAME + "("
                    + UsuarioEntry.COLUMN_CORREO + TEXT_TYPE + COMA_SEP
                    + UsuarioEntry.COLUMN_NOMBRE + TEXT_TYPE + COMA_SEP
                    + UsuarioEntry.COLUMN_CONTRASENNA + TEXT_TYPE
                    + ")";
    public static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + UsuarioEntry.TABLE_NAME;


}
