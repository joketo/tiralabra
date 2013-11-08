package kekoilua;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BinaarikekoTest {

    public Binaarikeko keko;
    public ArrayList<Integer> semikeko;
    
    @Before
    public void setUp() {
        keko = new Binaarikeko();
        semikeko = new ArrayList<>();
    }


    @Test
    public void testMaxHeapify() {
        System.out.println("MaxHeapify");
        int i = 0;
        ArrayList<Integer> kek = null;
        Binaarikeko instance = new Binaarikeko();
        instance.MaxHeapify(i);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of MaxInsert method, of class Binaarikeko.
     */
    @Test
    public void MaxInsertToimiiKunKekoOnTyhja() {
        System.out.println("MaxInsert");
        int alkio = 4;
        keko.MaxInsert(alkio);
        assertEquals(4, keko.getYlin());
    }
    
    @Test
    public void MaxInsertToimiiKunKekoEiOleTyhja(){
        keko.MaxInsert(1);
        keko.MaxInsert(3);
        keko.MaxInsert(5);
        assertEquals(5, keko.getYlin());
    }

    /**
     * Test of MaxDelete method, of class Binaarikeko.
     */
    @Test
    public void MaxDeleteToimiiKunKekoOnTyhja() {
        System.out.println("MaxDelete");
        keko.MaxDelete();
        assertEquals(-1, keko.getYlin()); //-1 on tyhjän keon merkki
    }
}