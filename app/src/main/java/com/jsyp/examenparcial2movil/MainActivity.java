package com.jsyp.examenparcial2movil;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText edNombre, edCiudad, edSigno, edCorreo;

    TextView edFecha; // Cambiado de EditText a TextView


    private Button btnEnviarDatos;

    private Button btnCalendario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edNombre = findViewById(R.id.txtNombre);
        edCiudad = findViewById(R.id.txtCiudad);
        edSigno = findViewById(R.id.txtSigno);
        edCorreo = findViewById(R.id.txtCorreo);
        edFecha = findViewById(R.id.txtFecha); // Actualizado
        btnCalendario = findViewById(R.id.btnCalendario);
        btnEnviarDatos = findViewById(R.id.btnEnviar);

        btnEnviarDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                procesar(view);
            }
        });

        btnCalendario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePicker();
            }
        });





    }



    private void showDatePicker() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                MainActivity.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        String selectedDate = dayOfMonth + "/" + (month + 1) + "/" + year;
                        edFecha.setText(selectedDate);
                    }
                },
                year, month, day);
        datePickerDialog.show();
    }

    public void procesar(View view) {
        String nombre = edNombre.getText().toString();
        String cedula = edCiudad.getText().toString();
        String placa = edSigno.getText().toString();
        String anio = edCorreo.getText().toString();
        String fecha = edFecha.getText().toString();

        Intent intent = new Intent(MainActivity.this, ActivityResultados.class);

        // Agrega los datos como extras al Intent
        intent.putExtra("NOMBRE", nombre);
        intent.putExtra("CEDULA", cedula);
        intent.putExtra("FECHA", fecha);

        intent.putExtra("PLACA", placa);
        intent.putExtra("ANIO", anio);



        startActivity(intent);

    }

}