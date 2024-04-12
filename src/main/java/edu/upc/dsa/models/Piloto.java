package edu.upc.dsa.models;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import edu.upc.dsa.util.RandomUtils;
import edu.upc.dsa.models.PlanVuelo;

public class Piloto {
    private String Identificador;
    private String Nombre;
    private String Apellido;
    private int HorasVuelo;
    private PlanVuelo plan;


    public Piloto() {
        this.Identificador = RandomUtils.getId();
    }

    public Piloto(String id, String nombre, String apellido, int h_vuelo) {
        this();
        this.setId(id);
        this.setNombre(nombre);
        this.setApellido(apellido);
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

    public String getApellido() {
        return Apellido;
    }
    public void setApellido(String apellido) {
        this.Apellido = apellido;
    }

    public int getHorasVuelo() {
        return HorasVuelo;
    }
    public void setHorasVuelo(int horas_vuelo) {
        this.HorasVuelo = horas_vuelo;
    }

    public PlanVuelo getPlanVuelo() {
        return plan;
    }
    public void setPlanVuelo(PlanVuelo flight) {
        this.plan = flight;
    }

    @Override
    public String toString() {
        return "Piloto [Identificador="+Identificador+", Nombre=" + Nombre + ", Apellido=" + Apellido + ", Horas Vuelo=" + HorasVuelo +"]";
    }

}