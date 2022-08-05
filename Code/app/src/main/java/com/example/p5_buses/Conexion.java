package com.example.p5_buses;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class Conexion extends SQLiteOpenHelper {


    public Conexion(@Nullable Context context) {
        super(context, "Proyecto", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {  //creacion de tablas
        db.execSQL("create table usuarios(cedula int primary key,nombre text,apellidos text,email text,usuario text,contraseña text,rol text)");
        db.execSQL("create table Estudiante(cedula int primary key,nombre text,apellidos text,dierrcion text,telefono int, estado text)");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS usuarios");
        db.execSQL("DROP TABLE IF EXISTS estudante");
        db.close();

    }




}
