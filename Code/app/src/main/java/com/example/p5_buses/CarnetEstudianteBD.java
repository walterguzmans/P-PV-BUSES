package com.example.p5_buses;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class CarnetEstudianteBD {
    static Conexion conexion;
    public CarnetEstudianteBD(Context contexto) {
        conexion = new Conexion (contexto);
    }


    public static boolean estudianteRegistrado(String nombre, int cedula) {
        SQLiteDatabase db =conexion.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from estudante where nombreCompleto=? and cedula=?", new String[]{nombre, String.valueOf(cedula)});
        if (cursor.getCount() > 0) {
            return true;
        } else {
            db.close();
        }
        return false;
    }
    public static long nuevoEstudiante(DatosCrearCarnet estudiante) {
        // writable porque vamos a insertar
        SQLiteDatabase baseDeDatos = conexion.getWritableDatabase();
        ContentValues valoresParaInsertar = new ContentValues();
        valoresParaInsertar.put("cedula", estudiante.getCedula());
        valoresParaInsertar.put("nombreCompleto", estudiante.getNombreCompleto());
        valoresParaInsertar.put("telefono", estudiante.getTelefono());
        valoresParaInsertar.put("direccion", estudiante.getDireccion());
        valoresParaInsertar.put("estado", estudiante.getEstado());
        return baseDeDatos.insert("estudiante", null, valoresParaInsertar);

    }
}
