package lab3_4;

import org.junit.Test;

import static org.junit.Assert.*;

public class VectorsJUnit4Test {

    @Test
    public void equalCheck() {
        System.out.println("VectorsJUnit4Test - EqualsCheck");
        assertTrue(Vectors.equal(new int[] {}, new int[] {}));
        assertTrue(Vectors.equal(new int[] {0}, new int[] {0}));
        assertTrue(Vectors.equal(new int[] {0,0}, new int[] {0,0}));
        assertTrue(Vectors.equal(new int[] {0,0}, new int[] {0,0}));
        assertTrue(Vectors.equal(new int[] {0,0,0}, new int[] {0,0,0}));
        assertTrue(Vectors.equal(new int[] {5,6,7}, new int[] {5,6,7}));

        assertFalse(Vectors.equal(new int[] {}, new int[] {0}));
        assertFalse(Vectors.equal(new int[] {0}, new int[] {0,0}));
        assertFalse(Vectors.equal(new int[] {0,0}, new int[] {0,0,0}));
        assertFalse(Vectors.equal(new int[] {0,0,0}, new int[] {0,0}));
        assertFalse(Vectors.equal(new int[] {0,0}, new int[] {0}));
        assertFalse(Vectors.equal(new int[] {0}, new int[] {}));
        assertFalse(Vectors.equal(new int[] {0,0,0}, new int[] {0,0,1}));
        assertFalse(Vectors.equal(new int[] {0,0,0}, new int[] {0,1,0}));
        assertFalse(Vectors.equal(new int[] {0,0,0}, new int[] {1,0,0}));
        assertFalse(Vectors.equal(new int[] {0,0,1}, new int[] {0,0,3}));
    }

    @Test
    public void scalarMultiplicationCheck() {
        System.out.println("VectorsJUnit4Test - ScalarMultiplicationCheck");
        assertEquals(0, Vectors.scalarMultiplication(new int[] {0,0}, new int[] {0,0}));
        assertEquals(39, Vectors.scalarMultiplication(new int[] {4,3}, new int[] {6,5}));
        assertEquals(-39, Vectors.scalarMultiplication(new int[] {-4,3}, new int[] {6,-5}));
        assertEquals(0, Vectors.scalarMultiplication(new int[] {2,3}, new int[] {-3,2}));
    }
}