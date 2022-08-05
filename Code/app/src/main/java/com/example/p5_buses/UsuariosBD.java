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
    public void buscarUsuario(DatosUsuarios usuario,int cedula){
        SQLiteDatabase baseDeDatos = conexion.getWritableDatabase();

        if(baseDeDatos!=null){
            Cursor cursor = baseDeDatos.rawQuery("Select * from usuarios where cedula='"+cedula+"'",null);
            if(cursor.moveToFirst()){
                do{
                    usuario.setNombreCompleto(cursor.getString(1));
                    usuario.setTelefono(cursor.getInt(2));
                    usuario.setEmail(cursor.getString(3));
                    usuario.setContrasena(cursor.getString(4));
                    usuario.setRol(cursor.getString(5));
                }while(cursor.moveToNext());
            }
        }
    }
       public int actualizar(DatosUsuarios usuario) {
        SQLiteDatabase baseDeDatos = conexion.getWritableDatabase();
        ContentValues valoresParaActualizar = new ContentValues();
        valoresParaActualizar.put("cedula", usuario.getCedula());
        valoresParaActualizar.put("nombreCompleto", usuario.getNombreCompleto());
        valoresParaActualizar.put("telefono", usuario.getTelefono());
        valoresParaActualizar.put("email", usuario.getEmail());
        valoresParaActualizar.put("contraseña", usuario.getContrasena());
        valoresParaActualizar.put("rol", usuario.getRol());
        return baseDeDatos.update("usuarios", valoresParaActualizar, "cedula= ?", new String[]{String.valueOf(usuario.getCedula())});
    }

    public List<DatosUsuarios> mostrarusuarios(){

        SQLiteDatabase baseDeDatos = conexion.getWritableDatabase();
        Cursor cursor = baseDeDatos.rawQuery("Select * from usuarios ",null);
        List<DatosUsuarios> usuarios = new ArrayList<>();
        if(cursor.moveToFirst()){
            do{
                usuarios.add(new DatosUsuarios(cursor.getString(cursor.getColumnIndexOrThrow("nombreCompleto")),
                        cursor.getString(cursor.getColumnIndexOrThrow("email")),
                        cursor.getString(cursor.getColumnIndexOrThrow("contraseña")),
                        cursor.getString(cursor.getColumnIndexOrThrow("rol")),
                        cursor.getInt(cursor.getColumnIndexOrThrow("telefono")),
                        cursor.getInt(cursor.getColumnIndexOrThrow("cedula"))));

            }while(cursor.moveToNext());
        }
        return usuarios;
    }
    public boolean eliminarUsuario(int cedula) {
        SQLiteDatabase baseDeDatos = conexion.getWritableDatabase();
        String[] argumentos = {String.valueOf(cedula)};
        int cant = baseDeDatos.delete("usuarios", "cedula = ?", argumentos);
        if(cant == 1){
            return true;
        }else{
            return false;
        }

    }
}
