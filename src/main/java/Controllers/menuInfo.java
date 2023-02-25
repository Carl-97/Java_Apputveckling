package Controllers;

import Entity.Items;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Named
@RequestScoped
@NamedQueries(
        @NamedQuery(name = "", query = "")
)
public class menuInfo {

    @PersistenceContext(name = "default")
    private EntityManager em;

    public String getName(){return "Menu";}
    public List<Items> getAllItems() {
        return em.createNamedQuery("allItems", Items.class).getResultList();
    }

    public List<Items> getItemByCategory(char category) {
        return em.createNamedQuery("Items.Category", Items.class).setParameter("itemCategory", category).getResultList();
    }
}
