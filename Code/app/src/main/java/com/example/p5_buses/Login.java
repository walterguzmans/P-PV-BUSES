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
    String correo,contraseña;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        et1correo = findViewById(R.id.txtcorreo);
        et2contraseña = findViewById(R.id.txtcontraseña);

       this.registrousuarios();
        Intent intent = new Intent(Login.this, MenuAdmin.class);
        startActivity(intent);

    }

    public void ingresar(View view) {
        correo = et1correo.getText().toString();
        contraseña = et2contraseña.getText().toString();

        if (correo == null || "".equals(contraseña)) {
            Toast.makeText(this, "Campos invalidos", Toast.LENGTH_SHORT).show();
        } else {
            boolean existe = this.existeusuario(correo, contraseña);
            if (existe) {
                boolean tipousuario = this.tipousuario(correo);
                if (tipousuario) {
                    //ingresar ventana administrador
                    Intent intent = new Intent(Login.this, MenuAdmin.class);
                    startActivity(intent);
                } else {
                    //ingresar ventana usuario
                    Intent intent = new Intent(Login.this, MenuUsuario.class);
                    startActivity(intent);
                }
            } else {
                Toast.makeText(this, "credenciales incorrectos", Toast.LENGTH_SHORT).show();
            }
        }
        et1correo.setText("");
        et2contraseña.setText("");

    }

    public void registrousuarios() {  // insercion de usuarios
        Conexion conexion = new Conexion(this);
        SQLiteDatabase db = conexion.getReadableDatabase();

        db.execSQL("INSERT OR IGNORE INTO  usuarios  (cedula ,nombre ,apellidos ,email ,usuario ,contraseña ,rol ) Values (70280733,'Keisy','Avalos Artavia','kavalosartavia@gmail.com','Keisy31','Camino123','Administrador')");
        db.execSQL("INSERT OR IGNORE INTO usuarios (cedula ,nombre ,apellidos ,email ,usuario ,contraseña ,rol) Values (72809024,'Paula','Villegas Mora','pau@gmail.com','Paula01','pau123','Usuario')");
        db.close();

    }

    public boolean existeusuario(String correo, String contrasena) {
        Conexion conexion = new Conexion(this);
        SQLiteDatabase db =conexion.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from usuarios where email=? and  contraseña=?", new String[]{correo, contrasena});
        if (cursor.getCount() > 0) {
            return true;
        } else {
            db.close();
        }
        return false;
    }

    public boolean tipousuario(String correo) {
        Conexion conexion = new Conexion(this);
        SQLiteDatabase db =conexion.getReadableDatabase();

        Cursor cursor = db.rawQuery("select  rol  from usuarios where email=?", new String[]{correo});

        if (cursor.moveToFirst()) {
            if (cursor.getString(cursor.getColumnIndexOrThrow("rol")).equals("Administrador"))
                return true;
        } else {
            db.close();
        }
        return false;
    }






}
