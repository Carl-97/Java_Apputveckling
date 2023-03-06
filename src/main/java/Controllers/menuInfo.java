package Controllers;

import Entity.Items;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;

@Named
@RequestScoped
@Transactional(Transactional.TxType.REQUIRED)
public class menuInfo {

    @PersistenceContext(name = "default")
    private EntityManager em;

    public String getName(){return "Menu";}
    public List<Items> getAllItems() {
        return em.createNamedQuery("Items.all", Items.class).getResultList();
    }

    public List<Items> getItemByCategory(String category) {
        return em.createNamedQuery("Items.category", Items.class).setParameter("itemcategory", category).getResultList();
    }

    public void createNewItem(String description, String itemcategory, String name, Integer price) {
        Items item = new Items(description, itemcategory, name, price);
        em.persist(item);
    }
}
