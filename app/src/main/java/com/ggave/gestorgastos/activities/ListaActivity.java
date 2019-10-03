package com.ggave.gestorgastos.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.ggave.gestorgastos.R;
import com.ggave.gestorgastos.adapters.ListAdapter;
import com.ggave.gestorgastos.repositories.Repositorio;

public class ListaActivity extends AppCompatActivity {


    TextView monto, detail;

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        detail = findViewById(R.id.detalle_titulo);
        monto = findViewById(R.id.total);

        recyclerView = findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        String valor = getIntent().getExtras().getString("valor");
        ListAdapter adapter = new ListAdapter();
        adapter.setList(Repositorio.getRepositorio(valor));
        monto.setText(String.valueOf(Repositorio.total(valor)));
        detail.setText("Saldo Actual "+valor);
        recyclerView.setAdapter(adapter);

    }
}