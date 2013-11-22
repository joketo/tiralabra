
package kekoilua;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class KasvavaArrayTest {
    
    KasvavaArray<Integer> arI;
    KasvavaArray<String> arS;
    @Before
    public void setUp() {
        arI = new KasvavaArray<>();
        arS = new KasvavaArray<>();
    }
      
    @Test
    public void testContainsToimiiKunYksiInt(){
        arI.add(3);
        assertEquals(true, arI.contains(3));
    }
    
    @Test
    public void testContainsToimiiKunYksiString(){
        arS.add("kissa");
        assertEquals(true, arS.contains("kissa"));
    }
    /**
     * Test of add method, of class KasvavaArray.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        arI.add(2);
        assertEquals(true, arI.contains(2));
    }

    /**
     * Test of delete method, of class KasvavaArray.
     */
    @Test
    public void testRemoveInt() {
        System.out.println("delete");
        arI.add(3);
        arI.add(2);
        System.out.println(arI.toString());
        arI.remove(2);
        System.out.println(arI.toString());
        assertEquals(false, arI.contains(2));
    }

    /**
     * Test of length method, of class KasvavaArray.
     */
    @Test
    public void testSize() {
        System.out.println("length");
        arI.add(1);
        arI.add(2);
        arI.add(3);
        assertEquals(3, arI.size());
    }
}