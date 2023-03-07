package RestAPI.Resources;

import Entity.Dinnertable;
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
@Path("/table")
public class DinnertableResource {

    @PersistenceContext
    EntityManager em;

    @GET
    public Response getAllTables(){
        return Response.ok(em.createNamedQuery("Dinnertable.all", Dinnertable.class).getResultList()).build();
    }

}
