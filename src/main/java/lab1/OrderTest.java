package lab1;

import static lab1.Assert.*;

/**
 * Test class for Order function
 */
public class OrderTest {

    /**
     * Run func for class
     * @param args command line args
     */
    public static void main(String[] args){
        assertTrue(isNotListChanged(), "Basic list not changed", "List changed");
        assertTrue(isNotSameList(), "Not Same list", "Same list");
        assertTrue(madeInRightOrder(), "Sorted right", "Not right sorted");
    }

    /**
     * Assert base list not changed
     * @return true is stable else false
     */
    private static boolean isNotListChanged(){
        String vals = "( 1 -11 13 )";
        FunList list = new Cons(1).append(new Cons(-11)).append(new Cons(13));
        FunList ordered = list.sort();
        return list.toString().equals(vals);
    }

    /**
     * Assert is new list created
     * @return true if created new else false
     */
    private static boolean isNotSameList(){
        FunList list = new Cons(1);
        FunList ordered = list.sort();
        return list != ordered;
    }

    /**
     * Assert does func work right way
     * @return true if OK else false
     * */
    private static boolean madeInRightOrder(){
        String val = "( 13 1 -11 )";
        FunList list = new Cons(1).append(new Cons(-11)).append(new Cons(13));
        FunList ordered = list.sort();
        return ordered.toString().equals(val);
    }
}
