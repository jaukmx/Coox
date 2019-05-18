package com.example.arturo.coox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Registro extends AppCompatActivity {
    Button btn_CancelarRegistro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        btn_CancelarRegistro=findViewById(R.id.btn_CancelarRegistro);
        btn_CancelarRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentReg = new Intent(Registro.this, Login.class);
                Registro.this.startActivity(intentReg);
            }
        });
    }
}
