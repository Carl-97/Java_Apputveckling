package RestAPI.Resources;

import Entity.Items;
import Entity.Orders;
import RestAPI.Request.CreateOrderRequest;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
@Transactional(Transactional.TxType.REQUIRED)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/orders")
public class OrderResource {

    @PersistenceContext
    EntityManager em;

    @GET
    public Response getAllOrders() {
        return Response.ok(em.createNamedQuery("Orders.all", Orders.class).getResultList()).build();
    }

    @GET
    @Path("{ID}")
    public Response getOrderByID(@PathParam("ID") Integer ID){
        return Response.ok(em.createNamedQuery("Orders.byTableID", Orders.class).setParameter(1, ID).getResultList()).build();
    }

    @GET
    @Path("/kitchen")
    public Response getOrderToKitchen(){
        return Response.ok(em.createNamedQuery("Orders.ToKitchen", Orders.class).getResultList()).build();
    }

    @POST
    public Response createNewOrder(@Valid List<CreateOrderRequest> createOrderRequestList){
        List<Orders> responseList = new ArrayList<>();
        for(CreateOrderRequest orderRequest: createOrderRequestList) {
            Orders order = new Orders(orderRequest);
            em.persist(order);

            responseList.add(order);
        }

        return Response.ok(responseList).build();
    }
    @DELETE
    @Path("/{id}")
    public Response deleteItems(@PathParam("id") Integer ID){
        Orders orderToDelete = em.find(Orders.class, ID);
        if (orderToDelete == null){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        em.remove(orderToDelete);
        return Response.ok().build();
    }
}
