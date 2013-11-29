
package kekoilua;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class BinomikekoTest {
    
    public Binomikeko keko;
    
    @Before
    public void setUp() {
        keko = new Binomikeko();
    }
    
    /**
     * Test of Delete method, of class Binomikeko.
     */
    @Test
    public void testDelete() {
        System.out.println("Delete");
        keko.Insert(1);
        keko.Insert(2);
        keko.Delete();
        assertEquals(keko.getYlin(), 2);
    }

    /**
     * Test of Insert method, of class Binomikeko.
     */
    @Test
    public void testInsert() {
        System.out.println("Insert");
        int a = 0;
        Binomikeko instance = new Binomikeko();
        instance.Insert(a);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getYlin method, of class Binomikeko.
     */
    @Test
    public void testGetYlin() {
        System.out.println("getYlin");
        Binomikeko instance = new Binomikeko();
        int expResult = 0;
        int result = instance.getYlin();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}