
package edu.upc.dsa.services;


import edu.upc.dsa.Manager;
import edu.upc.dsa.ManagerImpl;
import edu.upc.dsa.models.Dron;
import edu.upc.dsa.models.Piloto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Api(value = "/pilots", description = "Endpoint to Pilot Service")
@Path("/pilots")
public class PilotsService {

    private Manager tm;

    public PilotsService() {
        this.tm = ManagerImpl.getInstance();
        if (tm.PilotListSize() == 0) {
            this.tm.AddPilot("1","Andrea","Zapata");
            this.tm.AddPilot("2","Quim","Lucchini");
            this.tm.AddPilot("3","Carla","Sabate");

        }
    }
    @GET
    @ApiOperation(value = "Lista pilotos descendiente segun horas vuelo", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Piloto.class, responseContainer="List"),
    })
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response ListaPilotos() {
        List<Piloto> pilotos = this.tm.OrdenaPilotos(this.tm.findAll_Piloto());
        GenericEntity<List<Piloto>> entity = new GenericEntity<List<Piloto>>(pilotos) {};
        return Response.status(201).entity(entity).build()  ;

    }



}

/*
    @GET
    @ApiOperation(value = "get all Track", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Dron.class, responseContainer="List"),
    })
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTracks() {

        List<Dron> drones = this.tm.findAll();

        GenericEntity<List<Dron>> entity = new GenericEntity<List<Dron>>(drones) {};
        return Response.status(201).entity(entity).build()  ;

    }

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



    @POST
    @ApiOperation(value = "create a new Dron", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response=Dron.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })

    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newTrack(Dron dron) {

        if (dron.getId()==null || dron.getNombre()==null)  return Response.status(500).entity(dron).build();
        this.tm.AddDrone(dron.getId(), dron.getNombre(), dron.getFabricante(), dron.getModelo(), dron.getHorasVuelo(), dron.getAlmacen(), dron.getEstado());
        return Response.status(201).entity(dron).build();
    }

}
*/