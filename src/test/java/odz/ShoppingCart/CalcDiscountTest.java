package odz.ShoppingCart;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import static odz.ShoppingCart.Item.Type.*;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class CalcDiscountTest {

    private int discount;
    private Item currentItem;
    private static final Faker faker = new Faker();

    public CalcDiscountTest(Item currentItem , int discoutPredicted){
        this.currentItem = currentItem;
        discount = discoutPredicted;
    }


    @Parameterized.Parameters
    public static Collection getParametrizedItems(){
        return Arrays.asList(new Object[][]{
                {new Item(faker.lorem().characters(15), 20.0,
                        1, REGULAR ), 0},
                {new Item(faker.lorem().characters(15), 20,
                        1, SECOND), 0},
                {new Item(faker.lorem().characters(15), 20,
                        2, SECOND), 50},
                {new Item(faker.lorem().characters(15), 20,
                        99, SECOND), 50},
                {new Item(faker.lorem().characters(15), 20,
                        100, SECOND), 60},
                {new Item(faker.lorem().characters(15), 20,
                        101, SECOND), 60},
                {new Item(faker.lorem().characters(15), 20,
                        500, SECOND), 80},
                {new Item(faker.lorem().characters(15), 20,
                        1, DISCOUNT), 10},
                {new Item(faker.lorem().characters(15), 20,
                        9, DISCOUNT), 10},
                {new Item(faker.lorem().characters(15), 20,
                        10, DISCOUNT), 20},
                {new Item(faker.lorem().characters(15), 20,
                        30, DISCOUNT), 40},
                {new Item(faker.lorem().characters(15), 20,
                        90, DISCOUNT), 50},
                {new Item(faker.lorem().characters(15), 20,
                        99, DISCOUNT), 50},
                {new Item(faker.lorem().characters(15), 20,
                        100, DISCOUNT), 60},
                {new Item(faker.lorem().characters(15), 20,
                        500, DISCOUNT), 80},
                {new Item(faker.lorem().characters(15), 20,
                        101, DISCOUNT), 60},
                {new Item(faker.lorem().characters(15), 20,
                        1, SALE), 80},
                {new Item(faker.lorem().characters(15), 20,
                        500, SALE), 80}
        });
    }

    @Test
    public void discountCalculating(){
        assertEquals(discount, currentItem.calculateDiscount());
    }

}