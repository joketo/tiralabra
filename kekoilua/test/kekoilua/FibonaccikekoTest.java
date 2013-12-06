
package kekoilua;

import java.util.ArrayList;
import java.util.Collections;
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
     * Test of pop method, of class Fibonaccikeko.
     */
    
    @Test
    public void testDelete() {
        keko.insert(2);
        keko.insert(1);
        keko.insert(3);
        System.out.println(keko.toString());
        keko.pop();
        //System.out.println(keko.toString());
        assertEquals(2, keko.getYlin());
    }
    
    @Test
    public void testDeleteIsollaKeolla(){
        for(int i = 1; i < 101; i++){
            keko.insert(i);
        }
        keko.pop();
        assertEquals(2, keko.getYlin());
    }
    
    
    
    @Test
    public void testDeleteRandomKeolla(){
        ArrayList<Integer> a = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < 10000; i++) {
            a.add(rand.nextInt());
        }
        Random r = new Random();
        for(int i = 0; i < a.size(); i++){
            keko.insert(a.get(i));
        }
        int kPienin = keko.pop();
        Collections.sort(a);
        int aPienin = a.get(0);
        assertEquals(aPienin, kPienin);
    }
    
    @Test
    public void testInsert() {
        System.out.println("Insert");
        keko.insert(2);
        assertEquals(2, keko.getYlin());
    }

    @Test
    public void testInsertUseammalla(){
        for(int i = 1; i < 101; i++){
            keko.insert(i);
        }
     //   System.out.println(keko.toString());
        assertEquals(1, keko.getYlin());
    } 
    
    @Test
    public void testGetYlin() {
        System.out.println("getYlin");
        keko.insert(4);
        assertEquals(4, keko.getYlin());
    }
}