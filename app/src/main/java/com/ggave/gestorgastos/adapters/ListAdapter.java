package com.ggave.gestorgastos.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ggave.gestorgastos.R;
import com.ggave.gestorgastos.models.Listado;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder>{

    private List<Listado> listas;

    public void setList(List<Listado> listas) {
        this.listas = listas;
    }

    public ListAdapter(){
        this.listas = new ArrayList<>();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView monto, titulo;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            monto = itemView.findViewById(R.id.total);
            titulo = itemView.findViewById(R.id.detalle_titulo);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_resultados, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Listado list = this.listas.get(i);
        String a = list.getFecha();
        String b = list.getTipo();
        viewHolder.titulo.setText(a + " - " + b);
        viewHolder.monto.setText("S/. "+list.getMonto());

    }

    @Override
    public int getItemCount() {
        return this.listas.size();
    }

}
