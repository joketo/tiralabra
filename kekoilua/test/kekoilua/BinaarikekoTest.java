
package kekoilua;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class BinaarikekoTest {
    
    public BinaarikekoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of MaxHeapify method, of class Binaarikeko.
     */
    @Test
    public void testMaxHeapify() {
        System.out.println("MaxHeapify");
        int i = 0;
        ArrayList<Integer> kek = null;
        Binaarikeko instance = new Binaarikeko();
        instance.MaxHeapify(i, kek);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of MaxInsert method, of class Binaarikeko.
     */
    @Test
    public void testMaxInsert() {
        System.out.println("MaxInsert");
        int alkio = 0;
        Binaarikeko instance = new Binaarikeko();
        instance.MaxInsert(alkio);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of MaxDelete method, of class Binaarikeko.
     */
    @Test
    public void testMaxDelete() {
        System.out.println("MaxDelete");
        int alkio = 0;
        Binaarikeko instance = new Binaarikeko();
        instance.MaxDelete(alkio);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}