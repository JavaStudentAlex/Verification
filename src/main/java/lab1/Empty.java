/**
 * Mimics functional empty list.
 * @author Vyacheslav Moskalenko
 * @since JDK1.4
 */

package lab1;

/**
 * Child class of FunList that mean empty list
 * @author alex
 * @since 05.03.20
 */
public class Empty extends FunList{

    /**
     * Unique instance of class
     */
    private static Empty uniqueInstance = new Empty();

    /**
     * Empty private constructor
     */
    private Empty(){}


    /**
     * Method for realizing singleton pattern
     * @return Empty unique object
     */
    public static Empty getUniqueInstance(){
        return uniqueInstance;
    }

    /**
     * Overriden method who throw exception because not realized class method
     * @return exception
     */
    public int car(){
        throw new java.util.NoSuchElementException("car requires a non Empty Funlist");
    }

    /**
     * Overriden method who throw exception because not realized class method
     * @return exception
     */
    public FunList cdr(){
        throw new java.util.NoSuchElementException("cdr requires a non Empty Funlist");
    }

    /**
     * Method process the empty class to empty string
     * @return empty string
     */
    String toStringHelp(){
        return "";
    }

    /**
     * Overrided append method for empty funlist
     * @param other appending list
     * @return only other FunList
     */
    @Override
    public FunList append(FunList other) {
        return other;
    }

    /**
     * Overridden method for inserting int val to empty list
     * @param i value to insert
     * @return Cons object with one val
     */
    @Override
    public FunList insertInOrder(int i) {
        return new Cons(i);
    }

    /**
     * It is empty list class. It can not be ordered
     * @return empty list
     */
    @Override
    public FunList sort() {
        return this;
    }
}

