package com.example.arturo.coox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class panel_padres extends AppCompatActivity {
    TextView txtUsuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panel_padres);

        Intent intent =getIntent();

        String user=intent.getStringExtra("username");
        txtUsuario =findViewById(R.id.txtUser);
        txtUsuario.setText("Bienvenido "+user);
    }
}
