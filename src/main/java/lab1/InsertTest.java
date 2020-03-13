package lab1;


import static lab1.Assert.*;

/**
 * Test class for Insert func
 */
public class InsertTest {

    /**
     * run func
     * @param args command line args
     */
    public static void main(String[] args){
        assertTrue(isNotSameList(), "List changed", "Lists are same");
        assertTrue(numbersInserted(), "Inserted numbers", "where are numbers?");
        assertTrue(isNotNewListModified(), "Not modified", "List changed");
    }

    /**
     * Assert creating new list
     * @return yes if created else no
     */
    private static boolean isNotSameList(){
        FunList list = Empty.getUniqueInstance();
        FunList inserted = list.insertInOrder(5);
        if(list==inserted){
            return false;
        }
        list = new Cons(3);
        inserted = list.insertInOrder(6);
        return !(list == inserted);
    }

    /**
     * Assert are numbers right inserted
     * @return true if yes else false
     */
    private static boolean numbersInserted(){
        String values = "( 4 3 2 1 )";
        FunList list = new Cons(4).append(new Cons(3)).append(new Cons(1)).insertInOrder(2);
        return list.toString().equals(values);
    }


    /**
     * Assert is base list modified
     * @return yes if not modified else false
     */
    private static boolean isNotNewListModified(){
        String val = "( 1 )";
        FunList list = new Cons(1);
        list.insertInOrder(4);
        return list.toString().equals(val);
    }

}
