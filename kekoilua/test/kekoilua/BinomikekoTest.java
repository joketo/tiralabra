
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
        System.out.println(keko.toString());
        keko.Delete();
        assertEquals(keko.getYlin(), 2);
    }

    /**
     * Test of Insert method, of class Binomikeko.
     */
    @Test
    public void testInsert() {
        System.out.println("Insert");
        keko.Insert(3);
        assertEquals(keko.getYlin(), 3);
    }

    /**
     * Test of getYlin method, of class Binomikeko.
     */
    @Test
    public void testGetYlin() {
        keko.Insert(4);
        keko.Insert(5);
        keko.Insert(6);
        assertEquals(keko.getYlin(), 4);
    }
    
    @Test
    public void testInsertIsommallaMaaralla(){
        keko.Insert(4);
        keko.Insert(3);
        keko.Insert(1);
        keko.Insert(5);
        keko.Insert(3);
        keko.Insert(7);
        keko.Insert(5);
        System.out.println(keko.toString());
        assertEquals(1, keko.getYlin());
        
    }
}