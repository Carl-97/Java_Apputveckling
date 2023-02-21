package Entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Items {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ITEM_ID")
    private int itemId;
    @Basic
    @Column(name = "NAME")
    private String name;
    @Basic
    @Column(name = "desc")
    private String desc;
    @Basic
    @Column(name = "PRICE")
    private int price;
    @Basic
    @Column(name = "itemCategory")
    private Integer itemCategory;

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Integer getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(Integer itemCategory) {
        this.itemCategory = itemCategory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Items items = (Items) o;
        return itemId == items.itemId && price == items.price && Objects.equals(name, items.name) && Objects.equals(desc, items.desc) && Objects.equals(itemCategory, items.itemCategory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId, name, desc, price, itemCategory);
    }
}