package com.example.practicaexamen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class FinalizarPedido extends AppCompatActivity {
   TextView saludo;
   SharedPreferences preferences;
   Button enviarPedido,Regresar;
   String PizzaSeleccionada,BebidaSeleccionada,user,total,pantallaOrigen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finalizar_pedido);
        saludo=(TextView)findViewById(R.id.saludofinal);
        enviarPedido=(Button)findViewById(R.id.enviarPedido);
        Regresar=(Button)findViewById(R.id.regresar);
        Bundle extras=getIntent().getExtras();

        if(extras!=null) {
            pantallaOrigen = extras.get("PantallaOrigen").toString();
            if (pantallaOrigen.equals("Bebidas"))
                Regresar.setText("Regresar al Menu de Bebidas");
            if (pantallaOrigen.equals("Pizzas"))
                Regresar.setText("Regresar al Menu de Pizzas");
        }
        LeerDatos();
        CalcularTotal();
        if(PizzaSeleccionada.equals(""))
            PizzaSeleccionada="Ninguna";
        if(BebidaSeleccionada.equals(""))
            BebidaSeleccionada="Ninguna";
        saludo.setText("Estimado "+user+" ha seleccionado la pizza: "+PizzaSeleccionada+" acompañada de la bebida: "+BebidaSeleccionada+" Y su total a pagar es : $"+total);
        Regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i;
                if(pantallaOrigen.equals("Bebidas"))
                     i= new Intent(getApplicationContext(),MenuBebidas.class);
                else
                     i= new Intent(getApplicationContext(),MenuPizzas.class);
                startActivity(i);
            }
        });
        enviarPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(total.equals("0"))
               {
                   Toast.makeText(getApplicationContext(),"Debes seleccionar una bebida o una pizza",Toast.LENGTH_SHORT).show();
                   Intent i= new Intent(getApplicationContext(),MenuPrincipal.class);
                   startActivity(i);
               }else{
                   Toast.makeText(getApplicationContext(),"Gracias por usar la app de pizza hut su pedido fue recibido y en breve se enviara...",Toast.LENGTH_SHORT).show();
                    Reiniardatos();
                   Intent i= new Intent(getApplicationContext(),MenuPrincipal.class);
                   startActivity(i);
               }
            }
             });


    }

    @Override
    public void onBackPressed() {

    }

    private void Reiniardatos() {

            preferences=getSharedPreferences("credenciales", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor= preferences.edit();
            editor.putString("PizaSeleccionada","");
            editor.putString("BebidaSeleccionada","");
            editor.commit();

    }

    private void CalcularTotal() {
       if(!PizzaSeleccionada.equals("")&&!BebidaSeleccionada.equals(""))
           total="70";
        if(!PizzaSeleccionada.equals("")&&BebidaSeleccionada.equals(""))
            total="60";
        if(PizzaSeleccionada.equals("")&&!BebidaSeleccionada.equals(""))
            total="10";
        if(PizzaSeleccionada.equals("")&&BebidaSeleccionada.equals(""))
            total="0";
      }

    private void LeerDatos() {
        preferences=getSharedPreferences("credenciales", Context.MODE_PRIVATE);
        user=preferences.getString("user","");
        PizzaSeleccionada=preferences.getString("PizaSeleccionada","");
        BebidaSeleccionada=preferences.getString("BebidaSeleccionada","");
    }
}