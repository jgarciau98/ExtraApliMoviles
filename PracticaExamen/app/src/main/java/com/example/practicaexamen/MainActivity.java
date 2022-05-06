package com.example.practicaexamen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
  EditText user,pass;
  SharedPreferences preferences;
  Button iniciar,salir;
  String usuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user=(EditText)findViewById(R.id.edit_user);
        pass=(EditText)findViewById(R.id.edit_pass);
        iniciar=(Button)findViewById(R.id.iniciar);
        salir=(Button)findViewById(R.id.salir);
        LeerDatos();
        if(!usuario.equals(""))
            user.setText(usuario);
            iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!user.getText().toString().equals("")&&!pass.getText().toString().equals("")){
                    Intent i= new Intent(getApplicationContext(),MenuPrincipal.class);
                    GuardarCredenciales(user.getText().toString());
                    startActivity(i);
                }else{
                    Toast.makeText(getApplicationContext(),"Debe llenar ambos campos para continuar",Toast.LENGTH_SHORT).show();
                }

            }
        });

       salir.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
             finish();
           }
       });
    }

    private void LeerDatos() {
        preferences=getSharedPreferences("credenciales", Context.MODE_PRIVATE);
        usuario=preferences.getString("user","");
    }

    private void GuardarCredenciales(String nombreuser) {
        preferences=getSharedPreferences("credenciales", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor= preferences.edit();
        editor.putString("user",nombreuser);
        editor.commit();
    }
}