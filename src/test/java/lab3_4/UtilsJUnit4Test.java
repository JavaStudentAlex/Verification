package lab3_4;

import org.junit.*;

import static org.junit.Assert.*;

public class UtilsJUnit4Test {

    @BeforeClass
    public static void setUpClass(){
        System.out.println("UtilsJUnit4Test: @BeforeClass");
    }

    @AfterClass
    public static void teardownClass(){
        System.out.println("UtilsJUnit4Test: @AfterClass");
    }

    @Before
    public void setUp(){
        System.out.println("UtilsJUnit4: BeforeTest");
    }

    @After
    public void teardown(){
        System.out.println("UtilsJUnit4: AfterTest");
    }

    @Test
    public void concatWords() {
        System.out.println("UtilsJUnit4Test: concatenating words test");
        assertEquals("test", Utils.concatWords("test"));
        assertEquals("ttt", Utils.concatWords("t", "t", "t"));
    }

    @Test
    public void helloWorldCheck(){
        System.out.println("UtilsJUnit4Test: Hello world test");
        assertEquals("Hello, world!", Utils.concatWords("Hello", ", ", "world", "!"));
    }

    @Test
    public void computeFactorial() {
        System.out.println("UtilsJUnit4Test: factorial test");
        assertEquals("6", Utils.computeFactorial(3));
        assertEquals("24", Utils.computeFactorial(4));
        assertEquals("120", Utils.computeFactorial(5));
    }

    @Test(timeout = 1000)
    public void computeFactorialWithTimeout(){
        final int factorialNumber = 1 + (int)(30000*Math.random());
        System.out.println("UtilsJUnit4Test: Computing factorial of " + factorialNumber + " with 1000ms timeline");
        String result = Utils.computeFactorial(factorialNumber);
    }

    @Test(expected = IllegalArgumentException.class)
    public void expectedIlligalArgument(){
        final int factorialNumber = -5;
        System.out.println("UtilsJUnit4Test: Computing factorial of " + factorialNumber + " with illegal argument");
        String result = Utils.computeFactorial(factorialNumber);
    }

    @Test
    public void normalizeWord() {
        System.out.println("UtilsJUnit4Test: normalizing words test");
    }

    @Ignore
    @Test
    public void temporaryDisabled() throws Exception{
        System.out.println("UtilsJUnit4Test: temporary disabled test");
        assertEquals("Malm\u00f6", Utils.normalizeWord("Malmo\u0308"));
    }
}