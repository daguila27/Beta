package com.example.casa.beta;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class PerfilActivity extends AppCompatActivity {
    TextView nombre_usuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        nombre_usuario = (TextView) findViewById(R.id.nombre_usuario);

        nombre_usuario.setText(LoginActivity.SESSION.getNombre());
    }

}
