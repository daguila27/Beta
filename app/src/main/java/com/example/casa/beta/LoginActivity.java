package com.example.casa.beta;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.casa.beta.bd.UsuarioContract.*;
import com.example.casa.beta.bd.UsuarioHelper;
import com.example.casa.beta.object.Usuario;

public class LoginActivity extends AppCompatActivity {
    public static Usuario SESSION;
    TextView MENSAJE;
    EditText correo_usuario, contrasenna_usuario;
    Button Ingresar, Registrarse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        correo_usuario = (EditText) findViewById(R.id.correo_usuario);
        contrasenna_usuario = (EditText) findViewById(R.id.contrasenna_usuario);
        Ingresar = (Button) findViewById(R.id.ingresar);
        Registrarse = (Button) findViewById(R.id.registrarse);
        MENSAJE = (TextView) findViewById(R.id.mensaje);


        Ingresar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                UsuarioHelper udbh = new UsuarioHelper(v.getContext());
                SQLiteDatabase udb = udbh.getReadableDatabase();

                Cursor c = udb.rawQuery("SELECT * FROM " + UsuarioEntry.TABLE_NAME, null);
                MENSAJE.setText(Integer.toString(c.getCount()));
                if(c.moveToFirst()){
                    c = udb.rawQuery("SELECT * FROM " + UsuarioEntry.TABLE_NAME + " WHERE " +
                            UsuarioEntry.COLUMN_CORREO + " = '" + correo_usuario.getText().toString() + "' AND " +
                            UsuarioEntry.COLUMN_CONTRASENNA + " = '" + contrasenna_usuario.getText().toString() + "'", null);
                    if(c.moveToFirst()){
                        SESSION = new Usuario(c.getString(0),  c.getString(1), c.getString(2));
                        Intent Ingresar = new Intent(LoginActivity.this, PerfilActivity.class);
                        startActivity(Ingresar);
                    }
                    else{
                        SESSION = new Usuario(null, null, null);
                        MENSAJE.setText("CORREO NO VALIDO");
                    }
                    c.close();
                }
                udb.close();

            }
        });

    }
}
