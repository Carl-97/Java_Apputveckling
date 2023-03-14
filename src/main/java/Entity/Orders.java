package Entity;

import RestAPI.Request.CreateOrderRequest;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "Orders.all", query = "SELECT e FROM Orders e"),
        @NamedQuery(name = "Orders.byOrdersID", query = "SELECT e FROM Orders e WHERE e.ordersId = ?1"),
        @NamedQuery(name = "Orders.byTableID", query = "SELECT e FROM Orders e WHERE e.dinnertableByTableFk.tableId = ?1"),
        @NamedQuery(name = "Orders.ToKitchen", query = "select e.itemsByItemFk.name, e.note from Orders e where e.itemsByItemFk.itemCategory not like 'D'")
})
public class Orders {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ORDERS_ID")
    private int ordersId;
    @Basic
    @Column
    private String note;
    @Basic
    @Column
    private boolean cooked = false;

    @ManyToOne
    @JoinColumn(name = "ITEM_FK", referencedColumnName = "ITEM_ID")
    private Items itemsByItemFk;
    @ManyToOne
    @JoinColumn(name = "TABLE_FK", referencedColumnName = "TABLE_ID")
    private Dinnertable dinnertableByTableFk;

    public Orders() {}

    public Orders(String note, Items itemsByItemFk, Dinnertable dinnertableByTableFk) {
        this.note = note;
        this.itemsByItemFk = itemsByItemFk;
        this.dinnertableByTableFk = dinnertableByTableFk;
    }

    public Orders(CreateOrderRequest createOrderRequest) {
        note = createOrderRequest.getNote();
        itemsByItemFk = createOrderRequest.getItemsByItemFk();
        dinnertableByTableFk = createOrderRequest.getDinnertableByTableFk();
    }

    public int getOrdersId() {
        return ordersId;
    }

    public void setOrdersId(int ordersId) {
        this.ordersId = ordersId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public boolean isCooked() {
        return cooked;
    }

    public void setCooked(boolean hasBeenCooked) {
        this.cooked = hasBeenCooked;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orders orders = (Orders) o;
        return ordersId == orders.ordersId && Objects.equals(note, orders.note);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ordersId, note);
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
                "ordersId=" + ordersId +
                ", note='" + note + '\'' +
                ", itemsByItemFk=" + itemsByItemFk +
                ", dinnertableByTableFk=" + dinnertableByTableFk +
                '}';
    }
}
