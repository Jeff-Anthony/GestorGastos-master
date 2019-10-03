package com.ggave.gestorgastos.activities;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.ggave.gestorgastos.R;
import com.ggave.gestorgastos.repositories.Repositorio;

public class MainActivity extends AppCompatActivity {


    FloatingActionButton addButton;
    Button buscar_ahorro_button, buscar_credito_button, buscar_efectivo_button;
    TextView acumulado_ahorro, acumulado_credito, acumulado_efectivo;
    ProgressBar progressBar;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        addButton = findViewById(R.id.floatingActionButton);
        buscar_ahorro_button = findViewById(R.id.button_ahorro);
        buscar_credito_button = findViewById(R.id.button_credito);
        buscar_efectivo_button = findViewById(R.id.button_efectivo);
        acumulado_ahorro = findViewById(R.id.acumulado_ahorro);
        acumulado_credito = findViewById(R.id.acumulado_credito);
        acumulado_efectivo = findViewById(R.id.acumulado_efectivo);
        progressBar = findViewById(R.id.progressbar);

        Double numero = Repositorio.total_global();
        Log.e("Monto Totallll","monto: "+numero);
        progressBar.setProgress((int)Math.round(numero));

        acumulado_ahorro.setText("S/."+ Repositorio.total("Ahorro"));
        acumulado_credito.setText("S/."+ Repositorio.total("Tarjeta de Crédito"));
        acumulado_efectivo.setText("S/."+ Repositorio.total("Efectivo"));

        buscar_ahorro_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent q = new Intent(getApplicationContext(), ListaActivity.class);
                q.putExtra("valor", "Ahorro");
                startActivity(q);
            }
        });


        buscar_credito_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent p = new Intent(getApplicationContext(), ListaActivity.class);
                p.putExtra("valor", "Tarjeta de Crédito");
                startActivity(p);
            }
        });


        buscar_efectivo_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent w = new Intent(getApplicationContext(), ListaActivity.class);
                w.putExtra("valor", "Efectivo");
                startActivity(w);

            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), RegistroActivity.class);
                startActivity(i);
                finish();
            }
        });

    }

}


