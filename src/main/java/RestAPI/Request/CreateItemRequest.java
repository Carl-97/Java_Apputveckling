package RestAPI.Request;

public class CreateItemRequest {

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

    public String getDescription() {
        return description;
    }

    public String getItemCategory() {
        return itemCategory;
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

}
