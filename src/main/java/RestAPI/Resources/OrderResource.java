package RestAPI.Resources;

import Entity.Orders;
import RestAPI.Request.CreateItemRequest;
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
@Path("/order")
public class OrderResource {

    @PersistenceContext
    EntityManager em;

    @GET
    @Path("/{ID}")
    public Response GetOrderByID(@PathParam("ID") Integer ID){
        return Response.ok(em.createNamedQuery("Orders.byTableID", Orders.class).setParameter(1, ID).getResultList()).build();
    }
    @GET
    @Path("/kitchen")
    public Response GetOrderToKitchen(){
        return Response.ok(em.createNamedQuery("Orders.ToKitchen", Orders.class).getResultList()).build();
    }

    @POST
    @Path("/neworder")
    public Response CreateNewOrder(@Valid CreateOrderRequest createOrderRequest){

        Orders order = new Orders(createOrderRequest);
        em.persist(order);
        return Response.ok(order).build();
    }

    @POST
    @Path("newOrders")
    public Response createNewOrders(@Valid List<CreateOrderRequest> orderRequestList) {
        List<Orders> orderList = new ArrayList<>();
        for(CreateOrderRequest orderRequest: orderRequestList) {
            Orders order = new Orders(orderRequest);
            orderList.add(order);

            em.persist(order);
        }

        return Response.ok(orderList).build();
    }
}
