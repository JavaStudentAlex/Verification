package lab7_8.ShoppingCart;

import java.util.*;
import java.text.*;

/**
 * Containing items and calculating price.
 */
public class ShoppingCart {

    /**
     * Container for added items
     */
    private List items = new ArrayList();

    /**
     * Adds new item.
     *
     * @param title    item title 1 to 32 symbols
     * @param price    item ptice in cents, > 0, < 1000
     * @param quantity item quantity, from 1 to 1000
     * @param type     item type, on of ShoppingCart.ITEM_* constants
     * @throws IndexOutOfBoundsException if total items added over
     *                                   99
     * @throws IllegalArgumentException  if some value is wrong
     */
    public void addItem(String title, double price, int quantity, int type) {
        if (title == null || title.length() == 0 || title.length() > 32)
            throw new IllegalArgumentException("Illegal title");
        if (price < 0.01 || price >= 1000.00)
            throw new IllegalArgumentException("Illegal price");
        if (quantity <= 0 || quantity > 1000)
            throw new IllegalArgumentException("Illegal quantity");
        if (items.size() == 99)
            throw new IndexOutOfBoundsException("No more space in cart");
        Item item = new Item(title, price, quantity, type);
        items.add(item);
    }

    /**
     * Calculates item's discount.
     * For ITEM_REGULAR discount is 0%;
     * For ITEM_SECOND_FREE discount is 50% if quantity > 1
     * For ITEM_DISCOUNT discount is 10% + 10% for each full 10
     * items, but not more than 50% total
     * For ITEM_FOR_SALE discount is 90%
     * For each full 100 items item gets additional 10%, but not more
     * than 80% total
     */
    public static int calculateDiscount(Item item) {
        int discount = 0;
        switch (item.getType()) {
            case Item.ITEM_SECOND_FREE:
                if (item.getQuantity() > 1)
                    discount = 50;
                break;
            case Item.ITEM_DISCOUNT:
                discount = 10 + item.getQuantity() / 10 * 10;
                if (discount > 50)
                    discount = 50;
                break;
            case Item.ITEM_FOR_SALE:
                discount = 90;
        }
        discount += item.getQuantity() / 100 * 10;
        if (discount > 80)
            discount = 80;
        return discount;
    }
}
