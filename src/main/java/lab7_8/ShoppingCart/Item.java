package lab7_8.ShoppingCart;

public class Item {

    public static final int ITEM_REGULAR = 0;
    public static final int ITEM_DISCOUNT = 1;
    public static final int ITEM_SECOND_FREE = 2;
    public static final int ITEM_FOR_SALE = 3;

    private String title;
    private double price;
    private int quantity;
    private int type;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Item(String title, double price, int quantity, int type) {
        this.title = title;
        this.price = price;
        this.quantity = quantity;
        this.type = type;
    }
}
