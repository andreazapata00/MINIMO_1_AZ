
package edu.upc.dsa.services;


import edu.upc.dsa.Manager;
import edu.upc.dsa.ManagerImpl;
import edu.upc.dsa.models.Dron;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;



@Api(value = "/drones", description = "Endpoint to Drone Service")
@Path("/drones")
public class DronesService {

    private Manager tm;

    public DronesService() {
        this.tm = ManagerImpl.getInstance();
        if (tm.DroneListSize() == 0) {
            this.tm.AddDrone("1","Dron1","Airbus","A320");
            this.tm.AddDrone("2","Dron2","Boeing","B737");
            this.tm.AddDrone("3","Dron3","Airbus","A380");
        }
    }


    @GET
    @ApiOperation(value = "Lista drones descendiente segun horas vuelo", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Dron.class, responseContainer="List"),
    })
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response ListaDrones() {
        List<Dron> drones = this.tm.OrdenaDrones(this.tm.findAll_Dron());
        GenericEntity<List<Dron>> entity = new GenericEntity<>(drones) {};
        return Response.status(201).entity(entity).build()  ;

    }







}

/*
    @GET
    @ApiOperation(value = "get a Track", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Dron.class),
            @ApiResponse(code = 404, message = "Track not found")
    })
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTrack(@PathParam("id") String id) {
        Dron d = this.tm.getDron(id);
        if (d == null) return Response.status(404).build();
        else  return Response.status(201).entity(d).build();
    }

    @DELETE
    @ApiOperation(value = "delete a Track", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Track not found")
    })
    @Path("/{id}")
    public Response deleteTrack(@PathParam("id") String id) {
        Dron t = this.tm.getDron(id);
        if (t == null) return Response.status(404).build();
        else this.tm.deleteDron(id);
        return Response.status(201).build();
    }

    @PUT
    @ApiOperation(value = "update a Track", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Track not found")
    })
    @Path("/")
    public Response updateTrack(Dron dron) {

        Dron t = this.tm.updateDron(dron);

        if (t == null) return Response.status(404).build();

        return Response.status(201).build();
    }

}
*/