package edu.upc.dsa.models;

import edu.upc.dsa.util.RandomUtils;

public class Dron {
    private String Identificador;
    private String Nombre;
    private String Fabricante;
    private String Modelo;
    private int HorasVuelo;
    private int Estado; //Si está operativo:1 o no:0
    private int Almacen; //Si está en almacen:1 o no:0


    public Dron(String id, String nombre, String fabricante, String modelo, int h_vuelo, int almacen, int estado) {
        this.Identificador = id;
        this.Nombre = nombre;
        this.Fabricante = fabricante;
        this.Modelo = modelo;
        this.HorasVuelo = h_vuelo;
        this.Almacen = almacen;
        this.Estado = estado;
    }

    public String getId() {
        return Identificador;
    }
    public void setId(String id) {this.Identificador = id; }

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

    public int getEstado() {
        return Estado;
    }
    public void setEstado(int e) {
        this.Estado = e;
    }

    public int getAlmacen() {
        return Almacen;
    }
    public void setAlmacen(int a) {
        this.Almacen= a;
    }



}

