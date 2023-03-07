package RestAPI.Resources;

import Entity.Orders;
import Entity.TodaysLunch;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
@Transactional(Transactional.TxType.REQUIRED)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/test")
public class Resource {

    @PersistenceContext
    EntityManager em;

    @GET
    @Produces("text/plain")
    public String hello() {
        return "Hello, World!";
    }


    @GET
    @Path("/week")
    public Response GetTodaysLunch(){

        return Response.ok(em.createNamedQuery("Lunch.today", TodaysLunch.class).getResultList()).build();
    }

    @GET
    @Path("/order")
    public Response GetOrder(){
        return Response.ok(em.createNamedQuery("Orders.all", Orders.class).getResultList()).build();
    }

}