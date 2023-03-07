package Entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "Orders.all", query = "SELECT e FROM Orders e"),
        @NamedQuery(name = "Orders.byTableID", query = "SELECT e FROM Orders e WHERE e.dinnertableByTableFk.id = ?1"),
        @NamedQuery(name = "Orders.ToKitchen", query = "select e.itemsByItemFk.name, e.note from Orders e where e.itemsByItemFk.itemcategory not like 'D'")
})
public class Orders {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ORDERS_ID")
    private int id;
    @Basic
    @Column(name = "PRICE")
    private Double price;
    @Basic
    @Column(name = "QUANTITY")
    private Integer quantity;
    @Basic
    @Column(name = "NOTE")
    private String note;
    @Basic
    @Column(name = "READY",columnDefinition = "boolean default false")
    private Boolean readyCheck;

    @ManyToOne
    @JoinColumn(name = "ITEM_FK", referencedColumnName = "ITEM_ID")
    private Items itemsByItemFk;
    @ManyToOne
    @JoinColumn(name = "TABLE_FK", referencedColumnName = "TABLE_ID")
    private Dinnertable dinnertableByTableFk;

    public Orders() {}

    public Orders(Double price, Integer quantity, String note, Items itemsByItemFk, Dinnertable dinnertableByTableFk) {
        this.price = price;
        this.quantity = quantity;
        this.note = note;
        this.itemsByItemFk = itemsByItemFk;
        this.dinnertableByTableFk = dinnertableByTableFk;
    }

    public int getId() {
        return id;
    }

    public void setId(int ordersId) {
        this.id = ordersId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Boolean getReadyCheck() {
        return readyCheck;
    }

    public void setReadyCheck(Boolean readyCheck) {
        this.readyCheck = readyCheck;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orders orders = (Orders) o;
        return id == orders.id && Objects.equals(price, orders.price) && Objects.equals(quantity, orders.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, quantity);
    }

    public Items getItemsByItemFk() {
        return itemsByItemFk;
    }

    public void setItemsByItemFk(Items itemsByItemFk) {
        this.itemsByItemFk = itemsByItemFk;
    }

    public Dinnertable getDinnertableByTableFk() {
        return dinnertableByTableFk;
    }

    public void setDinnertableByTableFk(Dinnertable dinnertableByTableFk) {
        this.dinnertableByTableFk = dinnertableByTableFk;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "ordersId=" + id +
                ", price=" + price +
                ", quantity=" + quantity +
                ", note='" + note + '\'' +
                ", itemsByItemFk=" + itemsByItemFk +
                ", dinnertableByTableFk=" + dinnertableByTableFk +
                '}';
    }
}
