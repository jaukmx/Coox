package com.example.arturo.coox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class panel_padres extends AppCompatActivity {
    TextView txtUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panel_padres);
        Intent intent =getIntent();
        String user=intent.getStringExtra("username");
        txtUser =findViewById(R.id.txtUser);
        txtUser.setText("Bienvenido "+user);
    }
}
