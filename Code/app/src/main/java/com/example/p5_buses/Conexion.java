package com.example.p5_buses;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class Conexion extends SQLiteOpenHelper {

    public static final String DBname = "Proyecto.db";

    public Conexion(Context context) {
        super(context, "Proyecto.db", null, 1);  //creacion de la base de datos
    }

    @Override
    public void onCreate(SQLiteDatabase db) {  //creacion de tabla usuario
        db.execSQL("create table usuarios(cedula int primary key,nombre text,apellidos text,email text,usuario text,contraseña text,rol text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS usuarios");
        db.close();

    }

    public void registrousuarios() {  // insercion de usuarios
        SQLiteDatabase db = this.getReadableDatabase();

        db.execSQL("INSERT OR IGNORE INTO  usuarios  (cedula ,nombre ,apellidos ,email ,usuario ,contraseña ,rol ) Values (70280733,'Keisy','Avalos Artavia','kavalosartavia@gmail.com','Keisy31','Camino123','Administrador')");
        db.execSQL("INSERT OR IGNORE INTO usuarios (cedula ,nombre ,apellidos ,email ,usuario ,contraseña ,rol) Values (72809024,'Paula','Villegas Mora','pau@gmail.com','Paula01','pau123','Usuario')");
        db.close();

    }

    public boolean existeusuario(String correo, String contrasena) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from usuarios where email=? and  contraseña=?", new String[]{correo, contrasena});
        if (cursor.getCount() > 0) {
            return true;
        } else {
            db.close();
        }
        return false;
    }

    public boolean tipousuario(String correo) {
        SQLiteDatabase db = this.getReadableDatabase();
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
