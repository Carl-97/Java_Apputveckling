package Entity;

import RestAPI.Request.CreateOrderRequest;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "Orders.all", query = "SELECT e FROM Orders e"),
        @NamedQuery(name = "Orders.byTableID", query = "SELECT e FROM Orders e WHERE e.dinnertableByTableFk.id = ?1"),
        @NamedQuery(name = "Orders.ToKitchen", query = "select e.itemsByItemFk.name, e.note from Orders e where e.itemsByItemFk.itemCategory not like 'D'")
})
public class Orders {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ORDERS_ID")
    private int id;
    @Basic
    @Column(name = "NOTE")
    private String note;
    @Basic
    @Column(name = "READY",columnDefinition = "boolean default false")
    private Boolean ready;

    @ManyToOne
    @JoinColumn(name = "ITEM_FK", referencedColumnName = "ITEM_ID")
    private Items itemsByItemFk;
    @ManyToOne
    @JoinColumn(name = "TABLE_FK", referencedColumnName = "TABLE_ID")
    private Dinnertable dinnertableByTableFk;

    public Orders() {}

    public Orders(CreateOrderRequest orderRequest) {
        this.note = note;
        this.itemsByItemFk = orderRequest.getItemsByItemFk();
        this.dinnertableByTableFk = orderRequest.getDinnertableByTableFk();
    }

    public Orders(String note, Items itemsByItemFk, Dinnertable dinnertableByTableFk) {
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Boolean getReady() {
        return ready;
    }

    public void setReady(Boolean readyCheck) {
        this.ready = readyCheck;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orders orders = (Orders) o;
        return id == orders.id && Objects.equals(note, orders.note) && ready.equals(orders.ready) && itemsByItemFk.equals(orders.itemsByItemFk) && dinnertableByTableFk.equals(orders.dinnertableByTableFk);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, note, ready, itemsByItemFk, dinnertableByTableFk);
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
                ", note='" + note + '\'' +
                ", itemsByItemFk=" + itemsByItemFk +
                ", dinnertableByTableFk=" + dinnertableByTableFk +
                '}';
    }
}
