/**
 * Mimics fundamental function cons for constructs
 * memory objects which hold two values or pointers to values 
 * @author Vyacheslav Moskalenko
 * @since JDK1.4
 */

package lab1;

/**
 * Not empty child class of FunList abstract class.
 * @author alex
 * @since 05.03.20
 */
public class Cons extends FunList {

    /**
     * First element of list
     */
    private int _dat;

    /**
     * Other last elements of list
     */
    private FunList _cdr;

    /**
     * Constructor from that consist of two elems : first elem _dat and tail elems _cdr
     * @param carDat - first given element for _dat
     * @param cdr - tail elements for _cdr
     */
    public Cons(int carDat, FunList cdr){
        _dat = carDat;
        _cdr = cdr;
    }
    
    /**
     * Constructor from that consist of one elem : first elem for _dat is given and other tail _cdr is empty
     * @param i first elem
     */
    public Cons(int i){
        this(i, Empty.getUniqueInstance());
    }
    
    /** Method for getting first element
     * @return the first int in the list object
     */
    public int car(){
        return _dat;
    }
    
    /** Method for getting tail elements without first
     * @return the tail (all but the first element) of the list object
     */
    public FunList cdr(){
        return _cdr;
    }
    
    /** Method process class to string
     * @return a String description of the list object
     */
    String toStringHelp(){
        return " " + _dat + _cdr.toStringHelp();
    }

    @Override
    public FunList append(FunList other) {
        return new Cons(_dat, _cdr.append(other));
    }

    /**
     * Create new Cons ordered list and insert elem inside in the right pos
     * @param i value to insert
     * @return created new ordered in non-descend list
     */
    @Override
    public FunList insertInOrder(int i) {
        int newDatVal = Math.max(i, _dat), datValForRecursion = Math.min(i, _dat);
        return new Cons(newDatVal, _cdr.insertInOrder(datValForRecursion));
    }

    /**
     * Order current
     * @return new list that created from current elements in non-descend order
     */
    @Override
    public FunList sort() {
        FunList sorted = _cdr.sort();
        return sorted.insertInOrder(_dat);
    }
}