package com.example.p5_buses;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Conexion conexion;
    private EditText et1usuario, et2contraseña;
    String usuario,contraseña;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1usuario = findViewById(R.id.et1usuario);
        et2contraseña = findViewById(R.id.et2contraseña);
        conexion = new Conexion(this);
        conexion.registrousuarios();

    }

    public void ingresar(View view) {

        usuario = et1usuario.getText().toString();
        contraseña = et2contraseña.getText().toString();


        if (usuario == null || "".equals(contraseña)) {

            Toast.makeText(this, "campos invalidos", Toast.LENGTH_SHORT).show();

        } else {

            boolean existe = conexion.exiteusuario(usuario, contraseña);

            if (existe) {
                boolean tipousuario = conexion.tipousuario(usuario);

                if (tipousuario) {
 //ingresar ventana administrador
                    Toast.makeText(this, "Bienvenido administrador", Toast.LENGTH_SHORT).show();

                } else {
//ingresar venta usuario
                    Toast.makeText(this, "Bienvenido usuario", Toast.LENGTH_SHORT).show();

                }


            } else {
                Toast.makeText(this, "credenciales incorrectos", Toast.LENGTH_SHORT).show();
            }


        }
        et1usuario.setText("");
        et2contraseña.setText("");

    }




}

