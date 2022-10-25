package com.example.formulario;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    ImageButton btn_cuentacreada;
    Button btn_cancelarcuenta;
    Button btn_crearcuenta;
    EditText txt_nombrePerfil,txt_correo,txt_password,txt_confirmpassword;
    TextView tv_perfil,tv_correo_electro,tv_contrasena_registro,tv_confirm_contrasena_registro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_cuentacreada = findViewById(R.id.btn_siguiente);

        btn_cuentacreada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,login_activity.class);
                startActivity(intent);

            }
        });

        btn_cancelarcuenta = findViewById(R.id.btn_cancelarcuenta);

        btn_cancelarcuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,login_activity.class);
                startActivity(intent);

            }
        });
        btn_crearcuenta=findViewById(R.id.btn_crearcuenta);
        txt_nombrePerfil=findViewById(R.id.et_Nombre);
        txt_correo=findViewById(R.id.et_Correo);
        txt_password=findViewById(R.id.et_password);
        txt_confirmpassword=findViewById(R.id.et_confirmarpassword);
        //message
        tv_perfil=findViewById(R.id.tv_perfil);
        tv_correo_electro=findViewById(R.id.tv_correo_electro);
        tv_contrasena_registro=findViewById(R.id.tv_contrasena_registro);
        tv_confirm_contrasena_registro=findViewById(R.id.tv_confirm_contrasena_registro);

        btn_crearcuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validatePerfil();
                validateEmail();
                validatePassword();
            }
        });

    }
    private boolean validatePerfil(){
        String perfilInput = txt_nombrePerfil.getText().toString().trim();
        if (perfilInput.isEmpty()){
            tv_perfil.setText("Este campo no puede estar vacio");
            return false;
        } else{
            tv_perfil.setText("Perfil valido");
            return true;
        }
    }
    private boolean validateEmail() {
        String emailInput = txt_correo.getText().toString().trim();
        if (emailInput.isEmpty()) {
            tv_correo_electro.setText("Este campo no puede quedar vacio");
            return false;

        } else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            tv_correo_electro.setText("Ingresa correo valido");
            return false;
        } else {
            tv_correo_electro.setText("correo Valido");
            return true;
        }
    }
    private boolean validatePassword() {
        String passwordInput = txt_password.getText().toString().trim();
        String ConfitmpasswordInput = txt_confirmpassword.getText().toString().trim();
        if (passwordInput.isEmpty()) {
            tv_contrasena_registro.setText("Este campo no puede quedar vacio");
            return false;
        }  if (passwordInput.length()<5) {
            tv_contrasena_registro.setText("La contraseña debe tener al menos 5 caracteres");
            return false;
        }
        if (!passwordInput.equals(ConfitmpasswordInput)) {
            tv_confirm_contrasena_registro.setText("La contraseña no coincide");
            return false;
        }else {
            tv_confirm_contrasena_registro.setText("Contraseña coincide");
            Toast.makeText(getApplicationContext(),"Se valido correctamente",Toast.LENGTH_SHORT).show();
            return true;
        }
    }
}