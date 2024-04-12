package edu.upc.dsa;

import edu.upc.dsa.models.Dron;
import edu.upc.dsa.models.Piloto;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Queue;

import edu.upc.dsa.models.PlanVuelo;
import org.apache.log4j.Logger;


public class ManagerImpl implements Manager {
    private static Manager instance;
    protected Queue<Dron> almacen;
    protected List<Dron> drones;
    protected List<Piloto> pilotos;
    private Map<Integer, Dron> drones_reserva;
    private Map<LocalDateTime, PlanVuelo> planes;
    private List<PlanVuelo> reservations;

    final static Logger logger = Logger.getLogger(ManagerImpl.class);

    private ManagerImpl() {
        this.drones = new LinkedList<>();
        this.pilotos = new LinkedList<>();
        this.almacen = new LinkedList<>();
        this.drones_reserva = new HashMap<>();
        this.planes = new HashMap<>();
        this.reservations = new ArrayList<>();
    }

    public static Manager getInstance() {
        if (instance == null) instance = new ManagerImpl();
        return instance;
    }

    public Dron AddDrone(Dron drone) {
        logger.info("new Drone " + drone);

        this.drones.add(drone);
        logger.info("new Drone added");
        return drone;
    }

    public void AddDrone(String id, String nombre, String fabricante, String modelo, int horas) {
        AddDrone(new Dron(id, nombre, fabricante, modelo, horas));
    }

    public Piloto AddPiloto(Piloto piloto) {
        logger.info("new Pilot " + piloto);

        this.pilotos.add(piloto);
        logger.info("new Pilot added");
        return piloto;
    }

    public void AddPiloto(String id, String nombre, String apellido, int horas) {
        AddPiloto(new Piloto(id, nombre, apellido, horas));
    }

    public void OrdenaHorasVuelo_Dron(List<Dron> drones) {
        Collections.sort(drones, new Comparator<Dron>() {
            public int compare(Dron d1, Dron d2) {
                return Integer.compare(d2.getHorasVuelo(), d1.getHorasVuelo());
            }
        });
    }


    public void OrdenaHorasVuelo_Piloto(List<Piloto> pilotos) {
        Collections.sort(pilotos, new Comparator<Piloto>() {
            public int compare(Piloto p1, Piloto p2) {
                return Integer.compare(p2.getHorasVuelo(), p1.getHorasVuelo());
            }
        });
    }

    public void GuardarDron(Dron drone, Queue<Dron> Almacen) {
        Almacen.add(drone);
    }


    public Dron SacarUltimoDron(Queue<Dron> Almacen) {
        Dron UltimoDron = Almacen.poll();
        return UltimoDron;
    }


    public void AñadirReserva(int DronId, LocalDateTime startTime, int duration, String startPosition,
                              String endPosition, String PilotId) {
        // Comprobar si el dron está operativo
        Dron drone = drones_reserva.get(DronId);
        if (drone == null || !drone.getOperativo()) {
            System.err.println("Error: El dron " + DronId + " no está operativo.");
            return;
        }

        LocalDateTime endTime = startTime.plusHours(duration);
        for (Map.Entry<LocalDateTime, PlanVuelo> entry : planes.entrySet()) {
            PlanVuelo flightPlan = entry.getValue();
            if (flightPlan.getPiloto() != null && flightPlan.getPiloto().getId().equals(PilotId)) {
                if (flightPlan.getStartTime().isAfter(startTime) && flightPlan.getStartTime().isBefore(endTime)) {
                    System.err.println("Error: El piloto " + PilotId + " ya tiene un plan de vuelo asignado dentro del intervalo.");
                    return;
                }

            }
            else
                if (flightPlan.getDron() != null && flightPlan.getDron().getId().equals(DronId)) {
                if (flightPlan.getStartTime().isAfter(startTime) && flightPlan.getStartTime().isBefore(endTime)) {
                    System.err.println("Error: El dron " + DronId + " ya tiene un plan de vuelo asignado dentro del intervalo.");
                    return;
                }
                else reservations.add(flightPlan);

            }
        }
    }

    public List<PlanVuelo> getReservationsForPilot(Piloto pilot){
        for (FlightPlanReservation reservation : allReservations) { // Assuming allReservations is a list of all reservations
            if (reservation.getPilot().equals(pilot)) {
                reservations.add(reservation);
            }
        }
        return reservations;

    }



}


/*

    public Track getTrack(String id) {
        logger.info("getTrack("+id+")");

        for (Track t: this.tracks) {
            if (t.getId().equals(id)) {
                logger.info("getTrack("+id+"): "+t);

                return t;
            }
        }

        logger.warn("not found " + id);
        return null;
    }

    public List<Track> findAll() {
        return this.tracks;
    }

    @Override
    public void deleteTrack(String id) {

        Track t = this.getTrack(id);
        if (t==null) {
            logger.warn("not found " + t);
        }
        else logger.info(t+" deleted ");

        this.tracks.remove(t);

    }

    @Override
    public Track updateTrack(Track p) {
        Track t = this.getTrack(p.getId());

        if (t!=null) {
            logger.info(p+" rebut!!!! ");

            t.setSinger(p.getSinger());
            t.setTitle(p.getTitle());

            logger.info(t+" updated ");
        }
        else {
            logger.warn("not found "+p);
        }

        return t;
    }
}
*/