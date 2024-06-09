package com.reylulu.webapp.resources;

import com.reylulu.webapp.entidades.Materia;
import com.reylulu.webapp.negocio.DataService;
import jakarta.ejb.EJB;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
/**
 *
 * @author miran
 */
//CONSTRUCCION DE API REST PARA LAS PRUEBAS DEL CRUD MATERIA
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/materia")
public class RecursoMateria {
    @EJB DataService servicio;
    
    @GET
    public Response getMaterias(){
        List <Materia> materias = servicio.getMaterias();
        return Response.ok(materias).build();
    }
    //GUARDAR ALUMNO
    @POST
    public Response saveMateria(Materia materia){
        servicio.saveMateria(materia);
        return Response.ok("Materia creada").build();
    }
    //EDITAR ALUMNO
    @PUT
    public Response editMateria(Materia materia){
        servicio.editMateria(materia);
        return Response.ok("Materia editada").build();
    }
    //ELIMINAR ALUMNO
    @DELETE
    @Path("/{id}")
    public Response deleteMateria(@PathParam("id") Integer id){
        servicio.deleteMateria(new Materia(id));
        return Response.ok("Materia eliminada").build();
    }
}
