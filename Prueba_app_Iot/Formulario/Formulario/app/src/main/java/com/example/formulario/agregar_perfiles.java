package com.example.formulario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class agregar_perfiles extends AppCompatActivity {

    ImageButton btn_volverperfiles;
    Button btn_agregarperfil;
    EditText edt_agregar;
    TextView tv_agregar_perfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_perfiles);
        btn_volverperfiles = findViewById(R.id.btn_volverperfil);

        btn_volverperfiles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(agregar_perfiles.this,Perfiles_activity.class);
                startActivity(intent);

            }
        });
        btn_agregarperfil=findViewById(R.id.btn_guardarperfil);
        edt_agregar=findViewById(R.id.til_registrar_perfil);
        //message
        tv_agregar_perfil=findViewById(R.id.perfilesAlert);
        btn_agregarperfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validatePerfil();
            }
        });

    }
    private boolean validatePerfil(){
        String perfilInput = edt_agregar.getText().toString().trim();
        if (perfilInput.isEmpty()){
            tv_agregar_perfil.setText("Este campo no puede estar vacio");
            return false;
        } else{
            tv_agregar_perfil.setText("Perfil valido");
            Toast.makeText(getApplicationContext(),"Se valido correctamente",Toast.LENGTH_SHORT).show();

            return true;
        }
    }

}