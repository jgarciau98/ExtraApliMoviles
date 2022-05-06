package com.example.practicaexamen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MenuBebidas extends AppCompatActivity {
    ImageView coca,cris,agua;
    Button finped,irpiza;
    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_bebidas);
        coca=(ImageView)findViewById(R.id.coca);
        cris=(ImageView)findViewById(R.id.cristal);
        agua=(ImageView)findViewById(R.id.agua);
        finped=(Button)findViewById(R.id.finpedido);
        irpiza=(Button)findViewById(R.id.irpizza2);
        coca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GuardarSeleccion("CocaCola");
            }
        });
        cris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GuardarSeleccion("Cristal");
            }
        });
        agua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GuardarSeleccion("Agua");
            }
        });
        finped.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(),FinalizarPedido.class);
                i.putExtra("PantallaOrigen","Bebidas");
                startActivity(i);
            }
        });
        irpiza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(),MenuPizzas.class);
                startActivity(i);
            }
        });

    }
    private void GuardarSeleccion(String seleccion) {
        preferences=getSharedPreferences("credenciales", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor= preferences.edit();
        editor.putString("BebidaSeleccionada",seleccion);
        editor.commit();
    }
}