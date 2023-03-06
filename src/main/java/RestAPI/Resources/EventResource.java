package RestAPI.Resources;

import Entity.Event;
import Entity.Items;
import RestAPI.Request.CreateItemRequest;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.sql.Date;

@ApplicationScoped
@Transactional(Transactional.TxType.REQUIRED)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/Events")
public class EventResource {
    @PersistenceContext
    EntityManager em;

    @GET
    public Response GetAllEvents() {
        return Response.ok(em.createNamedQuery("Items.all", Items.class).getResultList()).build();
    }

    @GET
    @Path("/event")
    public Response GetEventById(@QueryParam("ID") int Id) {
        return Response.ok(em.createNamedQuery("Event.ByID", Event.class).setParameter("itemCategory", category).getResultList()).build();
    }

    @GET
    @Path("/event")
    public Response GetEventByDate(@QueryParam("date")Date date) {
        return Response.ok(em.createNamedQuery("Event.ByDate", Event.class).setParameter("itemCategory", category).getResultList()).build();
    }

    @POST
    @Path("post/item")
    public Response CreateItem(@Valid CreateItemRequest itemRequest) {
        Items items = new Items(itemRequest);
        em.persist(items);
        return Response.ok(itemRequest).build();
    }
}
