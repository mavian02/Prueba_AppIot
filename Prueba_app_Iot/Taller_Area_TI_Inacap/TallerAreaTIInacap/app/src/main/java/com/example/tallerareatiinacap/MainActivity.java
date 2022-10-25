package com.example.tallerareatiinacap;

import static com.example.tallerareatiinacap.R.layout.activity_main;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;
import java.util.Date;
import java.util.Calendar;



public class MainActivity extends AppCompatActivity implements MenuItem.OnMenuItemClickListener {
    Spinner comboLab;
    Button  btn_grabar;
    private EditText lab_fechayhora;
    private TextView txt_fecha;
    private EditText lit_rut;
    private EditText txt_nombre;
    private EditText txt_descripcion;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_main);
        lit_rut = (EditText)findViewById(R.id.til_validar);
        txt_nombre = (EditText)findViewById(R.id.txt_nombre);
        txt_descripcion = (EditText)findViewById(R.id.txt_descripcion);
        btn_grabar = (Button) findViewById(R.id.btn_grabar);
        txt_fecha = (TextView) findViewById(R.id.fecha);
        //lab_fechayhora = (EditText)findViewById(R.id.lab_fechayhora);

        Date actual= Calendar.getInstance().getTime();
        txt_fecha.setText(actual.toString());


        comboLab =(Spinner)findViewById(R.id.idSpinnerLab);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.combo_Lab, android.R.layout.simple_spinner_item);
        comboLab.setAdapter(adapter);


        lit_rut.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {

                    //Toast.makeText(MainActivity.this, "focus loosed", Toast.LENGTH_LONG).show();

                    Validar_rut validacion = new Validar_rut("");
                    String lit_validaciones = lit_rut.getText().toString();
                    validacion.setRUT(lit_validaciones);

                    if (validacion.Validacion_Concreta()== false){
                        lit_rut.setError("rut  es invalido");
                        //lit_rut.requestFocus();
                    }
                    else {
                        Toast.makeText(MainActivity.this, "rut valido", Toast.LENGTH_LONG).show();
                    }

                }
               // else {
                  //  Toast.makeText(MainActivity.this, "focused", Toast.LENGTH_LONG).show();
                //}
            }
        });



        btn_grabar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grabar();
                mostrarAdvertencia();


            }
        });
        //lab_fechayhora.setOnClickListener(new View.OnClickListener() {
            //@RequiresApi(api = Build.VERSION_CODES.O)
            //@Override
            //public void onClick(View view) {
                //LocalDateTime fechaHoraActuales = LocalDateTime.now();
                //System.out.println("\nFecha y hora actuales: " + fechaHoraActuales);
            //}
        //});

    }


    private void grabar() {
        txt_nombre.setError(null);
        txt_descripcion.setError(null);

        String nombre = txt_nombre.getText().toString();
        String descripcion = txt_descripcion.getText().toString();

        if (TextUtils.isEmpty(nombre)) {
            txt_nombre.setError(getString(R.string.error_campo_obligatorio));
            txt_nombre.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(descripcion)) {
            txt_descripcion.setError(getString(R.string.error_campo_obligatorio));
            txt_descripcion.requestFocus();
            return;
        }

        Toast.makeText(getApplicationContext(), "Se ha grabado correctamente", Toast.LENGTH_SHORT).show();
    }

        @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        return true;

    }
    private void mostrarAdvertencia(){
        new  AlertDialog.Builder(this)
                .setTitle("Advertencia")
                .setMessage("Si esta seguro de grabar el incedente")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener(){

                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })

                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        Log.d("Mensaje","se cancelo  la accion ");

                    }
                })
                .show();



    }

   // public class FechaHoraActuales {
    //    public static void main (String[] args){
     //       LocalDateTime fechaHoraActuales = LocalDateTime.now();
       //     System.out.println("\nFecha y hora actuales: " + fechaHoraActuales);
      //  }
   // }
}