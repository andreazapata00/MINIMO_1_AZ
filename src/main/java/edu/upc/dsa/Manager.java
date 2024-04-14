package edu.upc.dsa;

import edu.upc.dsa.models.Dron;
import edu.upc.dsa.models.Piloto;
import edu.upc.dsa.models.PlanVuelo;
import org.apache.commons.lang3.tuple.Pair;

import java.time.LocalDateTime;
import java.util.*;

public interface Manager {


    public int DroneListSize();
    public int PilotListSize();

    // -1- AÑADIR UN NUEVO DRON
    public Dron AddDrone(String id, String nombre, String fabricante, String modelo);
    public Dron AddDrone(Dron dron);

    public Dron getDrone(String id);
    public List<Dron> findAll_Dron();


    // -2- AÑADIR UN NUEVO PILOTO
    public Piloto AddPilot(Piloto piloto);
    public Piloto AddPilot(String id, String nombre, String apellido);

    public Piloto getPilot(String id);
    public List<Piloto> findAll_Piloto();


    // -3- LISTA DESCENDENTE DRONES POR HORAS DE VUELO
    public List<Dron> OrdenaDrones(List<Dron> drones);


    // -4- LISTA DESCENDENTE PILOTOS POR HORAS DE VUELO
    public List<Piloto> OrdenaPilotos(List<Piloto> pilotos);


    // -5- GUARDAR DRON EN ALMACEN
    public Stack<Dron> GuardarDronEnAlmacen(Dron dron);


    // -6- SACAR DRON PARA REPARAR
    public Dron PopDronAlmacen();


    // -7- AÑADIR UNA RESERVA A PLAN DE VUELO
    public PlanVuelo AddReserva(String id, LocalDateTime Time, int Duration, Pair<Double, Double> posicionInicio, Pair<Double, Double> posicionDestino, Piloto piloto);
    public PlanVuelo AddReserva(PlanVuelo plan);


    // -8- LISTADO PLANES DE VUELO PILOTO
    public List<PlanVuelo> PlanVueloPiloto(String pilotId);


    // -9- LISTADO PLANES DE VUELO DRON
    public List<PlanVuelo> PlanVueloDron(String dronId);



}









/*
    public void OrdenaHorasVuelo_Dron(List<Dron> drones);

    public void OrdenaHorasVuelo_Piloto(List<Piloto> pilotos);

    public void GuardarDron(Dron drone, Queue<Dron> almacen);

    public Dron SacarUltimoDron(Queue<Dron> Almacen);

    public void AñadirReserva(int DronId, LocalDateTime startTime, int duration, String startPosition,
                              String endPosition, String PilotId);

    public List<PlanVuelo> getReservationsForPilot(Piloto pilot);


    public Track addTrack(Track t);
    public Track getTrack(String id);
    public List<Track> findAll();
    public void deleteTrack(String id);
    public Track updateTrack(Track t);

    public int size();
}
*/