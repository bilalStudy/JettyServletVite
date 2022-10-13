package no.kristiania.webshop;

public class CartItem {
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    private String itemName;
    private int price;

    @Override
    public String toString() {
        return "CartItem{" +
                "itemName='" + itemName + '\'' +
                ", price=" + price +
                '}';
    }
}
