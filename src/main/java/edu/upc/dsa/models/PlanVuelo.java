package edu.upc.dsa.models;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import edu.upc.dsa.models.Dron;
import edu.upc.dsa.models.Piloto;
import edu.upc.dsa.util.RandomUtils;
import org.apache.commons.lang3.tuple.Pair;

public class PlanVuelo {
    private String DronId;
    private LocalDateTime Time;
    private int Duration;
    private Pair<Double, Double> posicionInicio;
    private Pair<Double, Double> posicionDestino;
    private double latitude_f;
    private double longitude_f;
    private Piloto piloto;

    public PlanVuelo(String id,LocalDateTime Time, int Duration,Pair<Double, Double> posicionInicio, Pair<Double, Double> posicionDestino,Piloto piloto) {
        this.DronId = id;
        this.Time = Time;
        this.Duration = Duration;
        this.posicionInicio = posicionInicio;
        this.posicionDestino = posicionDestino;
        this.piloto=piloto;
    }


    public boolean Coincidir(PlanVuelo other) {
        // check if the dron or the piloto already have a plan assigned in the same time interval
        if (this.DronId.equals(other.getDronId()) && this.Time.isAfter(other.Time) && this.Time.isBefore(other.Time.plusHours(other.Duration))) {
            return true;
        }
        if (this.piloto.getId().equals(other.piloto.getId()) && this.Time.isAfter(other.Time) && this.Time.isBefore(other.Time.plusHours(other.Duration))) {
            return true;
        }
        return false;
    }






    public Piloto getPiloto() {
        return piloto;
    }
    public String getDronId() { return this.DronId; }
    public LocalDateTime getTime() { return this.Time; }
    public int getDuration() { return this.Duration; }
    public double getLatitude_f() { return this.latitude_f; }
    public double getLongitude_f() { return this.longitude_f; }


    public void setDronId(String DronId) { this.DronId = DronId; }
    public void setTime(LocalDateTime Time) { this.Time = Time; }
    public void setDuration(int Duration) { this.Duration = Duration; }
    public void setLatitude_f(double latitude_f) { this.latitude_f = latitude_f; }
    public void setLongitude_f(double longitude_f) { this.longitude_f = longitude_f; }
    public void setPiloto(Piloto p) {
        this.piloto = p;
    }

}








