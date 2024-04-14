package edu.upc.dsa;

import edu.upc.dsa.models.Dron;
import edu.upc.dsa.models.Piloto;

import java.time.LocalDateTime;
import java.util.*;

import edu.upc.dsa.models.PlanVuelo;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.log4j.Logger;


public class ManagerImpl implements Manager {
    private static Manager instance;
    protected Stack<Dron> almacen;
    protected List<Dron> drones;
    protected List<Piloto> pilotos;
    protected PlanVuelo planVuelo;
    protected List<PlanVuelo> planVuelos;
    private Map<String, Dron> drones_reserva;
    private Map<String, Piloto> pilotos_reserva;


    final static Logger logger = Logger.getLogger(ManagerImpl.class);

    private ManagerImpl() {
        this.drones = new LinkedList<>();
        this.pilotos = new LinkedList<>();
        this.almacen = new Stack<>();
    }

    public int DroneListSize() {
        int ret = this.drones.size();
        logger.info("size " + ret);

        return ret;
    }
    public int PilotListSize() {
        int ret = this.pilotos.size();
        logger.info("size " + ret);

        return ret;
    }
    public static Manager getInstance() {
        if (instance == null) instance = new ManagerImpl();
        return instance;
    }


    // -1- AÑADIR UN NUEVO DRON
    public Dron AddDrone(Dron dron) {
        logger.info("New Dron " + dron);
        this.drones.add(dron);
        logger.info("new Pilot added");
        return dron;
    }
    public Dron AddDrone(String id, String nombre, String fabricante, String modelo) {
        return this.AddDrone(new Dron(id,nombre,fabricante,modelo,0,0,0));
    }


    public Dron getDrone(String id) {
        logger.info("getDrone("+id+")");

        for (Dron t: this.drones) {
            if (t.getId().equals(id)) {
                logger.info("getDrone("+id+"): "+t);

                return t;
            }
        }

        logger.warn("not found " + id);
        return null;
    }
    public List<Dron> findAll_Dron() {
        return this.drones;
    }



    // -2- AÑADIR UN NUEVO PILOTO
   public Piloto AddPilot(Piloto piloto) {
        logger.info("Nuevo Piloto " + piloto);
        this.pilotos.add(piloto);
        logger.info("Nuevo Piloto añadido");
        return piloto;
    }
    public Piloto AddPilot(String id, String nombre, String apellido) {
        return this.AddPilot(new Piloto(id,nombre,apellido,0,0));
    }


    public Piloto getPilot(String id) {
        logger.info("getPilot("+id+")");

        for (Piloto t: this.pilotos) {
            if (t.getId().equals(id)) {
                logger.info("getPilot("+id+"): "+t);

                return t;
            }
        }

        logger.warn("not found " + id);
        return null;
    }
    public List<Piloto> findAll_Piloto() {
        return this.pilotos;
    }



    // -3- LISTA DESCENDENTE DRONES POR HORAS DE VUELO
    public List<Dron> OrdenaDrones(List<Dron> drones){
        Collections.sort(drones, new Comparator<Dron>() {
            public int compare(Dron d1, Dron d2) {
                return Integer.compare(d2.getHorasVuelo(), d1.getHorasVuelo());
            }
        });
        return drones;
    }


    // -4- LISTA DESCENDENTE PILOTOS POR HORAS DE VUELO
    public List<Piloto> OrdenaPilotos(List<Piloto> pilotos){
        Collections.sort(pilotos, new Comparator<Piloto>() {
            public int compare(Piloto d1, Piloto d2) {
                return Integer.compare(d2.getHorasVuelo(), d1.getHorasVuelo());
            }
        });
        return pilotos;
    }

    // -5- GUARDAR DRON EN ALMACEN
    public Stack<Dron> GuardarDronEnAlmacen(Dron dron){
        this.almacen.push(dron);
        return almacen;
    }


    // -6- SACAR DRON PARA REPARAR
    public Dron PopDronAlmacen(){
        return almacen.pop();
    }


    //-7- PLAN DE VUELO
    public PlanVuelo AddReserva(PlanVuelo plan){
        this.planVuelo = plan;
        return planVuelo;
    }
    public PlanVuelo AddReserva(String id,LocalDateTime Time, int Duration,Pair<Double, Double> posicionInicio, Pair<Double, Double> posicionDestino,Piloto p){
        Dron dron = drones_reserva.get(id);
        Piloto piloto = p;

        if (dron == null) {
            throw new RuntimeException("No se encuentra el dron con identificador " + id);
        }

        if (dron.getEstado() == 0) {
            throw new RuntimeException("El dron con identificador " + id + " no está operativo");
        }

        if (piloto == null) {
            throw new RuntimeException("No se encuentra el piloto con identificador " + piloto.getId());
        }

        PlanVuelo newPlanVuelo = new PlanVuelo(id, Time, Duration, posicionInicio, posicionDestino, p);
        for (PlanVuelo planVuelo : planVuelos) {
            if (newPlanVuelo.Coincidir(planVuelo)) {
                throw new RuntimeException("Ya existe un plan de vuelo asignado al dron o al piloto en el mismo intervalo de tiempo");
            }
        }

        planVuelos.add(newPlanVuelo);
        return this.AddReserva(new PlanVuelo(id,  Time,  Duration, posicionInicio,posicionDestino ,  piloto));
    }



    // -8- LISTADO PLANES DE VUELO PILOTO
    public List<PlanVuelo> PlanVueloPiloto(String pilotId) {
        List<PlanVuelo> flightPlans = new ArrayList<>();
        for (PlanVuelo plan : planVuelos) {
            if (plan.getPiloto().getId().equals(pilotId)) {
                flightPlans.add(plan);
            }
            else {
                throw new RuntimeException ("No se encuentran planes de vuelo con este ID de piloto");
            }
        }
        return flightPlans;
    }


    // -9- LISTADO PLANES DE VUELO DRON
    public List<PlanVuelo> PlanVueloDron(String dronId) {
        List<PlanVuelo> flightPlans = new ArrayList<>();
        for (PlanVuelo plan : planVuelos) { // assuming flightPlansList is your list of flight plans
            if (plan.getDronId().equals(dronId)) {
                flightPlans.add(plan);
            }
        }
        return flightPlans;
    }


}
