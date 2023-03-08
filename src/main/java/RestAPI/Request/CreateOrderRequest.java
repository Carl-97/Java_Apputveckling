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
    public CreateOrderRequest(String note, Items itemsByItemFk, Dinnertable dinnertableByTableFk) {
        this.note = note;
        this.itemsByItemFk = itemsByItemFk;
        this.dinnertableByTableFk = dinnertableByTableFk;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getPrice() {
        return price;
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
}