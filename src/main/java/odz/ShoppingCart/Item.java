package odz.ShoppingCart;

/**
 * Class for representing item object
 */
public class Item {

    public enum Type { SECOND, REGULAR, SALE, DISCOUNT };
    private String title;
    private double price;
    private int quantity;
    private Type type;

    /**
     * Constructor for all elements
     * @param title string
     * @param price double
     * @param quantity int
     * @param type one from enum Type
     */
    public Item(String title, double price, int quantity, Type type){
        this.title = title;
        this.price = price;
        this.type = type;
        this.quantity = quantity;
    }

    /**
     * Method calculate overall cost of item with discount.
     * @return double value
     */
    public double calculateTotal(){
        int discount = calculateDiscount();
        return price  * quantity * (100 - discount) / 100;
    }

    /**
     * Calculates item's discount.
     * For ITEM_REGULAR discount is 0%;
     * For ITEM_SECOND_FREE discount is 50% if quantity > 1
     * For ITEM_DISCOUNT discount is 10% + 10% for each full 10 items, but not more than 50% total
     * For ITEM_FOR_SALE discount is 90%
     * For each full 100 items item gets additional 10%, but not more than 80% total
     */
    public int calculateDiscount(){
        int discount = 0;
        switch (type) {
            case SECOND:
                if (quantity > 1)
                    discount = 50;
                break;

            case DISCOUNT:
                discount = 10 + quantity / 10 * 10;
                if (discount > 50)
                    discount = 50;
                break;
            case SALE:
                discount = 90;
        }
        discount += quantity / 100 * 10;
        if (discount > 80)
            discount = 80;
        return discount;
    }

    //All getters and setters for class

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

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
