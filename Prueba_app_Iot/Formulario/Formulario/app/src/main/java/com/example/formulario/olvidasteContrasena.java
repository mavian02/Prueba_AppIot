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

public class olvidasteContrasena extends AppCompatActivity {

    Button btn_actualizarcontra;
    EditText actualizar_contra,confirmar_actualizar_contra;
    TextView PasswordError,ConfirmPassError;

    ImageButton btnanterior;
    Button btn_cancelarcontraseña;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_olvidaste_contrasena);
        btnanterior = (ImageButton) findViewById(R.id.btn_anterior);
        btnanterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(olvidasteContrasena.this,login_activity.class);
                startActivity(intent);
            }
        });
        btn_cancelarcontraseña = findViewById(R.id.btn_cancelaractualizacion);
        btn_cancelarcontraseña.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(olvidasteContrasena.this,login_activity.class);
                startActivity(intent);
            }
        });
        btn_actualizarcontra=findViewById(R.id.btn_actualizarcontra);
        actualizar_contra=findViewById(R.id.edt_actualizar_contra);
        confirmar_actualizar_contra=findViewById(R.id.edt_confirmar_actualizar_contra);
        //message

        PasswordError=findViewById(R.id.alert_actualizar);
        ConfirmPassError=findViewById(R.id.alert_confirm_actualizar);

        btn_actualizarcontra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validatePassword();
            }
        });

    }
        private void validatePassword() {
            String passwordInput = actualizar_contra.getText().toString().trim();
            String ConfitmpasswordInput = confirmar_actualizar_contra.getText().toString().trim();
            if (passwordInput.isEmpty()) {
                PasswordError.setText("Este campo no puede quedar vacio");
                return;
            }  if (passwordInput.length()<6) {
                PasswordError.setText("La contraseña debe tener al menos 5 caracteres");
                return;
            }
            if (!passwordInput.equals(ConfitmpasswordInput)) {
                ConfirmPassError.setText("La contraseña no coincide");
            }
            else {
                ConfirmPassError.setText("Contraseña coincide");
                Toast.makeText(getApplicationContext(),"Se valido correctamente",Toast.LENGTH_SHORT).show();
            }


        }


}

