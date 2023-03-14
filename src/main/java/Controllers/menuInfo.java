package Controllers;

import Entity.Items;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;

@Named
@RequestScoped
@Transactional(Transactional.TxType.REQUIRED)
public class MenuInfo {
    private String description;
    private String itemCategory;
    private String name;
    private Integer price;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getName(){return name;}

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void insert() {
        Items item = new Items(description, itemCategory, name, price);
        em.persist(item);
    }

    public void delete() {
        Items item = em.find(Items.class, id);
        if(item != null) {
            em.remove(item);
        }
    }

    public void update() {
        Items item = em.find(Items.class, id);
        item.setDescription(description);
        item.setItemCategory(itemCategory);
        item.setName(name);
        item.setPrice(price);
    }

    public List<Items> getAllItems() {
        return em.createNamedQuery("Items.all", Items.class).getResultList();
    }

    public List<Items> getItemByCategory(String category) {
        return em.createNamedQuery("Items.category", Items.class).setParameter("itemCategory", category).getResultList();
    }
}