package com.example.seedplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void login(View v){

        EditText campo1 = this.findViewById(R.id.usuario);
        String usuario = campo1.getText().toString();
        EditText campo2 = this.findViewById(R.id.contrasena);
        String contrasena = campo2.getText().toString();

        if(usuario.equals("Natalia") && contrasena.equals("123")){
            CheckBox cbRecuerdame = (CheckBox) findViewById(R.id.cbRecuerdame);
            boolean chequeado = cbRecuerdame.isChecked();
            if(chequeado==true){
                SharedPreferences datos = PreferenceManager.getDefaultSharedPreferences(this);
                SharedPreferences.Editor editor = datos.edit();
                editor.putString("usuario", usuario);
                editor.apply();
            }

            Intent i = new Intent(this, Principal1.class);
            startActivity(i);
        }else{
            Toast.makeText(this, "Error en las credenciales", Toast.LENGTH_SHORT).show();
        }

    }

    public void crearCuenta(View v){
        Intent i = new Intent(this, RegistrarCuenta.class);
        startActivity(i);
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences datos = PreferenceManager.getDefaultSharedPreferences(this);
        String usuario = datos.getString("usuario", "");
        if (!usuario.equals("")){
            Intent i = new Intent(this, Principal1.class);
            startActivity(i);
        }
    }
}