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
        int i = 0;
        ArrayList<Integer> kek = null;
        Binaarikeko instance = new Binaarikeko();
        instance.Heapify(i);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Insert method, of class Binaarikeko.
     */
    @Test
    public void MaxInsertToimiiKunKekoOnTyhja() {
        int alkio = 4;
        keko.Insert(alkio);
        assertEquals(4, keko.getYlin());
    }
    
    @Test
    public void MaxInsertToimiiKunKekoEiOleTyhja(){
        keko.Insert(1);
        keko.Insert(3);
        keko.Insert(5);
        assertEquals(5, keko.getYlin());
    }

    /**
     * Test of Delete method, of class Binaarikeko.
     */
    @Test
    public void MaxDeleteToimiiKunKekoOnTyhja() {
        keko.Delete();
        assertEquals(-1, keko.getYlin()); //-1 on tyhjän keon merkki
    }
    
    @Test
    public void MaxDeleteToimiiKunKeossaYksiAlkio(){
        keko.Insert(1);
        keko.Delete();
        assertEquals(-1, keko.getYlin());
    }
    
    @Test
    public void MaxDeleteToimiiKunKeossaNeljaAlkiota(){
        keko.Insert(4);
        keko.Insert(3);
        keko.Insert(2);
        keko.Insert(1);
        keko.Delete();
        assertEquals(3, keko.getYlin());
    }
}