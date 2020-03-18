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
    public void addItemTitleUnderInvalidEquivalentClass(){
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Illegal title");
        cartInstance.addItem(faker.lorem().characters(35), 1.0, 1,
                Item.ITEM_REGULAR);
    }

    @Test
    public void addItemTitleUpperInvalidEquivalentClass(){
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Illegal title");
        cartInstance.addItem(faker.lorem().characters(0), 1.0, 1,
                Item.ITEM_REGULAR);
    }

    @Test
    public void addItemTitleValidEquivalentClass(){
        cartInstance.addItem(faker.lorem().characters(2), 1.0, 1,
                Item.ITEM_REGULAR);
    }

    @Test
    public void addItemPriceUnderInvalidEquivalentClass(){
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Illegal price");
        cartInstance.addItem(faker.lorem().characters(15), -1.0, 1,
                Item.ITEM_REGULAR);
    }

    @Test
    public void addItemPriceUpperInvalidEquivalentClass(){
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Illegal price");
        cartInstance.addItem(faker.lorem().characters(15), 1001.0, 1,
                Item.ITEM_REGULAR);
    }

    @Test
    public void addItemPriceValidEquivalentClass(){
        cartInstance.addItem(faker.lorem().characters(15), 2.0, 1,
                Item.ITEM_REGULAR);
    }

    @Test
    public void addItemQuantityUnderInvalidEquivalentClass(){
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Illegal quantity");
        cartInstance.addItem(faker.lorem().characters(15), 1.0, -1,
                Item.ITEM_REGULAR);
    }

    @Test
    public void addItemQuantityUpperInvalidEquivalentClass(){
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Illegal quantity");
        cartInstance.addItem(faker.lorem().characters(15), 1.0, 1002,
                Item.ITEM_REGULAR);
    }

    @Test
    public void addItemQuantityValidEquivalentClass(){
        cartInstance.addItem(faker.lorem().characters(15), 1.0, 505,
                Item.ITEM_REGULAR);
    }

    @Test
    public void addItemSizeValidEquivalentClass(){
        int size = 54;
        for(int i=0;i<size; ++i){
            cartInstance.addItem(faker.lorem().characters(15), 1.0,
                    550, Item.ITEM_REGULAR);
        }
    }

    @Test
    public void addItemSizeInvalidEquivalentClass(){
        thrown.expect(IndexOutOfBoundsException.class);
        thrown.expectMessage("No more space in cart");
        int size = 100;
        for(int i=0;i<size; ++i){
            cartInstance.addItem(faker.lorem().characters(15), 1.0,
                    550, Item.ITEM_REGULAR);
        }
    }

    @Test
    public void addItemTypeInvalidEquivalentClass(){
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Illegal type");
        cartInstance.addItem(faker.lorem().characters(15), 1.0, 300,
                10);
    }

    @Test
    public void addItemTypeValidEquivalentClass(){
        cartInstance.addItem(faker.lorem().characters(15), 1.0, 300,
                Item.ITEM_FOR_SALE);
    }

}