package com.example.seedplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrarCuenta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_cuenta);


    }

    public void registrar(View v){
        EditText etUsuario = (EditText) findViewById(R.id.etUsuario);
        String usuario = etUsuario.getText().toString();

        EditText etCorreo = (EditText) findViewById(R.id.etCorreo);
        String correo = etCorreo.getText().toString();

        EditText etPassword = (EditText) findViewById(R.id.etPassword);
        String password = etPassword.getText().toString();

        EditText etPassword2 = (EditText) findViewById(R.id.etPassword2);
        String password2 = etPassword2.getText().toString();

        if (password.equals(password2)){
            Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Las contraseñas deben ser iguales", Toast.LENGTH_SHORT).show();
        }

    }
}