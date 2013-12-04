
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
        keko.Insert(2);
        keko.Insert(1);
        keko.Insert(3);
        System.out.println(keko.toString());
        keko.Delete();
        //System.out.println(keko.toString());
        assertEquals(2, keko.getYlin());
    }

   /*
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
        keko.Insert(7);
        System.out.println(keko.toString());
        assertEquals(4, keko.getYlin());
    } 
    
    @Test
    public void testGetYlin() {
        System.out.println("getYlin");
        keko.Insert(4);
        assertEquals(4, keko.getYlin());
    }*/
}