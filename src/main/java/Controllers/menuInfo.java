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

    private String description;
    private String itemCategory;
    private String name;
    private Integer price;
    @PersistenceContext(name = "default")
    private EntityManager em;


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(String itemCategory) {
        this.itemCategory = itemCategory;
    }

    public String getName(){return "Menu";}

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void submit() {
        Items item = new Items(description, itemCategory, name, price);
        em.persist(item);
    }

    public void update(int id) {
        Items item = em.find(Items.class, id);
        item.setDescription(description);
        item.setItemcategory(itemCategory);
        item.setName(name);
        item.setPrice(price);
    }

    public void delete(int id) {
        Items item = em.find(Items.class, id);
        em.remove(item);
    }

    public void testDelete() {
        Items item = em.find(Items.class, 1);
        em.remove(item);
    }
    public List<Items> getAllItems() {
        return em.createNamedQuery("Items.all", Items.class).getResultList();
    }

    public List<Items> getItemByCategory(String category) {
        return em.createNamedQuery("Items.category", Items.class).setParameter("itemcategory", category).getResultList();
    }
}
