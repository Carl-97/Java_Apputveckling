package RestAPI.Resources;

import Entity.TodaysLunch;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Named
@ApplicationScoped
@Transactional(Transactional.TxType.REQUIRED)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/lunch")
public class LunchResource {

    @PersistenceContext
    EntityManager em;

    @GET
    @Path("/week")
    public Response getWeeksLunch() {
        return Response.ok(em.createNamedQuery("Lunch.all", TodaysLunch.class).getResultList()).build();
    }

    @GET
    @Path("/today")
    public List<TodaysLunch> getTodaysLunch() {
        return em.createNamedQuery("Lunch.today", TodaysLunch.class).getResultList();
    }

}
