package com.jsyp.examenparcial2movil;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class Resultados extends AppCompatActivity {


    DatabaseHelper databaseHelper;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);

        databaseHelper = new DatabaseHelper(this);

        // Recibe los datos pasados desde MainActivity
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String nombre = extras.getString("NOMBRE");
            String cedula = extras.getString("CEDULA");
            String fecha = extras.getString("FECHA");
            String placa = extras.getString("PLACA");
            String anio = extras.getString("ANIO");



            // Muestra los datos en los TextView correspondientes
            TextView lblNombre = findViewById(R.id.lblNombre);
            lblNombre.setText("HOLA SOY " + nombre);

            TextView lblCiudad = findViewById(R.id.lblCiudad);
            lblCiudad.setText("VIVO EN " + cedula);

            TextView lblFechaNacim = findViewById(R.id.lblFechaNacim);
            lblFechaNacim.setText("NACÍ EL " + fecha);

            TextView lblSignoZodiaco = findViewById(R.id.lblSignoZodiaco);
            lblSignoZodiaco.setText("MI SIGNO DEL ZODÍACO ES " + placa);

            TextView lblCorreo = findViewById(R.id.lblCorreo);
            lblCorreo.setText("MI CORREO ELECTRÓNICO ES " + anio);

            Button btnAtras = findViewById(R.id.btnAtras);
            btnAtras.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish(); // Cierra la actividad actual y regresa a la actividad anterior
                }
            });



            Button btnInsertar = findViewById(R.id.btnInsertar);
            btnInsertar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Insertar los datos en la base de datos
                    boolean success = databaseHelper.insertData(nombre, cedula, fecha, placa, anio);
                    if (success) {
                        Toast.makeText(Resultados.this, "Datos insertados en la base de datos", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(Resultados.this, "Error al insertar datos en la base de datos", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}
