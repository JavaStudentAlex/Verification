/**
 * Mimics functional lists.
 * @author Moskalenko Vyacheslav
 * @since JDK1.4
 */

package lab1;


/**
 * Abstract(parent) list class
 * @author alex
 * @since 05.03.20
 */
public abstract class FunList {


    /**
     * Empty method
     * @return return int val
     */
    public abstract int car();


    /**
     * Empty method
     * @return FunList object
     */
    public abstract FunList cdr();
    
    /**
     * NOTE: toString () method is NOT abstract. It calls, toStringHelp() , an abstract method.
     * It represents what we call an "invariant" behavior for <code>FunList</code>.
     * It is an example of the "Template Method Pattern". A "template method" is a method that
     * makes calls to at least one abstract method in its own class.
     */
    public String toString(){
        return "(" + toStringHelp() + " )";
    }


    /**
     * Empty method
     * @return String object
     */
    abstract String toStringHelp();

    /**
     * Abstract method for appending other FunList object to current
     * @param other appending list
     * @return new appended list
     */
    public abstract FunList append(FunList other);

    /**
     * Insert int val in descending series
     * @param i value to insert
     * @return new list with inserted value inside
     */
    public abstract FunList insertInOrder(int i);

    /**
     * Create new non-descending sorted list
     * @return result sorted list
     */
    public abstract FunList sort();
}