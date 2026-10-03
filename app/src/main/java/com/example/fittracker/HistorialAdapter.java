package com.example.fittracker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HistorialAdapter extends RecyclerView.Adapter<HistorialAdapter.ViewHolder> {

    ArrayList<HistorialModel> datos ;


    public static class  ViewHolder extends RecyclerView.ViewHolder
    {
        private final TextView id;
        private final TextView ejercicio ;
        private final TextView fecha ;

        public ViewHolder(View v)
        {
            super(v);
            id = v.findViewById(R.id.sesion_id);
            ejercicio = v.findViewById(R.id.ejercicio);
            fecha = v.findViewById(R.id.fecha);
        }

    }


    HistorialAdapter (ArrayList<HistorialModel> datos_sesiones )
    {
        datos = datos_sesiones ;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.sesiones_ejercicio, parent, false);
        ViewHolder viewHolder = new ViewHolder(vista);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int posicion_actual )
    {
        //obtener el objeto actual que se va a cargar en el ViewHolder
        HistorialModel historialActual = datos.get(posicion_actual);
        //cargar los datos del contacto al ViewHolder
        viewHolder.id.setText(historialActual.id);
        viewHolder.ejercicio.setText(historialActual.ejercicio);
        viewHolder.fecha.setText(historialActual.fecha);
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }
}






