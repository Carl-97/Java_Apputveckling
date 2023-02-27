package Entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "Items.all", query = "SELECT e FROM Items e"),
        @NamedQuery(name = "Items.category", query = "SELECT e FROM Items e WHERE e.itemcategory = :itemcategory")
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
    private String itemcategory;
    @Basic
    @Column(name = "NAME")
    private String name;
    @Basic
    @Column(name = "PRICE")
    private Integer price;

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

    public String getItemcategory() {
        return itemcategory;
    }

    public void setItemcategory(String itemcategory) {
        this.itemcategory = itemcategory;
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
        return itemId == items.itemId && Objects.equals(description, items.description) && Objects.equals(itemcategory, items.itemcategory) && Objects.equals(name, items.name) && Objects.equals(price, items.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId, description, itemcategory, name, price);
    }

    @Override
    public String toString() {
        return "Items{" +
                "description='" + description + '\'' +
                ", itemcategory='" + itemcategory + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
