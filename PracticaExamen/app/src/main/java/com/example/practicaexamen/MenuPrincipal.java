package com.example.practicaexamen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MenuPrincipal extends AppCompatActivity {
  SharedPreferences preferences;
    TextView saludo;
  ImageView piza,bebida;
  String user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
        saludo=(TextView)findViewById(R.id.saludo);
        piza=(ImageView)findViewById(R.id.pizzas);
        bebida=(ImageView)findViewById(R.id.bebidas);
        LeerDatos();
        saludo.setText("Hola estimado "+user+" en que te podemos ayudar selecciona una opcion del menu");
        piza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(),MenuPizzas.class);
                startActivity(i);
            }
        });
        bebida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(),MenuBebidas.class);
                startActivity(i);
            }
        });
    }

    private void LeerDatos() {
        preferences=getSharedPreferences("credenciales", Context.MODE_PRIVATE);
        user=preferences.getString("user","");
    }
}