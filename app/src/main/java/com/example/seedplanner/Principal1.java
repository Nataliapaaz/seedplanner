package com.example.seedplanner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class Principal1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal1);
        Toolbar tb = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(tb);

        ImageView i = (ImageView) findViewById(R.id.logoImg);
        i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Principal1.this, "HOLAAA", Toast.LENGTH_SHORT).show();
            }
        });





        /*


        tl.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Toast.makeText(Principal1.this, "entro acá", Toast.LENGTH_SHORT).show();
                int position = tab.getPosition();
                switch (position) {
                    case 0:
                        Agregarinventario a = new Agregarinventario();
                        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,a).commit();
                        break;
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
*/
        // MENU LATERAL
        NavigationView nav = (NavigationView) findViewById(R.id.nav);
        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                System.out.println("Hola");
                Toast.makeText(Principal1.this, "holaaa", Toast.LENGTH_SHORT).show();
                int id = item.getItemId();
                if (id==R.id.op1){
                    Intent i = new Intent(getApplicationContext(), Recomendaciones.class);
                    startActivity(i);
                }
                else if (id==R.id.op2){
                    Intent i = new Intent(getApplicationContext(), Agregarainventario.class);
                    startActivity(i);
                }
                else if (id==R.id.op3) {
                    Intent i = new Intent(getApplicationContext(), Agregarainventario.class);
                    startActivity(i);
                }
                else if (id==R.id.op4) {
                    Toast.makeText(getApplicationContext(), "Vas informacion de semillas", Toast.LENGTH_SHORT).show();
                }
                else if (id==R.id.op5) {
                    Toast.makeText(getApplicationContext(), "Voy a foot square garden", Toast.LENGTH_SHORT).show();
                }
                else if (id==R.id.op6) {
                    Toast.makeText(getApplicationContext(), "vas al recordatorio", Toast.LENGTH_SHORT).show();
                    fragmento1 f = new fragmento1();
                    getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, f).commit();
                }
                else if (id==R.id.op7){
                    SharedPreferences datos = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                    SharedPreferences.Editor editor = datos.edit();
                    editor.remove("usuario");
                    editor.apply();
                    finish();
                }
                return false;
            }
        });
        DrawerLayout dl = (DrawerLayout) findViewById(R.id.principal);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this,
                dl,
                R.string.abrir_drawer,
                R.string.cerrar_drawer
        );
        dl.addDrawerListener(toggle);
        toggle.syncState();

        tb.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 if(dl.isDrawerOpen(GravityCompat.START)){
                   dl.closeDrawer(GravityCompat.START);
                }
                else{
                  dl.openDrawer((int)Gravity.START);
                }
            }
        });
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Toast.makeText(this, "VVVVVVVV", Toast.LENGTH_SHORT).show();
        int id = item.getItemId();
        if (id==R.id.op1){
            Toast.makeText(this, "Vas que puedo sembrar", Toast.LENGTH_SHORT).show();
        }
        else if (id==R.id.op2){
            Toast.makeText(this, "Vas guardar semillas", Toast.LENGTH_SHORT).show();
        }
        else if (id==R.id.op3) {
            Toast.makeText(this, "Vas a mi inventario de semillas", Toast.LENGTH_SHORT).show();
        }
        else if (id==R.id.op4) {
            Toast.makeText(this, "Vas informacion de semillas", Toast.LENGTH_SHORT).show();
        }
        else if (id==R.id.op5) {
            Toast.makeText(this, "Voy a foot square garden", Toast.LENGTH_SHORT).show();
        }
        else if (id==R.id.op6) {
            Toast.makeText(this, "vas al recordatorio", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }
}