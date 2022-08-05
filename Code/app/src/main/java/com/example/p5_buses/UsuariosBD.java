package com.example.p5_buses;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;


public class UsuariosBD {
    Conexion conexion;
    public UsuariosBD(Context contexto) {
        conexion = new Conexion (contexto);
    }

    public boolean tipousuario(String correo) {
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

    public boolean existeusuario(String correo, String contrasena) {
        SQLiteDatabase db =conexion.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from usuarios where email=? and  contraseña=?", new String[]{correo, contrasena});
        if (cursor.getCount() > 0) {
            return true;
        } else {
            db.close();
        }
        return false;
    }

    public long nuevoUsuario(DatosUsuarios usuario) {
        // writable porque vamos a insertar
        SQLiteDatabase baseDeDatos = conexion.getWritableDatabase();
        ContentValues valoresParaInsertar = new ContentValues();
        valoresParaInsertar.put("cedula", usuario.getCedula());
        valoresParaInsertar.put("nombreCompleto", usuario.getNombreCompleto());
        valoresParaInsertar.put("telefono", usuario.getTelefono());
        valoresParaInsertar.put("email", usuario.getEmail());
        valoresParaInsertar.put("contraseña", usuario.getContrasena());
        valoresParaInsertar.put("rol", usuario.getRol());
        return baseDeDatos.insert("usuarios", null, valoresParaInsertar);
    }
    public boolean usuarioRegistrado(String nombre, int cedula) {
        SQLiteDatabase db =conexion.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from usuarios where nombreCompleto=? and cedula=?", new String[]{nombre, String.valueOf(cedula)});
        if (cursor.getCount() > 0) {
            return true;
        } else {
            db.close();
        }
        return false;
    }
}
