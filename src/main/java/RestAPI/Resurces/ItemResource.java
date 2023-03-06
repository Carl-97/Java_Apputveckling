package RestAPI.Resurces;

import Entity.Items;
import Entity.Orders;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;

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

    @POST
    @Path("/newItem")
    public Response CreateNewItem(@Context UriInfo uriInfo, @Valid Items item){
        System.out.println(uriInfo);
        System.out.println(item);
        return Response.ok(item).build();
    }
}
