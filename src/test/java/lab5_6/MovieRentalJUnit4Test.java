package lab5_6;

import org.junit.*;
import static org.junit.Assert.*;

public class MovieRentalJUnit4Test {

    private String CLIENT_NAME_FORMAT = "Rental Record for %s\n";
    private String OBJECT_STATEMENT_FORMAT = "\t%s\t%s\n";
    private String SUMMARY_FORMAT = "Amount owed is %s\n" +
                                    "You earned %s frequent renter points";

    Movie theManWhoKnewTooMuch, mulan, slumdogMillionaire;
    @Before
    public void setUp() {
        theManWhoKnewTooMuch = new RegularMovie("The Man Who Knew Too Much");
        mulan = new ChildrensMovie("Mulan");
        slumdogMillionaire = new NewRealiseMovie("Slumdog Millionaire");
    }

    @Test
    public void testGetTitle() {
        assertEquals("The Man Who Knew Too Much", theManWhoKnewTooMuch.get_title());
    }

    @Test
    public void testGetDaysRented() {
        assertEquals(2, new MovieRental(theManWhoKnewTooMuch, 2).getDaysRented());
    }

    @Test
    public void testGetMovie() {
        assertEquals(theManWhoKnewTooMuch, new MovieRental(theManWhoKnewTooMuch, 2).getMovie());
    }

    @Test
    public void testGetName() {
        String name = "John Doe"; 
        assertEquals(name, new Customer(name)._name);
    }

    @Test
    public void simpleTestStatementRegularMovieOnly() {
        // regular movies cost $2.00 for the first 2 days, and $1.50/day thereafter
        // a rental earns 1 frequent-renter point no matter how many days
        Customer johnDoe = new Customer("John Doe");
        johnDoe.addMovieRental(new MovieRental(theManWhoKnewTooMuch, 1));
        String statementMustBe = String.format(CLIENT_NAME_FORMAT, johnDoe._name) +
                String.format(OBJECT_STATEMENT_FORMAT, theManWhoKnewTooMuch.get_title(), String.valueOf(2.0)) +
                String.format(SUMMARY_FORMAT, String.valueOf(2.0), String.valueOf(1));
        assertEquals(statementMustBe, johnDoe.statement());
    }

    @Test
    public void additionalTestStatementRegularMovieOnly() {
        // regular movies cost $2.00 for the first 2 days, and $1.50/day thereafter
        // a rental earns 1 frequent-renter point no matter how many days
        Customer johnDoe = new Customer("John Doe");
        johnDoe.addMovieRental(new MovieRental(theManWhoKnewTooMuch, 3));
        String statementMustBe = String.format(CLIENT_NAME_FORMAT, johnDoe._name) +
                String.format(OBJECT_STATEMENT_FORMAT, theManWhoKnewTooMuch.get_title(), String.valueOf(3.5)) +
                String.format(SUMMARY_FORMAT, String.valueOf(3.5), String.valueOf(1));
        assertEquals(statementMustBe, johnDoe.statement());
    }

    @Test
    public void cumulativeTestStatementRegularMovie() {
        // regular movies cost $2.00 for the first 2 days, and $1.50/day thereafter
        // a rental earns 1 frequent-renter point no matter how many days
        Customer johnDoe = new Customer("John Doe");
        johnDoe.addMovieRental(new MovieRental(theManWhoKnewTooMuch, 1));
        johnDoe.addMovieRental(new MovieRental(theManWhoKnewTooMuch, 3));
        String statementMustBe = String.format(CLIENT_NAME_FORMAT, johnDoe._name) +
                String.format(OBJECT_STATEMENT_FORMAT, theManWhoKnewTooMuch.get_title(), String.valueOf(2.0)) +
                String.format(OBJECT_STATEMENT_FORMAT, theManWhoKnewTooMuch.get_title(), String.valueOf(3.5)) +
                String.format(SUMMARY_FORMAT, String.valueOf(5.5), String.valueOf(2));
        assertEquals(statementMustBe, johnDoe.statement());
    }

    @Test
    public void simpleTestStatementChildrensMovieOnly() {
        // childrens' movies cost $1.50 for the first 3 days, and $1.25/day thereafter
        // a rental earns 1 frequent-renter point no matter how many days
        Customer johnDoeJr = new Customer("Johnny Doe, Jr.");
        johnDoeJr.addMovieRental(new MovieRental(mulan, 3));
        String statementMustBe = String.format(CLIENT_NAME_FORMAT, johnDoeJr._name) +
                String.format(OBJECT_STATEMENT_FORMAT, mulan.get_title(), String.valueOf(1.5)) +
                String.format(SUMMARY_FORMAT, String.valueOf(1.5), String.valueOf(1));
    }

    @Test
    public void additionalTestStatementChildrensMovieOnly() {
        // childrens' movies cost $1.50 for the first 3 days, and $1.25/day thereafter
        // a rental earns 1 frequent-renter point no matter how many days
        Customer johnDoeJr = new Customer("Johnny Doe, Jr.");
        johnDoeJr.addMovieRental(new MovieRental(mulan, 4));
        String statementMustBe = String.format(CLIENT_NAME_FORMAT, johnDoeJr._name) +
                String.format(OBJECT_STATEMENT_FORMAT, mulan.get_title(), String.valueOf(2.75)) +
                String.format(SUMMARY_FORMAT, String.valueOf(2.75), String.valueOf(1));
    }

    @Test
    public void cumulativeTestStatementChildrensMovieOnly() {
        // childrens' movies cost $1.50 for the first 3 days, and $1.25/day thereafter
        // a rental earns 1 frequent-renter point no matter how many days
        Customer johnDoeJr = new Customer("Johnny Doe, Jr.");
        johnDoeJr.addMovieRental(new MovieRental(mulan, 3));
        johnDoeJr.addMovieRental(new MovieRental(mulan, 4));
        String statementMustBe = String.format(CLIENT_NAME_FORMAT, johnDoeJr._name) +
                String.format(OBJECT_STATEMENT_FORMAT, mulan.get_title(), String.valueOf(1.5)) +
                String.format(OBJECT_STATEMENT_FORMAT, mulan.get_title(), String.valueOf(2.75)) +
                String.format(SUMMARY_FORMAT, String.valueOf(4.25), String.valueOf(2));
    }

    @Test
    public void newReleaseStatementSimpleTest() {
        // new releases cost $3.00/day
        // a rental earns 1 frequent-renter point 1 day; 2 points for 2 or more days
        Customer johnDoe = new Customer("John Doe");
        johnDoe.addMovieRental(new MovieRental(slumdogMillionaire, 1));
        String statementMustBe = String.format(CLIENT_NAME_FORMAT, johnDoe._name) +
                String.format(OBJECT_STATEMENT_FORMAT, slumdogMillionaire.get_title(), String.valueOf(3.0)) +
                String.format(SUMMARY_FORMAT, String.valueOf(3.0), String.valueOf(1));
        assertEquals(statementMustBe, johnDoe.statement());
    }

    @Test
    public void newReleaseStatementAdditionalTest() {
        // new releases cost $3.00/day
        // a rental earns 1 frequent-renter point 1 day; 2 points for 2 or more days
        Customer johnDoe = new Customer("John Doe");
        johnDoe.addMovieRental(new MovieRental(slumdogMillionaire, 3));
        String statementMustBe = String.format(CLIENT_NAME_FORMAT, johnDoe._name) +
                String.format(OBJECT_STATEMENT_FORMAT, slumdogMillionaire.get_title(), String.valueOf(9.0)) +
                String.format(SUMMARY_FORMAT, String.valueOf(9.0), String.valueOf(2));
        String v = johnDoe.statement();
        assertEquals(statementMustBe, johnDoe.statement());
    }

    @Test
    public void newReleaseStatementCumulativeTest() {
        // new releases cost $3.00/day
        // a rental earns 1 frequent-renter point 1 day; 2 points for 2 or more days
        Customer johnDoe = new Customer("John Doe");
        johnDoe.addMovieRental(new MovieRental(slumdogMillionaire, 1));
        johnDoe.addMovieRental(new MovieRental(slumdogMillionaire, 3));
        String statementMustBe = String.format(CLIENT_NAME_FORMAT, johnDoe._name) +
                String.format(OBJECT_STATEMENT_FORMAT, slumdogMillionaire.get_title(), String.valueOf(3.0)) +
                String.format(OBJECT_STATEMENT_FORMAT, slumdogMillionaire.get_title(), String.valueOf(9.0)) +
                String.format(SUMMARY_FORMAT, String.valueOf(12.0), String.valueOf(3));
        assertEquals(statementMustBe, johnDoe.statement());
    }
}