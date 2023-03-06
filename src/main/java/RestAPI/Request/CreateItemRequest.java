package RestAPI.Request;

import java.util.Objects;

public class CreateItemRequest {

    private int itemId;
    private String description;
    private String itemCategory;
    private String name;

    private Integer price;

    public CreateItemRequest(){}
    public CreateItemRequest(String description, String itemCategory, String name, Integer price) {
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
    public int hashCode() {
        return Objects.hash(itemId, description, itemCategory, name, price);
    }

    @Override
    public String toString() {
        return "Items{" +
                "description='" + description + '\'' +
                ", itemcategory='" + itemCategory + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
