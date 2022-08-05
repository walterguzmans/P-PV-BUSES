package com.example.p5_buses;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CrudUsuarios extends AppCompatActivity {
    UsuariosBD usuariosBD = new UsuariosBD(this);
    EditText cedula, nombre, telefono, email, contrasena;
    private Spinner spinner1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud_usuarios);
        cedula=findViewById(R.id.etcedula);
        nombre = findViewById(R.id.etnombre);
        telefono = findViewById(R.id.ettelefono);
        email = findViewById(R.id.etemail);
        contrasena=findViewById(R.id.etcontraseña);


        spinner1 =findViewById(R.id.spinner1);
        String []opciones={"Administrador","Usuario"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, opciones);
        spinner1.setAdapter(adapter);

    }
    public void agregarUsuario(View view) {
        int cedula1 = Integer.parseInt(cedula.getText().toString());
        String nombre1 = String.valueOf(nombre.getText());
        int tel1 = Integer.parseInt(telefono.getText().toString());
        String email1 = String.valueOf(email.getText());
        String contraseña = String.valueOf(contrasena.getText());
        String rol = spinner1.getSelectedItem().toString();

        if(nombre.getText().toString().isEmpty() || cedula.getText().toString().isEmpty() || telefono.getText().toString().isEmpty() || email.getText().toString().isEmpty() || contrasena.getText().toString().isEmpty()) {
            Toast.makeText(this, "Debe llenar todos los campos", Toast.LENGTH_SHORT).show();
        }else {
            if (usuariosBD.usuarioRegistrado(nombre1, cedula1)) {
                Toast.makeText(this, "El usuario ya existe", Toast.LENGTH_SHORT).show();
            } else {
                DatosUsuarios usuarios = new DatosUsuarios(nombre1, email1, contraseña, rol, tel1, cedula1);
                usuariosBD.nuevoUsuario(usuarios);

                Toast.makeText(this, "Datos ingresados con exito", Toast.LENGTH_SHORT).show();
            }
            cedula.setText("");
            nombre.setText("");
            telefono.setText("");
            email.setText("");
            contrasena.setText("");
            spinner1.setSelected(Boolean.parseBoolean(""));
        }

    }

}