package RestAPI.Request;

import Entity.Dinnertable;
import Entity.Items;

public class CreateOrderRequest {

    private Double price;
    private Integer quantity;
    private String note;
    private Items itemsByItemFk;
    private Dinnertable dinnertableByTableFk;

    public CreateOrderRequest(){};
    public CreateOrderRequest(Double price, Integer quantity, String note, Items itemsByItemFk, Dinnertable dinnertableByTableFk) {
        this.price = price;
        this.quantity = quantity;
        this.note = note;
        this.itemsByItemFk = itemsByItemFk;
        this.dinnertableByTableFk = dinnertableByTableFk;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getNote() {
        return note;
    }

    public Items getItemsByItemFk() {
        return itemsByItemFk;
    }

    public Dinnertable getDinnertableByTableFk() {
        return dinnertableByTableFk;
    }

}