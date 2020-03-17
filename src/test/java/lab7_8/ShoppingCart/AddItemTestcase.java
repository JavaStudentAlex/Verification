package lab7_8.ShoppingCart;

import com.github.javafaker.Faker;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class AddItemTestcase {

    Faker faker = new Faker();

    private ShoppingCart cartInstance;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp(){
        cartInstance = new ShoppingCart();
    }

    @Test
    public void addItemUnderInvalidEquivalentClassTest(){
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Illegal title");
        cartInstance.addItem(faker.lorem().characters(35), 1.0, 1,
                ShoppingCart.ITEM_REGULAR);
    }

    @Test
    public void addItemUpperInvalidEquivalentClassTest(){
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Illegal title");
        cartInstance.addItem(faker.lorem().characters(0), 1.0, 1,
                ShoppingCart.ITEM_REGULAR);
    }

    @Test
    public void addItemValidEquivalentClassTest(){
        cartInstance.addItem(faker.lorem().characters(2), 1.0, 1,
                ShoppingCart.ITEM_REGULAR);
    }

}