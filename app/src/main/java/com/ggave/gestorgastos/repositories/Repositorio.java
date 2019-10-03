package com.ggave.gestorgastos.repositories;

import com.ggave.gestorgastos.models.Listado;

import java.util.ArrayList;
import java.util.List;

public class Repositorio{

    private static List<Listado> operation;
    static{
        operation = new ArrayList<>();
        operation.add(new Listado("02/05/2019","Egresos", "100", "Tarjeta de Crédito"));
        operation.add(new Listado("18/03/2019","Ingresos", "100", "Ahorro"));
        operation.add(new Listado("28/09/2019","Ingresos", "300", "Efectivo"));
        operation.add(new Listado("01/07/2019","Ingresos", "200", "Tarjeta de Crédito"));
    }

    public static List<Listado> getRepositorio(String saldo) {
        List<Listado> temp = new ArrayList<>();
        for(int m = 0; m < operation.size(); m++){
            if(operation.get(m).getSaldo().equals(saldo)){
                temp.add(operation.get(m));
            }
        }
        return temp;
    }



    public static void agregar(String fecha, String tipo, String monto, String saldo){
        operation.add(new Listado(fecha, tipo, monto, saldo));
    }

    public static double total(String saldo){
        double total = 0;
        double total_ingresos = 0;
        double total_egresos = 0;
        for(int m = 0; m < operation.size(); m++){
            if(operation.get(m).getSaldo().equals(saldo)){
                if (operation.get(m).getTipo().equals("Ingresos")){
                    double numero1 = Double.parseDouble(operation.get(m).getMonto());
                    total_ingresos = total_ingresos + numero1;
                }else{
                    double numero2 = Double.parseDouble(operation.get(m).getMonto());
                    total_egresos = total_egresos + numero2;
                }
            }
        }
        total = total_ingresos - total_egresos;
        return total;
    }

    public static double total_global(){
        double sumatoria_egresos = 0;
        double sumatoria_ingresos = 0;
        double sumatoria = 0;
        for(int m = 0; m < operation.size(); m++){
            if(operation.get(m).getTipo().equals("Ingresos")){
                double numero1 = Double.parseDouble(operation.get(m).getMonto());
                sumatoria_ingresos = sumatoria_ingresos + numero1;
            }else{
                double numero2 = Double.parseDouble(operation.get(m).getMonto());
                sumatoria_egresos = sumatoria_egresos + numero2;
            }
        }
        sumatoria = (sumatoria_ingresos/(sumatoria_egresos+sumatoria_ingresos))*100;
        return sumatoria;
    }
}