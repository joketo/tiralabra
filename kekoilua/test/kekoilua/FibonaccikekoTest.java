
package kekoilua;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class FibonaccikekoTest {
    
    public FibonaccikekoTest() {
    }
    Fibonaccikeko keko;
    @Before
    public void setUp() {
        keko = new Fibonaccikeko();
    }
    
    
    /**
     * Test of Delete method, of class Fibonaccikeko.
     */
    @Test
    public void testDelete() {
        System.out.println("Delete");
        Fibonaccikeko instance = new Fibonaccikeko();
        instance.Delete();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Insert method, of class Fibonaccikeko.
     */
    @Test
    public void testInsert() {
        System.out.println("Insert");
        keko.Insert(2);
        assertEquals(2, keko.getYlin());
    }

    @Test
    public void testInsertUseammalla(){
        keko.Insert(4);
        keko.Insert(5);
        keko.Insert(6);
        keko.Insert(1);
        assertEquals(1, keko.getYlin());
    } 
    
    @Test
    public void testGetYlin() {
        System.out.println("getYlin");
        Fibonaccikeko instance = new Fibonaccikeko();
        int expResult = 0;
        int result = instance.getYlin();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}