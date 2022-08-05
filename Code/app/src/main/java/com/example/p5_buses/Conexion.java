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
    public void onCreate(SQLiteDatabase db) {  //creacion de tabla usuario
        db.execSQL("create table usuarios(cedula int primary key, nombreCompleto text, telefono int,email text,contraseña text,rol text)");

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS usuarios");
        db.close();

    }



}
