package com.example.formulario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class login_activity extends AppCompatActivity {


    Button validar_login;
    EditText editTextcorreo,editTextContra;
    TextView alertEmailerror,PasswordValido;

    Button btnOlvidar;
    Button btnCrear;
    ImageButton btn_pasarperfil;
    ImageButton btnGoogle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnOlvidar = findViewById(R.id.btn_olvidastetucontraseña);

        btnOlvidar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(login_activity.this,olvidasteContrasena.class);
                startActivity(intent);

            }
        });

        btnCrear = findViewById(R.id.crearcuenta);

        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(login_activity.this,MainActivity.class);
                startActivity(intent);

            }
        });
        btn_pasarperfil = findViewById(R.id.btn_pasarperfiles);

        btn_pasarperfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(login_activity.this,Perfiles_activity.class);
                startActivity(intent);

            }
        });




        btnGoogle = findViewById(R.id.ib_iniciargoogle);

        btnGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(login_activity.this,registerGoogle.class);
                startActivity(intent);

            }
        });
        validar_login=findViewById(R.id.validarlogin);
        editTextcorreo=findViewById(R.id.edt_correo);
        editTextContra=findViewById(R.id.edt_contrasena);
        //message
        alertEmailerror=findViewById(R.id.EmailAlert);
        PasswordValido=findViewById(R.id.Tv_PassAlert);

        validar_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateEmail();
                validatePassword();
            }
        });

    }
    private boolean validateEmail() {
        String emailInput = editTextcorreo.getText().toString().trim();
        if (emailInput.isEmpty()) {
            alertEmailerror.setText("Este campo no puede quedar vacio");
            return false;

        } else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            alertEmailerror.setText("Ingresa correo valido");
            return false;
        } else {
            alertEmailerror.setText("correo Valido");
            return true;
        }
    }
    private boolean validatePassword() {
        String passwordInput = editTextContra.getText().toString().trim();
        if (passwordInput.isEmpty()) {
            PasswordValido.setText("Este campo no puede quedar vacio");
            return false;
        }  if (passwordInput.length()<5) {
            PasswordValido.setText("La contraseña debe tener al menos 5 caracteres");
            return false;
        }else {
            PasswordValido.setError(null);;
            Toast.makeText(getApplicationContext(),"Se valido correctamente",Toast.LENGTH_SHORT).show();
            return true;
        }
    }
}