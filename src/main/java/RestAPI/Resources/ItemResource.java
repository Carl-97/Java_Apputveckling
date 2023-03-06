package RestAPI.Resources;

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

@ApplicationScoped
@Transactional(Transactional.TxType.REQUIRED)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/items")
public class ItemResource {

    @PersistenceContext
    EntityManager em;

    @GET
    public Response getAllItems() {
        return Response.ok(em.createNamedQuery("Items.all", Items.class).getResultList()).build();
    }

    @GET
    @Path("/{category}")
    public Response getItemByCat(@PathParam("category") String category) {
        return Response.ok(em.createNamedQuery("Items.category", Items.class).setParameter("itemCategory", category).getResultList()).build();
    }

    @POST
    public Response createItem(@Valid CreateItemRequest itemRequest) {
/*        if (em.find(Items.class, itemRequest.getName()) != null){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }*/
        Items items = new Items(itemRequest);
        em.persist(items);
        return Response.ok(itemRequest).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteItems(@PathParam("id") Integer ID){
        Items itemToDelete = em.find(Items.class, ID);
        if (itemToDelete == null){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        em.remove(itemToDelete);
        return Response.ok().build();
    }
}
