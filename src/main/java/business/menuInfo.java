package business;

import Entity.Items;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Named
@RequestScoped
public class menuInfo {

    @PersistenceContext(name = "default")
    private EntityManager em;

    public String getName(){return "Menu";}
    public List<Items> getAllItems() {
        return em.createNamedQuery("allItems", Items.class).getResultList();
    }
}
