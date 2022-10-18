package no.kristiania.webshop;

public class CartItem {
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    private String itemName;
    private String price;

    @Override
    public String toString() {
        return "CartItem{" +
                "itemName='" + itemName + '\'' +
                ", price=" + price +
                '}';
    }
}
