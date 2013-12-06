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

public class BinomikekoTest {

    public Binomikeko keko;

    @Before
    public void setUp() {
        keko = new Binomikeko();
    }
    @Test
    public void toimiikoDeletejosIsoKeko(){
       for (int i = 1; i <= 50; i++){
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
        Collections.sort(a);
        
        for(int i = 0; i < a.size(); i++){
            assertEquals((int)a.get(i), (int)keko.pop());
        }
        
    }
    @Test
    public void toimiikoUudenKeonLuonti() {
        keko.insert(4);
        keko.insert(5);
        keko.insert(6);
        assertEquals(4, keko.getYlin());
    }

    @Test
    public void testDelete() {
        System.out.println("Delete");
        keko.insert(1);
        keko.insert(2);
        keko.pop();
        assertEquals(2, keko.getYlin());
    }

    @Test
    public void testInsert() {
        System.out.println("Insert");
        keko.insert(3);
        assertEquals(keko.getYlin(), 3);
    }

    @Test
    public void testGetYlin() {
        System.out.println("testGetYlin");
        keko.insert(7);
        keko.insert(5);
        keko.insert(6);
        assertEquals(5, keko.getYlin());
    }

    @Test
    public void testInsertIsommallaMaaralla() {
        System.out.println("insertIsommalla");
        keko.insert(4);
        keko.insert(3);
        keko.insert(1);
        keko.insert(5);
        keko.insert(3);
        keko.insert(7);
        keko.insert(5);
        System.out.println(keko.toString());
        assertEquals(1, keko.getYlin());

    }
}