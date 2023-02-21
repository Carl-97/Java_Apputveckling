package Entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Orders {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ORDERS_ID")
    private int ordersId;
    @Basic
    @Column(name = "TABLE_FK")
    private int tableFk;
    @Basic
    @Column(name = "QUANTITY")
    private int quantity;
    @Basic
    @Column(name = "PRICE")
    private double price;
    @Basic
    @Column(name = "ITEM_FK")
    private int itemFk;

    public int getOrdersId() {
        return ordersId;
    }

    public void setOrdersId(int ordersId) {
        this.ordersId = ordersId;
    }

    public int getTableFk() {
        return tableFk;
    }

    public void setTableFk(int tableFk) {
        this.tableFk = tableFk;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getItemFk() {
        return itemFk;
    }

    public void setItemFk(int itemFk) {
        this.itemFk = itemFk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orders orders = (Orders) o;
        return ordersId == orders.ordersId && tableFk == orders.tableFk && quantity == orders.quantity && Double.compare(orders.price, price) == 0 && itemFk == orders.itemFk;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ordersId, tableFk, quantity, price, itemFk);
    }
}
