
package kekoilua;

import java.util.Random;
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
    
    @Test
    public void testDeleteIsollaKeolla(){
        for(int i = 1; i < 101; i++){
            keko.Insert(i);
        }
        keko.Delete();
        assertEquals(2, keko.getYlin());
    }
   
    @Test
    public void testDeleteRandomKeolla(){
        Random r = new Random();
        for(int i = 1; i < 101; i++){
            keko.Insert(r.nextInt());
        }
        keko.Delete();
        assertEquals(2, keko.getYlin());
    }
    
    @Test
    public void testInsert() {
        System.out.println("Insert");
        keko.Insert(2);
        assertEquals(2, keko.getYlin());
    }

    @Test
    public void testInsertUseammalla(){
        for(int i = 1; i < 101; i++){
            keko.Insert(i);
        }
     //   System.out.println(keko.toString());
        assertEquals(1, keko.getYlin());
    } 
    
    @Test
    public void testGetYlin() {
        System.out.println("getYlin");
        keko.Insert(4);
        assertEquals(4, keko.getYlin());
    }
}