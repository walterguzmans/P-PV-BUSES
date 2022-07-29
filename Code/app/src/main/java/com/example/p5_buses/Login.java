package com.example.p5_buses;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    Conexion conexion;
    private EditText et1correo, et2contraseña;
    String correo,contraseña;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        et1correo = findViewById(R.id.txtcorreo);
        et2contraseña = findViewById(R.id.txtcontraseña);
        conexion = new Conexion(this);
        conexion.registrousuarios();

    }

    public void ingresar(View view) {
        correo = et1correo.getText().toString();
        contraseña = et2contraseña.getText().toString();

        if (correo == null || "".equals(contraseña)) {
            Toast.makeText(this, "Campos invalidos", Toast.LENGTH_SHORT).show();
        } else {
            boolean existe = conexion.existeusuario(correo, contraseña);
            if (existe) {
                boolean tipousuario = conexion.tipousuario(correo);
                if (tipousuario) {
                    //ingresar ventana administrador
                    Toast.makeText(this, "Bienvenido administrador", Toast.LENGTH_SHORT).show();
                } else {
//ingresar ventana usuario
                    Toast.makeText(this, "Bienvenido usuario", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "credenciales incorrectos", Toast.LENGTH_SHORT).show();
            }
        }
        et1correo.setText("");
        et2contraseña.setText("");

    }
}
