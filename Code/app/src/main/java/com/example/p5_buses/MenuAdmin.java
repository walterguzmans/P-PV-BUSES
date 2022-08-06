package com.example.p5_buses;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuAdmin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_admin);
    }
    public void irMantenimientoUsuarios(View view) {
        Intent intent = new Intent(MenuAdmin.this, CrudUsuarios.class);
        startActivity(intent);
    }
}