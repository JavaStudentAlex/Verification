package odz.ShoppingCart;

import org.junit.Test;

import static odz.ShoppingCart.Item.Type.DISCOUNT;
import static odz.ShoppingCart.Item.Type.SALE;
import static org.junit.Assert.*;

public class TableTest {

    @Test
    public void testTable(){
        String result = "# Title                     Price Quantity Discount      Total\n" +
                        "--------------------------------------------------------------\n" +
                        "1 aaa                     $100.00      230      80%   $4600.00\n" +
                        "2 adlmajsnc               $123.00      130      60%   $6396.00\n" +
                        "3 as.kjcas,kjcbaskjcbk... $550.00      355      80%  $39050.00\n" +
                        "--------------------------------------------------------------\n" +
                        "4                                                    $50046.00";
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("aaa", 100.0, 230, SALE);
        cart.addItem("adlmajsnc", 123.0, 130, DISCOUNT);
        cart.addItem("as.kjcas,kjcbaskjcbk,asbckasbc", 550, 355, SALE);
        assertEquals(result, cart.toString());
    }

}