package RestAPI.Resurces;

import Entity.Items;
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
@Path("/item")
public class ItemResource {

    @PersistenceContext
    EntityManager em;

    @GET
    public Response GetAllItems(){
        return Response.ok(em.createNamedQuery("Items.all", Items.class).getResultList()).build();
    }

    @GET
    @Path("/{category}")
    public Response GetItemByCat(@PathParam("category") String category){
        return Response.ok(em.createNamedQuery("Items.category", Items.class).setParameter("itemcategory", category).getResultList()).build();
    }
}
