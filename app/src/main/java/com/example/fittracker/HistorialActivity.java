package com.example.fittracker;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HistorialActivity extends AppCompatActivity {
    RecyclerView recycler ;
    ArrayList<HistorialModel> datos_sesiones = new ArrayList<>();;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_historial);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        recycler = findViewById(R.id.recycler);


        datos_sesiones.add(new HistorialModel("S-01", "Saltar la Cuerda", "12-02-2026"));
        datos_sesiones.add(new HistorialModel("S-03", "Correr", "20-02-2026"));
        datos_sesiones.add(new HistorialModel("S-04", "Press Banca", "01-03-2026"));

        //crear el adapter
        HistorialAdapter adapter = new HistorialAdapter(datos_sesiones);
        //Layout Manager
        recycler.setLayoutManager(new LinearLayoutManager(this));
        //cargar el adapter a el recycler view
        recycler.setAdapter(adapter);
    }
}