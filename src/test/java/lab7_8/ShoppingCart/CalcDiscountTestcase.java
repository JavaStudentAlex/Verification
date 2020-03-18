package lab7_8.ShoppingCart;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class CalcDiscountTestcase {

    private Item currentItem;
    private int discount;
    private static final Faker faker = new Faker();

    public CalcDiscountTestcase(Item item, int discoutPredicted){
        currentItem = item;
        discount = discoutPredicted;
    }


    @Parameterized.Parameters
    public static Collection getParametrizedItems(){
        return Arrays.asList(new Object[][]{
            {new Item(faker.lorem().characters(15), 20.0,
                    1, Item.ITEM_REGULAR ), 0},
                {new Item(faker.lorem().characters(15), 20,
                        1, Item.ITEM_SECOND_FREE), 0},
                {new Item(faker.lorem().characters(15), 20,
                        2, Item.ITEM_SECOND_FREE), 50},
                {new Item(faker.lorem().characters(15), 20,
                        99, Item.ITEM_SECOND_FREE), 50},
                {new Item(faker.lorem().characters(15), 20,
                        100, Item.ITEM_SECOND_FREE), 60},
                {new Item(faker.lorem().characters(15), 20,
                        101, Item.ITEM_SECOND_FREE), 60},
                {new Item(faker.lorem().characters(15), 20,
                        500, Item.ITEM_SECOND_FREE), 80},
                {new Item(faker.lorem().characters(15), 20,
                        1, Item.ITEM_DISCOUNT), 10},
                {new Item(faker.lorem().characters(15), 20,
                        9, Item.ITEM_DISCOUNT), 10},
                {new Item(faker.lorem().characters(15), 20,
                        10, Item.ITEM_DISCOUNT), 20},
                {new Item(faker.lorem().characters(15), 20,
                        30, Item.ITEM_DISCOUNT), 40},
                {new Item(faker.lorem().characters(15), 20,
                        90, Item.ITEM_DISCOUNT), 50},
                {new Item(faker.lorem().characters(15), 20,
                        99, Item.ITEM_DISCOUNT), 50},
                {new Item(faker.lorem().characters(15), 20,
                        100, Item.ITEM_DISCOUNT), 60},
                {new Item(faker.lorem().characters(15), 20,
                        500, Item.ITEM_DISCOUNT), 80},
                {new Item(faker.lorem().characters(15), 20,
                        101, Item.ITEM_DISCOUNT), 60},
                {new Item(faker.lorem().characters(15), 20,
                        1, Item.ITEM_FOR_SALE), 80},
                {new Item(faker.lorem().characters(15), 20,
                        500, Item.ITEM_DISCOUNT), 80}
        });
    }

    @Test
    public void discountCalculating(){
        assertEquals(discount, ShoppingCart.calculateDiscount(currentItem));
    }

}