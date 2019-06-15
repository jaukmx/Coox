package com.example.arturo.coox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Registro extends AppCompatActivity {

    Button btn_CancelarRegistro, BotonRegistrar;
    EditText nombre, apellido1, apellido2, correo, contrasena;

    private static final String loginUrl = "http://34.83.87.64/coox/registeruser.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        btn_CancelarRegistro=findViewById(R.id.btn_CancelarRegistro);
        BotonRegistrar=findViewById(R.id.btn_EnviarRegistro);
        nombre=findViewById(R.id.reg_nombre);
        apellido1=findViewById(R.id.reg_apellido1);
        apellido2=findViewById(R.id.reg_apellido2);
        correo=findViewById(R.id.reg_correo);
        contrasena=findViewById(R.id.reg_password);

        btn_CancelarRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentReg = new Intent(Registro.this, Login.class);
                Registro.this.startActivity(intentReg);
            }
        });
        BotonRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userregistro();
            }
        });
    }
    public void userregistro(){
        StringRequest request =new StringRequest(StringRequest.Method.POST, loginUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response.contains("success")){

                    Intent intent3 = new Intent(getApplicationContext(), Login.class);
                    startActivity(intent3);

                    Toast.makeText(getApplicationContext(), "registro exitoso", Toast.LENGTH_LONG).show();




                }else{
                    Toast.makeText(getApplicationContext(), "Usuario o contraseña invalido", Toast.LENGTH_LONG).show();

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("registeruser","true");
                params.put("nombre",nombre.getText().toString().trim());
                params.put("apellido1",apellido1.getText().toString().trim());
                params.put("apellido2",apellido2.getText().toString().trim());
                params.put("correo",correo.getText().toString().trim());
                params.put("contrasena",contrasena.getText().toString().trim());
                return params;



            }
        };
        Volley.newRequestQueue(this).add(request);
    }
}
