package com.example.practicaexamen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MenuPizzas extends AppCompatActivity {
    ImageView hawa,ita,mex;
    Button finped,irbeb;
    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_pizzas);
        hawa=(ImageView)findViewById(R.id.hawaiana);
        ita=(ImageView)findViewById(R.id.italiana);
        mex=(ImageView)findViewById(R.id.mexicana);
        finped=(Button)findViewById(R.id.finped);
        irbeb=(Button)findViewById(R.id.irbeb);

        hawa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               GuardarSeleccion("Hawaiana");
            }
        });
        ita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GuardarSeleccion("Italiana");
            }
        });
        mex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GuardarSeleccion("Mexicana");
            }
        });
        finped.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(),FinalizarPedido.class);
                i.putExtra("PantallaOrigen","Pizzas");
                startActivity(i);
            }
        });
        irbeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(),MenuBebidas.class);

                startActivity(i);
            }
        });
    }

    private void GuardarSeleccion(String seleccion) {
        preferences=getSharedPreferences("credenciales", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor= preferences.edit();
        editor.putString("PizaSeleccionada",seleccion);
        editor.commit();
    }
}