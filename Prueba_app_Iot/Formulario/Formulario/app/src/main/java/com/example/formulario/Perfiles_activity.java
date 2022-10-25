package com.example.formulario;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Perfiles_activity extends AppCompatActivity {

    ImageButton btn_volveralogin, btn_siguiente_control,btn_agregarperfil;
    ImageButton perfil1,perfil2,perfil3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfiles);

        btn_volveralogin = findViewById(R.id.btn_volverlogin);

        btn_volveralogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Perfiles_activity.this,login_activity.class);
                startActivity(intent);

            }
        });
        perfil1 = findViewById(R.id.ib_iniciarperfil1);

        perfil1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Perfiles_activity.this,control.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "Iniciando perfil 1", Toast.LENGTH_SHORT).show();

            }
        });
        perfil2 = findViewById(R.id.ib_iniciarperfil2);

        perfil2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Perfiles_activity.this,control.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "Iniciando perfil 2", Toast.LENGTH_SHORT).show();

            }
        });
        perfil3 = findViewById(R.id.ib_iniciarperfil3);

        perfil3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Perfiles_activity.this,control.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "Iniciando perfil 3", Toast.LENGTH_SHORT).show();

            }
        });

        btn_agregarperfil = findViewById(R.id.ib_agregar_perfiles);

        btn_agregarperfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Perfiles_activity.this,agregar_perfiles.class);
                startActivity(intent);

            }
        });
    }
}