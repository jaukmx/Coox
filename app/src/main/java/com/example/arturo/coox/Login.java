package com.example.arturo.coox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;


public class Login extends AppCompatActivity {
    //variable textviw
    TextView registrarse;
    EditText username, userpassword;
    Button btnlogin;

    private static final String loginUrl = "http://192.168.1.66/coox/login.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        //Funcion de pasar a paguina de registarse
        registrarse = findViewById(R.id.txtRegistrar);
        //variasbles del formulario para logearse
        username = findViewById(R.id.txtUsuario);
        userpassword = findViewById(R.id.txtContraseña);
        btnlogin = findViewById(R.id.btn_login);

//Funcion de pasar a paguina de registarse
        registrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Registro.class);
                startActivity(intent);
            }
        });




/////Boton Login
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                userlogin();
            }
        });


    }
    public void userlogin(){
        StringRequest request =new StringRequest(StringRequest.Method.POST, loginUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response.contains("success")){

                    Intent intent = new Intent(getApplicationContext(), panel_padres.class);


                    intent.putExtra("username", username.getText().toString());
                    startActivity(intent);

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
                params.put("loginuser","true");
                params.put("username",username.getText().toString().trim());
                params.put("userpassword",userpassword.getText().toString().trim());
                return params;


            }
        };
        Volley.newRequestQueue(this).add(request);




    }

}