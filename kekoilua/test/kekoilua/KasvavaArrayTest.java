
package kekoilua;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class KasvavaArrayTest {
    
    KasvavaArray ar;
    @Before
    public void setUp() {
        ar = new KasvavaArray();
    }
    
    /**
     * Test of add method, of class KasvavaArray.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        Object alkio = null;
        KasvavaArray instance = null;
        instance.add(alkio);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class KasvavaArray.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Object alkio = null;
        KasvavaArray instance = null;
        instance.delete(alkio);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of length method, of class KasvavaArray.
     */
    @Test
    public void testLength() {
        System.out.println("length");
        KasvavaArray instance = null;
        int expResult = 0;
        int result = instance.length();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}