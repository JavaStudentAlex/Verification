package odz.ShoppingCart;
import java.util.*;
import static odz.ShoppingCart.Item.Type.*;

/**
 * Containing items and calculating price.
 */
public class ShoppingCart{

	/** Container for added items */
    public List items = new ArrayList();
    
    /**
     * Tests all class methods.
     */
    public static void main(String[] args){
        TableFormatter formatter = new TableFormatter();
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("aaa", 100.0, 230, SALE);
        cart.addItem("adlmajsnc", 123.0, 130, DISCOUNT);
        cart.addItem("as.kjcas,kjcbaskjcbk,asbckasbc", 550, 355, SALE);
        System.out.println(formatter.formatTable(cart.items));
    }

    /**
     * Adds new item.
     *
     * @param title     item title 1 to 32 symbols
     * @param price     item ptice in cents, > 0, < 1000
     * @param quantity  item quantity, from 1 to 1000
     * @param type      item type, on of ShoppingCart.ITEM_* constants
     *
     * @throws IndexOutOfBoundsException if total items added over 99
     * @throws IllegalArgumentException if some value is wrong
     */
    public void addItem(String title, double price, int quantity, Item.Type type) {
        validate(title, price, quantity);
        items.add(new Item(title, price, quantity, type));
    }

    /**
     * Method assert are item`s params valid
     * @param title item title 1 to 32 symbols
     * @param price item ptice in cents, > 0, < 1000
     * @param quantity item quantity, from 1 to 1000
     * @throws IndexOutOfBoundsException if total items added over 99
     * @throws IllegalArgumentException if some value is wrong
     */
    private void validate(String title, double price, int quantity) {
        if (title == null || title.length() == 0 || title.length() > 32)
            throw new IllegalArgumentException("Illegal title");

        if (price < 0.01 || price >= 1000.00)
            throw new IllegalArgumentException("Illegal price");

        if (quantity <= 0 || quantity > 1000)
            throw new IllegalArgumentException("Illegal quantity");

        if (items.size() == 99)
            throw new IndexOutOfBoundsException("No more space in cart");
    }


    /**
     * Formats shopping price.
     *
     * @return  string as lines, separated with \n,
     *          first line:   # Item                   Price Quan. Discount      Total
     *          second line: ---------------------------------------------------------
     *          next lines:  NN Title                 $PP.PP    Q       DD%     $TT.TT
     *                        1 Some title              $.30    2         -       $.60
     *                        2 Some very long ti... $100.00    1       50%     $50.00
     *                       ...
     *                       31 Item 42              $999.00 1000         - $999000.00
     *          end line:    ---------------------------------------------------------
     *          last line:   31                                             $999050.60
     *
     *          Item title is trimmed to 20 chars adding '...'
     *          
     *          if no items in cart returns "No items." string.
     */
    public String toString() {
        TableFormatter table = new TableFormatter();
        return table.formatTable(items);
    }

}















