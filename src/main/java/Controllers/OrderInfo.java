package Controllers;

import Entity.Orders;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;

@Named
@RequestScoped
@Transactional(Transactional.TxType.REQUIRED)
public class OrderInfo {

    @PersistenceContext(name = "default")
    private EntityManager em;

    public String getName() {
        return "Orders.Info";
    }
    public List<Orders> getAll() {
        return em.createNamedQuery("Orders.all", Orders.class).getResultList();
    }

    public List<Orders> getOrderItems() {
        return em.createNamedQuery("Orders.byTableID", Orders.class).setParameter(1,5).getResultList();
    }
}
