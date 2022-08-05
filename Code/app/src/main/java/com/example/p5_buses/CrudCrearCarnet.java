package com.example.p5_buses;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CrudCrearCarnet extends AppCompatActivity {
    CarnetEstudianteBD carnetBD = new CarnetEstudianteBD(this);
    EditText etCedula, etNombre, etTelefono, etDireccion, etEstado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_carnet);
        etCedula = findViewById(R.id.etCedula);
        etNombre = findViewById(R.id.etNombre);
        etTelefono = findViewById(R.id.etTelefono);
        etDireccion = findViewById(R.id.etDireccion);
        etEstado=findViewById(R.id.etEstado);
    }
    public void agregarCarnet(View view) {

        if(etNombre.getText().toString().isEmpty() || etCedula.getText().toString().length() == 0 || etTelefono.getText().toString().length() == 0 || etDireccion.getText().toString().isEmpty() || etEstado.getText().toString().isEmpty()) {
            Toast.makeText(this, "Debe llenar todos los campos", Toast.LENGTH_SHORT).show();
        }else {
            int cedula1 = Integer.parseInt(etCedula.getText().toString());
            String nombre1 = String.valueOf(etNombre.getText());
            int tel1 = Integer.parseInt(etTelefono.getText().toString());
            String direccion = String.valueOf(etDireccion.getText());
            String estado = String.valueOf(etEstado.getText());
            if (CarnetEstudianteBD.estudianteRegistrado(nombre1, cedula1)) {
                Toast.makeText(this, "El usuario ya existe", Toast.LENGTH_SHORT).show();
            } else {
                DatosCrearCarnet estudiante = new DatosCrearCarnet(nombre1, direccion, estado, tel1, cedula1);
                CarnetEstudianteBD.nuevoEstudiante(estudiante);

                Toast.makeText(this, "Datos ingresados con exito", Toast.LENGTH_SHORT).show();
            }
            etCedula.setText("");
            etNombre.setText("");
            etTelefono.setText("");
            etDireccion.setText("");
            etEstado.setText("");

        }

    }




}
