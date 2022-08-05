package com.example.p5_buses;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private EditText et1correo, et2contraseña;
    UsuariosBD usuario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et1correo = findViewById(R.id.txtcorreo);
        et2contraseña = findViewById(R.id.txtcontraseña);
        usuario = new UsuariosBD(this);
        usuario.registro();

    }



    public void ingresar(View view) {
        String email = et1correo.getText().toString();
        String password = et2contraseña.getText().toString();

        if (email == null || "".equals(password)) {
            Toast.makeText(this, "Campos invalidos", Toast.LENGTH_SHORT).show();
        } else {
            boolean existe = usuario.existeusuario(email, password);

            if (existe) {
                boolean verificartipousuario = usuario.tipousuario(email);
                if (verificartipousuario) {
                    Intent intent = new Intent(Login.this, MenuAdmin.class);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(Login.this, MenuUsuario.class);
                    startActivity(intent);
                }
            } else {
                Toast.makeText(this, "Credenciales incorrectos", Toast.LENGTH_SHORT).show();
            }
        }

    }








}
