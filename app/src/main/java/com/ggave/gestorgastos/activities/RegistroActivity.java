package com.ggave.gestorgastos.activities;

import android.content.Intent;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.ggave.gestorgastos.R;
import com.ggave.gestorgastos.repositories.Repositorio;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.zip.DataFormatException;

public class RegistroActivity extends AppCompatActivity {

    Spinner spinner;
    Button registrar;
    RadioButton r1;
    RadioButton r2;
    EditText monto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        spinner = findViewById(R.id.spinner);
        registrar = findViewById(R.id.Registro);
        r1 = findViewById(R.id.radio_ingresos);
        r2 = findViewById(R.id.radio_egresos);
        monto = findViewById(R.id.monto1);

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add();
            }
        });

    }

    private void add(){
        String saldo = spinner.getSelectedItem().toString();
        String cantidad = monto.getText().toString();
        String tipo;
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String date = df.format(Calendar.getInstance().getTime());

        if(r1.isChecked()){
            tipo = "Ingresos";
        }else{
            tipo = "Egresos";
        }
        Intent e = new Intent(getApplicationContext(),MainActivity.class);
        Repositorio.agregar(date, tipo, cantidad, saldo);
        startActivity(e);
        finish();
    }

}
