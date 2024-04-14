package edu.upc.dsa.models;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import edu.upc.dsa.util.RandomUtils;
import edu.upc.dsa.models.PlanVuelo;

public class Piloto {
    private String Identificador;
    private String Nombre;
    private String Apellido;
    private int HorasVuelo;
    private int Disponible; //si:1 no:0


    public Piloto(String id, String nombre, String apellido, int horasDeVuelo, int dispo) {
        this.Identificador = id;
        this.Nombre = nombre;
        this.Apellido = apellido;
        this.HorasVuelo = horasDeVuelo;
        this.Disponible = dispo;
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

    public int getDisponible() {
        return Disponible;
    }
    public void setDisponible(int d) {
        this.Disponible = d;
    }



}
