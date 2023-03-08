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
    @Column(name = "PRICE")
    private Double price;
    @Basic
    @Column(name = "QUANTITY")
    private Integer quantity;
    @Basic
    @Column
    private String note = "";
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

    public Orders(Double price, Integer quantity, String note, Items itemsByItemFk, Dinnertable dinnertableByTableFk) {
        this.price = price;
        this.quantity = quantity;
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
        return ordersId == orders.ordersId && Objects.equals(price, orders.price) && Objects.equals(quantity, orders.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ordersId, price, quantity);
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
                ", price=" + price +
                ", quantity=" + quantity +
                ", note='" + note + '\'' +
                ", itemsByItemFk=" + itemsByItemFk +
                ", dinnertableByTableFk=" + dinnertableByTableFk +
                '}';
    }
}
