package edu.upc.dsa.models;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import edu.upc.dsa.models.Dron;
import edu.upc.dsa.models.Piloto;
import edu.upc.dsa.util.RandomUtils;

public class PlanVuelo {
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String startPosition;
    private String endPosition;
    private Piloto piloto;
    private Dron dron;

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime time) {
        this.startTime = time;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime time) {
        this.endTime = time;
    }

    public String getStartPosition() {
        return startPosition;
    }

    public void setStartPosition(String pos) {
        this.startPosition = pos;
    }

    public String getEndPosition() {
        return endPosition;
    }

    public void setEndPosition(String pos) {
        this.endPosition = pos;
    }

    public Piloto getPiloto() {
        return piloto;
    }

    public void setPiloto(Piloto p) {
        this.piloto = p;
    }

    public Dron getDron() {
        return dron;
    }

    public void setDron(Dron d) {
        this.dron = d;
    }
}









