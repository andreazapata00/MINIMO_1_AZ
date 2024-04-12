package edu.upc.dsa.models;

import edu.upc.dsa.util.RandomUtils;

import java.util.LinkedList;
import java.util.Queue;

public class Dron {
    private String Identificador;
    private String Nombre;
    private String Fabricante;
    private String Modelo;
    private int HorasVuelo;
    private boolean Operativo;
    private PlanVuelo flightPlan;


    public Dron() {
        this.Identificador = RandomUtils.getId();
    }

    public Dron(String id, String nombre, String fabricante, String modelo, int h_vuelo) {
        this();
        this.setId(id);
        this.setNombre(nombre);
        this.setFabricante(fabricante);
        this.setModelo(modelo);
        this.setHorasVuelo(h_vuelo);
    }

    public String getId() {
        return Identificador;
    }
    public void setId(String id) {this.Identificador=id;}

    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }

    public String getFabricante() {
        return Fabricante;
    }
    public void setFabricante(String fabricante) {
        this.Fabricante = fabricante;
    }

    public String getModelo() {
        return Modelo;
    }
    public void setModelo(String modelo) {
        this.Modelo = modelo;
    }

    public int getHorasVuelo() {
        return HorasVuelo;
    }
    public void setHorasVuelo(int horas_vuelo) {
        this.HorasVuelo = horas_vuelo;
    }

    public PlanVuelo getPlanVuelo() {
        return flightPlan;
    }
    public void setPlanVuelo(PlanVuelo flight) {
        this.flightPlan = flight;
    }

    public boolean getOperativo() {
        return Operativo;
    }
    public void setOperativo(Boolean op) { this.Operativo = op;
    }
}
