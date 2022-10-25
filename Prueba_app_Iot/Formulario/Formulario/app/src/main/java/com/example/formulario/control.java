package com.example.formulario;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class control extends AppCompatActivity {


    private ImageButton btnMute, btn_atrasperfil, btnRestar, btnMenu,btnSumar,btnArriba,
            btnAbajo,btnIzquierda, btnDerecha,btnOkey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control);

        btnMute = (ImageButton) findViewById(R.id.btn_mute);

        btnMute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Haz seleccionado: Mute", Toast.LENGTH_SHORT).show();
            }
        });
        btnRestar = (ImageButton)findViewById(R.id.btn_restar);

        btnRestar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "bajando volumen", Toast.LENGTH_SHORT).show();
            }
        });
        btnSumar = (ImageButton)findViewById(R.id.btn_sumar);

        btnSumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Subiendo volumen", Toast.LENGTH_SHORT).show();
            }
        });
        btnMenu = (ImageButton)findViewById(R.id.btn_menu);

        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Haz seleccionado: Menu", Toast.LENGTH_SHORT).show();
            }
        });
        btnArriba = (ImageButton)findViewById(R.id.btn_arriba);

        btnArriba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Subiendo", Toast.LENGTH_SHORT).show();
            }
        });
        btnAbajo = (ImageButton)findViewById(R.id.btn_abajo);

        btnAbajo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Bajando", Toast.LENGTH_SHORT).show();
            }
        });
        btnIzquierda = (ImageButton)findViewById(R.id.btn_izquierda);

        btnIzquierda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Hacia la izquierda", Toast.LENGTH_SHORT).show();
            }
        });
        btnDerecha = (ImageButton)findViewById(R.id.btn_derecha);

        btnDerecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Hacia la derecha", Toast.LENGTH_SHORT).show();
            }
        });
        btnOkey = (ImageButton)findViewById(R.id.btn_ok);

        btnOkey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Haz pulsado Ok", Toast.LENGTH_SHORT).show();
            }
        });

    }
}