package com.example.formulario;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    Button MainActivityChangePassword;
    EditText MainActivityEmail,MainActivityPassword,MainActivityConfirmPassword;
    TextView MainActivityEmailerror,MainActivityPasswordError,MainActivityConfirmPassError;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        MainActivityChangePassword=findViewById(R.id.ChanePass);
        MainActivityEmail=findViewById(R.id.MainActivityEmail);
        MainActivityPassword=findViewById(R.id.MainActivityPassword);
        MainActivityConfirmPassword=findViewById(R.id.MainActivityConfirm);
        //message
        MainActivityEmailerror=findViewById(R.id.EmailAlert);
        MainActivityPasswordError=findViewById(R.id.PaswordAlert);
        MainActivityConfirmPassError=findViewById(R.id.ConfirmPassAlert);

        MainActivityChangePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateEmail();
                validatePassword();
            }
        });

    }
    private boolean validateEmail() {
        String emailInput = MainActivityEmail.getText().toString().trim();
        if (emailInput.isEmpty()) {
            MainActivityEmailerror.setText("Este campo no puede quedar vacio");
            return false;

        } else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            MainActivityEmailerror.setText("Ingresa correo valido");
            return false;
        } else {
            MainActivityEmailerror.setError(null);
            return true;
        }
    }
    private boolean validatePassword() {
        String passwordInput = MainActivityPassword.getText().toString().trim();
        String ConfitmpasswordInput = MainActivityConfirmPassword.getText().toString().trim();
        if (passwordInput.isEmpty()) {
            MainActivityPasswordError.setText("Este campo no puede quedar vacio");
            return false;
        }  if (passwordInput.length()<5) {
            MainActivityPasswordError.setText("La contraseña debe tener al menos 5 caracteres");
            return false;
        }
        if (!passwordInput.equals(ConfitmpasswordInput)) {
            MainActivityConfirmPassError.setText("La contraseña no coincide");
            return false;
        }else {
            MainActivityConfirmPassError.setText("Contraseña coincide");
            return true;
        }
    }
}