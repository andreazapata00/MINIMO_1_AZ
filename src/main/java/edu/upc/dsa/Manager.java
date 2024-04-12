package edu.upc.dsa;

import edu.upc.dsa.models.Dron;
import edu.upc.dsa.models.Piloto;
import edu.upc.dsa.models.PlanVuelo;
import java.util.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

public interface Manager {


    public void AddDrone(String id, String nombre, String fabricante, String modelo, int horas);

    public void AddPiloto(String id, String nombre, String apellido, int horas);

    public void OrdenaHorasVuelo_Dron(List<Dron> drones);

    public void OrdenaHorasVuelo_Piloto(List<Piloto> pilotos);

    public void GuardarDron(Dron drone, Queue<Dron> almacen);

    public Dron SacarUltimoDron(Queue<Dron> Almacen);

    public void AñadirReserva(int DronId, LocalDateTime startTime, int duration, String startPosition,
                              String endPosition, String PilotId);

    public List<PlanVuelo> getReservationsForPilot(Piloto pilot);
}
/*
    public Track addTrack(Track t);
    public Track getTrack(String id);
    public List<Track> findAll();
    public void deleteTrack(String id);
    public Track updateTrack(Track t);

    public int size();
}
*/