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

public class registerGoogle extends AppCompatActivity {
    Button btn_siguiente;
    EditText edt_login;
    TextView tv_confirmar_correo;
    ImageButton btn_volverlogin;
    Button btn_cancelarlogingoo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_google);

        btn_volverlogin = findViewById(R.id.btn_volverlogin);

        btn_volverlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(registerGoogle.this,login_activity.class);
                startActivity(intent);

            }
        });

        btn_cancelarlogingoo = findViewById(R.id.btn_cancelar_logingoogle);

        btn_cancelarlogingoo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(registerGoogle.this,login_activity.class);
                startActivity(intent);

            }
        });
        btn_siguiente=findViewById(R.id.siguiente);
        edt_login=findViewById(R.id.edt_confirm_correo);
        //message
        tv_confirmar_correo=findViewById(R.id.tv_confirmar_correo);
                btn_siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateEmail();
            }
        });

    }
    private boolean validateEmail() {
        String emailInput = edt_login.getText().toString().trim();
        if (emailInput.isEmpty()) {
            tv_confirmar_correo.setText("Este campo no puede quedar vacio");
            return false;

        } else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            tv_confirmar_correo.setText("Ingresa correo valido");
            return false;
        } else {
            tv_confirmar_correo.setText("correo valido");
            Toast.makeText(getApplicationContext(),"Se valido correctamente",Toast.LENGTH_SHORT).show();
            return true;
        }

    }

}