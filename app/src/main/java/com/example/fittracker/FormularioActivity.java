package com.example.fittracker;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class FormularioActivity extends AppCompatActivity {
    Spinner spinner_entrenamiento;
    Button button_salir;
    Button button_historial;
    ArrayList<String> ejercicios = new ArrayList<String>()  ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_formulario);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        button_salir = findViewById(R.id.button_salir);
        button_salir.setOnClickListener( v ->
                startActivity( new Intent(FormularioActivity.this, MainActivity.class) )
        );

        button_historial = findViewById(R.id.button_his);
        button_historial.setOnClickListener( v ->
                startActivity( new Intent(FormularioActivity.this, HistorialActivity.class) )
        );


        spinner_entrenamiento = findViewById(R.id.spinner_entrenamiento);
        ejercicios.add("Fuerza");
        ejercicios.add("Cardio");
        ejercicios.add("Yoga");
        ejercicios.add("Calistemia");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, ejercicios );
        spinner_entrenamiento.setAdapter(adapter);
    }
}