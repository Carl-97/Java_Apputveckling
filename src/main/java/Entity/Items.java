package Entity;

import RestAPI.Request.CreateItemRequest;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "Items.all", query = "SELECT e FROM Items e"),
        @NamedQuery(name = "Items.category", query = "SELECT e FROM Items e WHERE e.itemCategory = :itemCategory")
})
public class Items {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ITEM_ID")
    private int itemId;
    @Basic
    @Column(name = "DESCRIPTION")
    private String description;
    @Basic
    @Column(name = "ITEMCATEGORY")
    private String itemCategory;
    @Basic
    @Column(name = "NAME")
    private String name;
    @Basic
    @Column(name = "PRICE")
    private Integer price;

    public Items(){}
    public Items(CreateItemRequest createItemRequest) {
        this.description = createItemRequest.getDescription();
        this.itemCategory = createItemRequest.getItemCategory();
        this.name = createItemRequest.getName();
        this.price = createItemRequest.getPrice();
    }

    public Items(String description, String itemCategory, String name, Integer price) {
        this.description = description;
        this.itemCategory = itemCategory;
        this.name = name;
        this.price = price;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Items items = (Items) o;
        return itemId == items.itemId && Objects.equals(description, items.description) && Objects.equals(itemCategory, items.itemCategory) && Objects.equals(name, items.name) && Objects.equals(price, items.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId, description, itemCategory, name, price);
    }

    @Override
    public String toString() {
        return "Items{" +
                "description='" + description + '\'' +
                ", itemCategory='" + itemCategory + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
