package lab9_10;

import org.junit.Test;

import static org.junit.Assert.*;

public class ShoppingCartTestcase {

    @Test
    public void testAppendFormatted() {
        StringBuilder sb = new StringBuilder();
        ShoppingCart.appendFormatted(sb, "SomeLine", 0, 14);
        assertEquals("   SomeLine   ", sb.toString());
        sb = new StringBuilder();
        ShoppingCart.appendFormatted(sb, "SomeLine", 0, 15);
        assertEquals("   SomeLine    ", sb.toString());
        sb = new StringBuilder();
        ShoppingCart.appendFormatted(sb, "SomeLine", 0, 5);
        assertEquals("SomeL", sb.toString());
        sb = new StringBuilder();
        ShoppingCart.appendFormatted(sb, "SomeLine", 1, 15);
        assertEquals("       SomeLine", sb.toString());
        sb = new StringBuilder();
        ShoppingCart.appendFormatted(sb, "SomeLine       ", -1, 15);
        assertEquals("SomeLine       ", sb.toString());
    }

    @Test
    public void testCalculateDiscount() {
        assertEquals(80, ShoppingCart.Item.calcDiscount(ShoppingCart.Item.ItemType.SALE, 500));
        assertEquals(73, ShoppingCart.Item.calcDiscount(ShoppingCart.Item.ItemType.SALE, 30));
        assertEquals(71, ShoppingCart.Item.calcDiscount(ShoppingCart.Item.ItemType.SALE, 10));
        assertEquals(70, ShoppingCart.Item.calcDiscount(ShoppingCart.Item.ItemType.SALE, 9));
        assertEquals(70, ShoppingCart.Item.calcDiscount(ShoppingCart.Item.ItemType.SALE, 1));
        assertEquals(0, ShoppingCart.Item.calcDiscount(ShoppingCart.Item.ItemType.NEW, 20));
        assertEquals(0, ShoppingCart.Item.calcDiscount(ShoppingCart.Item.ItemType.NEW, 10));
        assertEquals(0, ShoppingCart.Item.calcDiscount(ShoppingCart.Item.ItemType.NEW, 1));
        assertEquals(80, ShoppingCart.Item.calcDiscount(ShoppingCart.Item.ItemType.SECOND_FREE, 500));
        assertEquals(53, ShoppingCart.Item.calcDiscount(ShoppingCart.Item.ItemType.SECOND_FREE, 30));
        assertEquals(51, ShoppingCart.Item.calcDiscount(ShoppingCart.Item.ItemType.SECOND_FREE, 10));
        assertEquals(50, ShoppingCart.Item.calcDiscount(ShoppingCart.Item.ItemType.SECOND_FREE, 9));
        assertEquals(50, ShoppingCart.Item.calcDiscount(ShoppingCart.Item.ItemType.SECOND_FREE, 2));
        assertEquals(0, ShoppingCart.Item.calcDiscount(ShoppingCart.Item.ItemType.SECOND_FREE, 1));
    }

}