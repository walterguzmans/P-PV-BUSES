package com.example.p5_buses;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ListaUsuarios extends AppCompatActivity {
    private RecyclerView recyclerusuarios;
    AdaptadorUsuario usuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_usuarios);
        recyclerusuarios= findViewById(R.id.recycler);
        recyclerusuarios.setLayoutManager(new LinearLayoutManager(this));
        UsuariosBD bd= new UsuariosBD(this);

        usuario= new AdaptadorUsuario(bd.mostrarusuarios());
        recyclerusuarios.setAdapter(usuario);
    }
}