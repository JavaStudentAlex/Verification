package lab1;

import static lab1.Assert.*;

/**
 * Test class for Append func
 */
public class AppendTest {

    /**
     * Main func for class AppendTest
     * @param args - params from command line
     */
    public static void main(String[] args){
        assertTrue(isSameEmptyObject(), "Singleton works", "Singleton don`t work");
        assertTrue(isListChanged(), "List not changed", "List changed");
        assertTrue(areElementsInsideList(), "Elements appended", "Elements not inside");
    }

    /**
     * Assert is the same object returned
     * @return true if same object
     */
    private static boolean isSameEmptyObject(){
        Empty ob1 = Empty.getUniqueInstance();
        Empty ob2 = Empty.getUniqueInstance();
        return ob1 == ob2;
    }

    /**
     * Method assert is base list changed
     * @return true is list changed else false
     */
    private static boolean isListChanged(){
        FunList list = new Cons(1);
        FunList appendedList = list.append(new Cons(2));
        return !(appendedList ==list);
    }

    /**
     * Method assert are elems appended
     * @return true is yes else no
     */
    private static boolean areElementsInsideList(){
        String result_val ="( 1 2 3 )";
        FunList asserted_list = new Cons(1).append(new Cons(2)).append(new Cons(3));
        return result_val.equals(asserted_list.toString());
    }
}
