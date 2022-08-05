package com.example.p5_buses;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdaptadorUsuario extends RecyclerView.Adapter<AdaptadorUsuario.ViewHolder>{

    public static class ViewHolder extends  RecyclerView.ViewHolder{
         private TextView cedula, nombreCompleto, telefono, email,rol;
          public ViewHolder(View itemView){
           super(itemView);
            cedula=(TextView) itemView.findViewById(R.id.tvCedula);
            nombreCompleto=(TextView) itemView.findViewById(R.id.tvnombre);
            telefono=(TextView) itemView.findViewById(R.id.tvtelefono);
            email=(TextView) itemView.findViewById(R.id.tvemail);
            rol=(TextView) itemView.findViewById(R.id.tvrol);
    }

}
         public List<DatosUsuarios> usuarios;

    public AdaptadorUsuario(List<DatosUsuarios>usuarios){
    this.usuarios=usuarios;
}


    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fila_usuario, parent, false);
        ViewHolder viewholder = new ViewHolder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.cedula.setText(String.valueOf(usuarios.get(position).getCedula()));
        holder.nombreCompleto.setText(usuarios.get(position).getNombreCompleto());
        holder.telefono.setText(String.valueOf(usuarios.get(position).getTelefono()));
        holder.email.setText(usuarios.get(position).getEmail());

        holder.rol.setText(usuarios.get(position).getRol());

    }

    @Override
    public int getItemCount() {
        return usuarios.size();
    }
}
